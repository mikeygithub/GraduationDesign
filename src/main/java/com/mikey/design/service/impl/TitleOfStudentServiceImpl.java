package com.mikey.design.service.impl;

import com.mikey.design.entity.Design;
import com.mikey.design.entity.TitleOfStudent;
import com.mikey.design.entity.TitleOfStudentExample;
import com.mikey.design.mapper.DesignMapper;
import com.mikey.design.mapper.TitleOfStudentMapper;
import com.mikey.design.service.TitleOfStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/6 9:16
 * @Version 1.0
 */
@Service
public class TitleOfStudentServiceImpl implements TitleOfStudentService {
    @Autowired
    private TitleOfStudentMapper titleOfStudentMapper;

    @Autowired
    private DesignMapper designMapper;

    /**
     * 添加志愿
     * @param titleOfStudent
     */
    @Override
    public void addTitleOfStudent(TitleOfStudent titleOfStudent) {
        titleOfStudentMapper.insert(titleOfStudent);
    }

    /**
     * 添加志愿
     * @param titleOfStudent1
     * @param titleOfStudent2
     */
    @Override
    public void addTitleOfStudent(TitleOfStudent titleOfStudent1, TitleOfStudent titleOfStudent2) {
        titleOfStudentMapper.insert(titleOfStudent1);
        titleOfStudentMapper.insert(titleOfStudent2);
    }

    /**
     * 通过学生id判断是否已经进行志愿填报
     * @param studentId
     * @return
     */
    @Override
    public boolean fillWishOrNot(Integer studentId) {
        TitleOfStudentExample titleOfStudentExample = new TitleOfStudentExample();
        TitleOfStudentExample.Criteria criteria = titleOfStudentExample.createCriteria();
        criteria.andDesOfStuEqualTo(studentId);
        return titleOfStudentMapper.countByExample(titleOfStudentExample)>0;
    }

    /**
     * 获取第一志愿信息
     * @param studentId
     * @return
     */
    @Override
    public Design getFirstWish(Integer studentId) {

        TitleOfStudentExample titleOfStudentExample = new TitleOfStudentExample();

        TitleOfStudentExample.Criteria criteria = titleOfStudentExample.createCriteria();

        criteria.andDesOfStuEqualTo(studentId);//当前学生志愿

        criteria.andDesWishOrderEqualTo(0);//第一志愿

        List<TitleOfStudent> titleOfStudent= titleOfStudentMapper.selectByExample(titleOfStudentExample);

        return designMapper.selectByPrimaryKey(titleOfStudent.get(0).getDesOfTitle());
    }

    /**
     *获取第二志愿信息
     * @param studentId
     * @return
     */
    @Override
    public Design getSecondWish(Integer studentId) {
        TitleOfStudentExample titleOfStudentExample = new TitleOfStudentExample();

        TitleOfStudentExample.Criteria criteria = titleOfStudentExample.createCriteria();

        criteria.andDesOfStuEqualTo(studentId);//当前学生志愿

        criteria.andDesWishOrderEqualTo(1);//第二志愿

        List<TitleOfStudent> titleOfStudent= titleOfStudentMapper.selectByExample(titleOfStudentExample);

        return designMapper.selectByPrimaryKey(titleOfStudent.get(0).getDesOfTitle());
    }

    /**
     * 获取录取的状态
     * @param studentId
     * @return
     */
    @Override
    public Integer getAdmitState(Integer studentId) {

        TitleOfStudentExample titleOfStudentExample = new TitleOfStudentExample();
        TitleOfStudentExample.Criteria criteria = titleOfStudentExample.createCriteria();
        criteria.andDesOfStuEqualTo(studentId);//当前学生志愿
        criteria.andDesWishOrderEqualTo(0);//第一志愿
        List<TitleOfStudent> titleOfStudent=titleOfStudentMapper.selectByExample(titleOfStudentExample);

        TitleOfStudentExample titleOfStudentExample2 = new TitleOfStudentExample();
        TitleOfStudentExample.Criteria criteria2 = titleOfStudentExample.createCriteria();
        criteria2.andDesOfStuEqualTo(studentId);//当前学生志愿
        criteria2.andDesWishOrderEqualTo(1);//第二志愿
        List<TitleOfStudent> titleOfStudent2= titleOfStudentMapper.selectByExample(titleOfStudentExample);

        return 0;
    }

    /**
     * 获取录取的课设信息
     * @param studentId
     * @return
     */
    @Override
    public Design getAdmitDesign(Integer studentId) {
        return null;
    }
}
