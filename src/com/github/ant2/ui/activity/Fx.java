package com.github.ant2.ui.activity;

import com.github.ant2.ui.transition.SlideTransition;
import com.github.ant2.ui.transition.StarfieldTransition;
import com.github.ant2.ui.transition.Transition;

/**
 * This class represents a transition effect. It encapsulates the "transition"
 * and the "duration" together, as well as defines some default effects.
 * 
 * @author dttvb
 */
public class Fx {

	/**
	 * Fx that slides from the left.
	 */
	public static final Fx SLIDE_LEFT = fx(SlideTransition.LEFT);

	/**
	 * Fx that slides from the right.
	 */
	public static final Fx SLIDE_RIGHT = fx(SlideTransition.RIGHT);

	/**
	 * Fx that displays a starfield.
	 */
	public static final Fx STARFIELD = fx(new StarfieldTransition(), 2000);

	private Transition transition;
	private long duration;

	/**
	 * Constructs an Fx.
	 * 
	 * @param transition
	 *            the transition to use
	 * @param duration
	 *            the duration of that animation
	 */
	public Fx(Transition transition, long duration) {
		this.transition = transition;
		this.duration = duration;
	}

	/**
	 * Returns the transition of this Fx.
	 * 
	 * @return the transition associated with this Fx.
	 */
	public Transition getTransition() {
		return transition;
	}

	/**
	 * Returns the duration for this animation
	 * 
	 * @return duration for this animation, in milliseconds
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * Convenience method that creates an Fx with default duration.
	 * 
	 * @param transition
	 *            the transition to use
	 * @return a new Fx
	 */
	public static Fx fx(Transition transition) {
		return new Fx(transition, 600);
	}

	/**
	 * Convenience method that creates an Fx with a specified duration.
	 * 
	 * @param transition
	 *            the transition to use
	 * @param duration
	 *            the duration, in milliseconds
	 * @return a new Fx
	 */
	public static Fx fx(Transition transition, long duration) {
		return new Fx(transition, duration);
	}

}
