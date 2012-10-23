package com.github.ant2.exceedvote;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.github.ant2.exceedvote.controller.VotingProcessController;
import com.github.ant2.exceedvote.model.ExceedVoteEvent;
import com.github.ant2.exceedvote.model.VoteEvent;
import com.github.ant2.exceedvote.model.Voter;
import com.github.ant2.exceedvote.model.VoterProfile;
import com.github.ant2.exceedvote.model.VotingProcess;
import com.github.ant2.exceedvote.view.VotingProcessView;

/**
 * eXceed Vote Main Class
 * 
 * @author dtinth
 */
public class ExceedVoteMain {

	private static Logger logger = Logger.getLogger(ExceedVoteMain.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure(ExceedVoteMain.class
				.getResourceAsStream("log4j.properties"));

		Voter voter = new Voter(new VoterProfile("マーリーさん", "5410000000"));
		VoteEvent event = new ExceedVoteEvent();

		VotingProcess model = new VotingProcess(event, voter);
		VotingProcessView view = new VotingProcessView();
		VotingProcessController controller = new VotingProcessController(model,
				view);
		controller.show();
	}

}
