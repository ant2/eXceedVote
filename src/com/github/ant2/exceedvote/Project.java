package com.github.ant2.exceedvote;

public class Project {
	private String name;
	private String description;
	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() { 
		return name; 
	}
	
	public String description() { 
		return description; 
	}
	
	public void setName(String name) { 
		this.name = name; 
	}
	
	public void setDescription(String description) { 
		this.description = description; 
	}
}
