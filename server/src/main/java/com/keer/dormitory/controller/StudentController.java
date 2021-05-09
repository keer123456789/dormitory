package com.keer.dormitory.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.keer.dormitory.core.model.Result;
import com.keer.dormitory.dto.StudentInfo;
import com.keer.dormitory.entity.Block;
import com.keer.dormitory.entity.Floor;
import com.keer.dormitory.entity.Room;
import com.keer.dormitory.entity.Student;
import com.keer.dormitory.service.BlockService;
import com.keer.dormitory.service.FloorService;
import com.keer.dormitory.service.RoomService;
import com.keer.dormitory.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.keer.dormitory.core.base.BaseController;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    private FloorService floorService;
    @Resource
    private BlockService blockService;
    @Resource
    private RoomService roomService;

    @PostMapping
    @ApiOperation("增加学生信息")
    public Result add(@RequestBody Student student) {
        logger.info("接收到请求: /student [POST],data:{}", student);
        if (studentService.getById(student.getId()) != null) {
            return Result.error("学生已经存在");
        }
        Room room=roomService.getById(student.getRoomId());
        if(room==null){
            return Result.error("房间不存在！");
        }
        if(student.getBedNum()>room.getSize()||student.getBedNum()<1){
            return Result.error("床位号错误");
        }

        if (!studentService.save(student)) {
            return Result.error("增加学生信息失败！");
        }
        return Result.ok();
    }

    @PostMapping("/update")
    @ApiOperation("更新学生信息")
    public Result update(@RequestBody Student student) {
        logger.info("接收到请求: /student/update [POST],data:{}", student);
        if (studentService.getById(student.getId()) == null) {
            return Result.error("学生不存在");
        }
        Student oldStudent = studentService.getById(student.getId());
        if (!student.getRoomId().equals(oldStudent.getRoomId())) {
            QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("room_id", student.getRoomId());
            int count = studentService.count(queryWrapper);

            Room newRoom = roomService.getById(student.getRoomId());
            if (count >= newRoom.getSize()) {
                return Result.error("宿舍已满");
            }
            newRoom.setEmptySize(newRoom.getEmptySize() - 1);
            roomService.updateById(newRoom);

            Room oldRoom = roomService.getById(oldStudent.getRoomId());
            oldRoom.setEmptySize(oldRoom.getEmptySize() + 1);
            roomService.updateById(oldRoom);
        }
        if (!studentService.updateById(student)) {
            return Result.error("更新学生信息失败！");
        }
        return Result.ok();
    }

    @GetMapping("/stop")
    @ApiOperation("学生退宿")
    public Result stop(@RequestParam String id) {
        logger.info("接收到请求: /student/stop [GET],data:{}", id);
        if (studentService.getById(id) == null) {
            return Result.error("学生不存在");
        }
        Student student = studentService.getById(id);
        if (student == null) {
            return Result.ok();
        }
        if (student.getRoomId() != null) {
            Room room = roomService.getById(student.getRoomId());
            if (room != null) {
                room.setEmptySize(room.getEmptySize() + 1);
                roomService.updateById(room);
            }
        }
        if (!studentService.removeById(id)) {
            return Result.error("退宿失败！");
        }
        return Result.ok();
    }

    @GetMapping()
    @ApiOperation("获取学生信息列表")
    public Result<List<StudentInfo>> list() {
        logger.info("接收到请求： /student [GET]");
        List<Student> students = studentService.list();
        List<StudentInfo> infos = new ArrayList<>();
        for (Student student : students) {
            StudentInfo info = new StudentInfo();
            info.setId(student.getId());
            info.setAcademy(student.getAcademy());
            info.setAddress(student.getAddress());
            info.setName(student.getName());
            info.setBedNum(student.getBedNum());
            if (student.getSex() == 0) {
                info.setSex("男");
            } else {
                info.setSex("女");
            }
            info.setIdentityNum(student.getIdentityNum());
            info.setClassNum(student.getClassNum());
            info.setMajor(student.getMajor());
            info.setNation(student.getNation());
            info.setPhoneNum(student.getPhoneNum());
            info.setRegion(student.getRegion());

            info.setRoomId(student.getRoomId());
            if (student.getRoomId() != null) {
                Room room = roomService.getById(student.getRoomId());
                info.setRoom(room.getName());
                Floor floor = floorService.getById(room.getFloorId());
                info.setFloor(floor.getName());
                info.setFloorId(floor.getId());
                Block block = blockService.getById(floor.getBlockId());
                info.setBlock(block.getName());
                info.setBlockId(block.getId());
            }
            infos.add(info);
        }
        return Result.ok(infos);
    }

}

