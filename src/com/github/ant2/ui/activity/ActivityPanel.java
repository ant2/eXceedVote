package com.github.ant2.ui.activity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import com.github.ant2.ui.transition.Painter;
import com.github.ant2.ui.transition.Transition;

/**
 * An ActivityPanel handles displaying ActivityViews (or any other component),
 * as well as facilitating transition effects (animations) between activity
 * views. One component may be displayed at a time (but that component may be a
 * container).
 * 
 * @author dtinth
 */
public class ActivityPanel extends JComponent {

	/** */
	private static final long serialVersionUID = 1L;

	/**
	 * The animator class.
	 * 
	 * @author dtinth
	 */
	private class Animator {

		private BufferedImage image;
		private long start = System.currentTimeMillis();
		private long duration;

		private Transition transition;

		private Painter drawBefore = new Painter() {
			@Override
			public void paint(Graphics2D g) {
				g.drawImage(image, 0, 0, null);
			}
		};

		private Painter drawAfter = new Painter() {
			@Override
			public void paint(Graphics2D g) {
				paintChildrenReal(g);
			}
		};

		public Animator(BufferedImage image, Transition transition,
				long duration) {
			this.image = image;
			this.transition = transition;
			this.duration = duration;
		}

		public void draw(Graphics2D graphics) {

			long elapsed = System.currentTimeMillis() - start;

			if (elapsed > duration) {
				paintChildrenReal(graphics);
				setAnimation(null);
				return;
			}

			double value = elapsed / (double) duration;
			transition.paint(ActivityPanel.this, value, drawBefore, drawAfter,
					graphics);
			repaint();

		}

	}

	private Animator animation = null;
	private boolean started = false;

	/**
	 * Constructs an ActivityPanel.
	 */
	public ActivityPanel() {
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
		} else if (started) {
			super.paintChildren(graphics);
		} else {
			graphics.setColor(Color.BLACK);
			graphics.fillRect(0, 0, getWidth(), getHeight());
		}
	}

	/**
	 * Display a component without a transition.
	 * 
	 * @param component
	 *            the component to display
	 */
	public void display(Component component) {
		display(component, null, 0);
	}

	/**
	 * Display a component with a transition effect.
	 * 
	 * @param component
	 *            the component to display
	 * @param transition
	 *            the transition effect to use
	 */
	public void display(Component component, Transition transition,
			long duration) {
		if (getWidth() > 0 && getHeight() > 0) {
			BufferedImage image = new BufferedImage(getWidth(), getHeight(),
					BufferedImage.TYPE_INT_ARGB);
			paintChildren(image.getGraphics());
			setAnimation(transition != null ? new Animator(image, transition,
					duration) : null);
			started = true;
		}
		removeAll();
		add(component, BorderLayout.CENTER);
		validate();
		repaint();
	}

}
