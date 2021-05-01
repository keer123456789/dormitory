package com.keer.dormitory.service;

import com.keer.dormitory.dto.SortInfo;
import com.keer.dormitory.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 任务表 服务类
 * </p>
 *
 * @author linhui
 * @since 2021-04-12
 */
public interface TaskService extends IService<Task> {
    /**
     * 根据任务id获取分配宿舍信息
     * @param taskId
     * @param sex
     * @return
     */
    List<SortInfo> getSortInfo(int taskId, int sex);

    /**
     * 分配宿舍
     * @param task
     * @param sex
     */
    void sortRoom(Task task, int sex);
}
