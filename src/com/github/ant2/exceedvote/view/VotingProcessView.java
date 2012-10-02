package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class VotingProcessView extends JFrame {

	public interface Delegate {
	}

	public VotingProcessView() {
		super("eXceed Vote");
		initComponents();
	}

	private void initComponents() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel mainPanel = new JPanel(new BorderLayout());
		countdownLabel = new JLabel();

		mainPanel.add(countdownLabel, BorderLayout.NORTH);

		new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateRemainingTime();
			}
		}).start();

		add(mainPanel, BorderLayout.CENTER);

	}

	private Delegate delegate;
	private Calendar finishTime;
	private JLabel countdownLabel;

	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	public void setFinishTime(Calendar finishTime) {
		this.finishTime = finishTime;
		updateRemainingTime();
	}

	private void updateRemainingTime() {
		long timeLeft = this.finishTime.getTimeInMillis()
				- Calendar.getInstance().getTimeInMillis();
		countdownLabel.setText(String.format("Remaining time: %d:%02d:%02d",
				timeLeft / (3600 * 1000), (timeLeft % (3600 * 1000))
						/ (60 * 1000), (timeLeft % (60 * 1000)) / 1000));
	}

}
