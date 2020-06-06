package com.FatOff.View;

import javax.swing.*;

import com.FatOff.Model.Customer;

import java.awt.*;

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

        Customer cust = (Customer) value;
        if (cust == null) {
            return this;
        }
        String text = getCustomerDisplayText(cust);
        text = HtmlHighlighter.highlightText(text, searchLabel.getText());
        this.setText(text);
        if (!isSelected) {
            this.setBackground(index % 2 == 0 ? background : defaultBackground);
        }
        return this;
    }

    public static String getCustomerDisplayText(Customer cust) {
        return String.format("%s [%s]", cust.getFirstName() + " " + cust.getLastName(), cust.getId());
    }
}