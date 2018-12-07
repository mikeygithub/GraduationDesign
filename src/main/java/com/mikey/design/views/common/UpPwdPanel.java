package com.mikey.design.views.common;

import com.mikey.design.entity.Admin;
import com.mikey.design.entity.Student;
import com.mikey.design.entity.Teacher;
import com.mikey.design.service.AdminService;
import com.mikey.design.service.StudentService;
import com.mikey.design.service.TeacherService;
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
public class UpPwdPanel extends JPanel {
    //学生
    private StudentService studentService;
    //教师
    private TeacherService teacherService;
    //管理员
    private AdminService adminService;
    //密码正则
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";
    //密码
    private String LOGINPASSWORD;

    /**
     * 刷新数据
     */
    public void refreshData(){
        getData();
        showView();
        this.validate();
        this.updateUI();
    }

    public void getData(){
        //获取当前登入用户信息
        Object loginUser = ThreadLocallUtil.get();

        //判断角色类型
        if(loginUser instanceof Student){//学生
            LOGINPASSWORD=((Student) loginUser).getStudentPassword();
        }else if (loginUser instanceof Teacher){//教师
            LOGINPASSWORD=((Teacher) loginUser).getTeacherPassword();
        }else if (loginUser instanceof Admin){//管理员
            LOGINPASSWORD=((Admin) loginUser).getAdminPassword();
        }

        studentService = (StudentService) SpringUtil.getBean("studentServiceImpl");
        teacherService = (TeacherService) SpringUtil.getBean("teacherServiceImpl");
        adminService = (AdminService) SpringUtil.getBean("adminServiceImpl");
    }

    public void showView(){

        Object loginUser = ThreadLocallUtil.get();

        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("修改登入密码");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //更改个人信息
        JPanel mainJpanel=new JPanel();
        mainJpanel.setLayout(new GridLayout(6,1));
        //1.原登入密码
        JPanel oldPwdJpanel=new JPanel();
        JLabel oldPwdJlabel=new JLabel("原登入密码：");
        JTextField oldPwdTextField=new JTextField("请输入原登入密码");
        oldPwdJpanel.add(oldPwdJlabel);
        oldPwdJpanel.add(oldPwdTextField);

        //2.新登入密码
        JPanel newPwdJpanel=new JPanel();
        JLabel newPwdJlabel=new JLabel("新登入密码：");
        JTextField newPwdJtextField=new JTextField("请输入新登入密码");
        newPwdJpanel.add(newPwdJlabel);
        newPwdJpanel.add(newPwdJtextField);

        //3.重复新登入密码
        JPanel reNewPwdJpanel=new JPanel();
        JLabel reNewPwdJlabel=new JLabel("新登入密码：");
        JTextField reNewPwdJtextField=new JTextField("请再次输入新密码");
        reNewPwdJpanel.add(reNewPwdJlabel);
        reNewPwdJpanel.add(reNewPwdJtextField);



        //提交按钮
        JPanel submits=new JPanel();
        JButton sunmit=new JButton("确认更改");
        JButton reselt=new JButton("取消更改");
        submits.add(sunmit);
        submits.add(reselt);


        mainJpanel.add(oldPwdJpanel);
        mainJpanel.add(newPwdJpanel);
        mainJpanel.add(reNewPwdJpanel);
        mainJpanel.add(submits);
        add(mainJpanel,BorderLayout.CENTER);

        reselt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oldPwdTextField.setText("请输入原登入密码");
                newPwdJtextField.setText("请输入新登入密码");
                reNewPwdJtextField.setText("请再次输入新密码");
            }
        });


        sunmit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkData(oldPwdTextField,newPwdJtextField,reNewPwdJtextField)) {//数据校验

                    int result = JOptionPane.showConfirmDialog(null, "确认更改密码？", "系统提示", JOptionPane.YES_NO_CANCEL_OPTION);
                    /**
                     * 提交保存
                     */
                    if (result == 0) {

                        if (loginUser instanceof Student) {//学生

                            ((Student) loginUser).setStudentPassword(newPwdJtextField.getText());

                            studentService.updateStudent((Student) loginUser);//更新

                            JOptionPane.showMessageDialog(null, "更新成功", "系统提示", JOptionPane.INFORMATION_MESSAGE);


                        } else if (loginUser instanceof Teacher) {//教师

                            ((Teacher) loginUser).setTeacherPassword(newPwdJtextField.getText());

                            teacherService.updateTeacherNum((Teacher) loginUser);

                            JOptionPane.showMessageDialog(null, "更新成功", "系统提示", JOptionPane.INFORMATION_MESSAGE);


                        } else if (loginUser instanceof Admin) {//管理员

                            ((Admin) loginUser).setAdminPassword(newPwdJtextField.getText());

                            adminService.updataAdmin((Admin) loginUser);

                            JOptionPane.showMessageDialog(null, "更新成功", "系统提示", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                    oldPwdTextField.setText("请输入原登入密码");
                    newPwdJtextField.setText("请输入新登入密码");
                    reNewPwdJtextField.setText("请再次输入新密码");
                    refreshData();//刷新数据
                }

            }
        });
    }

    /**
     * 数据校验
     * @param oldPwdTextField
     * @param newPwdJtextField
     * @param reNewPwdJtextField
     * @return
     */
    private boolean checkData(JTextField oldPwdTextField,JTextField newPwdJtextField, JTextField reNewPwdJtextField){

        String oldPwd=oldPwdTextField.getText().trim();//旧密码
        String newPwd=newPwdJtextField.getText().trim();//新密码
        String reNewPwd=reNewPwdJtextField.getText().trim();//新密码

        if (oldPwd.equals("")||oldPwd.length()<1||oldPwd.equals("请输入原登入密码")){
            JOptionPane.showMessageDialog(this,"请输入旧密码","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (newPwd.equals("")||newPwd.length()<1||newPwd.equals("请输入新登入密码")||reNewPwd.equals("")||reNewPwd.length()<1||reNewPwd.equals("请输入新登入密码")){
            JOptionPane.showMessageDialog(this,"请输入新密码","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if(newPwd.equals(reNewPwd)==false){
            JOptionPane.showMessageDialog(this,"两次输入的新密码不一致","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(oldPwd.equals(LOGINPASSWORD)==false){
            JOptionPane.showMessageDialog(this,"输入旧密码错误","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(Pattern.matches(REGEX_PASSWORD,newPwd)==false){
            JOptionPane.showMessageDialog(this,"密码由6-10字母数字组成","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
}
