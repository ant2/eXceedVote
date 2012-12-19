package com.github.ant2.exceedvote.view.admin;


import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

/**
 * Manage voter UI.
 *
 * @author Artima Mahahemarat
 */
public class ManageVoterWindow {

	private JFrame frmManageVoter;
	private JTable table;
	private JButton btnClose;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnAdd;

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
		
		btnAdd = new JButton("Add");
		frmManageVoter.getContentPane().add(btnAdd, "4, 2");
		
		btnEdit = new JButton("Edit");
		frmManageVoter.getContentPane().add(btnEdit, "4, 3");
		
		btnDelete = new JButton("Delete");
		frmManageVoter.getContentPane().add(btnDelete, "4, 4");
		
		btnClose = new JButton("Close");
		frmManageVoter.getContentPane().add(btnClose, "4, 6, 2, 1, right, default");
	}
	
	public void setVisible(boolean visible) {
		frmManageVoter.setVisible(visible);
	}

	public JButton getCloseButton() {
		return btnClose;
	}
	
	public JButton getAddButton() {
		return btnAdd;
	}
	
	public JButton getEditButton() {
		return btnEdit;
	}
	
	public JButton getDeleteButton() {
		return btnDelete;
	}

	public void dispose() {
		frmManageVoter.dispose();
	}
	
	public JTable getTable() {
		return table;
	}

}
