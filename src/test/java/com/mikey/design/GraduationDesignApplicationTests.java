package com.mikey.design;

import com.mikey.design.entity.Admin;
import com.mikey.design.entity.Student;
import com.mikey.design.entity.TitleOfStudent;
import com.mikey.design.entity.TitleOfStudentExample;
import com.mikey.design.mapper.DesignMapper;
import com.mikey.design.mapper.StudentMapper;
import com.mikey.design.mapper.TitleOfStudentMapper;
import com.mikey.design.service.AdminService;
import com.mikey.design.service.StudentService;
import com.mikey.design.views.login.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraduationDesignApplicationTests {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private TitleOfStudentMapper titleOfStudentMapper;

    @Autowired
    private DesignMapper designMapper;


    @Test
    public void contextLoads() {
//        Student student=studentMapper.selectByPrimaryKey(1);
//        System.out.println("Message="+student);

//        Student student=studentService.getStudent(1);
//        System.out.println("Message="+student);

//        System.setProperty("java.awt.headless", "false");
//        new Login();

//        Admin admin = adminService.getAdmin(1);
//        System.out.println("Message"+admin);

//        TitleOfStudent titleOfStudent = new TitleOfStudent();
//        titleOfStudent.setDesOfTitle(1);
//        titleOfStudent.setDesOfStu(1);
//        titleOfStudentMapper.insert(titleOfStudent);
//        /**
//         * 测试是否已经填报志愿
//         */
//        TitleOfStudentExample titleOfStudentExample = new TitleOfStudentExample();
//        TitleOfStudentExample.Criteria criteria = titleOfStudentExample.createCriteria();
//        criteria.andDesOfStuEqualTo(1);
//        System.out.println("Messge======"+ titleOfStudentMapper.countByExample(titleOfStudentExample));


        /**
         * test get first wish
         */
        TitleOfStudentExample titleOfStudentExample = new TitleOfStudentExample();

        TitleOfStudentExample.Criteria criteria = titleOfStudentExample.createCriteria();

        criteria.andDesOfStuEqualTo(1);//当前学生志愿

        criteria.andDesWishOrderEqualTo(0);//第一志愿


        List<TitleOfStudent> titleOfStudent= titleOfStudentMapper.selectByExample(titleOfStudentExample);

        System.out.println("Message==========="+titleOfStudent.get(0));

    }

}
