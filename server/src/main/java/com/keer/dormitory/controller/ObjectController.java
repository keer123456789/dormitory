package com.keer.dormitory.controller;


import com.keer.dormitory.core.model.Result;
import com.keer.dormitory.dto.ObjectInfo;
import com.keer.dormitory.entity.Block;
import com.keer.dormitory.entity.Floor;
import com.keer.dormitory.entity.Object;
import com.keer.dormitory.service.BlockService;
import com.keer.dormitory.service.FloorService;
import com.keer.dormitory.service.ObjectService;
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
 * 物品信息表 前端控制器
 * </p>
 *
 * @author linhui
 * @since 2021-04-07
 */
@RestController
@RequestMapping("/object")
public class ObjectController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(ObjectController.class);

    @Resource
    private ObjectService objectService;
    @Resource
    private FloorService floorService;
    @Resource
    private BlockService blockService;

    @PostMapping()
    @ApiOperation(value = "添加物品")
    public Result add(@RequestBody Object object) {
        logger.info("接收到请求 /object [POST] data:{}", object);
        if (objectService.save(object)) {
            return Result.ok();
        } else {
            return Result.error("添加物品失败");
        }
    }

    @GetMapping()
    @ApiOperation(value = "获取物品")
    public Result<List<ObjectInfo>> list() {
        logger.info("接收到请求 /object [GET] ");
        List<Object> objects = objectService.list();
        List<ObjectInfo> infos = new ArrayList<>();
        for (Object o : objects) {
            ObjectInfo info = new ObjectInfo();
            info.setKey(o.getId());
            info.setName(o.getName());
            info.setType(o.getType());
            info.setX(o.getX());
            info.setY(o.getY());
            Floor floor = floorService.getById(o.getFloorId());
            info.setFloor(floor.getName());
            Block block = blockService.getById(floor.getBlockId());
            info.setBlock(block.getName());
            infos.add(info);
        }
        return Result.ok(infos);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除物品")
    public Result delete(@RequestParam Integer key) {
        logger.info("接收到请求 /object/delete [GET] id:{} ", key);
        if (objectService.removeById(key)) {
            return Result.ok();
        } else {
            return Result.error("删除失败");
        }

    }
}

