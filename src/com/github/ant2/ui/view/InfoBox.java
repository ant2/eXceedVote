package com.github.ant2.ui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoBox extends JPanel {
	/** */
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;
	private JLabel textLabel;

	public InfoBox(String name, String text) {
		nameLabel = new JLabel();
		textLabel = new JLabel();
		nameLabel.setText(name);
		textLabel.setText(text);
		setLayout(new BorderLayout());
		this.add(nameLabel, BorderLayout.NORTH);
		this.add(textLabel, BorderLayout.CENTER);
		setMaximumSize(new Dimension(192, 50));
	}

	public void setText(String text) {
		textLabel.setText(text);
	}
}
