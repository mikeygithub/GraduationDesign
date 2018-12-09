package com.mikey.design.views.admin;

import com.mikey.design.entity.Teacher;
import com.mikey.design.service.TeacherService;
import com.mikey.design.utils.SpringUtil;
import com.mikey.design.views.common.UpdatePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/4 23:34
 * @Version 1.0
 */
public class AddTeacherJpanel extends JPanel {


    private TeacherService teacherService;


    public AddTeacherJpanel() {

        teacherService = (TeacherService) SpringUtil.getBean("teacherServiceImpl");

        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("添加教师信息");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //添加教师信息
        JPanel mainJpanel=new JPanel();
        mainJpanel.setLayout(new GridLayout(6,1));
        //1.名字
        JPanel username=new JPanel();
        JLabel nameJlabel=new JLabel("教师性名：");
        JTextField nameJtextField=new JTextField("请输入教师性名");
        username.add(nameJlabel);
        username.add(nameJtextField);
        //2.性别
        JPanel sex=new JPanel();
        JLabel sexJlabel=new JLabel("性别：");
        JComboBox sexboBox=new JComboBox();//下拉框
        sexboBox.addItem("男");
        sexboBox.addItem("女");
        sex.add(sexJlabel);
        sex.add(sexboBox);

        //3.联系电话
        JPanel phone=new JPanel();
        JLabel phoneJlabel=new JLabel("联系方式：");
        JTextField phoneJtextField=new JTextField("请输入电话号码");
        phone.add(phoneJlabel);
        phone.add(phoneJtextField);

        JButton reselt=new JButton("重置输入");
        reselt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameJtextField.setText("请输入教师性名");
                phoneJtextField.setText("请输入电话号码");
            }
        });
        //提交按钮
        JPanel submits=new JPanel();
        JButton sunmit=new JButton("确认添加");
        sunmit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //添加学生
                if (checkData(nameJtextField,sexboBox,phoneJtextField)) {

                    int result = JOptionPane.showConfirmDialog(null, "确认添加学生？", "系统提示", JOptionPane.YES_NO_CANCEL_OPTION);
                    /**
                     * 提交保存
                     */
                    if (result == JOptionPane.YES_NO_OPTION) {

                        Teacher teacher = new Teacher();
                        teacher.setTeacherName(nameJtextField.getText());
                        teacher.setTeacherSex(sexboBox.getSelectedIndex());
                        teacher.setTeacherPhone(phoneJtextField.getText());

                        teacherService.addTeacher(teacher);//添加学生

                        Teacher teacherByPhone = teacherService.getStudentByPhone(phoneJtextField.getText());

                        JOptionPane.showMessageDialog(null, "添加成功/学号为："+teacherByPhone.getTeacherId());
                        reselt.doClick();
                    }
                }
            }
        });

        submits.add(sunmit);
        submits.add(reselt);


        mainJpanel.add(username);
        mainJpanel.add(sex);
        mainJpanel.add(phone);
        mainJpanel.add(submits);
        add(mainJpanel,BorderLayout.CENTER);
    }
    /**
     * 数据校验
     * @param nameJtextField
     * @param sexboBox
     * @param phoneJtextField
     * @return
     */
    private boolean checkData(JTextField nameJtextField,JComboBox sexboBox, JTextField phoneJtextField){

        String userName=nameJtextField.getText().trim();//姓名
        int userSex=sexboBox.getSelectedIndex();//获取性别
        String userPhone=phoneJtextField.getText().trim();//获取电话

        if (userName.equals("")||userName.length()<1||userName.equals("请输入教师性名")){
            JOptionPane.showMessageDialog(this,"请输入教师性名","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (userPhone.equals("")||userPhone.length()<1||userPhone.equals("请输入电话号码")){
            JOptionPane.showMessageDialog(this,"请输入联系电话","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if(Pattern.matches(UpdatePanel.REGEX_USERNAME,userName)==false){
            JOptionPane.showMessageDialog(this,"用户名由2-10汉字组成","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(Pattern.matches(UpdatePanel.REGEX_MOBILE,userPhone)==false){
            JOptionPane.showMessageDialog(this,"请输入正确的移动电话号码","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        Teacher studentByPhone = teacherService.getStudentByPhone(userPhone);
        if (studentByPhone.getTeacherPhone()!=null){
            JOptionPane.showMessageDialog(this,"该手机号码已经被使用","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        return true;
    }
}
