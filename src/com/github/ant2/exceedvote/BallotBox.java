package com.github.ant2.exceedvote;

import java.util.ArrayList;
import java.util.List;

public class BallotBox {
	
	private List<Ballot> list;
	
	public BallotBox(){
		list = new ArrayList<Ballot>();
	}

	public void add(Ballot ballot){
		list.add(ballot);
	}
	
	public List<Ballot> getVoterBallots(){
		return list;
	}
	
	public int countBallot(){
		return list.size();
	}
}
