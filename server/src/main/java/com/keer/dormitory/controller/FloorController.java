package com.keer.dormitory.controller;


import com.keer.dormitory.core.model.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.keer.dormitory.core.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linhui
 * @since 2021-04-07
 */
@RestController
@RequestMapping("/floor")
public class FloorController extends BaseController {

    @GetMapping
    @ApiOperation("获取楼层平面图")
    public Result getImageInfo(@RequestParam Integer blockId,@RequestParam Integer floorNum){

        return null;
    }
}

