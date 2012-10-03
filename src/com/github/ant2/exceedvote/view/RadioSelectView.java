package com.github.ant2.exceedvote.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioSelectView extends JPanel {

	public interface Delegate {
		void optionSelected(Object option);
	}

	public class RadioSelectAction extends AbstractAction {

		private Object item;

		public RadioSelectAction(Object item) {
			super(item + "");
			this.item = item;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			delegate.optionSelected(item);
		}

	}

	private ButtonGroup group = new ButtonGroup();
	private Delegate delegate;
	private HashMap<Object, ButtonModel> buttonModelMap = new HashMap<Object, ButtonModel>();

	public RadioSelectView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	@SuppressWarnings("rawtypes")
	public void addOptions(Iterable options) {
		for (Object option : options) {
			JRadioButton radio = new JRadioButton(new RadioSelectAction(option));
			group.add(radio);
			add(radio);
			buttonModelMap.put(option, radio.getModel());
		}
	}

	public void selectOption(Object item) {
		ButtonModel model = buttonModelMap.get(item);
		if (model == null) {
			group.clearSelection();
		} else {
			group.setSelected(model, true);
		}
	}
}
