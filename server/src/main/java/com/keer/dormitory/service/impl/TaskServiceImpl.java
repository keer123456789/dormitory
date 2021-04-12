package com.keer.dormitory.service.impl;

import com.keer.dormitory.entity.Task;
import com.keer.dormitory.mapper.TaskMapper;
import com.keer.dormitory.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务表 服务实现类
 * </p>
 *
 * @author linhui
 * @since 2021-04-12
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
