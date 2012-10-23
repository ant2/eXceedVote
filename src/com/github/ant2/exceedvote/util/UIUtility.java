package com.github.ant2.exceedvote.util;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

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

}
