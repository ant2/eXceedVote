package com.github.ant2.ui.view;

import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 * A button with big text.
 * 
 * @author Artima Mahahemarat
 */
public class BigButton extends JButton {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a BigButton with a specified action.
	 * 
	 * @param action
	 *            action to be with the button.
	 */
	public BigButton(AbstractAction action) {
		super(action);
		initDesign();
	}

	private void initDesign() {
		setFont(new Font("Arial", Font.BOLD, 50));
		setDefaultCapable(true);
	}
}
