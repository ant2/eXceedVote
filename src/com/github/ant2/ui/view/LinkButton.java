package com.github.ant2.ui.view;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.AbstractAction;
import javax.swing.JButton;

public class LinkButton extends JButton {

	/** */
	private static final long serialVersionUID = 1L;

	public LinkButton(AbstractAction abstractAction) {
		super(abstractAction);
		initDesign();
	}

	private void initDesign() {
		setForeground(Color.BLUE);
		setFocusPainted(false);
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
	}
}
