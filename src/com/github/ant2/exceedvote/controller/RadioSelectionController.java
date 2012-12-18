package com.github.ant2.exceedvote.controller;

import java.util.List;

import com.github.ant2.ui.view.RadioSelectionPanel;

/**
 * Controller for the RadioSelectionPanel.
 * 
 * @param <T>
 *            the type of data displaying on the RadioSelectionPanel that's
 *            being controlled by this controller.
 * @author dtinth
 */
public class RadioSelectionController<T> {

	private List<T> list;
	private RadioSelectionPanel view;

	/**
	 * Construct a RadioSelectionController with the specific type of option.
	 * 
	 * @param view
	 *            the RadioSelectionPanel that's being controlled by this
	 *            controller
	 * @param list
	 *            options to be displayed on panel that's being controlled by
	 *            this controller
	 */
	public RadioSelectionController(RadioSelectionPanel view, List<T> list) {
		this.list = list;
		this.view = view;
		for (T item : list) {
			view.addOption(item.toString());
		}
	}

	/**
	 * Return the current selected element.
	 * 
	 * @return current selected element
	 */
	public T getSelected() {
		int selectedIndex = view.getSelectedIndex();
		if (selectedIndex == -1) return null;
		return list.get(selectedIndex);
	}

	/**
	 * Selects the item specified by item.
	 * 
	 * @param item
	 *            the item to select
	 */
	public void setSelection(T item) {
		view.setSelectedIndex(list.indexOf(item));
	}

}
