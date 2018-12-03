package com.mikey.design;

import com.mikey.design.views.login.Login;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages={"com.mikey.design.Mapper"})
@SpringBootApplication
public class GraduationdesignsystemApplication {


    public static void main(String[] args) {

        SpringApplication.run(GraduationdesignsystemApplication.class, args);

        showLoginView();
    }
    public static void showLoginView(){
        System.setProperty("java.awt.headless", "false");
//        new Login();
//        login.shows();
    }
}
