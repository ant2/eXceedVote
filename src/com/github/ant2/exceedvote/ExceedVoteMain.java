package com.github.ant2.exceedvote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import org.apache.log4j.PropertyConfigurator;

import com.github.ant2.exceedvote.model.ExceedVoteEvent;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;
import com.github.ant2.exceedvote.model.VoterProfile;
import com.github.ant2.exceedvote.view.BigButton;
import com.github.ant2.exceedvote.view.MainPanel;
import com.github.ant2.exceedvote.view.MainView;

/**
 * eXceed Vote Main Class
 * 
 * @author dtinth
 */
public class ExceedVoteMain {

	private static MainPanel mainPanel;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure(ExceedVoteMain.class
				.getResourceAsStream("log4j.properties"));

		Voter voter = new Voter(new VoterProfile("マーリーさん", "5410000000"));
		VoteEvent event = new ExceedVoteEvent();
		
		MainView mainView = new MainView();
		mainView.setVisible(true);
		
		mainPanel = mainView.getMainPanel();
		showA();
	}

	public static void showA() {
		mainPanel.display(new BigButton(new AbstractAction("GO TO PAGE B") {
			@Override
			public void actionPerformed(ActionEvent e) {
				showB();
			}
		}));
	}
	public static void showB() {
		mainPanel.display(new BigButton(new AbstractAction("GO TO PAGE A") {
			@Override
			public void actionPerformed(ActionEvent e) {
				showA();
			}
		}));
	}

}
