package com.github.ant2.exceedvote.view.activity;

import java.awt.BorderLayout;

import javax.swing.JButton;

import com.github.ant2.exceedvote.view.BigButton;
import com.github.ant2.exceedvote.view.HintView;

public class WelcomeActivityView extends ActivityView {

	/** */
	private static final long serialVersionUID = 1L;
	private JButton button;

	public WelcomeActivityView() {
		super(new BorderLayout());
		add(new HintView("!", "Welcome to eXceed Vote!!"), BorderLayout.NORTH);
		button = new BigButton(null);
		add(button);
	}

	public JButton getButton() {
		return button;
	}

}
