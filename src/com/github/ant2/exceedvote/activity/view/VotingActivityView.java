package com.github.ant2.exceedvote.activity.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.github.ant2.exceedvote.view.Scene;
import com.github.ant2.ui.activity.ActivityView;

public class VotingActivityView extends ActivityView {

	/** */
	private static final long serialVersionUID = 1L;
	private JButton cancelButton;
	private JButton submitButton;
	private Scene scene;
	
	public VotingActivityView() {
		JPanel panel = new JPanel(new BorderLayout());
		scene = new Scene("Voting Criteria", panel);
		cancelButton = scene.addFooterButton("Cancel");
		submitButton = scene.addFooterButton("Submit");
		add(scene);
	}
	
	public JButton getCancelButton() {
		return cancelButton;
	}
	
	public JButton getSubmitButton() {
		return submitButton;
	}
	
	public void setTitle(String title) {
		scene.setTitle(title);
	}

}
