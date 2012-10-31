package com.github.ant2.exceedvote.model.process;

import java.util.ArrayList;
import java.util.List;

import com.github.ant2.exceedvote.model.Project;
import com.github.ant2.exceedvote.model.VoteEvent;

/**
 * A view of the project's process.
 * 
 * @author Nutnicha Charoenporn
 */
public class ViewProjectProcess {

	/** A list of projects */
	private List<Project> list;
	
	/** A vote event */
	private VoteEvent event;

	/**
	 * Constructs the ViewProjectProcess. Initializes the event.
	 */
	public ViewProjectProcess(VoteEvent event) {
		this.event = event;
		list = event.getProjects();
	}

	/**
	 * Gets the list of available projects.
	 * 
	 * @return a list of available projects.
	 */
	public List<Project> getAllAvailableProjects() {
		List<Project> projects = new ArrayList<Project>();
		
		for(Project project : list){
			if(event.getProjects().contains(project)){
				projects.add(project);
			}
		}
		
		return projects;
	}

	/**
	 * Gets the project description
	 * 
	 * @param p1 the project
	 * @return the project description
	 */
	public Object getProjectInfo(Project p1) {
		return p1.getDescription();
	}

}
