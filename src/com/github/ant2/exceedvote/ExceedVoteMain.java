package com.github.ant2.exceedvote;

import java.util.Calendar;

import org.apache.log4j.PropertyConfigurator;

import com.github.ant2.exceedvote.activity.controller.CriterionSelectionActivity;
import com.github.ant2.exceedvote.activity.controller.VotingActivity;
import com.github.ant2.exceedvote.activity.controller.WelcomeActivity;
import com.github.ant2.exceedvote.activity.view.CriterionSelectionActivityView;
import com.github.ant2.exceedvote.activity.view.VotingActivityView;
import com.github.ant2.exceedvote.activity.view.WelcomeActivityView;
import com.github.ant2.exceedvote.controller.MainController;
import com.github.ant2.exceedvote.model.ExceedVoteEvent;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;
import com.github.ant2.exceedvote.model.VoterProfile;
import com.github.ant2.exceedvote.model.process.Context;
import com.github.ant2.exceedvote.model.process.CriterionSelectionProcess;
import com.github.ant2.exceedvote.model.process.VotingProcess;
import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.exceedvote.view.MainView;
import com.github.ant2.ui.activity.Activity;

/**
 * eXceed Vote Main Class
 * 
 * @author dtinth
 */
public class ExceedVoteMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UIUtility.setTheme();
		PropertyConfigurator.configure(ExceedVoteMain.class
				.getResourceAsStream("log4j.properties"));

		Voter voter = new Voter(new VoterProfile("マーリーさん", "5410000000"));
		VoteEvent event = new ExceedVoteEvent();
		Context context = new Context(event, voter);

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 3);
		event.setFinishTime(calendar);

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
