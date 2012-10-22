package com.github.ant2.exceedvote.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * The JPanel contains group of RadioButton showing the available project or
 * criteria.
 * 
 * @author dtinth
 */
public class RadioSelectionPanel extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;
	private ButtonGroup group = new ButtonGroup();
	private List<ButtonModel> buttonModels = new ArrayList<ButtonModel>();

	/**
	 * Construct a RadioSelectionPanel using BoxLayout set to Y-axis alignment.
	 */
	public RadioSelectionPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	/**
	 * Create an individual RadioButton with the specific label and add it to
	 * this Panel.
	 * 
	 * @param text
	 *            the label of the RadioButton
	 */
	public void addOption(String text) {
		JRadioButton radioButton = new JRadioButton(text);
		buttonModels.add(radioButton.getModel());
		group.add(radioButton);
		this.add(radioButton);
	}

	/**
	 * Return the index of current selected option.
	 * 
	 * @return index of current selected option
	 */
	public int getSelectedIndex() {
		return buttonModels.indexOf(group.getSelection());
	}

	public void setSelectedIndex(int index) {
		if (index >= 0) {
			group.setSelected(buttonModels.get(index), true);
		} else {
			group.clearSelection();
		}
	}

}
