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
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.dao.ebean.EbeanDaoFactory;
import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.model.process.Context;
import com.github.ant2.exceedvote.model.process.CriterionSelectionProcess;
import com.github.ant2.exceedvote.model.process.VotingProcess;
import com.github.ant2.exceedvote.stub.StubContext;
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

		//Context context = new StubContext();
		
		DaoFactory factory = new EbeanDaoFactory();
		VoteEvent event = factory.getEventDao().findAll().get(0);
		Voter voter = factory.getVoterDao().findAll().get(0);
		Context context = new Context(factory, event, voter);

		MainView mainView = new MainView();
		MainController mainController = new MainController(context, mainView);
		Activity activity;

		activity = new WelcomeActivity(context, new WelcomeActivityView());

		mainController.run(activity);

	}

}
