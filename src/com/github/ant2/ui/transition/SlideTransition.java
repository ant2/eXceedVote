package com.github.ant2.ui.transition;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 * A transition that slides from one side to another side.
 * 
 * @author dtinth
 */
public class SlideTransition implements Transition {

	/**
	 * The direction of sliding.
	 * 
	 * @author dtinth
	 */
	public static enum Direction {

		/**
		 * Slide from right.
		 */
		RIGHT(-1, 0, 1, 0),

		/**
		 * Slide from left.
		 */
		LEFT(1, 0, -1, 0);

		private final double x1;
		private final double y1;
		private final double x2;
		private final double y2;

		private Direction(double x1, double y1, double x2, double y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	/**
	 * The transition that slides from left to right.
	 */
	public static final SlideTransition LEFT = new SlideTransition(
			Direction.LEFT);

	/**
	 * The transition that slides from right to left.
	 */
	public static final SlideTransition RIGHT = new SlideTransition(
			Direction.RIGHT);

	private Direction direction;

	/**
	 * Constructs a SlideTransition with a specified direction.
	 * 
	 * @param direction
	 *            the direction of the transition
	 */
	public SlideTransition(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Construct a SlideTransition that transitions from left to right.
	 */
	public SlideTransition() {
		this(Direction.RIGHT);
	}

	@Override
	public void paint(Component component, double value, Painter before,
			Painter after, Graphics2D g) {

		double width = component.getWidth();
		double height = component.getHeight();

		value = 1 - Math.pow(1 - value, 2);
		AffineTransform transform = g.getTransform();
		g.translate(width * value * direction.x1, height * value * direction.y1);
		before.paint(g);
		g.setTransform(transform);
		value = 1 - value;
		g.translate(width * value * direction.x2, height * value * direction.y2);
		after.paint(g);

		g.setTransform(transform);

	}

}
