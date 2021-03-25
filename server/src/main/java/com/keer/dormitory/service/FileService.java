package com.keer.dormitory.service;

/**
 * @author: keer
 * @Date: 2021/3/25
 * @Description:
 */
public interface FileService {
    /**
     * 根据Excel表 异步创建宿舍楼信息
     * @param path
     */
    void asyncCreateBlock(String path);

    /**
     * 根据Excel表 异步创建学生信息
     * @param path
     */
    void asyncCreateStudent(String path);
}
