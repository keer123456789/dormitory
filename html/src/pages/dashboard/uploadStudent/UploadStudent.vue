<template>
  <div>
    <a-upload-dragger
      name="file"
      :multiple="true"
      action="http://127.0.0.1:8080/file/student/upload"
      @change="handleChange"
    >
      <p class="ant-upload-drag-icon">
        <a-icon type="inbox" />
      </p>
      <p class="ant-upload-text">点击上传学生信息EXCEL</p>
      <p class="ant-upload-hint">
        请确保上传文件格式
      </p>
    </a-upload-dragger>
    <a-modal
      title="房间人数"
      :visible="visible"
      :confirm-loading="confirmLoading"
      @ok="handleOk"
      @cancel="handleCancel"
    >
      <a-form :form="form" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
        <a-form-item label="taskId" style="display: none">
          <a-input v-decorator="['id']" />
        </a-form-item>
        <a-form-item label="男生宿舍人数">
          <a-input
            v-decorator="[
              'roomSizeFemale',
              {
                rules: [{ required: true, message: '请输入人数上限！' }],
              },
            ]"
          />
        </a-form-item>
        <a-form-item label="女生宿舍人数">
          <a-input
            v-decorator="[
              'roomSizeMale',
              {
                rules: [{ required: true, message: '请输入人数上限！' }],
              },
            ]"
          />
        </a-form-item>
      </a-form>
    </a-modal>
    <a-modal
      title="选择房间"
      :visible="visibleForChooseRoom"
      :confirm-loading="confirmLoadingForChooseRoom"
      @ok="handleOkForChooseRoom"
      @cancel="handleCancelForChooseRoom"
    >
      男生宿舍大小：{{ roomSizeMale }}<br />
      女生宿舍大小：{{ roomSizeFemale }}<br />
      分配所需男生宿舍个数：{{ roomNumMale }}<br />
      分配所需女生宿舍个数：{{ roomNumFemale }}<br />
      男生人数：{{ maleNum }}<br />
      女生人数：{{ femaleNum }}<br />
      <a-form
        :form="formForChooseRoom"
        :label-col="{ span: 5 }"
        :wrapper-col="{ span: 12 }"
      >
        <a-form-item label="taskId" style="display: none">
          <a-input v-decorator="['id']" />
        </a-form-item>
        <a-form-item label="男生宿舍楼选择">
          <a-select v-decorator="['maleBlock']" style="width: 120px">
            <a-select-option
              v-for="block in maleBlockData"
              :key="block.blockId"
            >
              {{ block.blockName }}&nbsp;{{ block.emptyRoom }}个空房间
            </a-select-option>
          </a-select>
        </a-form-item>
        <a-form-item label="女生宿舍楼选择">
          <a-select v-decorator="['femaleBlock']" style="width: 120px">
            <a-select-option
              v-for="block in femaleBlockData"
              :key="block.blockId"
            >
              {{ block.blockName }}&nbsp;{{ block.emptyRoom }}个空房间
            </a-select-option>
          </a-select>
        </a-form-item>
      </a-form>
    </a-modal>
    <a-modal
      title="分配房间"
      :visible="visibleForAssign"
      :confirm-loading="confirmLoadingForAssign"
      @ok="handleOkForAssign"
      @cancel="handleCancelForAssign"
    >
      <p>开始进行分配！</p>
    </a-modal>
  </div>
</template>

<script>
import { updateInfo, sortInfo, run } from "@/services/dataSource";

export default {
  name: "UploadStudent",
  data() {
    return {
      taskId: 0,
      visible: false,
      confirmLoading: false,
      loading: false,
      visibleForChooseRoom: false,
      confirmLoadingForChooseRoom: false,
      loadingForChooseRoom: false,
      roomSizeMale: "",
      roomSizeFemale: "",
      roomNumMale: "",
      roomNumFemale: "",
      maleNum: "",
      femaleNum: "",
      maleBlockData: [],
      femaleBlockData: [],
      visibleForAssign: false,
      confirmLoadingForAssign: false,
      loadingForAssign: false,
    };
  },
  beforeCreate() {
    //创建表单
    this.form = this.$form.createForm(this, { name: "form_in_modal" });
    this.formForChooseRoom = this.$form.createForm(this, {
      name: "form_in_modal",
    });
  },
  methods: {
    handleChange(info) {
      if (info.file.response.code == 200) {
        this.taskId = info.file.response.data;
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue({
            id: this.taskId,
          });
        });
      } else {
        this.$message.info("上传失败！");
      }
    },
    handleOk(e) {
      e.preventDefault();
      this.confirmLoading = true;
      const form = this.form;
      form.validateFields((err, values) => {
        if (err) {
          this.confirmLoading = false;
          return;
        }
        updateInfo(values).then((result) => {
          if (result.data.code == 200) {
            form.resetFields();
            this.visible = false;
            this.confirmLoading = false;
            let params = {
              id: this.taskId,
            };
            sortInfo(params).then((result) => {
              this.roomSizeMale = result.data.data.roomSizeMale;
              this.roomSizeFemale = result.data.data.roomSizeFemale;
              this.roomNumMale = result.data.data.roomNumMale;
              this.roomNumFemale = result.data.data.roomNumFemale;
              this.maleNum = result.data.data.maleNum;
              this.femaleNum = result.data.data.femaleNum;
              this.maleBlockData = result.data.data.maleInfo;
              this.femaleBlockData = result.data.data.femaleInfo;
              this.visibleForChooseRoom = true;
              this.$nextTick(() => {
                this.formForChooseRoom.setFieldsValue({
                  id: this.taskId,
                });
              });
            });
          } else {
            form.resetFields();
            this.visible = false;
            this.confirmLoading = false;
            this.$message.info("选择失败！请重试！");
          }
        });
      });
    },
    handleCancel() {
      this.visible = false;
      this.confirmLoading = false;
      this.form.resetFields();
    },
    handleOkForChooseRoom(e) {
      e.preventDefault();
      this.confirmLoading = true;
      const form = this.formForChooseRoom;
      form.validateFields((err, values) => {
        if (err) {
          this.confirmLoading = false;
          return;
        }
        updateInfo(values).then((result) => {
          if (result.data.code == 200) {
            this.$message.info("导入成功！");
            this.visibleForAssign = true;
          } else if (result.data.code == 500) {
            this.$message.info(result.data.msg);
          } else {
            this.$message.info("添加失败！");
          }
        });
        console.log("form 表单内容: ", values);
        form.resetFields();
        this.visibleForChooseRoom = false;
        this.confirmLoadingForChooseRoom = false;
      });
    },
    handleCancelForChooseRoom() {
      this.visibleForChooseRoom = false;
      this.confirmLoadingForChooseRoom = false;
      this.formForChooseRoom.resetFields();
    },
    handleOkForAssign() {
      let params = {
        id : this.taskId
      };
      run(params).then((result)=>{
        if (result.data.code == 200) {
            this.$message.info("分配房间成功！");
          } else if (result.data.code == 500) {
            this.$message.info(result.data.msg);
          } else {
            this.$message.info("分配房间失败！");
          }
      });
      this.visibleForAssign = false;
      this.confirmLoadingForAssign = false;
    },
    handleCancelForAssign() {
      this.visibleForAssign = false;
      this.confirmLoadingForAssign = false;
    },
  },
};
</script>

<style lang="less">
</style>








