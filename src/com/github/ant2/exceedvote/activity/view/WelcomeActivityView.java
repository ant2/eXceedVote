package com.github.ant2.exceedvote.activity.view;

import javax.swing.JButton;

import com.github.ant2.exceedvote.view.Menu;
import com.github.ant2.exceedvote.view.Scene;
import com.github.ant2.exceedvote.view.VerticallyCenteredPanel;
import com.github.ant2.ui.activity.ActivityView;

/**
 * The view for WelcomeActivity
 *
 * @author dtinth
 */
public class WelcomeActivityView extends ActivityView {

	/** */
	private static final long serialVersionUID = 1L;
	private JButton viewProjectInformationButton;
	private JButton voteButton;

	/**
	 * Constructs a new WelcomeActivityView.
	 */
	public WelcomeActivityView() {
		Menu menu = new Menu();
		viewProjectInformationButton = menu.addItem("View Project Information");
		voteButton = menu.addItem("Vote / Change Vote");
		add(new Scene("Welcome to eXceedVote",
				new VerticallyCenteredPanel(menu)));
	}

	/**
	 * Returns the "view project information" button.
	 * @return the "view project information" button
	 */
	public JButton getViewProjectInformationButton() {
		return viewProjectInformationButton;
	}

	/**
	 * Returns the "vote" button.
	 * @return the "vote" button
	 */
	public JButton getVoteButton() {
		return voteButton;
	}

}
