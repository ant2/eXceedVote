package com.github.ant2.exceedvote.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.exceedvote.view.CriterionListCellRenderer;

/**
 * Select event UI.
 * 
 * @author Nutnicha Charoenporn
 */

public class SelectEventWindow extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list;
	private JButton newEventButton;
	private JButton okButton;

	/**
	 * Create the frame.
	 */
	public SelectEventWindow() {
		setTitle("Select Event");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list = new JList();
		initComponent();
	}

	private void initComponent() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		list.setValueIsAdjusting(true);
		list.setPreferredSize(new Dimension(400, 300));

		list.setSelectedIndex(0);
		list.setBackground(Color.WHITE);
		list.setCellRenderer(new CriterionListCellRenderer());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JPanel eventListPanal = UIUtility.createStepPanel(
				"Please select an event", list);
		contentPane.add(eventListPanal, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		panel.add(okButton);

		newEventButton = new JButton("New Event");
		panel.add(newEventButton);

	}

	/**
	 * Returns the event list of the event.
	 * 
	 * @return the list of the event
	 */
	public JList getEventList() {
		return list;
	}

	/**
	 * Returns the new event button.
	 * 
	 * @return the new event button
	 */
	public JButton getNewEventButton() {
		return newEventButton;
	}

	/**
	 * Returns the OK button.
	 * 
	 * @return the OK button
	 */
	public JButton getOkButton() {
		return okButton;
	}

	/**
	 * Returns the index of the selected event.
	 * 
	 * @return index of the selected event
	 */
	public int getSelectedEvent() {
		return list.getSelectedIndex();
	}
}
