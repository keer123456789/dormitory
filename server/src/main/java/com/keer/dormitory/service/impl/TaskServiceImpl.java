package com.keer.dormitory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.keer.dormitory.dto.SortInfo;
import com.keer.dormitory.entity.*;
import com.keer.dormitory.mapper.TaskMapper;
import com.keer.dormitory.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    private StudentService studentService;
    @Resource
    private FloorService floorService;
    @Resource
    private RoomService roomService;
    @Resource
    private BlockService blockService;
    @Value("${image-location.type1.bed-distance}")
    private int bedDistance;
    @Value("${image-location.type1.up.start-y}")
    private int upStartY;

    /**
     * 给学生跟配宿舍
     *
     * @param task
     * @param sex  性别
     */
    @Override
    public void sortRoom(Task task, int sex) {
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("task_id", task.getId());
        studentQueryWrapper.eq("sex", sex);
        studentQueryWrapper.orderByAsc("class_num");
        List<Student> students = studentService.list(studentQueryWrapper);

        String[] blockIds = null;
        if (sex == 0) {
            blockIds = task.getMaleBlock().split(",");
        } else {
            blockIds = task.getFemaleBlock().split(",");
        }
        List<Room> roomList = new ArrayList<>();
        for (String id : blockIds) {
            QueryWrapper<Floor> floorQueryWrapper = new QueryWrapper<>();
            floorQueryWrapper.eq("block_id", Integer.parseInt(id));
            List<Floor> floors = floorService.list(floorQueryWrapper);
            List<Integer> floorIds = floors.stream().map(Floor::getId).collect(Collectors.toList());
            QueryWrapper<Room> roomQueryWrapper = new QueryWrapper<>();
            roomQueryWrapper.in("floor_id", floorIds);
            roomQueryWrapper.eq("`size`-`empty_size`", 0);
            List<Room> rooms = roomService.list(roomQueryWrapper);
            roomList.addAll(rooms);
        }

        int index = 0;
        for (Room room : roomList) {
            int empty = 0;
            int roomSize = 0;
            if (sex == 0) {
                roomSize = task.getRoomSizeMale();
                empty = task.getRoomSizeMale();
            } else {
                roomSize = task.getRoomSizeFemale();
                empty = task.getRoomSizeFemale();
            }
            for (int i = 0; i < roomSize; i++) {
                if (index >= students.size()) {
                    break;
                }
                students.get(index).setRoomId(room.getId());
                students.get(index).setBedNum(i + 1);
                students.get(index).setLocationX(room.getLocationX());
                if (Integer.parseInt(room.getName()) % 2 == 0) {
                    students.get(index).setLocationY((Integer.parseInt(room.getLocationY()) + (i + 1) * bedDistance) + "");
                } else {
                    students.get(index).setLocationY((upStartY + i * bedDistance) + "");
                }
                empty--;
                index++;
            }
            room.setEmptySize(empty);
            room.setSize(roomSize);
            if (index >= students.size()) {
                break;
            }
        }
        studentService.updateBatchById(students);
        roomService.updateBatchById(roomList);
    }

    @Override
    public List<SortInfo> getSortInfo(int taskId, int sex) {
        Task task = this.getById(taskId);
        QueryWrapper<Student> studentWrapper = new QueryWrapper();
        studentWrapper.eq("sex", sex);
        studentWrapper.eq("task_id", taskId);
        int studentNum = studentService.count(studentWrapper);
        int roomSize = 0;
        if (sex == 0) {
            roomSize = task.getRoomSizeMale();
        } else {
            roomSize = task.getRoomSizeFemale();
        }

        int roomNum = studentNum / roomSize + 1;

        QueryWrapper<Block> blockQueryWrapper = new QueryWrapper<>();
        blockQueryWrapper.eq("sex", sex);
        List<Block> blocks = blockService.list(blockQueryWrapper);
        List<SortInfo> res = new ArrayList<>();
        for (Block block : blocks) {
            QueryWrapper<Floor> floorQueryWrapper = new QueryWrapper<>();
            floorQueryWrapper.eq("block_id", block.getId());
            List<Floor> floors = floorService.list(floorQueryWrapper);
            List<Integer> floorIds = floors.stream().map(Floor::getId).collect(Collectors.toList());
            QueryWrapper<Room> roomQueryWrapper = new QueryWrapper<>();
            roomQueryWrapper.in("floor_id", floorIds);
            roomQueryWrapper.eq("`size`-`empty_size`", 0);
            int num = roomService.count(roomQueryWrapper);
            if (num >= roomNum) {
                SortInfo sortInfo = new SortInfo();
                sortInfo.setBlockId(block.getId());
                sortInfo.setBlockName(block.getName());
                sortInfo.setEmptyRoom(num);
                res.add(sortInfo);
            }
        }
        return res;
    }
}
