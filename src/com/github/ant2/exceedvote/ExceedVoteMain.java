package com.github.ant2.exceedvote;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

import org.apache.log4j.PropertyConfigurator;

import com.github.ant2.exceedvote.activity.controller.WelcomeActivity;
import com.github.ant2.exceedvote.activity.view.WelcomeActivityView;
import com.github.ant2.exceedvote.controller.MainController;
import com.github.ant2.exceedvote.model.ExceedVoteEvent;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;
import com.github.ant2.exceedvote.model.VoterProfile;
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
		try {
			UIManager.put("nimbusBase", new Color(0xdddddd));
			UIManager.put("nimbusBlueGrey", new Color(0xb5b3b1));
			UIManager.put("control", new Color(0xe5e4e3));
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			try {
				UIManager
						.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
			} catch (Exception ee) {
				// can't set look and feel
			}
		}
		PropertyConfigurator.configure(ExceedVoteMain.class
				.getResourceAsStream("log4j.properties"));

		Voter voter = new Voter(new VoterProfile("マーリーさん", "5410000000"));
		VoteEvent event = new ExceedVoteEvent();
		MainView mainView = new MainView();
		MainController mainController = new MainController(voter, event,
				mainView);
		Activity activity = new WelcomeActivity(new WelcomeActivityView());
		mainController.run(activity);

	}

}
