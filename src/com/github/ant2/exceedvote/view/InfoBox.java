package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.ant2.exceedvote.ui.theme.ThemeColor;
import com.github.ant2.exceedvote.util.UIUtility;

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
		setOpaque(false);

		nameLabel.setBackground(ThemeColor.INFOBOX_TITLE_BACKGROUND);
		nameLabel.setForeground(ThemeColor.INFOBOX_TITLE_FOREGROUND);
		nameLabel.setOpaque(true);
		UIUtility.addPadding(nameLabel, 3);

		textLabel.setBackground(ThemeColor.INFOBOX_TEXT_BACKGROUND);
		textLabel.setForeground(ThemeColor.INFOBOX_TEXT_FOREGROUND);
		textLabel.setOpaque(true);
		UIUtility.addPadding(textLabel, 3);
		textLabel.setFont(new Font("sans-serif", Font.PLAIN, 18));

		setLayout(new BorderLayout());
		this.add(nameLabel, BorderLayout.NORTH);
		this.add(textLabel, BorderLayout.CENTER);
		setMaximumSize(new Dimension(192, 50));
	}

	public void setText(String text) {
		textLabel.setText(text);
	}
}
