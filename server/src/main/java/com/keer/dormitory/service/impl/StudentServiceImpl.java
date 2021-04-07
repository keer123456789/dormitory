package com.keer.dormitory.service.impl;

import com.keer.dormitory.entity.Student;
import com.keer.dormitory.mapper.StudentMapper;
import com.keer.dormitory.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author linhui
 * @since 2021-04-07
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
