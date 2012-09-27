package com.github.ant2.exceedvote;

public class VoterProfile {
	private String name;
	private String studentId;
	
	public VoterProfile(String name, String studentId) {
		this.name = name;
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public String getStudentId() {
		return studentId;
	}
}
