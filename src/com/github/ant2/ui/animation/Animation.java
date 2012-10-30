package com.github.ant2.ui.animation;

import java.awt.Component;
import java.awt.Graphics2D;

public interface Animation {

	void setComponent(Component component);

	void draw(double value, Drawable before, Drawable after, Graphics2D g);

}
