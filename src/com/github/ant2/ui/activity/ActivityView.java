package com.github.ant2.ui.activity;

import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * A base class for all ActivityViews.
 * 
 * @author dtinth
 */
public class ActivityView extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an ActivityView.
	 */
	public ActivityView() {
		super();
	}

	/**
	 * Constructs an ActivityView with a LayoutManager.
	 * 
	 * @param layout
	 *            the LayoutManager to use.
	 */
	public ActivityView(LayoutManager layout) {
		super(layout);
	}

}
