package com.github.ant2.exceedvote.activity.view;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.exceedvote.view.CriterionListCellRenderer;
import com.github.ant2.exceedvote.view.Scene;
import com.github.ant2.ui.activity.ActivityView;

public class CriterionSelectionActivityView extends ActivityView {

	private JButton backButton;
	private JButton continueButton;

	public CriterionSelectionActivityView() {
		JList list = new JList(new String[]{"a", "b", "c", "d", "helllo world"});
		list.setCellRenderer(new CriterionListCellRenderer());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel panel = UIUtility.createStepPanel("Please select a criterion", list);
		Scene scene = new Scene("Vote / Change Vote", panel);
		backButton = scene.addFooterButton("Back to Main Menu");
		continueButton = scene.addFooterButton("Continue >>");
		add(scene);
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public JButton getContinueButton() {
		return continueButton;
	}

}
