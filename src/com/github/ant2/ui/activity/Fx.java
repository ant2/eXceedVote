package com.github.ant2.ui.activity;

import com.github.ant2.ui.transition.SlideTransition;
import com.github.ant2.ui.transition.StarfieldTransition;
import com.github.ant2.ui.transition.Transition;

public class Fx {

	public static final Fx SLIDE_LEFT = fx(SlideTransition.LEFT);
	public static final Fx SLIDE_RIGHT = fx(SlideTransition.RIGHT);
	public static final Fx STARFIELD = fx(new StarfieldTransition(), 2000);

	private Transition transition;
	private long duration;

	public Fx(Transition transition, long duration) {
		this.transition = transition;
		this.duration = duration;
	}

	public Transition getTransition() {
		return transition;
	}

	public long getDuration() {
		return duration;
	}

	public static Fx fx(Transition transition) {
		return new Fx(transition, 600);
	}

	public static Fx fx(Transition transition, long duration) {
		return new Fx(transition, duration);
	}

}
