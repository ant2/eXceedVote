package com.github.ant2.ui.view;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 * A button that looks like a link.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class LinkButton extends JButton {

	/** */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a LinkButton with a specified action.
	 * 
	 * @param abstractAction
	 *            the action to associate with this LinkButton
	 */
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
