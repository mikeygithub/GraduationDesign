package com.mikey.design.service;

import com.mikey.design.entity.Teacher;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/28 18:45
 * @Version 1.0
 */
public interface TeacherService {
    public int getTeacherNum();
    public void addTeacher(Teacher teacher);
    public void updateTeacherNum(Teacher teacher);
    public void deleteTeacherNum(int teacherId);
    public Teacher getTeacher(int teacherId);

    List<Teacher> getAllTeacher();
}
