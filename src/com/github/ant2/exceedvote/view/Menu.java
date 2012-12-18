package com.github.ant2.exceedvote.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A menu with big buttons in the center.
 * 
 * @author dttvb
 */
public class Menu extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new Menu.
	 */
	public Menu() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	/**
	 * Adds a new menu item as a button.
	 * 
	 * @param text
	 *            text to display
	 * @return the new button
	 */
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
