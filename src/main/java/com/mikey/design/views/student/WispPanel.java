package com.mikey.design.views.student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Mikey
 * @Title: 填报志愿
 * @Description: 填报志愿面板
 * @Email:1625017540@qq.com
 * @date 2018/12/4 11:14
 * @Version 1.0
 */
public class WispPanel extends JPanel {
    //TODO:待完善已经填报页面
    public WispPanel() throws HeadlessException {

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
        //TODO:待查询出teacherList
        teacherboBox.addItem("张老师");
        teacherboBox.addItem("李老师");
        teacherboBox.addItem("冀老师");
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
        /**
         * 志愿二
         */
        JPanel secondWishJpanel=new JPanel();
        secondWishJpanel.setBorder(new EmptyBorder(5,5,5,5));
        secondWishJpanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        JLabel wishabel2=new JLabel("志愿二:    ");
        JLabel teacherLabel2=new JLabel("指导老师:");
        JComboBox teacherboBox2=new JComboBox();//下拉框
        //TODO:待查询出teacherList
        teacherboBox2.addItem("张老师");
        teacherboBox2.addItem("李老师");
        teacherboBox2.addItem("冀老师");
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
