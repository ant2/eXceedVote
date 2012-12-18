package com.github.ant2.exceedvote.view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * A panel which the children is vertically-centered. A decorator.
 * 
 * @author dtinth
 */
public class VerticallyCenteredPanel extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new VerticallyCenteredPanel
	 * 
	 * @param component
	 *            the component to wrap
	 */
	public VerticallyCenteredPanel(JComponent component) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		component.setAlignmentX(0.5f);
		add(Box.createVerticalGlue());
		add(component);
		add(Box.createVerticalGlue());
	}

}
