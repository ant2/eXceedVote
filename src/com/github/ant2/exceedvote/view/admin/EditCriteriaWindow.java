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
 * Editing criteria UI.
 * 
 * @author Nutnicha Charoenporn
 */

public class EditCriteriaWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCriteriaName;
	private JPanel panel;
	private JButton btnDelete;
	private JButton btnSave;

	/**
	 * Create the frame.
	 */
	public EditCriteriaWindow() {
		setTitle("Edit Criteria");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		initComponent();
	}

	private void initComponent() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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

		JLabel lblCriteriaName = new JLabel("Criteria Name : ");
		lblCriteriaName.setBackground(Color.WHITE);
		lblCriteriaName.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblCriteriaName, "6, 8, right, default");

		txtCriteriaName = new JTextField();
		txtCriteriaName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCriteriaName.setText("criteria name");
		contentPane.add(txtCriteriaName, "8, 8, fill, default");
		txtCriteriaName.setColumns(10);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, "6, 14, 3, 1, fill, fill");

		btnDelete = new JButton("Delete");
		panel.add(btnDelete);

		btnSave = new JButton("Save");
		panel.add(btnSave);
	}

	/**
	 * Return delete button.
	 * 
	 * @return btnDelete
	 */
	public JButton getDeleteButton() {
		return btnDelete;
	}

	/**
	 * Return save button.
	 * 
	 * @return btnSave
	 */
	public JButton getSaveButton() {
		return btnSave;
	}

	/**
	 * Return name field.
	 * 
	 * @return txtCriteriaName
	 */
	public JTextField getNameField() {
		return txtCriteriaName;
	}
}
