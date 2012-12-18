package com.github.ant2.exceedvote.activity.view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.github.ant2.exceedvote.util.UIUtility;

/**
 * A view that represents a single voting component, with [+] and [-] button.
 *
 * @author dtinth
 */
public class ProjectVoteView extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;

	private JLabel countLabel;
	private JButton addButton;
	private JButton subtractButton;
	private JLabel nameLabel;

	/**
	 * Constructs a new ProjectVoteView.
	 */
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

	/**
	 * Sets the text on the count label.
	 * @param text the text to set
	 */
	public void setCountLabelText(String text) {
		countLabel.setText(text);
	}

	/**
	 * Sets the text on the name label.
	 * @param text the text to set
	 */
	public void setNameLabelText(String text) {
		nameLabel.setText(text);
	}

	/**
	 * Returns the add button.
	 * @return the add button
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * Returns the subtract button.
	 * @return the subtract button
	 */
	public JButton getSubtractButton() {
		return subtractButton;
	}

}
