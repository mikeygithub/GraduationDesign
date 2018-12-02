

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class test1 extends JFrame {
    private JPanel pane = null; // 主要的JPanel，该JPanel的布局管理将被设置成CardLayout
    private JPanel p = null; // 放按钮的JPanel
    private CardLayout card = null; // CardLayout布局管理器
    private JButton button_1 = null; // 上一步
    private JButton button_2 = null; // 下一步
    private JButton b_1 = null, b_2 = null, b_3 = null; // 三个可直接翻转到JPanel组件的按钮
    private JPanel p_1 = null, p_2 = null, p_3 = null; // 要切换的三个JPanel

    public test1() {
        super("CardLayout Test");
        setTitle("\u6A21\u578B\u5165\u5E93\u5DE5\u5177");
        setResizable(false);
        try {
            // 将LookAndFeel设置成Windows样式
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        card = new CardLayout(5, 5);
        pane = new JPanel(card); // JPanel的布局管理将被设置成CardLayout
        p = new JPanel(); // 构造放按钮的JPanel
        button_1 = new JButton("< 上一步");
        button_2 = new JButton("下一步 >");
        b_1 = new JButton("1");
        b_2 = new JButton("2");
        b_3 = new JButton("3");
        b_1.setMargin(new Insets(2,2,2,2));
        b_2.setMargin(new Insets(2,2,2,2));
        b_3.setMargin(new Insets(2,2,2,2));
        p.add(button_1);
        p.add(b_1);
        p.add(b_2);
        p.add(b_3);
        p.add(button_2);
        p_1 = new JPanel();
        p_2 = new JPanel();
        p_3 = new JPanel();
        p_1.setBackground(Color.WHITE);
        p_2.setBackground(Color.BLUE);
        p_3.setBackground(Color.GREEN);
        p_1.add(new JLabel("JPanel_1"));
        p_2.add(new JLabel("JPanel_2"));
        p_3.add(new JLabel("JPanel_3"));
        pane.add(p_1, "p1");
        pane.add(p_2, "p2");
        pane.add(p_3, "p3");

        button_1.addActionListener(new ActionListener(){ // 上一步的按钮动作
            public void actionPerformed(ActionEvent e) {
                card.previous(pane);
            }
        });
        button_2.addActionListener(new ActionListener(){ // 下一步的按钮动作
            public void actionPerformed(ActionEvent e) {
                card.next(pane);
            }
        });
        b_1.addActionListener(new ActionListener() { // 直接翻转到p_1
            public void actionPerformed(ActionEvent e) {
                card.show(pane, "p1");
            }
        });
        b_2.addActionListener(new ActionListener() { // 直接翻转到p_2
            public void actionPerformed(ActionEvent e) {
                card.show(pane, "p2");
            }
        });
        b_3.addActionListener(new ActionListener() { // 直接翻转到p_3
            public void actionPerformed(ActionEvent e) {
                card.show(pane, "p3");
            }
        });
        this.getContentPane().add(pane);
        this.getContentPane().add(p, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(490, 387);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new test1();
    }

}

