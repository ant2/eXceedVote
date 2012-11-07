package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.github.ant2.exceedvote.util.UIUtility;

public class ProjectButton extends JButton {

	public static class IconView extends JComponent {
		public IconView() {
			setPreferredSize(new Dimension(64, 64));
			setMaximumSize(new Dimension(64, 64));
			setMinimumSize(new Dimension(64, 64));
		}
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(new Color(0xaaaaaa));
			g.fillRect(0, 0, getWidth(), getHeight());
			super.paintComponent(g);
		}
	}
	
	public ProjectButton(String string) {
		super();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(256, 64));
		setMinimumSize(new Dimension(64, 64));
		JLabel center = new JLabel("<html>" + string + "</html>");
		center.setHorizontalAlignment(SwingConstants.CENTER);
		add(center, BorderLayout.CENTER);
		add(new IconView(), BorderLayout.WEST);
	}

	public static void main(String[] args) {
		UIUtility.setTheme();
		UIUtility.testWidget(new ProjectButton("Project Name"));
	}

}
