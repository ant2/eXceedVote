package com.github.ant2.exceedvote.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.github.ant2.exceedvote.model.Ballot;
import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.view.ChangeBallotView;

public class ChangeBallotController implements ChangeBallotView.Delegate {
	private VotingProcess model;
	private ChangeBallotView view;
	
	private List<Ballot> ballots;

	public ChangeBallotController(VotingProcess model,
			ChangeBallotView changeBallotView) {
		this.model = model;
		view = changeBallotView;
		view.setDelegate(this);
		
		ballots = model.getBallots();
		view.getTable().setModel(new BallotTableModel());
	}

	@Override
	public void changeButtonClicked() {
		System.out.println("Change ballot button is clicked");
	}

	public void show() {
		view.setVisible(true);
	}
	
	public class BallotTableModel extends AbstractTableModel implements
			TableModel {
		
		private final String[] columnNames = {
			"Voted At", "Project", "Criterion"
		};

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public int getRowCount() {
			return ballots.size();
		}

		@Override
		public Object getValueAt(int row, int column) {
			switch (column) {
			case 0:
				return String.format("%tT", ballots.get(row).getVotedAt());
			case 1:
				return ballots.get(row).getProject();
			case 2:
				return ballots.get(row).getCriterion();
			default:
				return "Unknown column " + column;
			}
		}

		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}

	}

}
