package com.keer.dormitory.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keer.dormitory.core.model.Result;
import com.keer.dormitory.dto.RegisterReq;
import com.keer.dormitory.dto.SetBlockManagerReq;
import com.keer.dormitory.dto.UserInfoDTO;
import com.keer.dormitory.entity.Block;
import com.keer.dormitory.entity.User;
import com.keer.dormitory.service.BlockService;
import com.keer.dormitory.service.UserService;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.keer.dormitory.core.base.BaseController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 用户信息 表 前端控制器
 * </p>
 *
 * @author linhui
 * @since 2021-03-23
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理接口")
public class UserController extends BaseController {
    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;
    @Resource
    private BlockService blockService;

    @ApiOperation(value = "用户登录接口")
    @GetMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password, HttpServletRequest req) {
        logger.info("接收到请求[GET]: /user/login,username:{},password:{}", username, password);
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return Result.error("参数缺失，请检查");
        }
        HttpSession session = req.getSession();
        User oldUser = (User) session.getAttribute("userInfo");
        if (oldUser != null && oldUser.getName().equals(username)) {
            return Result.ok(oldUser);
        }
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.select("name", "role", "password");
        wrapper.eq("name", username);
        User user = userService.getOne(wrapper);
        if (user == null) {
            return Result.error("用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            return Result.error("密码错误");
        }
        user.setPassword(null);
        session.setAttribute("userInfo", user);
        JSONObject resultJson = new JSONObject();
        resultJson.put("token", "Authorization:" + UUID.randomUUID().toString());
        resultJson.put("expireAt", getTomorrow());
        resultJson.put("permissions", JSON.parse("[{\"id\":\"queryForm\",\"operation\":[\"add\",\"edit\"]}]"));
        resultJson.put("roles", JSON.parse("[{\"id\":\"admin\",\"operation\":[\"add\",\"edit\",\"delete\"]}]"));
        return Result.ok(resultJson);
    }

    @ApiOperation(value = "用户注册接口")
    @PostMapping("/register")
    public Result register(@RequestBody RegisterReq data) {
        logger.info("接收到请求[POST]: /user/register, data : {}", data);
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("name", data.getUsername());
        int sum = userService.count(wrapper);
        if (sum > 0) {
            return Result.error("用户名存在，注册失败！");
        }
        User user = new User();
        user.setName(data.getUsername());
        user.setPassword(data.getPassword());
        if (userService.save(user)) {
            return Result.ok();
        } else {
            return Result.error("注册失败！！");
        }
    }

    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "String", paramType = "query")})
    @ApiOperation(value = "管理员  获取全部用户信息")
    public Result<List<UserInfoDTO>> list(HttpServletRequest req) {
        User loginUser = (User) req.getSession().getAttribute("userInfo");
        if (loginUser == null || loginUser.getRole() != 0) {
            logger.info("接收到请求[GET]: /user ；权限不足，user ：{}", loginUser);
            return Result.roleError();
        }
        Page<User> page = this.getPage();
        logger.info("接收到请求[GET]: /user, pageNum : {},pageSize:{}", page.getCurrent(), page.getSize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id", "name", "role");
        wrapper.gt("role", 0);
        page = userService.page(page, wrapper);
        List<User> users = page.getRecords();
        List<UserInfoDTO> userInfos = new ArrayList<>();
        for (User user : page.getRecords()) {
            UserInfoDTO userInfo = new UserInfoDTO();
            userInfo.setUserName(user.getName());
            userInfo.setRole(user.getRole());
            QueryWrapper<Block> blockWrapper = new QueryWrapper();
            blockWrapper.eq("manager_id", user.getId());
            for (Block block : blockService.list(blockWrapper)) {
                userInfo.addBlockInfo(block.getId(), block.getName());
            }
            userInfos.add(userInfo);
        }
        return Result.ok(userInfos);
    }

    @PostMapping
    @ApiOperation(value = "管理员  给宿管分配宿舍楼")
    public Result setBlockManager(@RequestBody SetBlockManagerReq data, HttpServletRequest req) {
        User loginUser = (User) req.getSession().getAttribute("userInfo");
        if (loginUser == null || loginUser.getRole() != 0) {
            logger.info("接收到请求[POST]: /user ；权限不足，user ：{}", loginUser);
            return Result.roleError();
        }
        logger.info("接收到请求[POST]: /user ；data：{}", data);
        QueryWrapper<User> userWrapper = new QueryWrapper();
        userWrapper.eq("name", data.getUserName());
        User user = userService.getOne(userWrapper);
        if (user == null) {
            return Result.error("用户不存在");
        }

        QueryWrapper<Block> blockWrapper = new QueryWrapper();
        blockWrapper.in("id", data.getBlock());
        if (blockService.count(blockWrapper) != data.getBlock().size()) {
            return Result.error("有错误的宿舍楼id，请检查！！");
        }
        UpdateWrapper<Block> updateWrapper = new UpdateWrapper();
        updateWrapper.set("manager_id", user.getId());
        updateWrapper.in("id", data.getBlock());
        if (blockService.update(updateWrapper)) {
            return Result.ok();
        } else {
            return Result.error("数据库操作错误！！");
        }
    }

    /**
     * 获取当前的时间的明天时间
     *
     * @return
     */
    private String getTomorrow() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}

