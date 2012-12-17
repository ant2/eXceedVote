package com.github.ant2.exceedvote.model.process.admin;

import com.github.ant2.exceedvote.dao.CriterionDao;
import com.github.ant2.exceedvote.dao.DaoFactory;
import com.github.ant2.exceedvote.model.domain.Criterion;
import com.github.ant2.exceedvote.util.ChangeObservable;

public class EditCriterionProcess extends ChangeObservable {

	private DaoFactory df;
	private Criterion criterion;
	private CriterionDao dao;
	private String error;

	public EditCriterionProcess(DaoFactory df, Criterion criterion) {
		this.df = df;
		this.criterion = criterion;
		dao = df.getCriterionDao();
	}

	public void setName(String name) {
		criterion.setName(name);
	}

	public String getName() {
		return criterion.getName();
	}

	public boolean save() {
		if (criterion.getName().isEmpty()) {
			error = "Criterion name must not be empty!";
			return false;
		}
		dao.save(criterion);
		notifyObservers();
		return true;
	}

	public boolean delete() {
		dao.remove(criterion);
		notifyObservers();
		return true;
	}

	public String getError() {
		return error;
	}

}
