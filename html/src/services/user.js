import {LOGIN, REGISTER, ROUTES} from '@/services/api'
import {request, METHOD, removeAuthorization} from '@/utils/request'

/**
 * 登录服务
 * @param name 账户名
 * @param password 账户密码
 * @returns {Promise<AxiosResponse<T>>}
 */
export async function login(name, password) {
  return request(LOGIN, METHOD.GET, {
    username: name,
    password: password
  })
}

/**
 * 注册服务
 * @param {*} name 
 * @param {*} password 
 */
export async function register(username	, password) {
  return request(REGISTER, METHOD.POST, {
    username: username,
    password: password
  })
}

export async function getRoutesConfig() {
  return request(ROUTES, METHOD.GET)
}

/**
 * 退出登录
 */
export function logout() {
  localStorage.removeItem(process.env.VUE_APP_ROUTES_KEY)
  localStorage.removeItem(process.env.VUE_APP_PERMISSIONS_KEY)
  localStorage.removeItem(process.env.VUE_APP_ROLES_KEY)
  removeAuthorization()
}

export default {
  login,
  logout,
  getRoutesConfig,
  register
}
