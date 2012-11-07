package com.github.ant2.exceedvote.activity.view;

import java.awt.ComponentOrientation;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.github.ant2.exceedvote.util.UIUtility;
import com.github.ant2.exceedvote.view.ProjectButton;
import com.github.ant2.exceedvote.view.Scene;
import com.github.ant2.ui.activity.ActivityView;
import com.github.ant2.ui.view.HintView;

public class ProjectSelectionActivityView extends ActivityView {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel grid;
	private JButton backButton;

	public ProjectSelectionActivityView(String title) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.add(new HintView(">", "Please select a project..."),
				UIUtility.createVerticalGridBagConstrints());
		grid = new JPanel(new GridLayout(0, 3));
		grid.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		UIUtility.addPadding(grid, UIUtility.SMALL_PADDING);
		UIUtility.addPadding(panel, UIUtility.SMALL_PADDING);
		panel.add(grid, UIUtility.createVerticalGridBagConstrints());
		Scene scene = new Scene(title, panel);
		add(scene);
		backButton = scene.addFooterButton("Go Back");
	}

	public ProjectButton addButton(String name) {
		ProjectButton button = new ProjectButton(name);
		grid.add(button);
		return button;
	}

	public JButton getBackButton() {
		return backButton;
	}

}
