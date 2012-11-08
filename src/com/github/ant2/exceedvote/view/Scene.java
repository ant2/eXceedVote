package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.ant2.exceedvote.util.UIUtility;

public class Scene extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel footer;
	private JLabel titleLabel;

	public Scene(String title, JComponent component) {

		this(title);
		add(component, BorderLayout.CENTER);

	}

	public Scene(String title) {

		setLayout(new BorderLayout());

		titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
		UIUtility.addPadding(titleLabel, 20, 20, 10, 20);
		titleLabel.setAlignmentX(0.5f);

		add(titleLabel, BorderLayout.NORTH);

	}

	public void setTitle(String title) {
		titleLabel.setText(title);
	}

	public JButton addFooterButton(String text) {
		if (footer == null) {
			footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			add(footer, BorderLayout.SOUTH);
		}
		JButton button = new JButton(text);
		button.setFont(new Font("sans-serif", Font.PLAIN, 28));
		footer.add(button);
		return button;
	}

}
