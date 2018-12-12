package com.mikey.design;

import com.mikey.design.views.login.Login;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

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
//            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
//            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            //加载美化包
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);//关闭设置功能
            //设置此开关量为false即表示关闭之，BeautyEye LNF中默认是true
            BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        new Login();
    }
}
