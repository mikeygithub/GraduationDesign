package com.mikey.design.listerner.common;

import com.mikey.design.entity.Admin;
import com.mikey.design.entity.Student;
import com.mikey.design.entity.Teacher;
import com.mikey.design.service.AdminService;
import com.mikey.design.service.StudentService;
import com.mikey.design.service.TeacherService;
import com.mikey.design.utils.SpringUtil;
import com.mikey.design.utils.ThreadLocalUtil;
import com.mikey.design.views.admin.AdminMainView;
import com.mikey.design.views.student.StudentMainView;
import com.mikey.design.views.teacher.TeacherMainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/3 9:36
 * @Version 1.0
 */
@Component
public class LoginListener extends AbstractAction {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;

    private final static String ADMIN="admin";

    private final static String STU="student";

    private final static String TEA="teacher";

    private final  static String IS_NUM="^\\d+$";

    private JFrame login;

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

        /**
         * 无法通过自动注入，只能通过工具类获取
         */
        studentService = (StudentService) SpringUtil.getBean("studentServiceImpl");
        teacherService = (TeacherService) SpringUtil.getBean("teacherServiceImpl");
        adminService = (AdminService) SpringUtil.getBean("adminServiceImpl");


        this.username=usernameField.getText().trim();//获取用户名
        this.password=new String(passwordField.getPassword()).trim();//获取密码
        this.role=group.getSelectedCheckbox().getLabel();//获取角色

        if(Pattern.matches(IS_NUM,username)==false){
            JOptionPane.showMessageDialog(login, "学号或者工号错误");
            return;
        }

        if(username.length()==0||password.length()==0||username.equals("请输入学号或者工号")){
            JOptionPane.showMessageDialog(login, "用户名密码不能为空");
            return;
        }

        switch (role){
            case ADMIN://管理员登入
                Admin admin=adminService.getAdmin(Integer.parseInt(username));
                if (admin==null){
                    JOptionPane.showMessageDialog(login, "用户不存在");
                    return;
                }
                this.baseUserName=admin.getAdminId().toString();
                this.basePassWord=admin.getAdminPassword();
                //身份认证
                if(username.equals(baseUserName)&&password.equals(basePassWord)){//判断用户名和密码
                    System.out.println("管理员登入成功------------》》》》");
                    //登录成功
                    ThreadLocalUtil.set(admin);//保存用户信息
                    login.setVisible(false);
                    new AdminMainView(login);//进入管理员页面
                }
                else{
                    JOptionPane.showMessageDialog(login, "用户名或密码错误");
                }
                break;
            case STU://学生登入

                Student student= this.studentService.getStudent(Integer.parseInt(username));

                if (student==null){
                    JOptionPane.showMessageDialog(login, "用户不存在");
                    return;
                }

                this.baseUserName=student.getStudentId().toString();
                this.basePassWord=student.getStudentPassword();
                //身份认证
                if(username.equals(baseUserName)&&password.equals(basePassWord)){//判断用户名和密码
                    //登录成功
                    ThreadLocalUtil.set(student);//保存用户信息
                    login.setVisible(false);
                    new StudentMainView(login);//进入学生页面
                }
                else{
                    JOptionPane.showMessageDialog(login, "用户名或密码错误");
                }
                break;
            case TEA://教师登入
                    Teacher teacher=teacherService.getTeacher(Integer.parseInt(username));

                if (teacher==null){
                    JOptionPane.showMessageDialog(login, "用户不存在");
                    return;
                }
                    this.baseUserName=teacher.getTeacherId().toString();
                    this.basePassWord=teacher.getTeacherPassword();
                //身份认证
                if(username.equals(baseUserName)&&password.equals(basePassWord)){//判断用户名和密码
                    //登录成功
                    ThreadLocalUtil.set(teacher);//保存登入用户信息
                    login.setVisible(false);
                    new TeacherMainView(login);//进入教师页面
                }
                else{
                    JOptionPane.showMessageDialog(login, "用户名或密码错误");
                }
                break;
        }
    }

    public LoginListener() {
    }

    public LoginListener(JTextField username, JPasswordField passwordField, CheckboxGroup group,JFrame login) {
        this.usernameField = username;
        this.passwordField = passwordField;
        this.group=group;
        this.login=login;
    }
}
