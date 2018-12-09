package com.mikey.design.views.common;

import com.mikey.design.entity.Admin;
import com.mikey.design.entity.Student;
import com.mikey.design.entity.Teacher;
import com.mikey.design.service.AdminService;
import com.mikey.design.service.StudentService;
import com.mikey.design.service.TeacherService;
import com.mikey.design.utils.SpringUtil;
import com.mikey.design.utils.ThreadLocalUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

/**
 * @author Mikey
 * @Title: 更新个人信息
 * @Description: 更新个人信息面板
 * @Email:1625017540@qq.com
 * @date 2018/12/4 11:14
 * @Version 1.0
 */
public class UpdatePanel extends JPanel {
    //学生
    private StudentService studentService;
    //教师
    private TeacherService teacherService;
    //管理员
    private AdminService adminService;
    //当前登入用户名
    private String loginUserName="";
    //当前登入用性别
    private int loginUserSex;//0：女、1：男
    //当前登入用户联系方式
    private String loginUserPhone="";
    //teaherInfo
    private String loginUserTeacherInfo="请输入教师个人简介";
    //手机号码
    public static final String REGEX_MOBILE ="^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
    //用户名
    public static final String REGEX_USERNAME = "^[\u4E00-\u9FA5]{2,10}$";

    public void getData(){
        //获取当前登入用户信息
        Object loginUser = ThreadLocalUtil.get();

        //判断角色类型
        if(loginUser instanceof Student){//学生
            loginUserName=((Student) loginUser).getStudentName();
            loginUserSex=((Student) loginUser).getStudentSex();
            loginUserPhone=((Student) loginUser).getStudentPhone();
        }else if (loginUser instanceof Teacher){//教师
            loginUserName=((Teacher) loginUser).getTeacherName();
            loginUserSex=((Teacher) loginUser).getTeacherSex();
            loginUserPhone=((Teacher) loginUser).getTeacherPhone();
            loginUserTeacherInfo=((Teacher) loginUser).getTeacherInfo();

        }else if (loginUser instanceof Admin){//管理员
            loginUserName=((Admin) loginUser).getAdminName();
            loginUserSex=((Admin) loginUser).getAdminSex();
            loginUserPhone=((Admin) loginUser).getAdminPhone();
        }
    }

    public UpdatePanel() throws HeadlessException {

        studentService = (StudentService) SpringUtil.getBean("studentServiceImpl");
        teacherService = (TeacherService) SpringUtil.getBean("teacherServiceImpl");
        adminService = (AdminService) SpringUtil.getBean("adminServiceImpl");



        //获取当前登入用户信息
        Object loginUser = ThreadLocalUtil.get();

        getData();//获取数据


        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("修改个人信息");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //更改个人信息
        JPanel mainJpanel=new JPanel();
        mainJpanel.setLayout(new GridLayout(7,1));
        //1.名字
        JPanel username=new JPanel();
        JLabel nameJlabel=new JLabel("用户名：");
        JTextField nameJtextField=new JTextField(loginUserName);
        username.add(nameJlabel);
        username.add(nameJtextField);
        //2.性别
        JPanel sex=new JPanel();
        JLabel sexJlabel=new JLabel("性别：");
        JComboBox sexboBox=new JComboBox();//下拉框
        sexboBox.addItem("女");
        sexboBox.addItem("男");
        sex.add(sexJlabel);
        sex.add(sexboBox);
        //显示性别
        sexboBox.setSelectedIndex(loginUserSex);

        //3.联系电话
        JPanel phone=new JPanel();
        JLabel phoneJlabel=new JLabel("联系方式：");
        JTextField phoneJtextField=new JTextField(loginUserPhone);
        phone.add(phoneJlabel);
        phone.add(phoneJtextField);

        //4.教师info
        JPanel teacherInfoJpanel=new JPanel();
        JTextArea teacherInfoJtextArea=new JTextArea(loginUserTeacherInfo,5,15);
        //提交按钮
        JPanel submits=new JPanel();
        JButton sunmit=new JButton("确认更改");
        JButton reselt=new JButton("取消更改");
        submits.add(sunmit);
        submits.add(reselt);

        mainJpanel.add(username);
        mainJpanel.add(sex);
        mainJpanel.add(phone);

        if (loginUser instanceof  Teacher){
            JLabel teacherInfoJlabel=new JLabel("个人简介：");
            teacherInfoJpanel.add(teacherInfoJlabel);
            teacherInfoJpanel.add(teacherInfoJtextArea);
            mainJpanel.add(teacherInfoJpanel);
        }

        mainJpanel.add(submits);
        add(mainJpanel,BorderLayout.CENTER);

        //确认更改
        sunmit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkData(nameJtextField,sexboBox,phoneJtextField)) {

                    int result = JOptionPane.showConfirmDialog(null, "确认更改信息？", "系统提示", JOptionPane.YES_NO_CANCEL_OPTION);
                    /**
                     * 提交保存
                     */
                    if (result == JOptionPane.YES_NO_OPTION) {

                        if (loginUser instanceof Student) {//学生
                            ((Student) loginUser).setStudentName(nameJtextField.getText());
                            ((Student) loginUser).setStudentSex(sexboBox.getSelectedIndex());
                            ((Student) loginUser).setStudentPhone(phoneJtextField.getText());

                            studentService.updateStudent((Student) loginUser);//更新

                            JOptionPane.showMessageDialog(null, "更新成功", "系统提示", JOptionPane.INFORMATION_MESSAGE);

                            getData();//获取数据

                            return;

                        } else if (loginUser instanceof Teacher) {//教师
                            //TODO:待添加教师info
                            ((Teacher) loginUser).setTeacherName(nameJtextField.getText());
                            ((Teacher) loginUser).setTeacherSex(sexboBox.getSelectedIndex());
                            ((Teacher) loginUser).setTeacherPhone(phoneJtextField.getText());
                            ((Teacher) loginUser).setTeacherInfo(teacherInfoJtextArea.getText());

                            teacherService.updateTeacherNum((Teacher) loginUser);

                            JOptionPane.showMessageDialog(null, "更新成功", "系统提示", JOptionPane.INFORMATION_MESSAGE);

                            getData();//获取数据

                            return;

                        } else if (loginUser instanceof Admin) {//管理员

                            ((Admin) loginUser).setAdminName(nameJtextField.getText());
                            ((Admin) loginUser).setAdminSex(sexboBox.getSelectedIndex());
                            ((Admin) loginUser).setAdminPhone(phoneJtextField.getText());

                            adminService.updataAdmin((Admin) loginUser);

                            JOptionPane.showMessageDialog(null, "更新成功", "系统提示", JOptionPane.INFORMATION_MESSAGE);

                            getData();//获取数据

                            return;

                        }
                    }
                }

            }
        });
    }

    /**
     * 数据校验
     * @param nameJtextField
     * @param sexboBox
     * @param phoneJtextField
     * @return
     */
    private boolean checkData(JTextField nameJtextField,JComboBox sexboBox, JTextField phoneJtextField){

        String userName=nameJtextField.getText().trim();//
        int userSex=sexboBox.getSelectedIndex();//获取性别
        String userPhone=phoneJtextField.getText().trim();//获取电话

        if (userName.equals("")||userName.length()<1){
            JOptionPane.showMessageDialog(this,"请输入用户名","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (userPhone.equals("")||userPhone.length()<1){
            JOptionPane.showMessageDialog(this,"请输入联系电话","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if(Pattern.matches(REGEX_USERNAME,userName)==false){
            JOptionPane.showMessageDialog(this,"用户名由2-10汉字组成","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(Pattern.matches(REGEX_MOBILE,userPhone)==false){
            JOptionPane.showMessageDialog(this,"请输入正确的移动电话号码","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        /**
         * 判断手机号是否已经注册
         */
        Student studentByPhone = studentService.getStudentByPhone(userPhone);
        if (studentByPhone.getStudentPhone()!=null&&!studentByPhone.getStudentPhone().equals(loginUserPhone)){
            JOptionPane.showMessageDialog(this,"该手机号码已经被使用","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
}
