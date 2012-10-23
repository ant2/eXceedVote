package com.github.ant2.exceedvote.controller;

import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.github.ant2.exceedvote.model.Ballot;
import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.view.ChangeBallotView;

public class ChangeBallotController implements ChangeBallotView.Delegate {
	
	/**
	 * Controller delegate for ChangeBallotController.
	 *
	 * @author dtinth
	 */
	public interface Delegate {
		/**
		 * Invoked when the ballot has been selected for changing.
		 * 
		 * @param ballot
		 */
		void ballotSelected(Ballot ballot);
	}
	
	private VotingProcess model;
	private ChangeBallotView view;
	
	private List<Ballot> ballots;
	private Delegate delegate;
	
	public ChangeBallotController(VotingProcess model,
			ChangeBallotView changeBallotView) {
		this.model = model;
		view = changeBallotView;
		view.setDelegate(this);
		
		ballots = model.getBallots();
		view.getTable().setModel(new BallotTableModel());
		view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				updateButton();
			}
		});
		
		updateButton();
	}
	
	public void updateButton() {
		view.getSubmitButton().setEnabled(view.getTable().getSelectedRow() >= 0);
	}
	
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	@Override
	public void changeButtonClicked() {
		view.setVisible(false);
		delegate.ballotSelected(ballots.get(view.getTable().getSelectedRow()));
		view.dispose();
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
