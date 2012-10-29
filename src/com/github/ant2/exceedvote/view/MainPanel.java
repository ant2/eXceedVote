package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;
	
	private class Animation {
		private BufferedImage image;
		private long start = System.currentTimeMillis();
		private long duration = 1000;

		public Animation(BufferedImage image) {
			this.image = image;
		}

		public void draw(Graphics2D graphics) {
			long elapsed = System.currentTimeMillis() - start;
			if (elapsed > duration) {
				paintChildrenReal(graphics);
				setAnimation(null);
				return;
			}
			double value = elapsed / (double)duration;
			value = 1 - Math.pow(1 - value, 2);
			double x = (1 - value) * getWidth();
			AffineTransform transform = graphics.getTransform();
			graphics.translate(x - getWidth(), 0);
			graphics.drawImage(image, 0, 0, null);
			graphics.translate(getWidth(), 0);
			paintChildrenReal(graphics);
			graphics.setTransform(transform);
			repaint();
		}
	}
	
	private Animation animation = null;
	
	public MainPanel() {
		super(new BorderLayout());
		add(new JLabel("Main Panel"), BorderLayout.CENTER);
	}
	
	private void setAnimation(Animation animation) {
		this.animation = animation;
	}
	
	private void paintChildrenReal(Graphics graphics) {
		super.paintChildren(graphics);
	}
	
	@Override
	protected void paintChildren(Graphics graphics) {
		if (animation != null) {
			animation.draw((Graphics2D)graphics);
		} else {
			super.paintChildren(graphics);
		}
	}

	public void display(Component component) {
		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		paintChildren(image.getGraphics());
		setAnimation(new Animation(image));
		removeAll();
		add(component, BorderLayout.CENTER);
		validate();
	}
	
}
