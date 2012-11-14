package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.VoteEvent;
import com.github.ant2.exceedvote.model.domain.Voter;

public interface VoterDao {

	List<Voter> findAllByEvent(VoteEvent event);

	void save(Voter voter);

	Voter find(int id);

	List<Voter> findAll();

}
