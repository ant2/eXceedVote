package com.github.ant2.exceedvote.view.admin;


import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.Sizes;
import javax.swing.Box;
import javax.swing.JLabel;

public class ManageEventWindow extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageEventWindow frame = new ManageEventWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageEventWindow() {
		setTitle("Event Manage");
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.PREF_COLSPEC,
				ColumnSpec.decode("max(100dlu;pref)"),
				ColumnSpec.decode("max(20dlu;pref)"),
				ColumnSpec.decode("max(100dlu;pref)"),
				FormFactory.PREF_COLSPEC,},
			new RowSpec[] {
				FormFactory.PREF_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
				RowSpec.decode("max(30dlu;pref)"),
				RowSpec.decode("max(40dlu;pref)"),
				FormFactory.PREF_ROWSPEC,}));
		
		JLabel lblProjects = new JLabel("Projects");
		getContentPane().add(lblProjects, "2, 2");
		
		JLabel lblCriteria = new JLabel("Criteria");
		getContentPane().add(lblCriteria, "4, 2");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "2, 3, fill, fill");
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1, "4, 3, fill, fill");
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, "2, 4, fill, top");
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit");
		panel_1.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, "4, 4, fill, top");
		
		JButton btnAdd = new JButton("Add");
		panel_2.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		panel_2.add(btnEdit);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "2, 5, 2, 1, center, center");
		
		JButton btnNewButton = new JButton("Manage Voter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Result");
		panel.add(btnNewButton_1);
		
		JButton btnLogOut = new JButton("Log Out");
		getContentPane().add(btnLogOut, "4, 5, right, center");
		
	}

}
