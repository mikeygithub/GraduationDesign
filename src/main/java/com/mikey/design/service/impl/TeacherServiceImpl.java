package com.mikey.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.Student;
import com.mikey.design.entity.Teacher;
import com.mikey.design.entity.TeacherExample;
import com.mikey.design.entity.TitleOfStudent;
import com.mikey.design.mapper.TeacherMapper;
import com.mikey.design.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikey
 * @Title: 教师
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

    /**
     * 获取单个教师信息
     * @param teacherId
     * @return
     */
    @Override
    public Teacher getTeacher(int teacherId) {
        return teacherMapper.selectByPrimaryKey(teacherId);
    }

    /**
     * 直接获取全部教师信息
     * @return
     */
    public List<Teacher> getAllTeacher(){
        return teacherMapper.selectByExample(null);
    }
    /**
     * 分页查询教师信息列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo getAllTeacherByPage(int currentPage,int pageSize) {

        PageHelper.startPage(currentPage,pageSize);

        List<Teacher> teacherList=teacherMapper.selectByExample(null);

        PageInfo pageData = new PageInfo(teacherList, pageSize);

        return pageData;
    }

    /**
     * 获取将要被录取的学生信息
     * @param teacherId
     * @return
     */
    @Override
    public PageInfo<TitleOfStudent> getWillAdmitStudentMes(Integer teacherId, int currentPage, int pageSize){

        PageHelper.startPage(currentPage,pageSize);

        List<TitleOfStudent> titleOfStudentList=teacherMapper.getWillAdmitStudentMes(teacherId);

        PageInfo pageData=new PageInfo(titleOfStudentList,pageSize);

        return pageData;
    }

    /**
     * 获取当前教师已经录取的学生信息
     * @param teacherId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TitleOfStudent> getAllAlreayAdmitStudent(Integer teacherId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);

        List<TitleOfStudent> titleOfStudentList=teacherMapper.getAllAlreayAdmitStudent(teacherId);

        PageInfo pageData=new PageInfo(titleOfStudentList,pageSize);

        return pageData;
    }

    /**
     * 获取学生填报志愿状态
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TitleOfStudent> getAllStudentWishStateForAdmin(int currentPage, int pageSize) {

        PageHelper.startPage(currentPage,pageSize);

        List<TitleOfStudent> titleOfStudentList=teacherMapper.getAllStudentWishStateForAdmin();

        PageInfo pageData=new PageInfo(titleOfStudentList,pageSize);

        return pageData;

    }

    /**
     * 通过手机号回显新增教师
     * @param teacherPhone
     * @return
     */
    @Override
    public Teacher getStudentByPhone(String teacherPhone) {
        TeacherExample teacherExample=new TeacherExample();

        TeacherExample.Criteria criteria = teacherExample.createCriteria();

        criteria.andTeacherPhoneEqualTo(teacherPhone);

        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);

        if (teacherList.size()>0)return teacherList.get(0);

        return new Teacher();
    }
}
