package com.github.ant2.exceedvote;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

import org.apache.log4j.PropertyConfigurator;

import com.github.ant2.exceedvote.model.ExceedVoteEvent;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;
import com.github.ant2.exceedvote.model.VoterProfile;
import com.github.ant2.exceedvote.view.BigButton;
import com.github.ant2.exceedvote.view.MainPanel;
import com.github.ant2.exceedvote.view.MainView;
import com.github.ant2.exceedvote.view.animation.SlideAnimation;

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
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
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
		mainView.setVisible(true);

		mainPanel = mainView.getMainPanel();
		showA();
	}

	public static void showA() {
		Object[][] data = new Object[][] { { 1, 2, 3 }, { 4, 5, 6 },
				{ 4, 5, 6 }, { 4, 5, 6 }, { 4, 5, 6 }, { 4, 5, 6 },
				{ 4, 5, 6 }, { 4, 5, 6 }, { 4, 5, 6 }, { 4, 5, 6 },
				{ 4, 5, 6 }, { 1, 2, 3 }, { 4, 5, 6 }, { 4, 5, 6 },
				{ 4, 5, 6 }, { 4, 5, 6 }, { 4, 5, 6 }, { 4, 5, 6 },
				{ 4, 5, 6 }, { 4, 5, 6 }, { 4, 5, 6 }, { 4, 5, 6 } };
		JPanel panel = new JPanel(new BorderLayout());
		JTable table = new JTable(data, new Object[] { "A", "B", "C" });
		panel.add(new JScrollPane(table), BorderLayout.CENTER);
		panel.add(new BigButton(new AbstractAction("GO TO PAGE B") {
			@Override
			public void actionPerformed(ActionEvent e) {
				showB();
			}
		}), BorderLayout.NORTH);
		mainPanel.display(panel, new SlideAnimation(
				SlideAnimation.Direction.LEFT));
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
