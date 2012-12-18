package com.github.ant2.exceedvote.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.github.ant2.ui.view.HintView;

/**
 * Utility class for user interface components.
 * 
 * @author dtinth
 */
public class UIUtility {

	/** size of padding */
	public static final int SMALL_PADDING = 10;

	/**
	 * Adds a padding to a component, four sides.
	 * 
	 * @param component
	 *            component to add padding
	 * @param size
	 *            the size to pad
	 */
	public static void addPadding(JComponent component, int size) {
		addPadding(component, size, size, size, size);
	}

	/**
	 * Adds a padding to a component.
	 * 
	 * @param component
	 *            component to add padding
	 * @param top
	 *            top padding
	 * @param left
	 *            left padding
	 * @param bottom
	 *            bottom padding
	 * @param right
	 *            right padding
	 */
	public static void addPadding(JComponent component, int top, int left,
			int bottom, int right) {
		Border border = BorderFactory.createEmptyBorder(top, left, bottom,
				right);
		if (component.getBorder() == null) {
			component.setBorder(border);
		} else {
			component.setBorder(BorderFactory.createCompoundBorder(border,
					component.getBorder()));
		}
	}

	/**
	 * Creates a grid bag constraint that lays out the components vertically.
	 * 
	 * @return the created grid bag constraints
	 */
	public static GridBagConstraints createVerticalGridBagConstrints() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		return gridBagConstraints;
	}

	/**
	 * Creates a step panel
	 * 
	 * @return a new panel
	 */
	public static JPanel createStepPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		UIUtility.addPadding(panel, UIUtility.SMALL_PADDING);
		return panel;
	}

	/**
	 * Creates a step panel with the number
	 * 
	 * @param num
	 *            the number to display
	 * @param hint
	 *            the hint to display
	 * @return a new panel
	 */
	public static JPanel createStepPanel(String num, String hint) {
		JPanel panel = createStepPanel();
		panel.add(new HintView(num, hint), BorderLayout.NORTH);
		return panel;
	}

	/**
	 * Creates a step panel with the number, hint and the wrapped component
	 * 
	 * @param num
	 *            the number to display
	 * @param hint
	 *            the hint to display
	 * @param component
	 *            the component to put in this step panel
	 * @return a new panel
	 */
	public static JPanel createStepPanel(String num, String hint,
			Component component) {
		JPanel panel = createStepPanel(num, hint);
		panel.add(component, BorderLayout.CENTER);
		return panel;
	}

	/**
	 * Creates a step panel with a hint and a wrapped component.
	 * 
	 * @param hint
	 *            the hint to display
	 * @param component
	 *            the component to put in this step panel
	 * @return a new panel
	 */
	public static JPanel createStepPanel(String hint, Component component) {
		JPanel panel = createStepPanel(">", hint);
		panel.add(component, BorderLayout.CENTER);
		return panel;
	}

	/**
	 * Creates a padded step panel.
	 * 
	 * @param num
	 *            number to display
	 * @param hint
	 *            hint to display
	 * @param component
	 *            the component to wrap
	 * @return a new panel
	 */
	public static JPanel createPaddedStepPanel(String num, String hint,
			JComponent component) {
		JPanel pad = new JPanel(new BorderLayout());
		UIUtility.addPadding(pad, 0, 24, 0, 0);
		pad.add(component, BorderLayout.CENTER);
		return createStepPanel(num, hint, pad);
	}

	/**
	 * Tests the widget: displays a new JFrame containing that widget.
	 * 
	 * @param component
	 *            the widget to test
	 */
	public static void testWidget(Component component) {
		setTheme();
		JFrame frame = new JFrame(component.getClass().getName() + ": "
				+ component.toString());
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(component, BorderLayout.CENTER);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	private static boolean themeSet = false;

	/**
	 * Sets the UI theme so that it looks beautiful.
	 */
	public static void setTheme() {
		if (themeSet) return;
		themeSet = true;
		try {
			UIManager.put("nimbusBase", new Color(0xdddddd));
			UIManager.put("nimbusBlueGrey", new Color(0xb5b3b1));
			UIManager.put("control", new Color(0xe5e4e3));
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			try {
				UIManager
						.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
			} catch (Exception ee) {
				// can't set look and feel
			}
		}
	}

}
