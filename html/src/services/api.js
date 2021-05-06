//跨域代理前缀
const API_PROXY_PREFIX='/api'
const BASE_URL = process.env.NODE_ENV === 'production' ? process.env.VUE_APP_API_BASE_URL : API_PROXY_PREFIX
// const BASE_URL = process.env.VUE_APP_API_BASE_URL
// const BASE_URL = `http://127.0.0.1:8080`;
module.exports = {
  LOGIN: `${BASE_URL}/login`,
  REGISTER: `${BASE_URL}/register`,
  ROUTES: `${BASE_URL}/routes`,
  GOODS: `${BASE_URL}/goods`,
  USERS: `${BASE_URL}/users`,
  MAPDATA: `${BASE_URL}/mapdata`,
  OBJECT: `${BASE_URL}/object`,
  GETBUILDDATA: `${BASE_URL}/getbuilddata`,
  STUDENT: `${BASE_URL}/student`,
  GETSTUDENT: `${BASE_URL}/getstudent`,
  STOP: `${BASE_URL}/stop`,
  UPDATE: `${BASE_URL}/update`,
  GETOBJECT: `${BASE_URL}/getobject`,
  DELOBJECT: `${BASE_URL}/delobject`,
}
