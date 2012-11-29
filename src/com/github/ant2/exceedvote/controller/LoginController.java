package com.github.ant2.exceedvote.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import apple.laf.JRSUIConstants.Widget;

import com.github.ant2.exceedvote.activity.controller.CriterionSelectionActivity;
import com.github.ant2.exceedvote.activity.controller.VotingActivity;
import com.github.ant2.exceedvote.activity.controller.WelcomeActivity;
import com.github.ant2.exceedvote.activity.view.CriterionSelectionActivityView;
import com.github.ant2.exceedvote.activity.view.VotingActivityView;
import com.github.ant2.exceedvote.activity.view.WelcomeActivityView;
import com.github.ant2.exceedvote.model.LoginResult;
import com.github.ant2.exceedvote.model.process.Context;
import com.github.ant2.exceedvote.model.process.CriterionSelectionProcess;
import com.github.ant2.exceedvote.model.process.LoginProcess;
import com.github.ant2.exceedvote.model.process.VotingProcess;
import com.github.ant2.exceedvote.view.LoginWindow;
import com.github.ant2.exceedvote.view.MainView;
import com.github.ant2.ui.activity.Activity;

public class LoginController {

	private LoginProcess process;
	private LoginWindow window;

	public LoginController(LoginProcess process, LoginWindow window) {
		this.process = process;
		this.window = window;
	}

	public void run() {
		window.setVisible(true);
		resetField();
		window.getLoginButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				doLogin();
			}
		});

		window.getResetButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetField();
			}
		});
	}

	private void doLogin() {
		LoginResult result = process.login(window.getUsernameField().getText(),
				new String(window.getPasswordField().getPassword()));
		if (result.getStatus() != LoginResult.Status.SUCCESS) {
			window.showLoginError();
			return;
		}
		window.dispose();
		startMain(result);
	}

	private void startMain(LoginResult result) {

		Context context = process.getContext(result);

		MainView mainView = new MainView();
		MainController mainController = new MainController(context, mainView);
		Activity activity;

		activity = new WelcomeActivity(context, new WelcomeActivityView());
		mainController.run(activity);
		
	}

	private void resetField() {
		window.getUsernameField().setText("");
		window.getPasswordField().setText("");
	}

}
