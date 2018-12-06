package com.mikey.design.service;

import com.mikey.design.entity.Design;
import com.mikey.design.entity.TitleOfStudent;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/6 9:12
 * @Version 1.0
 */
public interface TitleOfStudentService {
    void addTitleOfStudent(TitleOfStudent titleOfStudent);
    void addTitleOfStudent(TitleOfStudent titleOfStudent1,TitleOfStudent titleOfStudent2);
    boolean fillWishOrNot(Integer studentId);//判断该学生是否已经填报志愿
    Design getFirstWish(Integer studentId);//获取第一志愿信息
    Design getSecondWish(Integer studentId);//获取第二志愿信息
    Integer getAdmitState(Integer studentId);//获取录取状态

    Design getAdmitDesign(Integer studentId);
}
