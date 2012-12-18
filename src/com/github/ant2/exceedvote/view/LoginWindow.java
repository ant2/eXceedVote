package com.github.ant2.exceedvote.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Login UI.
 * 
 * @author Nutnicha Charoenporn
 */

public class LoginWindow extends JFrame {

	/** */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JButton btnLogin;
	private JButton btnReset;

	/**
	 * Create the frame and add components.
	 */
	public LoginWindow() {
		setTitle("eXceedVote Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblUsername, "6, 10");

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setText("username");
		panel.add(txtUsername, "8, 10, fill, default");
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password  : ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblPassword, "6, 12, left, default");

		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdPassword.setText("password");
		panel.add(pwdPassword, "8, 12, fill, default");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "6, 16, 3, 1, fill, fill");

		btnLogin = new JButton("Login");
		panel_1.add(btnLogin);

		btnReset = new JButton("Reset");
		panel_1.add(btnReset);
	}

	/**
	 * Returns the username text field.
	 * 
	 * @return username text field
	 */
	public JTextField getUsernameField() {
		return txtUsername;
	}

	/**
	 * Returns the password text field.
	 * 
	 * @return password text field
	 */
	public JPasswordField getPasswordField() {
		return pwdPassword;
	}

	/**
	 * Returns the login button.
	 * 
	 * @return login button
	 */
	public JButton getLoginButton() {
		return btnLogin;
	}

	/**
	 * Returns the reset button.
	 * 
	 * @return reset button
	 */
	public JButton getResetButton() {
		return btnReset;
	}

	/**
	 * Show the error message dialog on the screen.
	 */
	public void showLoginError() {
		JOptionPane.showMessageDialog(this, "Invalid username or password.",
				"Login failure.", JOptionPane.ERROR_MESSAGE);
	}
}
