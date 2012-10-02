package com.github.ant2.exceedvote.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ProjectCellItemRenderer extends JLabel implements ListCellRenderer {

	public ProjectCellItemRenderer() {
		setFont(new Font("Arial", Font.BOLD, 20));
		setOpaque(true);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		setText(value + "");
		setEnabled(list.isEnabled());
		
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		return this;
	}

}