package com.github.ant2.ui.transition;

import java.awt.Component;
import java.awt.Graphics2D;

/**
 * The Transition interface is used by the ActivityPanel to do transition
 * effects.
 * 
 * @author dtinth
 */
public interface Transition {

	/**
	 * Paints a transition between before and after to the graphics.
	 * 
	 * @param component
	 *            the context component
	 * @param value
	 *            the current state of animation, from 0 (begin) to 1 (end)
	 * @param before
	 *            a painter that paints the state before the transition
	 * @param after
	 *            a painter that paints the target things
	 * @param graphics
	 *            the graphics to paint to
	 */
	void paint(Component component, double value, Painter before,
			Painter after, Graphics2D graphics);
}
