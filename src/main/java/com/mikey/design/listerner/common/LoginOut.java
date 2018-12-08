package com.mikey.design.listerner.common;

import com.mikey.design.utils.ThreadLocalUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Mikey
 * @Title:  logout
 * @Description:    退出登入监听器
 * @Email:1625017540@qq.com
 * @date 2018/12/4 10:16
 * @Version 1.0
 */
public class LoginOut extends AbstractAction {

    private JFrame loginjFrame;//登入面板
    private JFrame mainjFrame;//主页面面板

    @Override
    public void actionPerformed(ActionEvent e) {
        mainjFrame.setVisible(false);//关闭登入面板
        ThreadLocalUtil.remove();//移除登入的用户
        System.out.println("用户退出登入成功================》》》》》》");
        loginjFrame.setVisible(true);//开启登入面板
    }

    public LoginOut(JFrame loginjFrame, JFrame mainjFrame) {
        this.loginjFrame = loginjFrame;
        this.mainjFrame = mainjFrame;
    }
}
