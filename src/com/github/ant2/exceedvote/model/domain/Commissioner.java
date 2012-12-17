package com.github.ant2.exceedvote.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Commissioner extends Model {

	private String name;

	@OneToOne(cascade = CascadeType.ALL) private User user;

	@ManyToOne private VoteEvent voteEvent;

	public Commissioner() {
	}

	public Commissioner(String name) {
		this.name = name;
	}

	/**
	 * Returns the commissioner's name
	 * 
	 * @return name the commissioner's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name to this Commissioner.
	 * 
	 * @param name
	 *            the name that is going to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Id @GeneratedValue protected Integer id;

	/**
	 * Returns the voter entity ID.
	 * 
	 * @return id the voter entity ID.
	 */
	@Override
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the entity ID for this voter.
	 * 
	 * @param id
	 *            the voter entity ID that is going to be set.
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Returns the message shows the voter's studentID, name, and entity ID.
	 */
	@Override
	public String toString() {
		return "Commissioner [name=" + name + ", id=" + id + "]";
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
