package com.github.ant2.ui.transition;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;

public class StarfieldTransition implements Transition {

	private static final int NUM_STARS = 200;
	private Star[] stars;

	private static class Star {
		public double x, y, z;
		public double r, sTheta, vTheta, theta;

		public Star() {
			z = Math.random() * 10;
			r = Math.random();
			sTheta = Math.random() * Math.PI * 2;
			vTheta = (Math.random() - 0.5) * Math.PI * 1/3;
		}

		public void update(double time) {
			theta = sTheta + time * vTheta;
			x = 0.5 + Math.cos(theta) * r;
			y = 0.5 + Math.sin(theta) * r;
			
		}
	}

	public StarfieldTransition() {
		stars = new Star[NUM_STARS];
		for (int i = 0; i < NUM_STARS; i++) {
			stars[i] = new Star();
		}
	}

	@Override
	public void paint(Component component, double value, Painter before,
			Painter after, Graphics2D graphics) {

		int width = component.getWidth();
		int height = component.getHeight();

		{
			double scale = 0.2 + 0.8 * (1 - Math.pow(1 - value, 2));
			Graphics2D g = (Graphics2D) graphics.create();
			g.translate(width / 2, height / 2);
			g.scale(scale, scale);
			g.translate(-width / 2, -height / 2);
			after.paint(g);
		}

		{
			Graphics2D g = (Graphics2D) graphics.create();
			float alpha = (float) (1 - value);
			g.setComposite(AlphaComposite.SrcOver.derive(alpha));
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.WHITE);

			double cameraZ = value * 9;
			for (Star star : stars) {
				star.update(value);
				double distanceZ = star.z - cameraZ;
				if (distanceZ <= 0) continue;
				double viewSize = distanceZ;
				double x = 0.5 + (star.x - 0.5) / viewSize;
				double y = 0.5 + (star.y - 0.5) / viewSize;
				g.fillOval((int)(x * width) - 2, (int)(y * height) - 2, 4, 4);
			}
		}

	}

}
