package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LaunchWindow {

	private JFrame frame;
	private final JButton btnNewButton = new JButton("Sign Up");
	private final JButton btnLogin = new JButton("Login");
	private final JLabel lblWelcomToTurtlepunch = new JLabel("Welcome to TurtlePunch");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchWindow window = new LaunchWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LaunchWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{430, 87, 467, 0};
		gridBagLayout.rowHeights = new int[]{22, 129, 38, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				SignUpWindow sign = new SignUpWindow(frame);
				sign.SignUpScreen();
			}
		});
		
		GridBagConstraints gbc_lblWelcomToTurtlepunch = new GridBagConstraints();
		gbc_lblWelcomToTurtlepunch.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcomToTurtlepunch.gridx = 1;
		gbc_lblWelcomToTurtlepunch.gridy = 1;
		lblWelcomToTurtlepunch.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblWelcomToTurtlepunch, gbc_lblWelcomToTurtlepunch);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.WEST;
		gbc_btnLogin.fill = GridBagConstraints.VERTICAL;
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 2;
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LoginWindow log = new LoginWindow(frame);
				log.LoginScreen();
			}
		});
		frame.getContentPane().add(btnLogin, gbc_btnLogin);
	}
}
