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
	 * Constructs the BallotBox. Initializes the list of ballots.
	 */
	public BallotBox() {
		list = new ArrayList<Ballot>();
	}

	/**
	 * Adds a ballot into this list.
	 * 
	 * @param ballot
	 *            the ballot to be added
	 */
	public void add(Ballot ballot) {
		list.add(ballot);
	}

	/**
	 * Gets the list of ballots.
	 * @param v 
	 * 
	 * @return list of ballots
	 */
	public List<Ballot> getVoterBallots(Voter v) {
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
