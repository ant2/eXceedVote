package com.github.ant2.exceedvote.view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ManageVoterWindow {

	private JFrame frmManageVoter;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageVoterWindow window = new ManageVoterWindow();
					window.frmManageVoter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageVoterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageVoter = new JFrame();
		frmManageVoter.setTitle("Manage Voter");
		frmManageVoter.setBounds(100, 100, 275, 210);
		frmManageVoter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageVoter.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("80dlu"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("20dlu"),
				RowSpec.decode("20dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JScrollPane scrollPane = new JScrollPane();
		frmManageVoter.getContentPane().add(scrollPane, "2, 2, 1, 4, fill, fill");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JButton btnAdd = new JButton("Add");
		frmManageVoter.getContentPane().add(btnAdd, "4, 2");
		
		JButton btnEdit = new JButton("Edit");
		frmManageVoter.getContentPane().add(btnEdit, "4, 3");
		
		JButton btnDelete = new JButton("Delete");
		frmManageVoter.getContentPane().add(btnDelete, "4, 4");
		
		JButton btnClose = new JButton("Close");
		frmManageVoter.getContentPane().add(btnClose, "4, 6, 2, 1, right, default");
	}

}
