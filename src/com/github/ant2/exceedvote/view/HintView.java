package com.github.ant2.exceedvote.view;

import java.awt.Font;

import javax.swing.JLabel;

public class HintView extends JLabel {

	public HintView(String text) {
		
		super(text);
		
		setFont(new Font("Arial", Font.BOLD, 16));
		
	}
	
}
