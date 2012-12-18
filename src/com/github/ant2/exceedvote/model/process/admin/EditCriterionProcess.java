package com.github.ant2.exceedvote.model.process.admin;

import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.util.ChangeObservable;

/**
 * The process for editing criterion.
 * 
 * @author Thiwat Rongsirigul (Leo Aiolia)
 */
public class EditCriterionProcess extends ChangeObservable {
	private DaoFactory df;
	private Criterion criterion;
	private CriterionDao dao;
	private String error;

	/**
	 * Constructห a new EditCriterionProcess.
	 * 
	 * @param df
	 *            the DAO factory to get all other DAO
	 * @param criterion
	 *            the editing criterion
	 */
	public EditCriterionProcess(DaoFactory df, Criterion criterion) {
		this.df = df;
		this.criterion = criterion;
		dao = this.df.getCriterionDao();
	}

	/**
	 * Set the name of the chosen criterion.
	 * 
	 * @param name
	 *            new name of the criterion
	 */
	public void setName(String name) {
		criterion.setName(name);
	}

	/**
	 * Returns the name of the criterion.
	 * 
	 * @return name of the criterion
	 */
	public String getName() {
		return criterion.getName();
	}

	/**
	 * Save the new criterion to the database.
	 * 
	 * @return true if the criterion is successfully saved, otherwise false
	 */
	public boolean save() {
		if (criterion.getName().isEmpty()) {
			error = "Criterion name must not be empty!";
			return false;
		}
		dao.save(criterion);
		notifyObservers();
		return true;
	}

	/**
	 * Delete the criterion from the database.
	 * 
	 * @return true if can delete
	 */
	public boolean delete() {
		dao.remove(criterion);
		notifyObservers();
		return true;
	}

	/**
	 * Returns the error message.
	 * 
	 * @return the error message
	 */
	public String getError() {
		return error;
	}

}
