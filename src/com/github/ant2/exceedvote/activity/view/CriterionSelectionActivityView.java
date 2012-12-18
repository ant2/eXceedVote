package com.github.ant2.exceedvote.activity.view;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.exceedvote.view.CriterionListCellRenderer;
import com.github.ant2.exceedvote.view.Scene;
import com.github.ant2.ui.activity.ActivityView;

/**
 * An activity view for Criterion Selection Activity.
 *
 * @author dttvb
 */
public class CriterionSelectionActivityView extends ActivityView {

	/** */
	private static final long serialVersionUID = 1L;
	private JButton backButton;
	private JButton continueButton;
	private JList list;

	/**
	 * Constructs a new CriterionSelectionActivityView.
	 */
	public CriterionSelectionActivityView() {
		list = new JList();
		list.setCellRenderer(new CriterionListCellRenderer());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel panel = UIUtility.createStepPanel("Please select a criterion",
				list);
		Scene scene = new Scene("Vote / Change Vote", panel);
		backButton = scene.addFooterButton("Back to Main Menu");
		continueButton = scene.addFooterButton("Continue >>");
		add(scene);
	}

	/**
	 * Returns the Back button.
	 * @return the back button
	 */
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * Returns the Continue button.
	 * @return the continue button
	 */
	public JButton getContinueButton() {
		return continueButton;
	}

	/**
	 * Returns the Criterion List view.
	 * @return the criterion list view
	 */
	public JList getList() {
		return list;
	}

}
