package com.mikey.design.views.teacher;

import com.mikey.design.entity.Design;
import com.mikey.design.entity.Teacher;
import com.mikey.design.service.DesignService;
import com.mikey.design.utils.SpringUtil;
import com.mikey.design.utils.ThreadLocallUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

/**
 * @author Mikey
 * @Title: 更新密码
 * @Description: 更新个人登入密码
 * @Email:1625017540@qq.com
 * @date 2018/12/4 11:14
 * @Version 1.0
 */
public class AddTitlePanel extends JPanel {
    //校验数字
    public static final String REGEX_ISNUM ="^[0-9]*[1-9][0-9]*$";
    //service接口
    private DesignService designService;

    /**
     * 获取相关数据
     */
    public void getDate(){
        designService = (DesignService) SpringUtil.getBean("designServiceImpl");
    }

    public AddTitlePanel() throws HeadlessException {

        //获取当前登入用户信息
        Teacher teacher = (Teacher) ThreadLocallUtil.get();

        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("添加毕业设计题目");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //添加毕业设计题目
        JPanel mainJpanel=new JPanel();
        mainJpanel.setLayout(new GridLayout(6,1));
        //1.毕业设计题目
        JPanel titleNameJpanel=new JPanel();
        JLabel titleNameJlabel=new JLabel("毕业设计题目：");
        JTextField titleNameTextField=new JTextField("请输入毕业设计题目");
        titleNameJpanel.add(titleNameJlabel);
        titleNameJpanel.add(titleNameTextField);

        //2.毕业设计人数
        JPanel titleNumJpanel=new JPanel();
        JLabel titleNumJlabel=new JLabel("毕业设计人数：");
        JTextField titleNumJtextField=new JTextField("请输入毕业设计人数");
        titleNumJpanel.add(titleNumJlabel);
        titleNumJpanel.add(titleNumJtextField);

        //3.毕业设计要求
        JPanel titleRequireJpanel=new JPanel();
        JLabel titleRequireJlabel=new JLabel("毕业设计要求：");
        JTextArea titleRequireJtextArea=new JTextArea("请输入毕业设计要求",5,15);
        titleRequireJpanel.add(titleRequireJlabel);
        titleRequireJpanel.add(titleRequireJtextArea);



        //提交按钮
        JPanel submits=new JPanel();
        JButton sunmit=new JButton("确认添加");
        JButton reselt=new JButton("点击重置");
        reselt.addActionListener(new AbstractAction() {//添加监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                titleNameTextField.setText("请输入毕业设计题目");
                titleNumJtextField.setText("请输入毕业设计人数");
                titleRequireJtextArea.setText("请输入毕业设计要求");
            }
        });
        submits.add(sunmit);
        submits.add(reselt);


        mainJpanel.add(titleNameJpanel);
        mainJpanel.add(titleNumJpanel);
        mainJpanel.add(titleRequireJpanel);
        mainJpanel.add(submits);
        add(mainJpanel,BorderLayout.CENTER);
        //确认添加
        sunmit.addActionListener(new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkData(titleNameTextField,titleNumJtextField,titleRequireJtextArea)) {

                int result = JOptionPane.showConfirmDialog(null, "确认添加毕设题目？", "系统提示", JOptionPane.YES_NO_CANCEL_OPTION);
                /**
                 * 提交保存
                 */
                if (result == 0) {

                    getDate();

                    Design design = new Design();
                    design.setDesignTitle(titleNameTextField.getText());
                    design.setDesignOfTeacher(teacher.getTeacherId());
                    design.setDesignNum(Integer.parseInt(titleNumJtextField.getText()));
                    design.setDesignRequire(titleRequireJtextArea.getText());

                        designService.addDesign(design);//保存

                        JOptionPane.showMessageDialog(null, "提交毕业设计题目成功", "系统提示", JOptionPane.INFORMATION_MESSAGE);

                        reselt.doClick();//重置文本输入框

                        return;

                    }
                }
            }
    });
}

    /**
     * 数据校验
     * @param titleNameTextField
     * @param titleNumJtextField
     * @param titleRequireJtextArea
     * @return
     */
    private boolean checkData(JTextField titleNameTextField,JTextField titleNumJtextField,JTextArea titleRequireJtextArea){

        String title=titleNameTextField.getText().trim();//题目
        String titleNum=titleNumJtextField.getText().trim();//获取人数
        String titleRequire=titleRequireJtextArea.getText();//获取毕业设计需求

        if (title.equals("")||title.length()<1||title.equals("请输入毕业设计题目")||title.length()>100){
            JOptionPane.showMessageDialog(this,"请正确输入毕业设计题目","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (titleNum.equals("")||titleNum.length()<1||Pattern.matches(REGEX_ISNUM,titleNum)==false){
            JOptionPane.showMessageDialog(this,"请输入一个正整数","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (titleRequire.equals("")||titleRequire.length()<1){
            JOptionPane.showMessageDialog(this,"请正确输入毕设需求","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
}
