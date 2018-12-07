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

    @Override
    public long alreadyFillWishStudetnNum() {
        //TODO:待完成查询
        return 100l;
    }

    @Override
    public long notFillWishStudetnNum() {
        //TODO:待完成查询
        return 0l;
    }

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

    @Override
    public void updataAdmin(Admin admin) {
        adminMapper.updateByPrimaryKey(admin);
    }
}
