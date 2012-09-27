package com.github.ant2.exceedvote;

/**
 * A project which voter can vote for.
 * 
 * @author Artima Mahahemarat
 */
public class Project {
	/** project name */
	private String name;
	/** project description */
	private String description;

	/**
	 * Constructs a project with name and description.
	 * 
	 * @param name
	 * @param description
	 */
	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * Returns project name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns project description.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets project name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets project description.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() { 
		return name;
	}
}
