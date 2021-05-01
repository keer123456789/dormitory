package com.keer.dormitory.service;

import com.keer.dormitory.dto.SortInfo;
import com.keer.dormitory.entity.Task;

import java.util.List;

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
     * @param taskId
     */
    void asyncCreateStudent(int taskId);


}
