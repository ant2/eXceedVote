package com.github.ant2.exceedvote.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * A project which voter can vote for.
 * 
 * @author Artima Mahahemarat
 */
@Entity
public class Project extends Model implements VoteEvent.Part {

	/** project name */
	private String name;
	/** project description */
	private String description;

	@ManyToOne private VoteEvent voteEvent;

	/**
	 * Constructs a project with name and description.
	 * 
	 * @param name
	 * @param description
	 */
	public Project(String name, String description) {
		this(name);
		setDescription(description);
	}

	public Project(String name) {
		this();
		setName(name);
	}

	public Project() {
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

	@Override
	public VoteEvent getVoteEvent() {
		return voteEvent;
	}

	public void setVoteEvent(VoteEvent voteEvent) {
		this.voteEvent = voteEvent;
	}

	@Id @GeneratedValue protected Integer id;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Project other = (Project) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}
	
	
}
