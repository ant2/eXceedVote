package com.github.ant2.exceedvote.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioSelectionPanel extends JPanel {

	private ButtonGroup group = new ButtonGroup();
	private List<ButtonModel> buttonModels = new ArrayList<ButtonModel>();

	public RadioSelectionPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public void addOption(String text) {
		JRadioButton radioButton = new JRadioButton(text);
		buttonModels.add(radioButton.getModel());
		group.add(radioButton);
		this.add(radioButton);
	}
	
	public int getSelectedIndex() {
		return buttonModels.indexOf(group.getSelection());
	}

}
