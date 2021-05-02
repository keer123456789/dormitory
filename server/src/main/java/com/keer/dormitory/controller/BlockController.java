package com.keer.dormitory.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.keer.dormitory.core.model.PageData;
import com.keer.dormitory.core.model.PageResult;
import com.keer.dormitory.core.model.Result;
import com.keer.dormitory.dto.BlockInfoReq;
import com.keer.dormitory.dto.BlockResp;
import com.keer.dormitory.dto.RoomInfoDTO;
import com.keer.dormitory.entity.*;
import com.keer.dormitory.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.keer.dormitory.core.base.BaseController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 宿舍楼信息 前端控制器
 * </p>
 *
 * @author linhui
 * @since 2021-04-07
 */
@RestController
@RequestMapping("/block")
@Api(tags = "宿舍楼管理接口")
public class BlockController extends BaseController {
    public static Logger logger = LoggerFactory.getLogger(BlockController.class);
    @Resource
    private BlockService blockService;
    @Resource
    private FloorService floorService;
    @Resource
    private RoomService roomService;
    @Resource
    private StudentService studentService;
    @Resource
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "创建宿舍楼接口")
    public Result createBlock(@RequestBody BlockInfoReq data) {
        logger.info("接收到请求 [POST] /block, data:{}", data.toString());
        Block block = data.getBlock();
        if (!blockService.save(block)) {
            return Result.error("创建宿舍楼失败！");
        }
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < block.getFloorSize(); i++) {
            Floor floor = new Floor();
            floor.setBlockId(block.getId());
            floor.setFloorNum(i + 1);
            floor.setName((i + 1) + "层");
            floors.add(floor);
        }
        if (!floorService.saveBatch(floors)) {
            blockService.removeById(block.getId());
            QueryWrapper<Floor> wrapper = new QueryWrapper<>();
            wrapper.eq("block_id", block.getId());
            floorService.remove(wrapper);
            return Result.error("创建宿舍楼失败！");
        }
        Map<Integer, Integer> floorNumToIdMap = floors.stream().collect(Collectors.toMap(Floor::getFloorNum, Floor::getId));
        List<Room> rooms = new ArrayList<>();
        for (RoomInfoDTO roomInfoDTO : data.getRooms()) {
            Room room = new Room();
            room.setName(roomInfoDTO.getName());
            room.setEmptySize(block.getRoomSize());
            room.setSize(block.getRoomSize());
            room.setFloorId(floorNumToIdMap.get(roomInfoDTO.getFloorNum()));
            rooms.add(room);
        }
        if (!roomService.saveBatch(rooms)) {
            List<Integer> floorIds = floors.stream().map(Floor::getId).collect(Collectors.toList());
            blockService.removeById(block.getId());
            QueryWrapper<Floor> wrapper = new QueryWrapper<>();
            wrapper.eq("block_id", block.getId());
            floorService.remove(wrapper);
            QueryWrapper<Room> roomQueryWrapper = new QueryWrapper<>();
            roomQueryWrapper.in("floor_id", floorIds);
            roomService.remove(roomQueryWrapper);
            return Result.error("创建宿舍楼失败！");
        }
        return Result.ok();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "删除宿舍楼接口")
    public Result deleteBlock(@PathVariable String id) {
        logger.info("接收到请求 [DELETE] /block/{}", id);
        /**
         * 删除宿舍楼
         */
        blockService.removeById(id);
        /**
         * 删除宿舍楼对应的楼层
         */
        QueryWrapper<Floor> floorWrapper = new QueryWrapper<>();
        floorWrapper.eq("block_id", id);
        List<Floor> floors = floorService.list(floorWrapper);
        floorService.remove(floorWrapper);

        /**
         * 删除宿舍楼对应的宿舍房间
         */
        QueryWrapper<Room> roomWrapper = new QueryWrapper<>();
        for (Floor floor : floors) {
            roomWrapper.eq("floor_id", floor.getId()).or();
        }
        List<Room> rooms = roomService.list(roomWrapper);
        roomService.remove(roomWrapper);

        /**
         * 将对应的宿舍学生信息更改
         */
        UpdateWrapper<Student> studentWrapper = new UpdateWrapper<>();
        studentWrapper.set("room_id", null);
        for (Room room : rooms) {
            studentWrapper.eq("room_id", room.getId()).or();
        }
        studentService.update(studentWrapper);

        return Result.ok();
    }

    @GetMapping()
    @ApiOperation(value = "获得宿舍楼信息")
    public Result<List<BlockResp>> list() {
        logger.info("接收到请求 [GET] /block");
        List<Block> blocks = blockService.list();
        List<BlockResp> resps = new ArrayList<>();
        for (Block block : blocks) {
            BlockResp blockResp = new BlockResp();
            blockResp.setId(block.getId());
            blockResp.setName(block.getName());

            if (block.getManagerId() != null) {
                QueryWrapper<User> userWrapper = new QueryWrapper<>();
                userWrapper.eq("id", block.getManagerId());
                User user = userService.getOne(userWrapper);
                blockResp.setManagerName(user.getName());
            }

            QueryWrapper<Floor> floorQueryWrapper = new QueryWrapper<>();
            floorQueryWrapper.eq("block_id", block.getId());
            List<Floor> floors = floorService.list(floorQueryWrapper);
            blockResp.setFloorNum(floors.size());

            if (floors.isEmpty()) {
                resps.add(blockResp);
                continue;
            }
            List<Integer> floorIds = floors.stream().map(Floor::getId).collect(Collectors.toList());
            QueryWrapper<Room> roomQueryWrapper = new QueryWrapper<>();
            roomQueryWrapper.in("floor_id", floorIds);
            List<Room> rooms = roomService.list(roomQueryWrapper);
            blockResp.setRoomNum(rooms.size());

            if (rooms.isEmpty()) {
                resps.add(blockResp);
                continue;
            }
            List<Integer> roomIds = rooms.stream().map(Room::getId).collect(Collectors.toList());
            QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
            studentQueryWrapper.in("room_id", floorIds);
            blockResp.setStudentNum(studentService.count(studentQueryWrapper));

            resps.add(blockResp);
        }

        return Result.ok(resps);
    }
}

