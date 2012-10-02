package com.github.ant2.exceedvote.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BallotView extends JDialog {

	public interface Delegate {
		void submitted();
	}

	/** */
	private static final long serialVersionUID = 1L;

	private Delegate delegate;
	private RadioSelectView projectSelectView;
	private RadioSelectView criterionSelectView;

	public BallotView(Frame parent) {
		super(parent, true);
		setTitle("Vote for Project");
		initComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	private void initComponents() {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JPanel projectsPanel = new JPanel();
		JPanel criteriaPanel = new JPanel();

		projectsPanel.setBorder(BorderFactory
				.createTitledBorder(" Select Project "));
		criteriaPanel.setBorder(BorderFactory
				.createTitledBorder(" Pick a Criterion "));

		projectSelectView = new RadioSelectView();
		criterionSelectView = new RadioSelectView();
		projectsPanel.add(projectSelectView);
		criteriaPanel.add(criterionSelectView);
		
		JButton submitButton = new JButton(new AbstractAction("Submit") {
			/** */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(BallotView.this,
						"Are you sure?", "eXceed Vote Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					delegate.submitted();
				}
			}
		});

		add(projectsPanel);
		add(criteriaPanel);
		add(submitButton);

	}

	@SuppressWarnings("rawtypes")
	public void addProjectOptions(Iterable projectOptions) {
		projectSelectView.addOptions(projectOptions);
	}
	
	@SuppressWarnings("rawtypes")
	public void addCriterionOptions(Iterable criterionOptions) {
		criterionSelectView.addOptions(criterionOptions);
	}
	
}
