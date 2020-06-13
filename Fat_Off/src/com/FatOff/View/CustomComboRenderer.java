package com.FatOff.View;

import javax.swing.*;

import com.FatOff.Model.Person;

import java.awt.*;

@SuppressWarnings("serial")
public class CustomComboRenderer extends DefaultListCellRenderer {
    public static final Color background = new Color(250, 250, 255);
    private static final Color defaultBackground = (Color) UIManager.get("List.background");
    private JLabel searchLabel;

    public CustomComboRenderer(JLabel filterLabel) {
        this.searchLabel = filterLabel;
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        Object pers = (Person) value;
        if (pers == null) {
            return this;
        }
        String text = getCustomerDisplayText(pers);
        text = HtmlHighlighter.highlightText(text, searchLabel.getText());
        this.setText(text);
        if (!isSelected) {
            this.setBackground(index % 2 == 0 ? background : defaultBackground);
        }
        return this;
    }

    public static String getCustomerDisplayText(Object pers) {
        if (pers == null) {
            return "";
        }
        return String.format("%s,  [%s]", ((Person)pers).toString(), ((Person)pers).getId());
    }
}