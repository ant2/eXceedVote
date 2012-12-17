package com.github.ant2.exceedvote.util;

import java.util.Observable;
import java.util.Observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeObservable {

	private static Logger logger = LogManager.getLogger(ChangeObservable.class);
	private MyObservable observable = new MyObservable();

	private class MyObservable extends Observable {
		public void fire() {
			setChanged();
			notifyObservers();
		}
	}

	public void addObserver(final ChangeObserver o) {
		observable.addObserver(new Observer() {
			@Override
			public void update(Observable arg0, Object arg1) {
				logger.debug(ChangeObservable.this + " notifies " + o + ".");
				o.changed();
			}
		});
	}

	protected void notifyObservers() {
		logger.debug(this + " has been changed.");
		observable.fire();
	}

}
