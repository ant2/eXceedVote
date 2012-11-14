package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.VoteEvent;

public interface EventDao {

	List<VoteEvent> findAll();

	void save(VoteEvent newEvent);

}
