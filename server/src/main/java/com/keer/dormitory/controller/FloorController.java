package com.keer.dormitory.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.keer.dormitory.core.model.Result;
import com.keer.dormitory.dto.ImageInfo;
import com.keer.dormitory.dto.Location;
import com.keer.dormitory.entity.Floor;
import com.keer.dormitory.entity.Room;
import com.keer.dormitory.entity.Student;
import com.keer.dormitory.service.FloorService;
import com.keer.dormitory.service.RoomService;
import com.keer.dormitory.service.StudentService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.keer.dormitory.core.base.BaseController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author linhui
 * @since 2021-04-07
 */
@RestController
@RequestMapping("/floor")
public class FloorController extends BaseController {
    @Resource
    private FloorService floorService;
    @Resource
    private RoomService roomService;
    @Resource
    private StudentService studentService;

    @GetMapping("/image-info")
    @ApiOperation("获取楼层平面图")
    public Result<ImageInfo> getImageInfo(@RequestParam Integer blockId, @RequestParam Integer floorNum) {
        ImageInfo imageInfo = new ImageInfo();
        QueryWrapper<Floor> floorQueryWrapper = new QueryWrapper<>();
        floorQueryWrapper.eq("block_id", blockId);
        floorQueryWrapper.eq("floor_num", floorNum);
        Floor floor = floorService.getOne(floorQueryWrapper);
        QueryWrapper<Room> roomQueryWrapper = new QueryWrapper<>();
        roomQueryWrapper.eq("floor_id", floor.getId());
        List<Room> rooms = roomService.list(roomQueryWrapper);
        for (Room room : rooms) {
            Location location = new Location();
            location.setType("宿舍坐标");
            location.setName(room.getName());
            location.setX(Integer.parseInt(room.getLocationX()));
            location.setY(Integer.parseInt(room.getLocationY()));
            imageInfo.addRoomLocation(location);
        }
        List<Integer> roomIds = rooms.stream().map(Room::getId).collect(Collectors.toList());
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.in("room_id", roomIds);
        List<Student> students = studentService.list(studentQueryWrapper);
        for (Student student : students) {
            Location location = new Location();
            location.setType("学生坐标");
            location.setName(student.getName());
            location.setX(Integer.parseInt(student.getLocationX()));
            location.setY(Integer.parseInt(student.getLocationY()));
            imageInfo.addStudentLocation(location);
        }
        return Result.ok(imageInfo);
    }

}

