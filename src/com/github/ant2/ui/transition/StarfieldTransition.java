package com.github.ant2.ui.transition;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;

public class StarfieldTransition implements Transition {

	@Override
	public void paint(Component component, double value, Painter before,
			Painter after, Graphics2D graphics) {

		int width = component.getWidth();
		int height = component.getHeight();

		{
			double scale = 0.4 + 0.6 * (1 - Math.pow(1 - value, 2));
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
		}
	}

}
