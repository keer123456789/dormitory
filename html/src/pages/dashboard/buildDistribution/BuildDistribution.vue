<template>
  <div>
    <a-row :gutter="[0, 16]">
      <a-col :span="24">
        <a-card :bordered="false" style="width: 100%">
          <h1 class="card-name">宿舍楼管理员</h1>
        </a-card>
      </a-col>
      <a-col :span="24">
        <a-card :bordered="false" style="width: 100%">
          <a-upload
            action="http://127.0.0.1:8080/file/block/upload"
            :multiple="true"
            :file-list="fileList"
            @change="handleChange"
          >
            <a-button> <a-icon type="upload" /> 批量导入宿舍楼 </a-button>
          </a-upload>
          <a-table :columns="columns" :data-source="data" :loading="loading">
            <a slot="name" slot-scope="text">{{ text }}</a>
            <span slot="action" slot-scope="text">
              <a @click="edit(text)">编辑</a>
            </span>
          </a-table>
        </a-card>
      </a-col>
    </a-row>
    <a-modal
      title="编辑"
      :visible="visible"
      :confirm-loading="confirmLoading"
      @ok="handleOk"
      @cancel="handleCancel"
    >
      <a-form :form="form" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
        <a-form-item label="序列号" style="display: none">
          <a-input v-decorator="['xlh']" />
        </a-form-item>
        <a-form-item label="姓名">
          <a-input
            v-decorator="[
              'name',
              {
                rules: [{ required: true, message: '请输入姓名！' }],
              },
            ]"
          />
        </a-form-item>
        <a-form-item label="宿舍楼id">
          <a-input
            v-decorator="[
              'buildId',
              {
                rules: [{ required: true, message: '请输入宿舍楼id！' }],
              },
            ]"
          />
        </a-form-item>
        <a-form-item label="宿舍楼名称">
          <a-input
            v-decorator="[
              'buildName',
              {
                rules: [{ required: true, message: '请输入宿舍楼名称！' }],
              },
            ]"
          />
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script>
import { users, editUser } from "@/services/dataSource";

const columns = [
  {
    title: "用户名",
    dataIndex: "name",
    key: "name",
    scopedSlots: { customRender: "name" },
  },
  {
    title: "角色",
    dataIndex: "role",
    key: "role",
    width: 80,
  },
  {
    title: "宿舍楼id",
    dataIndex: "buildId",
    key: "buildId",
    ellipsis: true,
  },
  {
    title: "宿舍楼名称",
    dataIndex: "buildName",
    key: "buildName",
    ellipsis: true,
  },
  {
    title: "操作",
    key: "action",
    scopedSlots: { customRender: "action" },
  },
];

var result = {
  data: [],
};

export default {
  name: "BuildDistribution",
  beforeCreate() {
    //创建表单
    this.form = this.$form.createForm(this, { name: "form_in_modal" });
  },
  data() {
    return {
      data: result.data,
      columns: result.columns,
      visible: false,
      confirmLoading: false,
      loading: false,
      fileList: [{}],
    };
  },
  mounted() {
    this.getUsers();
  },
  methods: {
    getUsers(params = {}) {
      console.log("params:", params);
      this.loading = true;
      users(params).then((result) => {
        this.loading = false;
        this.data = result.data.data;
        this.columns = columns;
      });
    },
    edit(text) {
      this.visible = true;
      console.log(text);
      this.$nextTick(() => {
        this.form.setFieldsValue({
          name: text.name,
          buildId: text.buildId,
          buildName: text.buildName,
          xlh: text.xlh,
        });
      });
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
        editUser(values).then((result) => {
          console.log(result);
          if (result.data.code == 200) {
            this.getUsers();
            this.$message.info("修改成功！");
          } else {
            this.$message.info(result.data.msg);
          }
        });
        console.log("form 表单内容: ", values);
        form.resetFields();
        this.visible = false;
        this.confirmLoading = false;
      });
    },
    handleCancel() {
      console.log("Clicked cancel button");
      this.visible = false;
    },
    handleChange(info) {
      let fileList = [...info.fileList];
      fileList = fileList.slice(-2);
      fileList = fileList.map(file => {
        if (file.response) {
          file.url = file.response.url;
        }
        return file;
      });
      this.fileList = fileList;
      if (info.file.response.code == 200) {
        this.$message.info("导入成功！");
        this.getUsers();
        this.fileList = [{}];
      } else {
        this.$message.info("导入失败！");
      }
    },
  },
};
</script>

<style lang="less">
.card-name {
  font-size: 24px;
  font-weight: bold;
}
</style>








