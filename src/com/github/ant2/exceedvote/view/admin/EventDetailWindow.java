package com.github.ant2.exceedvote.view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EventDetailWindow {

	private JFrame frmEventDetail;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventDetailWindow window = new EventDetailWindow();
					window.frmEventDetail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EventDetailWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventDetail = new JFrame();
		frmEventDetail.setTitle("Event Detail");
		frmEventDetail.setBounds(100, 100, 230, 150);
		frmEventDetail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventDetail.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("30dlu"),
				FormFactory.PREF_COLSPEC,
				ColumnSpec.decode("30dlu"),},
			new RowSpec[] {
				FormFactory.PREF_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.PREF_ROWSPEC,}));
		
		JPanel panel_1 = new JPanel();
		frmEventDetail.getContentPane().add(panel_1, "2, 2, fill, fill");
		
		JLabel lblName = new JLabel("Name");
		panel_1.add(lblName);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		frmEventDetail.getContentPane().add(panel, "2, 4, fill, fill");
		
		JButton btnCancel = new JButton("Cancel");
		panel.add(btnCancel);
		
		JButton btnOk = new JButton("Ok");
		panel.add(btnOk);
	}

}
