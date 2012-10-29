package com.github.ant2.exceedvote.view;

import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.JButton;

public class BigButton extends JButton {
	private static final long serialVersionUID = 1L;

	public BigButton(AbstractAction action) {
		super(action);
		initDesign();
	}

	private void initDesign() {
		setFont(new Font("Arial", Font.BOLD, 50));
		setDefaultCapable(true);
	}
}
