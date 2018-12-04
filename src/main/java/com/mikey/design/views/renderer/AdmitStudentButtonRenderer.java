package com.mikey.design.views.renderer;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/4 22:12
 * @Version 1.0
 */
public class AdmitStudentButtonRenderer  implements TableCellRenderer {

    private JPanel buttonJpanel;

    private JButton admitButton;

    public AdmitStudentButtonRenderer() {
        buttonJpanel=new JPanel();
        buttonJpanel.setLayout(new BorderLayout());
        admitButton=new JButton("录取");
        buttonJpanel.add(admitButton,BorderLayout.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return buttonJpanel;
    }

}
