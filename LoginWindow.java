package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import Json.JSONHelper;
import System.Publisher;
import System.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class LoginWindow {

	private static JFrame mainframe;
	private JFrame frame;
	private final JLabel lblEmail = new JLabel("Email:");
	private final JTextField textField = new JTextField();
	private final JPasswordField textField_1 = new JPasswordField();
	private final JLabel lblPassword = new JLabel("Password:");
	private final JButton btnLogin = new JButton("Login");
	private final JButton btnCancel = new JButton("Cancel");
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void LoginScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					LoginWindow window = new LoginWindow(mainframe);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param mainframe
	 */
	public LoginWindow(JFrame mainframe) {
		this.mainframe = mainframe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textField.setBounds(190, 53, 86, 20);
		textField.setColumns(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblEmail.setBounds(74, 51, 77, 25);

		frame.getContentPane().add(lblEmail);

		frame.getContentPane().add(textField);
		textField_1.setColumns(10);
		textField_1.setBounds(190, 89, 86, 20);

		frame.getContentPane().add(textField_1);
		lblPassword.setBounds(74, 87, 77, 25);

		frame.getContentPane().add(lblPassword);

		btnLogin.setBounds(43, 168, 89, 23);

		frame.getContentPane().add(btnLogin);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.setVisible(true);
				

			}
		});
		btnCancel.setBounds(190, 168, 89, 23);

		frame.getContentPane().add(btnCancel);
		
		JRadioButton rdbtnUser = new JRadioButton("User");
		buttonGroup.add(rdbtnUser);
		rdbtnUser.setBounds(74, 119, 58, 23);
		frame.getContentPane().add(rdbtnUser);
		
		JRadioButton rdbtnPublisher = new JRadioButton("Publisher");
		buttonGroup.add(rdbtnPublisher);
		rdbtnPublisher.setBounds(179, 119, 97, 23);
		frame.getContentPane().add(rdbtnPublisher);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String email = textField.getText();
				String filepath = System.getProperty("user.dir");
				JSONHelper helper = new JSONHelper();
				
				if(rdbtnUser.isSelected()) {
					filepath = (filepath+"\\customer.json");
					
					
				}else if(rdbtnPublisher.isSelected()){
					filepath = (filepath+"\\publisher.json"); 
				}
				
				JSONObject account = null;
				account = helper.findJSONObject(filepath, "Email", email);
				System.out.println(account.toString());
				
				
				if(rdbtnUser.isSelected()) {
					
					email = (String) account.get("Email");
					String username = (String) account.get("User Name");
					String birthdate = (String) account.get("Birth Date");
					String surname = (String) account.get("Surname");
					String name = (String) account.get("Name");
					String password = (String) account.get("Password");
				
					User user = new User(username,name,surname,email,password,birthdate,"");
					CustomerAccountScreen userscreen = new CustomerAccountScreen(user);
					userscreen.CustomerScreen();
					//					userscreen.initialize();
					mainframe.dispose();
					frame.dispose();
				}else if(rdbtnPublisher.isSelected()){
					String username = (String) account.get("User Name");
					String birthdate = (String) account.get("Birth Date");
					String surname = (String) account.get("Surname");
					String name = (String) account.get("Name");
					String password = (String) account.get("Password");
				
					Publisher publisher = new Publisher(username,name,surname,email,password,birthdate,"");
					PublisherAccountScreen userscreen = new PublisherAccountScreen(publisher);
					userscreen.PublisherScreen();
				}
				
				
				
			}
		});
	}
}
