package com.keer.dormitory.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.keer.dormitory.core.model.Result;
import com.keer.dormitory.dto.RegisterReq;
import com.keer.dormitory.entity.User;
import com.keer.dormitory.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.keer.dormitory.core.base.BaseController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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

    @ApiOperation(value = "用户登录接口")
    @GetMapping("/login")
    public Result<User> login(@RequestParam String username, @RequestParam String password, HttpServletRequest req) {
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
        wrapper.select("name","role","password");
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
        return Result.ok(user);
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


}

