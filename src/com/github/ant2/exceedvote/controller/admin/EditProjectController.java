package com.github.ant2.exceedvote.controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.ant2.exceedvote.model.process.admin.EditProjectProcess;
import com.github.ant2.exceedvote.view.admin.EditProjectWindow;

/**
 * A controller for EditProjectProcess
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class EditProjectController {
	private EditProjectProcess process;
	private EditProjectWindow window;

	/**
	 * @param subprocess subprocess to control
	 * @param window window to control
	 */
	public EditProjectController(EditProjectProcess subprocess,
			EditProjectWindow window) {
		process = subprocess;
		this.window = window;
		addListener();
	}

	private void addListener() {
		window.getSaveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		window.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});

		window.getProjectNameTextField().setText(process.getName());
	}

	private void save() {
		process.setName(window.getProjectNameTextField().getText());
		if (process.save()) {
			window.dispose();
		}
	}

	private void delete() {
		if (process.delete()) {
			window.dispose();
		}
	}

	/**
	 * Runs the controller: display the window.
	 */
	public void run() {
		window.setVisible(true);
		window.pack();
	}

}
