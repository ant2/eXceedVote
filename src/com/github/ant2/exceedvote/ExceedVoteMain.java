package com.github.ant2.exceedvote;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.ant2.exceedvote.activity.controller.CriterionSelectionActivity;
import com.github.ant2.exceedvote.activity.controller.VotingActivity;
import com.github.ant2.exceedvote.activity.controller.WelcomeActivity;
import com.github.ant2.exceedvote.activity.view.CriterionSelectionActivityView;
import com.github.ant2.exceedvote.activity.view.VotingActivityView;
import com.github.ant2.exceedvote.activity.view.WelcomeActivityView;
import com.github.ant2.exceedvote.controller.MainController;
import com.github.ant2.exceedvote.model.process.Context;
import com.github.ant2.exceedvote.model.process.CriterionSelectionProcess;
import com.github.ant2.exceedvote.model.process.VotingProcess;
import com.github.ant2.exceedvote.stub.StubDaoFactory;
import com.github.ant2.exceedvote.util.UIUtility;
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

		StubDaoFactory sdf = new StubDaoFactory();
		Context context = new Context(sdf, sdf.EVENT, sdf.V2);

		MainView mainView = new MainView();
		MainController mainController = new MainController(context, mainView);
		Activity activity;

		activity = new WelcomeActivity(context, new WelcomeActivityView());

		CriterionSelectionProcess process2 = context
				.createCriterionSelectionProcess();
		activity = new CriterionSelectionActivity(activity, process2,
				new CriterionSelectionActivityView());

		VotingProcess process = process2.createVotingProcess(process2
				.getAllCriteria().get(0));
		activity = new VotingActivity(activity, process,
				new VotingActivityView());

		mainController.run(activity);

	}

}
