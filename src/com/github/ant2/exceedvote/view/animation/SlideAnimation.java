package com.github.ant2.exceedvote.view.animation;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class SlideAnimation extends AbstractAnimation {

	public static enum Direction {
		RIGHT(-1, 0, 1, 0), LEFT(1, 0, -1, 0);
		public final double x1;
		public final double y1;
		public final double x2;
		public final double y2;

		private Direction(double x1, double y1, double x2, double y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	private Direction direction;

	public SlideAnimation(Direction direction) {
		this.direction = direction;
	}

	public SlideAnimation() {
		this(Direction.RIGHT);
	}

	@Override
	public void draw(double value, Drawable before, Drawable after, Graphics2D g) {

		double width = component.getWidth();
		double height = component.getHeight();

		value = 1 - Math.pow(1 - value, 2);
		AffineTransform transform = g.getTransform();
		g.translate(width * value * direction.x1, height * value * direction.y1);
		before.draw(g);
		g.setTransform(transform);
		value = 1 - value;
		g.translate(width * value * direction.x2, height * value * direction.y2);
		after.draw(g);

		g.setTransform(transform);

	}

}
