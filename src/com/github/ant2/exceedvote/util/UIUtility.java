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

public class UIUtility {

	public static final int SMALL_PADDING = 10;

	public static void addPadding(JComponent component, int size) {
		addPadding(component, size, size, size, size);
	}

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

	public static GridBagConstraints createVerticalGridBagConstrints() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		return gridBagConstraints;
	}

	public static JPanel createStepPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		UIUtility.addPadding(panel, UIUtility.SMALL_PADDING);
		return panel;
	}

	public static JPanel createStepPanel(String num, String hint) {
		JPanel panel = createStepPanel();
		panel.add(new HintView(num, hint), BorderLayout.NORTH);
		return panel;
	}

	public static JPanel createStepPanel(String num, String hint,
			Component component) {
		JPanel panel = createStepPanel(num, hint);
		panel.add(component, BorderLayout.CENTER);
		return panel;
	}

	public static JPanel createStepPanel(String hint, Component component) {
		JPanel panel = createStepPanel(">", hint);
		panel.add(component, BorderLayout.CENTER);
		return panel;
	}

	public static JPanel createPaddedStepPanel(String num, String hint,
			JComponent component) {
		JPanel pad = new JPanel(new BorderLayout());
		UIUtility.addPadding(pad, 0, 24, 0, 0);
		pad.add(component, BorderLayout.CENTER);
		return createStepPanel(num, hint, pad);
	}

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
