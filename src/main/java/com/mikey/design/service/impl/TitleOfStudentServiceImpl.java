package com.mikey.design.service.impl;

import com.mikey.design.entity.Design;
import com.mikey.design.entity.DesignExample;
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

        if (titleOfStudent.size()>0) {
            return designMapper.selectByPrimaryKey(titleOfStudent.get(0).getDesOfTitle());
        }else {
            return null;
        }
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

        if (titleOfStudent.size()>0) {
            return designMapper.selectByPrimaryKey(titleOfStudent.get(0).getDesOfTitle());
        }else {
            return null;
        }
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

        if(titleOfStudent.size()>0&&titleOfStudent.get(0).getDesState()==0)return 0;
        if(titleOfStudent.size()>0&&titleOfStudent.get(0).getDesState()==1)return 1;

        TitleOfStudentExample titleOfStudentExample2 = new TitleOfStudentExample();
        TitleOfStudentExample.Criteria criteria2 = titleOfStudentExample.createCriteria();
        criteria2.andDesOfStuEqualTo(studentId);//当前学生志愿
        criteria2.andDesWishOrderEqualTo(1);//第二志愿
        List<TitleOfStudent> titleOfStudent2= titleOfStudentMapper.selectByExample(titleOfStudentExample2);

        if(titleOfStudent2.size()>0){
            return titleOfStudent2.get(0).getDesState();
        }
        return 0;
    }

    /**
     * 获取录取的课设信息
     * @param studentId
     * @return
     */
    @Override
    public Design getAdmitDesign(Integer studentId) {

        TitleOfStudentExample titleOfStudentExample = new TitleOfStudentExample();

        TitleOfStudentExample.Criteria criteria = titleOfStudentExample.createCriteria();

        criteria.andDesOfStuEqualTo(studentId);//当前学生志愿

        criteria.andDesStateEqualTo(1);//已经录取

        List<TitleOfStudent> titleOfStudent= titleOfStudentMapper.selectByExample(titleOfStudentExample);

        if (titleOfStudent.size()>0){
            return designMapper.selectByPrimaryKey(titleOfStudent.get(0).getDesOfTitle());
        }else {
            return null;
        }
    }

    /**
     *
     * @param teacherId
     * @return
     */
    @Override
    public List<TitleOfStudent> getByTeacherId(Integer teacherId) {

        DesignExample designExample = new DesignExample();

        DesignExample.Criteria criteria = designExample.createCriteria();

        criteria.andDesignOfTeacherEqualTo(teacherId);

        List<Design> designList = designMapper.selectByExample(designExample);//查询出当前教师的所有毕业设计题目

        if (designList.size()>0){

        }

        return null;
    }

    /**
     * 录取志愿
     * @param titleOfStudent
     */
    @Override
    public void admitStudentWish(TitleOfStudent titleOfStudent) {

        titleOfStudent.setDesState(1);//录取

        titleOfStudentMapper.updateByPrimaryKey(titleOfStudent);//提交更新

        //TODO:将该学生的另一个志愿回档

    }
}
