package com.keer.dormitory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.keer.dormitory.dto.SortInfo;
import com.keer.dormitory.entity.*;
import com.keer.dormitory.mapper.TaskMapper;
import com.keer.dormitory.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
        List<Student> maleStudents = studentService.list(studentQueryWrapper);

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
            int empty = task.getRoomSize();
            for (int i = 0; i < task.getRoomSize(); i++) {
                if (index >= maleStudents.size()) {
                    break;
                }
                maleStudents.get(index).setRoomId(room.getId());
                maleStudents.get(index).setBedNum(i + 1);
                empty--;
                index++;
            }
            room.setEmptySize(empty);
            room.setSize(task.getRoomSize());
            if (index >= maleStudents.size()) {
                break;
            }
        }
        studentService.updateBatchById(maleStudents);
        roomService.updateBatchById(roomList);
    }

    @Override
    public List<SortInfo> getSortInfo(int taskId, int sex) {
        Task task = this.getById(taskId);
        QueryWrapper<Student> studentWrapper = new QueryWrapper();
        studentWrapper.eq("sex", sex);
        studentWrapper.eq("task_id", taskId);
        int studentNum = studentService.count(studentWrapper);
        int roomNum = studentNum / task.getRoomSize() + 1;

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
