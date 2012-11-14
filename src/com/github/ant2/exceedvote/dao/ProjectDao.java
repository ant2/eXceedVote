package com.github.ant2.exceedvote.dao;

import java.util.List;

import com.github.ant2.exceedvote.model.domain.Project;
import com.github.ant2.exceedvote.model.domain.VoteEvent;

public interface ProjectDao {

	void save(Project project);

	List<Project> findAllByEvent(VoteEvent event);

}
