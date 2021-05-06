<template>
  <div>
    <a-row style="min-height: 0.9rem; font-size: 0.4rem">
      <a-col :span="1"
        ><a-icon type="search" style="font-size: 22px; margin: 4px"></a-icon>
      </a-col>
      <a-col :span="6">
        <a-input-search
          placeholder="姓名查询"
          enter-button
          v-model="searchName"
          @search="onSearch"
      /></a-col>
      <a-col :span="1"></a-col>
      <a-col :span="5">
        <a-button type="primary" @click="doStudent"> 添加学生 </a-button>
      </a-col>
    </a-row>
    <a-table
      :columns="columns"
      :data-source="datalt"
      bordered
      style="margin-top: 10px"
    >
      <template slot="name" slot-scope="text">
        <a>{{ text }}</a>
      </template>
      <a slot="name" slot-scope="text">{{ text }}</a>
      <span slot="action" slot-scope="text">
        <a @click="doEdit(text)">编辑</a>
        <a @click="doStop(text)" style="margin-left: 10px">退宿</a>
      </span>
    </a-table>
    <a-modal
      title="新增"
      :visible="visible"
      :confirm-loading="confirmLoading"
      @ok="handleOkForadd"
      @cancel="handleCancel"
    >
      <a-form :form="form" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
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
        <a-form-item label="学号">
          <a-input
            v-decorator="[
              'id',
              {
                rules: [{ required: true, message: '请选择学号！' }],
              },
            ]"
          />
        </a-form-item>
        <a-form-item label="手机号">
          <a-input v-decorator="['phoneNum']" />
        </a-form-item>
        <a-form-item label="行政班号">
          <a-input v-decorator="['classNum']" />
        </a-form-item>
        <a-form-item label="身份证号">
          <a-input v-decorator="['identity_num']" />
        </a-form-item>
        <a-form-item label="民族">
          <a-input v-decorator="['nation']" />
        </a-form-item>
        <a-form-item label="性别">
          <a-input v-decorator="['sex']" />
        </a-form-item>
        <a-form-item label="学院">
          <a-input v-decorator="['academy']" />
        </a-form-item>
        <a-form-item label="专业">
          <a-input v-decorator="['major']" />
        </a-form-item>
        <a-form-item label="床号">
          <a-input v-decorator="['bedNum']" />
        </a-form-item>
        <a-form-item label="房间id">
          <a-input v-decorator="['roomId']" />
        </a-form-item>
        <a-form-item label="地区">
          <a-input v-decorator="['region']" />
        </a-form-item>
        <a-form-item label="家庭住址">
          <a-input v-decorator="['address']" />
        </a-form-item>
      </a-form>
    </a-modal>
    <a-modal
      title="编辑"
      :visible="visibleForEdit"
      :confirm-loading="confirmLoadingForEdit"
      @ok="handleOkForEdit"
      @cancel="handleCancelForEdit"
    >
      <a-form
        :form="formForEdit"
        :label-col="{ span: 5 }"
        :wrapper-col="{ span: 12 }"
      >
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
        <a-form-item label="学号">
          <a-input
            v-decorator="[
              'id',
              {
                rules: [{ required: true, message: '请选择学号！' }],
              },
            ]"
          />
        </a-form-item>
        <a-form-item label="手机号">
          <a-input v-decorator="['phoneNum']" />
        </a-form-item>
        <a-form-item label="行政班号">
          <a-input v-decorator="['classNum']" />
        </a-form-item>
        <a-form-item label="身份证号">
          <a-input v-decorator="['identity_num']" />
        </a-form-item>
        <a-form-item label="民族">
          <a-input v-decorator="['nation']" />
        </a-form-item>
        <a-form-item label="性别">
          <a-input v-decorator="['sex']" />
        </a-form-item>
        <a-form-item label="学院">
          <a-input v-decorator="['academy']" />
        </a-form-item>
        <a-form-item label="专业">
          <a-input v-decorator="['major']" />
        </a-form-item>
        <a-form-item label="床号">
          <a-input v-decorator="['bedNum']" />
        </a-form-item>
        <a-form-item label="房间id">
          <a-input v-decorator="['roomId']" />
        </a-form-item>
        <a-form-item label="地区">
          <a-input v-decorator="['region']" />
        </a-form-item>
        <a-form-item label="家庭住址">
          <a-input v-decorator="['address']" />
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script>
import { student, getStudent, stop, update } from "@/services/dataSource";

var data = [];

// 在data中定义searchName模糊搜索双向模型 ，columns 定义表格头部信息，data：表格数据信息，datalt过滤后展示的表格数据列表
export default {
  name: "StudentInfo",
  data() {
    return {
      searchName: "",
      confirmLoading: false,
      confirmLoadingForEdit: false,
      visible: false,
      visibleForEdit: false,
      columns: [
        {
          title: "姓名",
          dataIndex: "name",
          scopedSlots: { customRender: "name" },
          filteredValue: this.searchName ? this.searchName : null,
        },
        {
          title: "学号",
          dataIndex: "id",
        },
        {
          title: "学院",
          dataIndex: "academy",
        },
        {
          title: "专业",
          dataIndex: "major",
        },
        {
          title: "性别",
          dataIndex: "sex",
        },
        {
          title: "行政班号",
          dataIndex: "classNum",
        },
        {
          title: "床号",
          dataIndex: "bedNum",
        },
        {
          title: "房间id",
          dataIndex: "roomId",
        },
        {
          title: "手机号",
          dataIndex: "phoneNum",
        },
        {
          title: "身份证号",
          dataIndex: "identity_num",
        },
        {
          title: "民族",
          dataIndex: "nation",
        },
        {
          title: "地区",
          dataIndex: "region",
        },
        {
          title: "家庭住址",
          dataIndex: "address",
        },
        {
          title: "操作",
          key: "action",
          scopedSlots: { customRender: "action" },
          width: 110,
        },
      ],
      data,
      datalt: data,
    };
  },
  beforeCreate() {
    //创建表单
    this.form = this.$form.createForm(this, { name: "form_in_modal" });
    this.formForEdit = this.$form.createForm(this, { name: "form_in_modal " });
  },
  mounted() {
    getStudent().then((result) => {
      // console.log(result.data.data);
      this.data = result.data.data;
      this.datalt = this.data;
    });
  },
  methods: {
    // onSearch 搜索功能，根据输入框中输入的字符进行在数组中过滤更新到新的数组中并在前端页面渲染展示
    onSearch() {
      if (this.searchName && this.searchName !== "") {
        this.datalt = this.data.filter(
          (p) => p.name.indexOf(this.searchName) !== -1
        );
      } else {
        this.datalt = this.data;
      }
    },
    doStudent() {
      this.visible = true;
      this.$nextTick(() => {
        this.form.setFieldsValue({});
      });
    },
    handleOkForadd(e) {
      e.preventDefault();
      this.confirmLoading = true;
      const form = this.form;
      form.validateFields((err, values) => {
        if (err) {
          this.confirmLoading = false;
          return;
        }
        console.log("form 表单内容: ", values);
        let params = values;
        student(params).then((result) => {
          console.log(result);
          if (result.data.code == 200) {
            this.$message.info("添加成功！");
          }
        });
        form.resetFields();
        this.visible = false;
        this.confirmLoading = false;
      });
    },
    handleCancel() {
      console.log("Clicked cancel button");
      this.visible = false;
    },
    doEdit(text) {
      console.log(text);
      this.visibleForEdit = true;
      this.$nextTick(() => {
        this.formForEdit.setFieldsValue({
          name: text.name,
          id: text.id,
          academy: text.academy,
          major: text.major,
          sex: text.sex,
          classNum: text.classNum,
          bedNum: text.bedNum,
          roomId: text.roomId,
          phoneNum: text.phoneNum,
          identity_num: text.identity_num,
          nation: text.nation,
          region: text.region,
          address: text.address,
        });
      });
    },
    handleOkForEdit(e) {
      e.preventDefault();
      this.confirmLoadingForEdit = true;
      const formForEdit = this.formForEdit;
      formForEdit.validateFields((err, values) => {
        if (err) {
          this.confirmLoading = false;
          return;
        }
        console.log("formForEdit 表单内容: ", values);
        update(values).then((result)=>{
          if(result.data.code == 200){
            this.$message.info(result.data.msg);
          }
        });
        formForEdit.resetFields();
        this.visibleForEdit = false;
        this.confirmLoadingForEdit = false;
      });
    },
    handleCancelForEdit() {
      this.visibleForEdit = false;
    },
    doStop(text) {
      let params = { id: text.id };
      console.log(params);
      stop(params).then((result) => {
        console.log(result);
        if (result.data.code == 200) {
          this.$message.info("退宿成功！");
        }
      });
    },
  },
};
</script>
