package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;

public class VotingProcessView extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;

	public interface Delegate {

		void voteButtonClicked();
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
		countdownLabel.setHorizontalAlignment(CENTER);
		countdownLabel.setFont(new Font("Arial", Font.BOLD, 18));
		countdownLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

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
			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				delegate.voteButtonClicked();
			}
		});
		
		voteButton.setFont(new Font("Arial", Font.BOLD, 50));
		voteButton.setDefaultCapable(true);

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
		long timeLeft = finishTime.getTimeInMillis()
				- Calendar.getInstance().getTimeInMillis();
		countdownLabel.setText(String.format("Remaining time: %d:%02d:%02d",
				timeLeft / (3600 * 1000), (timeLeft % (3600 * 1000))
						/ (60 * 1000), (timeLeft % (60 * 1000)) / 1000));
	}

	public void setTeamListModel(ListModel model) {
		teamList.setModel(model);
	}

}
