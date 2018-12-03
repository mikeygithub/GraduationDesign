package com.mikey.design;

import com.mikey.design.entity.Admin;
import com.mikey.design.entity.Student;
import com.mikey.design.mapper.StudentMapper;
import com.mikey.design.service.AdminService;
import com.mikey.design.service.StudentService;
import com.mikey.design.views.login.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraduationdesignsystemApplicationTests {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;


    @Test
    public void contextLoads() {
//        Student student=studentMapper.selectByPrimaryKey(1);
//        System.out.println("Message="+student);

        Student student=studentService.getStudent(1);
        System.out.println("Message="+student);

//        System.setProperty("java.awt.headless", "false");
//        new Login();

        Admin admin = adminService.getAdmin(1);
        System.out.println("Message"+admin);
    }

}
