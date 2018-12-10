package com.mikey.design.views.admin;

import com.mikey.design.service.AdminService;
import com.mikey.design.service.TeacherService;
import com.mikey.design.utils.SpringUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mikey
 * @Title: 统计志愿填报
 * @Description:  统计志愿填报，总学生人数，已经填报人数，未填报人数，教师人数，毕业设计题目总数
 * @Email:1625017540@qq.com
 * @date 2018/12/5 12:23
 * @Version 1.0
 */
public class WishDateCountJpanel extends JPanel {
    //总学生人数
    private String ALL_STUDENT_NUM="暂无";
    //已经填报人数
    private String ALREADY_STUDENT_NUM="暂无";
    //未填报人数
    private String ALL_NOT_FILL_STUDENT_NUM="暂无";
    //教师人数
    private String ALL_TEACHER_NUM="暂无";
    //毕业设计题目总数
    private String ALL_DESIGN_TITLE_NUM="暂无";
    //service接口
    private TeacherService teacherService;
    //
    private AdminService adminService;

    public void getData(){
        teacherService = (TeacherService) SpringUtil.getBean("teacherServiceImpl");
        adminService = (AdminService) SpringUtil.getBean("adminServiceImpl");
        //总学生人数
        ALL_STUDENT_NUM=String.valueOf(adminService.getStudentNum());
        //已经填报人数
        ALREADY_STUDENT_NUM=String.valueOf(adminService.getAlreadyFillWishStudentNum());
        //未填报人数
        ALL_NOT_FILL_STUDENT_NUM=String.valueOf(adminService.getNotFillWishStudentNum());
        //教师人数
        ALL_TEACHER_NUM=String.valueOf(adminService.getTeacherNum());
        //毕业设计题目总数
        ALL_DESIGN_TITLE_NUM=String.valueOf(adminService.allTitleNum());

    }

    public void showView() {
        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("统计志愿填报情况");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //内容面板
        JPanel mainJpanel=new JPanel();
        mainJpanel.setLayout(new GridLayout(6,1));
        //1.总学生人数
        JPanel studentNumJpanel=new JPanel();
        JLabel nameJlabel=new JLabel("总学生人数：");
        JLabel nameJlabelInfo=new JLabel(ALL_STUDENT_NUM);
        studentNumJpanel.add(nameJlabel);
        studentNumJpanel.add(nameJlabelInfo);

        //2.已经填报人数
        JPanel alreadyFillNumJpanel=new JPanel();
        JLabel alreadyFillNumJLabel=new JLabel("已经填报人数：");
        JLabel alreadyFillNumJLabelInfo=new JLabel(ALREADY_STUDENT_NUM);
        alreadyFillNumJpanel.add(alreadyFillNumJLabel);
        alreadyFillNumJpanel.add(alreadyFillNumJLabelInfo);
        //3.未填报人数
        JPanel notFillNumJpanel=new JPanel();
        JLabel notFillNumJlabel=new JLabel("未填报人数：");
        JLabel notFillNumJlabelInfo=new JLabel(ALL_NOT_FILL_STUDENT_NUM);
        notFillNumJpanel.add(notFillNumJlabel);
        notFillNumJpanel.add(notFillNumJlabelInfo);
        //4.教师个数
        JPanel teacherNumJpanel=new JPanel();
        JLabel teacherNumJlabel=new JLabel("教师人数：");
        JLabel teacherNumJlabelInfo=new JLabel(ALL_TEACHER_NUM);
        teacherNumJpanel.add(teacherNumJlabel);
        teacherNumJpanel.add(teacherNumJlabelInfo);
        //5.毕业设计题目总数
        JPanel titleNumJpanel=new JPanel();
        JLabel titleNumJlabel=new JLabel("毕业设计题目总数：");
        JLabel titleNumJlabelInfo=new JLabel(ALL_DESIGN_TITLE_NUM);
        titleNumJpanel.add(titleNumJlabel);
        titleNumJpanel.add(titleNumJlabelInfo);


        mainJpanel.add(studentNumJpanel);
        mainJpanel.add(alreadyFillNumJpanel);
        mainJpanel.add(notFillNumJpanel);
        mainJpanel.add(teacherNumJpanel);
        mainJpanel.add(titleNumJpanel);

        add(mainJpanel,BorderLayout.CENTER);
    }

    public void refreshData(){
        getData();//获取数据
        showView();//展现视图
    }

}
