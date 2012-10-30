package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;

import com.github.ant2.exceedvote.view.animation.Animation;
import com.github.ant2.exceedvote.view.animation.Drawable;
import com.github.ant2.exceedvote.view.animation.SlideAnimation;

public class MainPanel extends JComponent {

	/** */
	private static final long serialVersionUID = 1L;

	private class Animator {

		private BufferedImage image;
		private long start = System.currentTimeMillis();
		private long duration = 600;

		private Animation animation;

		private Drawable drawBefore = new Drawable() {
			@Override
			public void draw(Graphics2D g) {
				g.drawImage(image, 0, 0, null);
			}
		};

		private Drawable drawAfter = new Drawable() {
			@Override
			public void draw(Graphics2D g) {
				paintChildrenReal(g);
			}
		};

		public Animator(BufferedImage image, Animation animation) {
			this.image = image;
			this.animation = animation;
			this.animation.setComponent(MainPanel.this);
		}

		public void draw(Graphics2D graphics) {

			long elapsed = System.currentTimeMillis() - start;

			if (elapsed > duration) {
				paintChildrenReal(graphics);
				setAnimation(null);
				return;
			}

			double value = elapsed / (double) duration;
			animation.draw(value, drawBefore, drawAfter, graphics);
			repaint();

		}

	}

	private Animator animation = null;

	public MainPanel() {
		setLayout(new BorderLayout());
		add(new JComponent() {
			/** */
			private static final long serialVersionUID = 1L;
		}, BorderLayout.CENTER);
		setDoubleBuffered(true);
	}

	private void setAnimation(Animator animation) {
		this.animation = animation;
	}

	private void paintChildrenReal(Graphics graphics) {
		super.paintChildren(graphics);
	}

	@Override
	protected void paintChildren(Graphics graphics) {
		if (animation != null) {
			animation.draw((Graphics2D) graphics);
		} else {
			super.paintChildren(graphics);
		}
	}

	public void display(Component component) {
		display(component, new SlideAnimation());
	}

	public void display(Component component, Animation animation) {
		BufferedImage image = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		paintChildren(image.getGraphics());
		setAnimation(new Animator(image, animation));
		removeAll();
		add(component, BorderLayout.CENTER);
		validate();
		repaint();
	}

}
