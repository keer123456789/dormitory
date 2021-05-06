import Mock from 'mockjs'
import '@/mock/user/current'

import '@/mock/user/login'

import '@/mock/user/routes'
import '@/mock/goods'
import '@/mock/user/users'
import '@/mock/block/mapdata'
import '@/mock/object/object'
import '@/mock/getbuilddata/getbuilddata'
import '@/mock/student/student'
import '@/mock/getstudent/getstudent'
import '@/mock/stop/stop'
import '@/mock/update/update'
import '@/mock/getobject/getobject'
import '@/mock/delobject/delobject'

// 设置全局延时
Mock.setup({
  timeout: '200-400'
})
