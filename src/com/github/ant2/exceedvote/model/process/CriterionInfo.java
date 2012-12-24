package com.github.ant2.exceedvote.model.process;

import com.github.ant2.exceedvote.model.domain.Criterion;

/**
 * Holds info about a criterion.
 * 
 * @author dtinth
 */
public interface CriterionInfo {

	/**
	 * Returns the criterion.
	 * 
	 * @return criterion
	 */
	Criterion getCriterion();

	/**
	 * Returns true if the voter has voted on this criterion.
	 * 
	 * @return true if the voter has voted on this criterion, false
	 *         otherwise
	 */
	boolean isVoted();

}