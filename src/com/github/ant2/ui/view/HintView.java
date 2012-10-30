package com.github.ant2.ui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.github.ant2.exceedvote.util.UIUtility;

/**
 * A hint view, like a label, but with number in a circle in front of the text.
 * 
 * @author dtinth
 */
public class HintView extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;

	/**
	 * The label with a circle and number inside it.
	 * 
	 * @author dtinth
	 */
	private final class NumberLabel extends JLabel {

		/** */
		private static final long serialVersionUID = 1L;

		private NumberLabel(String text) {
			super(text);
			setPreferredSize(new Dimension(20, 20));
			setFont(new Font("Arial", Font.BOLD, 12));
			setForeground(Color.WHITE);
			setHorizontalAlignment(SwingConstants.CENTER);
		}

		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D g = (Graphics2D) graphics;
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(Color.BLACK);
			g.fillOval(1, 0, getWidth() - 1, getHeight() - 1);
			super.paintComponent(g);
		}

	}

	/**
	 * Constructs a HintView with the specified number and text.
	 * 
	 * @param number
	 *            the number to display inside the circle to the left of the
	 *            text
	 * @param text
	 *            the text to display
	 */
	public HintView(String number, String text) {

		setLayout(new BorderLayout());

		add(new NumberLabel(number), BorderLayout.WEST);

		JLabel label = new JLabel(text);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		UIUtility.addPadding(label, 0, 7, 0, 0);

		add(label, BorderLayout.CENTER);
		UIUtility.addPadding(this, 0, 0, 4, 0);

	}

}
