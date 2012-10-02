package com.github.ant2.exceedvote.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioSelectView extends JPanel {

	public class RadioSelectAction extends AbstractAction {

		public RadioSelectAction(Object item) {
			super(item + "");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}

	}

	private ButtonGroup group = new ButtonGroup();

	public RadioSelectView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	@SuppressWarnings("rawtypes")
	public void addOptions(Iterable options) {
		for (Object option : options) {
			JRadioButton radio = new JRadioButton(new RadioSelectAction(option));
			group.add(radio);
			add(radio);
		}
	}

}
