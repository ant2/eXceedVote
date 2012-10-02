package com.github.ant2.exceedvote.view;

import javax.swing.JFrame;

public class VotingProcessView extends JFrame {

	public interface Delegate {
	}

	public VotingProcessView() {
		super("eXceed Vote");
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}

	private Delegate delegate;
	
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}
	
}
