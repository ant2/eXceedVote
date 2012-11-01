package com.github.ant2.exceedvote.activity.view;

import java.awt.BorderLayout;

import javax.swing.JButton;

import com.github.ant2.exceedvote.view.Menu;
import com.github.ant2.exceedvote.view.Scene;
import com.github.ant2.ui.activity.ActivityView;

public class WelcomeActivityView extends ActivityView {

	/** */
	private static final long serialVersionUID = 1L;
	private JButton button;

	public WelcomeActivityView() {
		super(new BorderLayout());
		Menu menu = new Menu();
		menu.addItem("View Project Information");
		menu.addItem("Vote / Change Vote");
		add(new Scene("Welcome to eXceedVote", menu));
	}

	public JButton getButton() {
		return button;
	}

}
