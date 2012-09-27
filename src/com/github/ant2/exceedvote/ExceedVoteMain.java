package com.github.ant2.exceedvote;

import java.util.List;

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
		test();
	}

	private static void test() {

		Voter v = new Voter();
		VoterSession session = new VoterSession();

		int allowedBallots = v.getAllowedBallots();
		System.out.println("Allowed ballots " + allowedBallots);

		VoterProfile profile = v.getProfile();
		BallotBox box = session.getBallotBox();

		System.out.println("Hello, " + profile);

		int remainingTime = session.getRemainingTime();
		System.out.printf("We have %d : %d left\n", remainingTime / 60,
				remainingTime % 60);

		List<Project> projects = session.getProjects();
		List<Criterion> criteria = session.getCriteria();

		System.out.println("Projects:");
		for (Project project : projects) {
			System.out.println("- " + project);
		}

		System.out.println("Criteria:");
		for (Criterion criterion : criteria) {
			System.out.println("- " + criterion);
		}

		// user selects a project
		Project selectedProject = projects.get(0);
		Criterion selectedCriteria = criteria.get(0);

		// use that information to create a ballot
		Ballot b = new Ballot(v, selectedProject, selectedCriteria);
		session.submit(b);

	}

}
