package com.github.ant2.exceedvote;

import org.apache.log4j.PropertyConfigurator;

import com.github.ant2.exceedvote.model.ExceedVoteEvent;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;
import com.github.ant2.exceedvote.model.VoterProfile;

/**
 * eXceed Vote Main Class
 * 
 * @author dtinth
 */
public class ExceedVoteMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure(ExceedVoteMain.class
				.getResourceAsStream("log4j.properties"));

		Voter voter = new Voter(new VoterProfile("マーリーさん", "5410000000"));
		VoteEvent event = new ExceedVoteEvent();

		for (;;) {
			System.out.println("UNDER CONSTRUCTION :3");
		}

	}

}
