package com.mikey.design.views.student;

import com.mikey.design.entity.Design;
import com.mikey.design.entity.Student;
import com.mikey.design.service.TitleOfStudentService;
import com.mikey.design.utils.SpringUtil;
import com.mikey.design.utils.ThreadLoaclUtil;

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

    private  TitleOfStudentService titleOfStudentService;

    private String[] admitStateArray={"待录取","已经录取","未录取"};//录取状态

    private String theFirstWishName="";

    private String theSecondWishName="";

    private String adminState="";

    private String adminResult="";


    /**
     * 获取志愿状态信息
     */
    private void getData(){
        titleOfStudentService= (TitleOfStudentService) SpringUtil.getBean("titleOfStudentServiceImpl");
        Student self = (Student) ThreadLoaclUtil.get();//获取用户（学生）信息
        //第一志愿
        Design firstDesign=titleOfStudentService.getFirstWish(self.getStudentId());
        if (firstDesign!=null)theFirstWishName=firstDesign.getDesignTitle();
        //第二志愿
        Design secondDesign=titleOfStudentService.getSecondWish(self.getStudentId());
        if(secondDesign!=null)theSecondWishName=secondDesign.getDesignTitle();
        //获取志愿录取状态
        if(firstDesign!=null&&secondDesign!=null)adminState=admitStateArray[titleOfStudentService.getAdmitState(self.getStudentId())];
        //获取录取的志愿
        if(adminState.equals("已经录取")&&firstDesign!=null&&secondDesign!=null)adminResult=titleOfStudentService.getAdmitDesign(self.getStudentId()).getDesignTitle();
    }

    /**
     * 刷新数据
     */
    public void refreshData(){
        getData();
        showView();
    }
    /**
     * 够造视图
     */
    public void showView() {

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
        mainJpanel.setLayout(new GridLayout(6,1));

        JPanel tip=new JPanel();
        JLabel alrealdFillWispJLable=new JLabel("您已进行填报");
        tip.add(alrealdFillWispJLable);

        JPanel firstJpanel=new JPanel();
        JLabel firstWispJLable=new JLabel("第一志愿：");
        JLabel firstWispJLableInfo=new JLabel(theFirstWishName);
        firstJpanel.add(firstWispJLable);
        firstJpanel.add(firstWispJLableInfo);

        JPanel secondJpanel=new JPanel();
        JLabel secondWispJLable=new JLabel("第二志愿：");
        JLabel secondWispJLableInfo=new JLabel(theSecondWishName);
        secondJpanel.add(secondWispJLable);
        secondJpanel.add(secondWispJLableInfo);

        JPanel stateJpanel=new JPanel();
        JLabel stateWispJLable=new JLabel("录取状态：");//0.待录取、1.待录取、2.已经录取
        JLabel stateWispJLableInfo=new JLabel(adminState);
        stateJpanel.add(stateWispJLable);
        stateJpanel.add(stateWispJLableInfo);

        JPanel resultJpanel=new JPanel();
        JLabel resultWispJLable=new JLabel("录取的志愿：");
        JLabel resultWispJLableInfo=new JLabel(adminResult);
        resultJpanel.add(resultWispJLable);
        resultJpanel.add(resultWispJLableInfo);

        mainJpanel.add(tip);
        mainJpanel.add(firstJpanel);
        mainJpanel.add(secondJpanel);
        mainJpanel.add(stateJpanel);

        if(adminState.equals("已经录取"))mainJpanel.add(resultJpanel);

        add(mainJpanel,BorderLayout.CENTER);

    }

}
