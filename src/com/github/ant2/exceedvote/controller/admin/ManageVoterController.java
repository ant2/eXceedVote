package com.github.ant2.exceedvote.controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.github.ant2.exceedvote.model.domain.Voter;
import com.github.ant2.exceedvote.model.process.admin.ManageVoterProcess;
import com.github.ant2.exceedvote.view.admin.ManageVoterWindow;

public class ManageVoterController {

	private ManageVoterWindow window;
	private ManageVoterProcess process;
	private List<Voter> voters = new ArrayList<Voter>();
	private VoterTableModel tableModel;
	private JTable table;

	public ManageVoterController(ManageVoterProcess process,
			ManageVoterWindow window) {
		
		this.process = process;
		this.window = window;
		
		this.window.getCloseButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		this.window.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteSelected();
			}
		});
		
		tableModel = new VoterTableModel();
		table = this.window.getTable();
		table.setModel(tableModel);
		reload();
		
	}

	private void update() {
		tableModel.fireTableDataChanged();
	}

	public void run() {
		window.setVisible(true);
	}
	
	private void close() {
		window.dispose();
	}
	
	private Voter getSelected() {
		return voters.get(table.getSelectedRow());
	}
	
	private void deleteSelected() {
		process.removeVoter(getSelected());
		reload();
	}
	
	private void reload() {
		voters = process.getAllVoters();
		update();
	}

	public class VoterTableModel extends AbstractTableModel {

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public int getRowCount() {
			return voters.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Voter voter = voters.get(rowIndex);
			if (columnIndex == 0) return voter.getName();
			if (columnIndex == 1) return voter.getUser().getUsername();
			return "";
		}
		
		@Override
		public String getColumnName(int column) {
			if (column == 0) return "Name";
			if (column == 1) return "Username";
			return "";
		}
		
	}

}
