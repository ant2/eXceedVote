package com.github.ant2.exceedvote.controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.ant2.exceedvote.model.process.admin.EditProjectProcess;
import com.github.ant2.exceedvote.view.admin.EditProjectWindow;

/**
 * 
 *
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class EditProjectController {
	private EditProjectProcess process;
	private EditProjectWindow window;

	public EditProjectController(EditProjectProcess subprocess,
			EditProjectWindow window) {
		this.process = subprocess;
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
	
	public void run() {
		window.setVisible(true);
		window.pack();
	}

}
