package com.mikey.design.views.student;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mikey
 * @Title:已经填报页面
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/5 13:53
 * @Version 1.0
 */
public class AlrealdFillWispPanel extends JPanel {
    public AlrealdFillWispPanel() {

        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("填报志愿");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        JPanel mainJpanel=new JPanel();//已经填报页面
        JLabel alrealdFillWispJLable=new JLabel("你已经进行填报了");
        mainJpanel.add(alrealdFillWispJLable);
        add(mainJpanel,BorderLayout.CENTER);
    }
}
