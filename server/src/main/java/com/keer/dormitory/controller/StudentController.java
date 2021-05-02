package com.keer.dormitory.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.keer.dormitory.core.model.Result;
import com.keer.dormitory.entity.Room;
import com.keer.dormitory.entity.Student;
import com.keer.dormitory.service.RoomService;
import com.keer.dormitory.service.StudentService;
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
 * 学生信息表 前端控制器
 * </p>
 *
 * @author linhui
 * @since 2021-04-07
 */
@RestController
@RequestMapping("/student")
@Api(tags = "学生管理接口")
public class StudentController extends BaseController {
    public static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private StudentService studentService;

    @Resource
    private RoomService roomService;

    @PostMapping
    @ApiOperation("增加学生信息")
    public Result add(@RequestBody Student student) {
        logger.info("接收到请求: /student [POST],data:{}", student);
        if (studentService.getById(student.getId()) != null) {
            return Result.error("学生已经存在");
        }
        if (!studentService.save(student)) {
            return Result.error("增加学生信息失败！");
        }
        return Result.ok();
    }

    @PostMapping("/update")
    @ApiOperation("分配学生宿舍")
    public Result update(@RequestBody Student student) {
        logger.info("接收到请求: /student [PUT],data:{}", student);
        if (studentService.getById(student.getId()) == null) {
            return Result.error("学生不存在");
        }
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("room_id", student.getRoomId());
        int count = studentService.count(queryWrapper);
        Room room = roomService.getById(student.getRoomId());
        if (count >= room.getSize()) {
            return Result.error("宿舍已满");
        }
        if (!studentService.updateById(student)) {
            return Result.error("更新学生信息失败！");
        }
        return Result.ok();
    }

    @GetMapping("/stop/{student_id}")
    @ApiOperation("学生退宿")
    public Result stop(@PathVariable String student_id) {
        logger.info("接收到请求: /student/stop [GET],data:{}", student_id);
        if (studentService.getById(student_id) == null) {
            return Result.error("学生不存在");
        }
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", student_id);
        updateWrapper.set("room_id", null);
        if (!studentService.update(updateWrapper)) {
            return Result.error("更新学生信息失败！");
        }
        return Result.ok();
    }

    @GetMapping()
    @ApiOperation("获取学生信息列表")
    public Result<List<Student>> list() {
        logger.info("接收到请求： /student [GET]");
        List<Student> students = studentService.list();
        return Result.ok(students);
    }

}

