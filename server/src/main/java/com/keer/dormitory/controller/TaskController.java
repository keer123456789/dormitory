package com.keer.dormitory.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.keer.dormitory.core.model.Result;
import com.keer.dormitory.dto.BlockSortInfo;
import com.keer.dormitory.dto.SortInfo;
import com.keer.dormitory.entity.Student;
import com.keer.dormitory.entity.Task;
import com.keer.dormitory.service.StudentService;
import com.keer.dormitory.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.keer.dormitory.core.base.BaseController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 任务表 前端控制器
 * </p>
 *
 * @author linhui
 * @since 2021-04-07
 */
@RestController
@RequestMapping("/task")
@Api(tags = "任务管理接口")
public class TaskController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Resource
    private TaskService taskService;
    @Resource
    private StudentService studentService;

    @ApiOperation(value = "更新任务")
    @PostMapping("/update-info")
    @ResponseBody
    public Result<Integer> updateTask(@RequestBody Task data) {
        logger.info("接收到请求 /task/update [POST] data:{}", data);
        if (taskService.updateById(data)) {
            return Result.ok();
        }
        return Result.error("更新任务失败！");
    }

    @ApiOperation(value = "运行任务")
    @GetMapping("/run/{taskId}")
    @ResponseBody
    public Result runTask(@PathVariable Integer taskId) {
        logger.info("接收到请求 /task/run/{} [GET] ", taskId);
        Task task = taskService.getById(taskId);
        taskService.sortRoom(task, 0);
        taskService.sortRoom(task, 1);
        return Result.ok();
    }

    @GetMapping("/sort-info/{taskId}")
    @ApiOperation("获取分配宿舍的信息")
    public Result<BlockSortInfo> getSortInfo(@PathVariable Integer taskId) {
        logger.info("接收到请求 /task/sort-info/{} [GET]", taskId);
        Task task = taskService.getById(taskId);
        List<SortInfo> maleSortInfo = taskService.getSortInfo(taskId, 0);
        List<SortInfo> femaleSortInfo = taskService.getSortInfo(taskId, 1);
        BlockSortInfo blockSortInfo = new BlockSortInfo();
        blockSortInfo.setFemaleInfo(femaleSortInfo);
        blockSortInfo.setMaleInfo(maleSortInfo);
        blockSortInfo.setRoomSizeFemale(task.getRoomSizeFemale());
        blockSortInfo.setRoomSizeMale(task.getRoomSizeMale());

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("task_id", task.getId());
        queryWrapper.eq("sex", 0);
        int maleNum = studentService.count(queryWrapper);
        blockSortInfo.setMaleNum(maleNum);
        if (maleNum % task.getRoomSizeMale() == 0) {
            blockSortInfo.setRoomNumMale(maleNum / task.getRoomSizeMale());
        } else {
            blockSortInfo.setRoomNumMale(maleNum / task.getRoomSizeMale() + 1);
        }

        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("task_id", task.getId());
        queryWrapper.eq("sex", 1);
        int femaleNum = studentService.count(queryWrapper);
        blockSortInfo.setFemaleNum(femaleNum);
        if (femaleNum % task.getRoomSizeFemale() == 0) {
            blockSortInfo.setRoomNumFemale(femaleNum / task.getRoomSizeFemale());
        } else {
            blockSortInfo.setRoomNumFemale(femaleNum / task.getRoomSizeFemale() + 1);
        }
        return Result.ok(blockSortInfo);
    }
}

