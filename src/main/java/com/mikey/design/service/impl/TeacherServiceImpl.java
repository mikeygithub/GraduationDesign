package com.mikey.design.service.impl;

import com.mikey.design.entity.Teacher;
import com.mikey.design.mapper.TeacherMapper;
import com.mikey.design.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/28 18:48
 * @Version 1.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 获取教师人数
     * @return
     */
    @Override
    public int getTeacherNum() {
        return 0;
    }

    /**
     * 添加教师
     * @param teacher
     */
    @Override
    public void addTeacher(Teacher teacher) {

        teacherMapper.insert(teacher);
    }

    /**
     * 修改教师
     * @param teacher
     */
    @Override
    public void updateTeacherNum(Teacher teacher) {

        teacherMapper.updateByPrimaryKey(teacher);
    }

    /**
     * 删除教师
     * @param teacherId
     */
    @Override
    public void deleteTeacherNum(int teacherId) {

        teacherMapper.deleteByPrimaryKey(teacherId);
    }

    @Override
    public Teacher getTeacher(int teacherId) {
        return teacherMapper.selectByPrimaryKey(teacherId);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherMapper.selectByExample(null);
    }
}
