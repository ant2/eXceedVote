package com.github.ant2.exceedvote;

import java.util.ArrayList;
import java.util.List;

/**
 * A BallotBox that keeps a list of ballots.
 * 
 * @author Nutnicha Charoenporn
 */
public class BallotBox {

	/** A list of ballots */
	private List<Ballot> list;

	/**
	 * Constructs a list of ballots.
	 */
	public BallotBox() {
		list = new ArrayList<Ballot>();
	}

	/**
	 * Adds ballot into the list.
	 * 
	 * @param ballot that added
	 */
	public void add(Ballot ballot) {
		list.add(ballot);
	}

	/**
	 * Gets the list of ballots.
	 * 
	 * @return list of ballots
	 */
	public List<Ballot> getVoterBallots() {
		return list;
	}

	/**
	 * Counts ballots in the list.
	 * 
	 * @return number of ballots in the list
	 */
	public int countBallot() {
		return list.size();
	}
}
