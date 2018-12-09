package com.mikey.design.mapper;

import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.Student;
import com.mikey.design.entity.Teacher;
import com.mikey.design.entity.TeacherExample;
import java.util.List;

import com.mikey.design.entity.TitleOfStudent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TeacherMapper {
    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    //获取填报当前登入教师的所有学生志愿信息
    List<TitleOfStudent> getWillAdmitStudentMes(Integer teacherId);
    //获取当前教师已经录取的学生信息
    List<TitleOfStudent> getAllAlreayAdmitStudent(Integer teacherId);
}