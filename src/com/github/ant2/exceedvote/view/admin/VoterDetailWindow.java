package com.github.ant2.exceedvote.view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VoterDetailWindow {

	private JFrame frmVoterDetail;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoterDetailWindow window = new VoterDetailWindow();
					window.frmVoterDetail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VoterDetailWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVoterDetail = new JFrame();
		frmVoterDetail.setTitle("Voter Detail");
		frmVoterDetail.setBounds(100, 100, 220, 215);
		frmVoterDetail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoterDetail.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("20dlu"),
				FormFactory.PREF_COLSPEC,
				ColumnSpec.decode("20dlu"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JPanel panel = new JPanel();
		frmVoterDetail.getContentPane().add(panel, "2, 2, fill, fill");
		
		JLabel lblName = new JLabel("Name");
		panel.add(lblName);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frmVoterDetail.getContentPane().add(panel_1, "2, 4, fill, fill");
		
		JLabel lblUsername = new JLabel("Username");
		panel_1.add(lblUsername);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		frmVoterDetail.getContentPane().add(panel_2, "2, 6, fill, fill");
		
		JLabel lblPassword = new JLabel("Password");
		panel_2.add(lblPassword);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		frmVoterDetail.getContentPane().add(btnSave, "2, 8, right, default");
	}

}
