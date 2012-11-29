package com.github.ant2.exceedvote;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.activity.controller.CriterionSelectionActivity;
import com.github.ant2.exceedvote.activity.controller.VotingActivity;
import com.github.ant2.exceedvote.activity.controller.WelcomeActivity;
import com.github.ant2.exceedvote.activity.view.CriterionSelectionActivityView;
import com.github.ant2.exceedvote.activity.view.VotingActivityView;
import com.github.ant2.exceedvote.activity.view.WelcomeActivityView;
import com.github.ant2.exceedvote.controller.LoginController;
import com.github.ant2.exceedvote.controller.MainController;
import com.github.ant2.exceedvote.dao.jpa.JPADaoFactory;
import com.github.ant2.exceedvote.model.process.Context;
import com.github.ant2.exceedvote.model.process.CriterionSelectionProcess;
import com.github.ant2.exceedvote.model.process.LoginProcess;
import com.github.ant2.exceedvote.model.process.VotingProcess;
import com.github.ant2.exceedvote.stub.StubDaoFactory;
import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.exceedvote.view.LoginWindow;
import com.github.ant2.exceedvote.view.MainView;
import com.github.ant2.ui.activity.Activity;

/**
 * eXceed Vote Main Class
 * 
 * @author dtinth
 */
public class ExceedVoteMain {

	private static Logger logger = LogManager.getLogger(ExceedVoteMain.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		logger.info("eXceed Vote Starting...");

		UIUtility.setTheme();

		LoginProcess loginProcess = new LoginProcess(new JPADaoFactory());
		LoginWindow window = new LoginWindow();
		
		LoginController controller = new LoginController(loginProcess, window);
		controller.run();

	}

}
