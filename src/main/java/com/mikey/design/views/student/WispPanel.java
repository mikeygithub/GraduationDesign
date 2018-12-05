package com.mikey.design.views.student;

import com.mikey.design.entity.Design;
import com.mikey.design.entity.Teacher;
import com.mikey.design.service.DesignService;
import com.mikey.design.service.StudentService;
import com.mikey.design.service.TeacherService;
import com.mikey.design.utils.SpringUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

/**
 * @author Mikey
 * @Title: 填报志愿
 * @Description: 填报志愿面板
 * @Email:1625017540@qq.com
 * @date 2018/12/4 11:14
 * @Version 1.0
 */
public class WispPanel extends JPanel {

    private StudentService studentService;
    private TeacherService teacherService;
    private DesignService designService;
    private  List<Teacher> teacherList=null;
    private  List<Design> titleList=null;

    private void getData(){
        studentService = (StudentService) SpringUtil.getBean("studentServiceImpl");
        teacherService = (TeacherService) SpringUtil.getBean("teacherServiceImpl");
        designService= (DesignService) SpringUtil.getBean("designServiceImpl");
        this.teacherList=teacherService.getAllTeacher();//获取全部教师信息
        this.titleList=designService.getAllDesign();//获取全部毕设题目信息
    }
    public WispPanel() throws HeadlessException {
        getData();//获取数据信息
        showView();//展现视图

    }
    public void showView() throws HeadlessException {

        setLayout(new GridLayout(7,1));//七行一列网格布局
        /**
         * 标题
         */
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("填报志愿");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.setLayout(new FlowLayout());
        titleJpanel.add(title);
        add(titleJpanel);
        /**
         * 志愿一
         */
        JPanel firstWishJpanel=new JPanel();
        firstWishJpanel.setBorder(new EmptyBorder(5,5,5,5));
        firstWishJpanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        JLabel wishabel=new JLabel("志愿一:    ");
        JLabel teacherLabel=new JLabel("指导老师:");
        JComboBox teacherboBox=new JComboBox();//下拉框

        for (Teacher t:teacherList){
            teacherboBox.addItem(t.getTeacherName());
        }
        firstWishJpanel.add(wishabel);
        firstWishJpanel.add(teacherLabel);
        firstWishJpanel.add(teacherboBox);



        JLabel blank1=new JLabel("    ");
        JLabel titleLabel=new JLabel("课设题目:");
        JComboBox titleBox=new JComboBox();//下拉框
        //TODO:待查询出titleList
        titleBox.addItem("毕业设计选题系统");
        titleBox.addItem("食堂在线订餐系统");
        titleBox.addItem("算法图形演示系统");
        firstWishJpanel.add(blank1);
        firstWishJpanel.add(titleLabel);
        firstWishJpanel.add(titleBox);

        add(firstWishJpanel);

        //设置监听达到联级更新
        teacherboBox.addItemListener(e -> {//lambda语法
           if(e.getStateChange() == ItemEvent.SELECTED){//只在确认选择时进行更新

                    titleBox.removeAllItems();//移除所有下拉框内容

               for (Teacher t:teacherList){
                   if(teacherboBox.getSelectedItem().toString().equals(t.getTeacherName())){//判断教师是否
                       for (Design d:titleList){
                           if (d.getDesignOfTeacher()==t.getTeacherId())
                               titleBox.addItem(d.getDesignTitle());
                       }
                   }
               }
                    System.out.println("选项========》》》"+teacherboBox.getSelectedItem().toString());
//                    //添加题目到下拉框
//                    for (Design d:titleList){
////                        if (d.get)
//                        titleBox.addItem("666");
//                    }
           }
      }
        );
        /**
         * 志愿二
         */
        JPanel secondWishJpanel=new JPanel();
        secondWishJpanel.setBorder(new EmptyBorder(5,5,5,5));
        secondWishJpanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        JLabel wishabel2=new JLabel("志愿二:    ");
        JLabel teacherLabel2=new JLabel("指导老师:");
        JComboBox teacherboBox2=new JComboBox();//下拉框

        for (Teacher t:teacherList){
            teacherboBox2.addItem(t.getTeacherName());
        }

        secondWishJpanel.add(wishabel2);
        secondWishJpanel.add(teacherLabel2);
        secondWishJpanel.add(teacherboBox2);

        JLabel blank2=new JLabel("    ");
        JLabel titleLabel2=new JLabel("课设题目:");
        JComboBox titleBox2=new JComboBox();//下拉框
        //TODO:待查询出titleList
        titleBox2.addItem("毕业设计选题系统");
        titleBox2.addItem("食堂在线订餐系统");
        titleBox2.addItem("算法图形演示系统");
        secondWishJpanel.add(blank2);
        secondWishJpanel.add(titleLabel2);
        secondWishJpanel.add(titleBox2);

        add(secondWishJpanel);

        //设置监听达到联级更新
        teacherboBox2.addItemListener(e -> {//lambda语法
                    titleBox2.removeAllItems();//移除所有下拉框内容
                    System.out.println("选项========》》》"+e.getItemSelectable().toString());
                    titleBox2.addItem("666");
                }
        );
        /**
         * 提交按钮
         */
        JPanel btnJpanel=new JPanel();
        JButton submint=new JButton("提交");
        JButton reset=new JButton("重置");
        reset.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherboBox.setSelectedIndex(0);
                titleBox.setSelectedIndex(0);
                teacherboBox2.setSelectedIndex(0);
                titleBox2.setSelectedIndex(0);
            }
        });
        btnJpanel.add(submint);
        btnJpanel.add(reset);

        add(btnJpanel);
    }
}
