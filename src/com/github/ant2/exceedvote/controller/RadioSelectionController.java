package com.github.ant2.exceedvote.controller;

import java.util.List;

import com.github.ant2.exceedvote.model.Project;
import com.github.ant2.exceedvote.view.RadioSelectionPanel;

public class RadioSelectionController<T> {

	private List<T> list;
	private RadioSelectionPanel view;

	public RadioSelectionController(RadioSelectionPanel view, List<T> list) {
		this.list = list;
		this.view = view;
		for (T item : list) {
			view.addOption(item.toString());
		}
	}

	public T getSelected() {
		int selectedIndex = view.getSelectedIndex();
		if (selectedIndex == -1) return null;
		return list.get(selectedIndex);
	}

}
