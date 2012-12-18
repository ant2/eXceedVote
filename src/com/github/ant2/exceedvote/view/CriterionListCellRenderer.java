package com.github.ant2.exceedvote.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * A list cell render for criterion list. It displays as a big text with some
 * circle in front indicating the selection.
 * 
 * @author dtinth
 */
public class CriterionListCellRenderer extends JLabel implements
		ListCellRenderer {

	/** */
	private static final long serialVersionUID = 1L;
	private boolean selected;

	/**
	 * Constructs a new CriterionListCellRenderer
	 */
	public CriterionListCellRenderer() {
		setFont(new Font("Arial", Font.PLAIN, 20));
		setOpaque(true);
		setBorder(BorderFactory.createEmptyBorder(10, 54, 10, 30));
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		setText("<html><b>" + value + "</b>");
		setEnabled(list.isEnabled());
		setSelected(isSelected);

		return this;
	}

	private void setSelected(boolean selected) {
		this.selected = selected;
		if (!selected) {
			setBackground(new Color(0xffffff));
			setForeground(new Color(0x000000));
		} else {
			setBackground(new Color(0x000000));
			setForeground(new Color(0xffffff));
		}
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(selected ? new Color(0xffffff) : new Color(0x000000));
		int size = getHeight() - 20;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawOval(20, 10, size, size);
		if (selected) {
			g.setColor(new Color(0xffffff));
			g.fillOval(27, 17, size - 13, size - 13);
		}
	}

}