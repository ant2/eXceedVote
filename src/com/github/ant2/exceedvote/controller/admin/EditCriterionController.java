package com.github.ant2.exceedvote.controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.ant2.exceedvote.model.process.admin.EditCriterionProcess;
import com.github.ant2.exceedvote.view.admin.EditCriteriaWindow;

public class EditCriterionController {

	private EditCriterionProcess process;
	private EditCriteriaWindow window;

	public EditCriterionController(EditCriterionProcess process,
			EditCriteriaWindow window) {
		this.process = process;
		this.window = window;

		window.getSaveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});

		window.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				delete();
			}
		});

		window.getNameField().setText(process.getName());
	}

	private void save() {
		process.setName(window.getNameField().getText());
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
	}

}
