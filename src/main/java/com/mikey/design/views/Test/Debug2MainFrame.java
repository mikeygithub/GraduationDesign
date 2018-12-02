//package com.mikey.design.views.Test;
//
///**
// * @author Mikey
// * @Title:
// * @Description:
// * @Email:1625017540@qq.com
// * @date 2018/12/2 22:24
// * @Version 1.0
// */
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import cn.com.tcb.autotest.action.set.SetAboutAction;
//import cn.com.tcb.autotest.action.set.SetPanelInitAction;
//import cn.com.tcb.autotest.ui.auto.AutoPanel;
//import cn.com.tcb.autotest.ui.conn.ConnPanel;
//import cn.com.tcb.autotest.ui.pro.ProPanel;
//import cn.com.tcb.autotest.ui.set.SetPanel;
//
//import javax.swing.SwingConstants;
//import javax.swing.JLabel;
//
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.Font;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
///**
// * @function 自检软件主页面
// * @describe
// * @time 2017年2月16日下午1:36:58
// *
// */
//public class Debug2MainFrame extends JFrame {
//
//    private static final long serialVersionUID = 1L;
//    private JPanel contentPane;
//    private JLabel name;// 软件名称
//    private JLabel version;// 软件版本
//    private JPanel topPanel;
//    private JPanel bottomPanel;
//    private JPanel mainPanel;// 主面板
//    CardLayout card = new CardLayout();// 定义卡片布局对象
//    private JButton connButton;
//    private JButton autoButton;
//    private JButton setButton;
//    private JButton proButton;
//    private JButton departmentButton;
//    private JButton companyButton;
//
//    private SetPanelInitAction setPanelInitAction = new SetPanelInitAction();
//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Debug2MainFrame frame = new Debug2MainFrame();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * Create the frame.
//     */
//    public Debug2MainFrame() {
//        setResizable(false);
//        setType(Type.POPUP);
//        setTitle("自检软件--数字实验室");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 800, 602);
//        setLocationRelativeTo(null);
//        contentPane = new JPanel();
//        contentPane.setBackground(new Color(102, 102, 102));
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        connButton = new JButton("通信检测");
//        connButton.setFont(new Font("宋体", Font.PLAIN, 14));
//        connButton.setForeground(Color.WHITE);
//        connButton.setBackground(new Color(102, 102, 102));
//        connButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                card.show(mainPanel, "conn");
//                connButton.setBackground(new Color(51, 102, 255));
//                autoButton.setBackground(new Color(102, 102, 102));
//                setButton.setBackground(new Color(102, 102, 102));
//                proButton.setBackground(new Color(102, 102, 102));
//
//            }
//        });
//        connButton.setBounds(0, 66, 120, 80);
//        contentPane.add(connButton);
//
//        autoButton = new JButton("自动检测");
//        autoButton.setFont(new Font("宋体", Font.PLAIN, 14));
//        autoButton.setForeground(Color.WHITE);
//        autoButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                card.show(mainPanel, "auto");
//                connButton.setBackground(new Color(102, 102, 102));
//                autoButton.setBackground(new Color(51, 102, 255));
//                setButton.setBackground(new Color(102, 102, 102));
//                proButton.setBackground(new Color(102, 102, 102));
//            }
//        });
//        autoButton.setBackground(new Color(102, 102, 102));
//        autoButton.setBounds(0, 146, 120, 80);
//        contentPane.add(autoButton);
//
//        setButton = new JButton("设置");
//        setButton.setFont(new Font("宋体", Font.PLAIN, 14));
//        setButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                card.show(mainPanel, "set");
//                connButton.setBackground(new Color(102, 102, 102));
//                autoButton.setBackground(new Color(102, 102, 102));
//                setButton.setBackground(new Color(51, 102, 255));
//                proButton.setBackground(new Color(102, 102, 102));
//            }
//        });
//        setButton.setBackground(new Color(51, 102, 255));
//        setButton.setForeground(Color.WHITE);
//        setButton.setBounds(0, 226, 120, 80);
//        contentPane.add(setButton);
//
//        proButton = new JButton("高级调试");
//        proButton.setFont(new Font("宋体", Font.PLAIN, 14));
//        proButton.setForeground(Color.WHITE);
//        proButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                card.show(mainPanel, "pro");
//                connButton.setBackground(new Color(102, 102, 102));
//                autoButton.setBackground(new Color(102, 102, 102));
//                setButton.setBackground(new Color(102, 102, 102));
//                proButton.setBackground(new Color(51, 102, 255));
//            }
//        });
//        proButton.setBackground(new Color(102, 102, 102));
//        proButton.setBounds(0, 306, 120, 80);
//        contentPane.add(proButton);
//
//        topPanel = new JPanel();
//        topPanel.setBounds(0, 0, 784, 66);
//        topPanel.setBackground(Color.DARK_GRAY);
//        topPanel.setForeground(Color.WHITE);
//        contentPane.add(topPanel);
//        topPanel.setLayout(null);
//
//        name = new JLabel("自检软件");
//        name.setBounds(120, 0, 240, 40);
//        topPanel.add(name);
//        name.setFont(new Font("华文新魏", Font.PLAIN, 24));
//        name.setForeground(Color.YELLOW);
//        name.setBackground(new Color(105, 105, 105));
//        name.setVerticalAlignment(SwingConstants.BOTTOM);
//        name.setHorizontalAlignment(SwingConstants.CENTER);
//
//        version = new JLabel("v2.0.0");
//        version.setFont(new Font("宋体", Font.PLAIN, 14));
//        version.setBounds(120, 40, 240, 26);
//        topPanel.add(version);
//        version.setForeground(Color.WHITE);
//        version.setBackground(new Color(105, 105, 105));
//        version.setVerticalAlignment(SwingConstants.TOP);
//        version.setHorizontalAlignment(SwingConstants.CENTER);
//
//        departmentButton = new JButton("DTVLAB");
//        departmentButton.addMouseListener(new SetAboutAction());
//        departmentButton.setFont(new Font("宋体", Font.PLAIN, 14));
//        departmentButton.setBackground(Color.DARK_GRAY);
//        departmentButton.setForeground(Color.GREEN);
//        departmentButton.setBounds(0, 0, 120, 66);
//        topPanel.add(departmentButton);
//
//        companyButton = new JButton("TCB");
//        companyButton.setFont(new Font("宋体", Font.PLAIN, 14));
//        companyButton.setBackground(Color.DARK_GRAY);
//        companyButton.setForeground(Color.GREEN);
//        companyButton.setBounds(664, 0, 120, 66);
//        topPanel.add(companyButton);
//
//        bottomPanel = new JPanel();
//        bottomPanel.setBounds(119, 528, 665, 38);
//        bottomPanel.setBackground(Color.DARK_GRAY);
//        contentPane.add(bottomPanel);
//
//        mainPanel = new JPanel();
//        mainPanel.setBounds(119, 65, 665, 463);
//        contentPane.add(mainPanel);
//        card = new CardLayout(0, 0);
//        mainPanel.setLayout(card);
//
//        JPanel setPanel = new SetPanel();
//        mainPanel.add(setPanel, "set");
//
//        JPanel connPanel = ConnPanel2.getInstance();
//        mainPanel.add(connPanel, "conn");
//
//        JPanel autoPanel = AutoPanel.getInstance();
//        mainPanel.add(autoPanel, "auto");
//
//        JPanel proPanel = ProPanel.getInstance();
//        mainPanel.add(proPanel, "pro");
//
//    }
//}
