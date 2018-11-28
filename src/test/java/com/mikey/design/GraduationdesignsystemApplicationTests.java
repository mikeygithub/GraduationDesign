package com.mikey.design;

import com.mikey.design.entity.Student;
import com.mikey.design.mapper.StudentMapper;
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
    @Test
    public void contextLoads() {
        Student student=studentMapper.selectByPrimaryKey(1);
        System.out.println("Message="+student);
    }

}
