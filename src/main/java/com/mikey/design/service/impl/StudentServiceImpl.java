package com.mikey.design.service.impl;

import com.mikey.design.entity.Student;
import com.mikey.design.entity.StudentExample;
import com.mikey.design.mapper.StudentMapper;
import com.mikey.design.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/28 18:25
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 添加学生
     * @param student
     */
    @Override
    public void addStudent(Student student) {
        studentMapper.insert(student);
    }

    /**
     * 修改学生
     * @param student
     */
    @Override
    public void updateStudent(Student student) {

        studentMapper.updateByPrimaryKey(student);
    }

    /**
     * 删除学生
     * @param studentId
     */
    @Override
    public void deleteStudent(int studentId) {

        studentMapper.deleteByPrimaryKey(studentId);
    }

    /**
     * 获取学生人数
     * @return
     */
    @Override
    public int getStudentNum() {
        StudentExample studentExample=new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
//        criteria.

        return 0;
    }

    /**
     * 获取学生信息
     * @param studentId
     */
    @Override
    public void getStudent(int studentId) {

        studentMapper.selectByPrimaryKey(studentId);
    }
}
