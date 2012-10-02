package com.github.ant2.exceedvote.domain;

/**
 * The VoterProfile describes the Voter.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class VoterProfile {
	private String name;
	private String studentId;

	/**
	 * Constructs a VoterProfile with specific name and student id
	 * 
	 * @param name
	 *            the full name of voter
	 * @param studentId
	 *            the student ID of voter
	 */
	public VoterProfile(String name, String studentId) {
		this.name = name;
		this.studentId = studentId;
	}

	/**
	 * Returns the name associated with this profile.
	 * 
	 * @return profile owner name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the student ID associated with this profile.
	 * 
	 * @return profile owner student ID
	 */
	public String getStudentId() {
		return studentId;
	}

	@Override
	public String toString() {
		return name;
	}
}
