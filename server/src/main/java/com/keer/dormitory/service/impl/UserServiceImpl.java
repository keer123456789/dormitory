package com.keer.dormitory.service.impl;

import com.keer.dormitory.entity.User;
import com.keer.dormitory.mapper.UserMapper;
import com.keer.dormitory.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 表 服务实现类
 * </p>
 *
 * @author linhui
 * @since 2021-03-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
