package com.github.ant2.exceedvote.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;

	public Menu() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public JButton addItem(String text) {
		JButton button = new JButton(text);
		button.setAlignmentX(CENTER_ALIGNMENT);
		button.setFont(new Font("sans-serif", Font.PLAIN, 36));
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(button);
		add(Box.createRigidArea(new Dimension(0, 10)));
		return button;
	}

}
