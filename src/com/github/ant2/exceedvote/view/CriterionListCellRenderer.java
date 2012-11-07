package com.github.ant2.exceedvote.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CriterionListCellRenderer extends JLabel implements
		ListCellRenderer {

	/** */
	private static final long serialVersionUID = 1L;

	public CriterionListCellRenderer() {
		setFont(new Font("Arial", Font.BOLD, 20));
		setOpaque(true);
		setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		setText(value + "");
		setEnabled(list.isEnabled());

		if (!isSelected) {
			setBackground(new Color(0xffffff));
			setForeground(new Color(0x000000));
		} else {
			setBackground(new Color(0x000000));
			setForeground(new Color(0xffffff));
		}
		return this;
	}

}