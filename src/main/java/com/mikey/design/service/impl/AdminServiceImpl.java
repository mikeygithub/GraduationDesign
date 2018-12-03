package com.mikey.design.service.impl;

import com.mikey.design.entity.Admin;
import com.mikey.design.mapper.AdminMapper;
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

    /**
     * 统计教师信息
     * @return
     */
    @Override
    public Object getTeacherMessage() {
        return null;
    }

    /**
     * 统计学生信息
     * @return
     */
    @Override
    public Object getStudentMessage() {
        return null;
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
}
