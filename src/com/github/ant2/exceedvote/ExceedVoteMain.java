package com.github.ant2.exceedvote;

import java.awt.Color;
import java.util.Calendar;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

import org.apache.log4j.PropertyConfigurator;

import com.github.ant2.exceedvote.activity.controller.CriterionSelectionActivity;
import com.github.ant2.exceedvote.activity.controller.WelcomeActivity;
import com.github.ant2.exceedvote.activity.view.CriterionSelectionActivityView;
import com.github.ant2.exceedvote.activity.view.WelcomeActivityView;
import com.github.ant2.exceedvote.controller.MainController;
import com.github.ant2.exceedvote.model.ExceedVoteEvent;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;
import com.github.ant2.exceedvote.model.VoterProfile;
import com.github.ant2.exceedvote.model.process.Context;
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
		MainController mainController = new MainController(context,
				mainView);
		Activity activity1 = new WelcomeActivity(context, new WelcomeActivityView());
		Activity activity = new CriterionSelectionActivity(activity1, context, new CriterionSelectionActivityView());
		mainController.run(activity);

	}

}
