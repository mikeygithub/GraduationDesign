package com.mikey.design.service;

import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.Teacher;
import com.mikey.design.entity.TitleOfStudent;

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
    PageInfo getAllTeacherByPage(int currentPage, int pageSize);
    PageInfo<TitleOfStudent> getWillAdmitStudentMes(Integer teacherId, int currentPage, int pageSize);
}
