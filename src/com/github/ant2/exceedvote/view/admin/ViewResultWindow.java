package com.github.ant2.exceedvote.view.admin;

import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLEditorKit;

public class ViewResultWindow extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	private JEditorPane editorPane;

	public ViewResultWindow() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("View Voting Result");
		initComponents();
	}

	private void initComponents() {
		editorPane = new JEditorPane();
		JScrollPane scrollPane = new JScrollPane(editorPane);
		HTMLEditorKit kit = new HTMLEditorKit();
		editorPane.setEditorKit(kit);
		editorPane.setDocument(kit.createDefaultDocument());
		editorPane.setEditable(false);
		scrollPane.setPreferredSize(new Dimension(400, 300));
		add(scrollPane);
		pack();
	}

	public void setText(String t) {
		editorPane.setText(t);
	}

}
