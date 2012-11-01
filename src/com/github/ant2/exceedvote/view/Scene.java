package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.ant2.exceedvote.util.UIUtility;

public class Scene extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;

	public Scene(String title, JComponent component) {
		setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		
		JLabel titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
		UIUtility.addPadding(titleLabel, 20, 20, 10, 20);
		titleLabel.setAlignmentX(0.5f);
		component.setAlignmentX(0.5f);
		
		center.add(Box.createVerticalGlue());
		center.add(component);
		center.add(Box.createVerticalGlue());
		
		add(titleLabel, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
	}
	
}
