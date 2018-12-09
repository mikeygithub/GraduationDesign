package com.mikey.design.service.impl;

import com.mikey.design.entity.Admin;
import com.mikey.design.mapper.AdminMapper;
import com.mikey.design.mapper.DesignMapper;
import com.mikey.design.mapper.StudentMapper;
import com.mikey.design.mapper.TeacherMapper;
import com.mikey.design.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/28 18:47
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private DesignMapper designMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public long getTeacherNum() {
        return teacherMapper.countByExample(null);
    }

    @Override
    public long getStudentNum() {
        return studentMapper.countByExample(null);
    }
    /**
     * 获取全部题目总数
     * @return
     */
    @Override
    public long allTitleNum() {
        return designMapper.countByExample(null);
    }

    /**
     * 管理员信息
     * @param adminId
     * @return
     */
    @Override
    public Admin getAdmin(int adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    /**
     * 更新管理员
     * @param admin
     */
    @Override
    public void updataAdmin(Admin admin) {
        adminMapper.updateByPrimaryKey(admin);
    }

    /**
     *统计已经填报志愿的学生个数
     * @return
     */
    @Override
    public long getAlreadyFillWishStudentNum() {
        return teacherMapper.getAlreadyFillWishStudentNum();
    }

    /**
     * 统计未填报志愿的学生个数
     * @return
     */
    @Override
    public long getNotFillWishStudentNum() {
        return teacherMapper.getNotFillWishStudentNum();
    }
}
