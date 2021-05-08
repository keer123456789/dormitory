import {GOODS, USERS, MAPDATA, OBJECT, GETBUILDDATA, STUDENT, GETSTUDENT, STOP, UPDATE, GETOBJECT, DELOBJECT, EDITUSER } from './api'
import {METHOD, request} from '@/utils/request'

export async function goodsList(params) {
  return request(GOODS, METHOD.GET, params)
}

/**
 * 获取用户列表
 * @param {*} pageSize 
 * @param {*} pageNum 
 * @returns 
 */
export async function users(params){
  return request(USERS, METHOD.GET, params)
}

export async function getMapData(params){
  return request(MAPDATA, METHOD.GET, params)
}

export async function object(params){
  return request(OBJECT, METHOD.POST, params)
}

export async function getBuildData(){
  return request(GETBUILDDATA, METHOD.GET)
}

export async function student(params){
  return request(STUDENT, METHOD.POST, params)
}

export async function getStudent(){
  return request(GETSTUDENT, METHOD.GET)
}

export async function stop(params) {
  return request(STOP, METHOD.GET, params)
}

export async function update(params) {
  return request(UPDATE, METHOD.POST, params)
}

export async function getObject(){
  return request(GETOBJECT, METHOD.GET)
}

export async function delObject(params) {
  return request(DELOBJECT, METHOD.GET, params)
}

export async function editUser(params) {
  return request(EDITUSER, METHOD.POST, params)
}

export default {goodsList, users}