<template>
  <div>
    <a-card>
      <a-radio-group v-model="value" @change="onChange">
        <a-radio :value="1">
          A
        </a-radio>
        <a-radio :value="2">
          B
        </a-radio>
        <a-radio :value="3">
          C
        </a-radio>
        <a-radio :value="4">
          D
        </a-radio>
      </a-radio-group>
    </a-card>
  </div>
</template>

<script>
export default {
  name: "SecondCard",
  props:{
    selectValue: Function
  },
  data() {
    return {
      value: 0,
    };
  },
  methods: {
    onChange(e) {
      console.log('radio checked', e.target.value);
      this.selectValue(e.target.value)
    },
  },
}
</script>

<style scoped>

</style>