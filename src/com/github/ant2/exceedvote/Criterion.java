package com.github.ant2.exceedvote;

/**
 * A criterion which voter can vote for.
 * 
 * @author Artima Mahahemarat
 */
public class Criterion {
	/** criterion name */
	private String name;

	/**
	 * Constructs a criterion with name.
	 * 
	 * @param name
	 */
	public Criterion(String name) {
		this.name = name;
	}

	/**
	 * Returns criterion name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets criterion name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
