package com.github.ant2.exceedvote.util;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

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

	public static JPanel createPaddedStepPanel(String num, String hint,
			JComponent component) {
		JPanel pad = new JPanel(new BorderLayout());
		UIUtility.addPadding(pad, 0, 24, 0, 0);
		pad.add(component, BorderLayout.CENTER);
		return createStepPanel(num, hint, pad);
	}

}
