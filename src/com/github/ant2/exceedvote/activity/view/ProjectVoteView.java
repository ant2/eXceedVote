package com.github.ant2.exceedvote.activity.view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.github.ant2.exceedvote.util.UIUtility;

public class ProjectVoteView extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;
	
	private JLabel countLabel;
	private JButton addButton;
	private JButton subtractButton;
	private JLabel nameLabel;

	public ProjectVoteView() {
		super(new BorderLayout());
		nameLabel = new JLabel();
		add(nameLabel, BorderLayout.CENTER);
		JPanel votePanel = new JPanel(new BorderLayout());
		countLabel = new JLabel("?");
		UIUtility.addPadding(countLabel, 0, 7, 0, 7);
		votePanel.add(countLabel, BorderLayout.CENTER);
		addButton = new JButton("+");
		subtractButton = new JButton("-");
		votePanel.add(addButton, BorderLayout.EAST);
		votePanel.add(subtractButton, BorderLayout.WEST);
		add(votePanel, BorderLayout.EAST);
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
				BorderFactory.createEmptyBorder(7, 7, 7, 7)));
	}
	
	public void setCountLabelText(String text) {
		countLabel.setText(text);
	}
	
	public void setNameLabelText(String text) {
		nameLabel.setText(text);
	}
	
	public JButton getAddButton() {
		return addButton;
	}
	
	public JButton getSubtractButton() {
		return subtractButton;
	}

}
