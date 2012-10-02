package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.TableModel;

public class VotingProcessView extends JFrame {

	public interface Delegate {
	}

	private Delegate delegate;
	private Calendar finishTime;
	private JLabel countdownLabel;
	private JList teamList;
	
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
		
		teamList = new JList();
		teamList.setCellRenderer(new ProjectCellItemRenderer());
		
		JScrollPane scrollPane = new JScrollPane(teamList);
		scrollPane.setPreferredSize(new Dimension(300, 400));
		
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		
		JButton voteButton = new JButton(new AbstractAction("Vote!") {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("vote button clicked");
			}
		});
		
		mainPanel.add(voteButton, BorderLayout.SOUTH);

		add(mainPanel, BorderLayout.CENTER);

	}

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

	public void setTeamListModel(ListModel model) {
		teamList.setModel(model);
	}
	
}
