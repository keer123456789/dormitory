import TabsView from '@/layouts/tabs/TabsView'
import BlankView from '@/layouts/BlankView'

// 路由配置
const options = {
  routes: [
    {
      path: '/login',
      name: '登录页',
      component: () => import('@/pages/login')
    },
    {
      path: '/register',
      name: '注册页',
      component: () => import('@/pages/register')
    },
    {
      path: '*',
      name: '404',
      component: () => import('@/pages/exception/404'),
    },
    {
      path: '/403',
      name: '403',
      component: () => import('@/pages/exception/403'),
    },
    {
      path: '/',
      name: '首页',
      component: TabsView,
      redirect: '/login',
      children: [
        {
          path: 'dashboard',
          name: '工作页',
          meta: {
            icon: 'dashboard'
          },
          component: BlankView,
          children: [
            {
              path: 'workplace',
              name: '分配详情',
              meta: {
                page: {
                  closable: false
                }
              },
              component: () => import('@/pages/dashboard/workplace'),
            },
            {
              path: 'buildDistribution',
              name: '管理员信息',
              meta: {
                page: {
                  closable: true
                }
              },
              component: () => import('@/pages/dashboard/buildDistribution'),
            },
            {
              path: 'uploadStudent',
              name: '上传学生信息',
              meta: {
                page: {
                  closable: true
                }
              },
              component: () => import('@/pages/dashboard/uploadStudent'),
            },
            {
              path: 'studentInfo',
              name: '学生信息',
              meta: {
                page: {
                  closable: true
                }
              },
              component: () => import('@/pages/dashboard/studentInfo'),
            },
            {
              path: 'objectInfo',
              name: '物品信息',
              meta: {
                page: {
                  closable: true
                }
              },
              component: () => import('@/pages/dashboard/objectInfo'),
            }
          ]
          
        }
      ]
    },
  ]
}

export default options
