package com.keer.dormitory.controller;


import com.keer.dormitory.core.model.Result;
import com.keer.dormitory.entity.Object;
import com.keer.dormitory.service.ObjectService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.keer.dormitory.core.base.BaseController;

import javax.annotation.Resource;

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
}

