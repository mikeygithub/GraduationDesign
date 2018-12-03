package com.mikey.design.listerner;

import com.mikey.design.entity.Admin;
import com.mikey.design.entity.Student;
import com.mikey.design.entity.Teacher;
import com.mikey.design.service.AdminService;
import com.mikey.design.service.StudentService;
import com.mikey.design.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/3 9:36
 * @Version 1.0
 */
public class LoginListener extends AbstractAction {

    private final static String ADMIN="admin";

    private final static String STU="student";

    private final static String TEA="teacher";

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;

    private JTextField usernameField;

    private JPasswordField passwordField;

    private String username;

    private String password;

    private String role;

    private  CheckboxGroup group;//选择

    private String baseUserName;//数据库查询出来的用户名

    private String basePassWord;//数据库查询出来的密码

    @Override
    public void actionPerformed(ActionEvent e) {

        this.username=usernameField.getText().trim();//获取用户名
        this.password=new String(passwordField.getPassword()).trim();//获取密码
        this.role=group.getSelectedCheckbox().getLabel();

        if(username.length()==0||password.length()==0){
            JOptionPane.showMessageDialog(null, "用户名密码不能为空");
            return;
        }

        switch (role){
            case ADMIN://管理员登入
                Admin admin=adminService.getAdmin(Integer.parseInt(username));
                this.baseUserName=admin.getAdminName();
                this.basePassWord=admin.getAdminPassword();
                //身份认证
                if(username.equals("admin")&&password.equals("123456")){//判断用户名和密码
                    //登录成功
                }
                else{
                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
                }
                break;
            case STU://学生登入
                Student student=studentService.getStudent(Integer.parseInt(username));
                this.baseUserName=student.getStudentName();
                this.basePassWord=student.getStudentPassword();
                //身份认证
                if(username.equals("admin")&&password.equals("123456")){//判断用户名和密码
                    //登录成功
                }
                else{
                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
                }
                break;
            case TEA://教师登入
                Teacher teacher=teacherService.getTeacher(Integer.parseInt(username));
                this.baseUserName=teacher.getTeacherName();
                this.basePassWord=teacher.getTeacherPassword();
                //身份认证
                if(username.equals("admin")&&password.equals("123456")){//判断用户名和密码
                    //登录成功
                }
                else{
                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
                }
                break;
        }
    }

    public LoginListener() {
    }

    public LoginListener(JTextField username, JPasswordField passwordField, CheckboxGroup group) {
        this.usernameField = username;
        this.passwordField = passwordField;
        this.group=group;
    }
}
