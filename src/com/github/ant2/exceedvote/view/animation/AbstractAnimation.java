package com.github.ant2.exceedvote.view.animation;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class AbstractAnimation implements Animation {

	protected Component component;
	
	@Override
	public void setComponent(Component component) {
		this.component = component;
	}

}
