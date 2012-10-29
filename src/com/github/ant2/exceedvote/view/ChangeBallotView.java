package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.github.ant2.exceedvote.util.UIUtility;

public class ChangeBallotView extends JDialog {
	/** */
	private static final long serialVersionUID = 1L;
	private Delegate delegate;
	private JTable table;
	private BigButton submitButton;

	public interface Delegate {
		void changeButtonClicked();
	}

	public ChangeBallotView(Frame parent) {
		super(parent, true);
		setTitle("Change Ballot");
		initComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initComponents() {

		initShowBallotTable();
		initButtonArea();

		pack();
	}

	private void initShowBallotTable() {

		// Ballot display panel
		JPanel ballotDisplay = new JPanel(new BorderLayout());
		UIUtility.addPadding(ballotDisplay, UIUtility.SMALL_PADDING);

		// Create first hint
		HintView selectBallot = new HintView("1",
				"Select a ballot that you wish to change");
		ballotDisplay.add(selectBallot, BorderLayout.NORTH);

		table = new JTable();
		table.setFont(new Font("Verdana", Font.BOLD, 20));
		table.setRowHeight(30);

		JScrollPane tablePane = new JScrollPane(table);
		tablePane.setPreferredSize(new Dimension(640, 200));
		ballotDisplay.add(tablePane);

		// ADD
		add(ballotDisplay, BorderLayout.CENTER);

	}

	private void initButtonArea() {
		// Bottom area
		JPanel bottomPanel = new JPanel(new BorderLayout());
		UIUtility.addPadding(bottomPanel, UIUtility.SMALL_PADDING);

		// Click to change Ballot
		HintView clickToChange = new HintView("2", "Click change ballot");
		bottomPanel.add(clickToChange, BorderLayout.NORTH);

		submitButton = new BigButton(new AbstractAction("Change Ballot") {
			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				delegate.changeButtonClicked();
			}
		});
		bottomPanel.add(submitButton, BorderLayout.SOUTH);

		// ADD
		add(bottomPanel, BorderLayout.SOUTH);
	}

	public BigButton getSubmitButton() {
		return submitButton;
	}

	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	public JTable getTable() {
		return table;
	}
}
