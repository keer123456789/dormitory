<template>
  <div>
    <a-row style="min-height: 0.9rem; font-size: 0.4rem">
      <a-col :span="1"
        ><a-icon type="search" style="font-size: 22px; margin: 4px"></a-icon>
      </a-col>
      <a-col :span="6">
        <a-input-search
          placeholder="名称查询"
          enter-button
          v-model="searchName"
          @search="onSearch"
      /></a-col>
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
        <a @click="doDelete(text)">删除</a>
      </span>
    </a-table>
  </div>
</template>

<script>
import { getObject, delObject } from "@/services/dataSource";

var data = [];

export default {
  name: "ObjectInfo",
  data() {
    return {
      searchName: "",
      data,
      datalt: data,
      columns: [
        {
          title: "物品名称",
          dataIndex: "name",
          scopedSlots: { customRender: "name" },
          filteredValue: this.searchName ? this.searchName : null,
        },
        {
          title: "x轴位置",
          dataIndex: "x",
        },
        {
          title: "y轴位置",
          dataIndex: "y",
        },
        {
          title: "物品类别",
          dataIndex: "type",
        },
        {
          title: "宿舍楼号",
          dataIndex: "blockname",
        },
        {
          title: "楼层号",
          dataIndex: "floorname",
        },
        {
          title: "操作",
          key: "action",
          scopedSlots: { customRender: "action" },
          width: 70,
        },
      ],
    };
  },
  mounted() {
    getObject().then((result) => {
      this.data = result.data.data;
      this.datalt = this.data;
    });
  },
  methods: {
    onSearch() {
      if (this.searchName && this.searchName !== "") {
        this.datalt = this.data.filter(
          (p) => p.name.indexOf(this.searchName) !== -1
        );
      } else {
        this.datalt = this.data;
      }
    },
    doDelete(text){
        let params={};
        params.key = text.key;
        delObject(params).then((result)=>{
            console.log(result);
            if(result.data.code == 200){
                this.$message.info(result.data.msg);
            }
        })
    }
  },
};
</script>

<style lang="less">
</style>