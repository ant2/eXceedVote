package com.github.ant2.exceedvote.view.admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Editing projects UI.
 * 
 * @author Nutnicha Charoenporn
 */

public class EditProjectWindow extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblProjectName;
	private JTextField projectNameTextField;
	private JPanel panel;
	private JButton deleteButton;
	private JButton saveButton;

	/**
	 * Create the frame.
	 */
	public EditProjectWindow() {
		setTitle("Edit Project");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		initComponent();
	}

	private void initComponent() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"), }));

		lblProjectName = new JLabel("Project Name : ");
		lblProjectName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProjectName.setBackground(Color.WHITE);
		contentPane.add(lblProjectName, "6, 8, right, default");

		projectNameTextField = new JTextField();
		projectNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		projectNameTextField.setText("project name");
		contentPane.add(projectNameTextField, "8, 8, fill, default");
		projectNameTextField.setColumns(10);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, "6, 14, 3, 1, fill, fill");

		deleteButton = new JButton("Delete");
		panel.add(deleteButton);

		saveButton = new JButton("Save");
		panel.add(saveButton);
	}

	public JTextField getProjectNameTextField() {
		return projectNameTextField;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

}
