package com.mikey.design;

import com.mikey.design.views.login.Login;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages={"com.mikey.design.mapper"})
@SpringBootApplication
public class GraduationdesignsystemApplication {


    public static void main(String[] args) {

        SpringApplication.run(GraduationdesignsystemApplication.class, args);

        showLoginView();
    }
    public static void showLoginView(){
        System.setProperty("java.awt.headless", "false");
        try
        {
//            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            //加载美化包
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        new Login();
    }
}
