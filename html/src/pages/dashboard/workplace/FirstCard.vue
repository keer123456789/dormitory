<template>
  <div>
    <a-card>
      <a-button @click="handleSecond(objData.key)">{{ objData.name }}</a-button>
      <a-button @click="add">添加{{ objData.key }}</a-button>
      <a-button @click="del(objData.key)">删除</a-button>
    </a-card>
  </div>
</template>

<script>
export default {
  name: "FirstCard",
  props: {
    handleSecond: Function,
    add: Function,
    del: Function,
    objData: Object
  },
  data() {
    return {}
  },
  methods: {}
}
</script>

<style scoped>

</style>