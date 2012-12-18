package com.github.ant2.exceedvote.view.admin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Manage event UI.
 *
 * @author Artima Mahahemarat
 */
public class ManageEventWindow extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JList projectList;
	private JList criteriaList;
	private JButton addProjectButton;
	private JButton editProjectButton;
	private JButton addCriteriaButton;
	private JButton editCriteriaButton;
	private JButton manageVoterButton;
	private JButton viewResultButton;
	private JButton logoutButton;

	/**
	 * Create the frame.
	 */
	public ManageEventWindow() {
		setTitle("Event Manager");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}

	private void initComponent() {
		getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] { FormFactory.PREF_COLSPEC,
						ColumnSpec.decode("max(100dlu;pref)"),
						ColumnSpec.decode("max(20dlu;pref)"),
						ColumnSpec.decode("max(100dlu;pref)"),
						FormFactory.PREF_COLSPEC, }, new RowSpec[] {
						FormFactory.PREF_ROWSPEC, FormFactory.PREF_ROWSPEC,
						RowSpec.decode("max(30dlu;pref)"),
						RowSpec.decode("max(40dlu;pref)"),
						FormFactory.PREF_ROWSPEC, }));

		JLabel lblProjects = new JLabel("Projects");
		getContentPane().add(lblProjects, "2, 2");

		JLabel lblCriteria = new JLabel("Criteria");
		getContentPane().add(lblCriteria, "4, 2");

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "2, 3, fill, fill");

		projectList = new JList();
		scrollPane.setViewportView(projectList);

		JScrollPane scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1, "4, 3, fill, fill");

		criteriaList = new JList();
		scrollPane_1.setViewportView(criteriaList);

		JPanel projectButtonPanal = new JPanel();
		getContentPane().add(projectButtonPanal, "2, 4, fill, top");

		addProjectButton = new JButton("Add");
		projectButtonPanal.add(addProjectButton);

		editProjectButton = new JButton("Edit");
		projectButtonPanal.add(editProjectButton);

		JPanel criteriaButtonPanal = new JPanel();
		getContentPane().add(criteriaButtonPanal, "4, 4, fill, top");

		addCriteriaButton = new JButton("Add");
		criteriaButtonPanal.add(addCriteriaButton);

		editCriteriaButton = new JButton("Edit");
		criteriaButtonPanal.add(editCriteriaButton);

		JPanel manageButtonPanal = new JPanel();
		getContentPane().add(manageButtonPanal, "2, 5, 2, 1, center, center");

		manageVoterButton = new JButton("Manage Voter");
		manageButtonPanal.add(manageVoterButton);

		viewResultButton = new JButton("View Result");
		manageButtonPanal.add(viewResultButton);

		logoutButton = new JButton("Log Out");
		getContentPane().add(logoutButton, "4, 5, right, center");
	}

	/**
	 * Return project list.
	 * 
	 * @return projectList
	 */
	public JList getProjectList() {
		return projectList;
	}

	/**
	 * Return criteria list.
	 * 
	 * @return criteriaList
	 */
	public JList getCriterionList() {
		return criteriaList;
	} 

	/**
	 * Return add project button. 
	 * 
	 * @return addProjectButton
	 */
	public JButton getAddProjectButton() {
		return addProjectButton;
	}

	/**
	 * Return edit project button.
	 * 
	 * @return editProjectButton
	 */
	public JButton getEditProjectButton() {
		return editProjectButton;
	}

	/**
	 * Return add criteria button.
	 * 
	 * @return addCriteriaButton
	 */
	public JButton getAddCriterionButton() {
		return addCriteriaButton;
	}

	/**
	 * Return edit criteria button.
	 * 
	 * @return editCriteriaButton
	 */
	public JButton getEditCriterionButton() {
		return editCriteriaButton;
	}

	/**
	 * Return manage voter button.
	 * 
	 * @return manageVoterButton
	 */
	public JButton getManageVoterButton() {
		return manageVoterButton;
	}

	/**
	 * Return view result button.
	 * 
	 * @return viewResultButton
	 */
	public JButton getViewResultButton() {
		return viewResultButton;
	}

	/**
	 * Return logout button.
	 * 
	 * @return logoutButton
	 */
	public JButton getLogoutButton() {
		return logoutButton;
	}
}
