package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

import com.sun.xml.internal.ws.Closeable;

import Json.JSONHelper;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.text.Format;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpWindow {
	
	private static JFrame mainframe;
	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("Name:");
	private final JLabel lblSurname = new JLabel("Surname:");
	private final JLabel lblUserName = new JLabel("User Name:");
	private final JLabel lblBirthDate = new JLabel("Birth Date:");
	private final JLabel lblEmail = new JLabel("Email:");
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JButton btnSignIn = new JButton("Sign In");
	private final JButton btnCancel = new JButton("Cancel");
	private final JLabel lblPleaseEnterPersonal = new JLabel("Please enter personal information to sign in.");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void SignUpScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpWindow window = new SignUpWindow(mainframe);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param mainframe 
	 */
	public SignUpWindow(JFrame mainframe) {
		this.mainframe = mainframe;
		initialize();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textField.setBounds(120, 87, 86, 20);
		textField.setColumns(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblNewLabel.setBounds(32, 85, 78, 24);
		
		frame.getContentPane().add(lblNewLabel);
		lblSurname.setBounds(32, 125, 78, 24);
		
		frame.getContentPane().add(lblSurname);
		lblUserName.setBounds(32, 165, 78, 24);
		
		frame.getContentPane().add(lblUserName);
		lblBirthDate.setBounds(32, 245, 78, 24);
		
		frame.getContentPane().add(lblBirthDate);
		lblEmail.setBounds(32, 285, 78, 24);
		
		frame.getContentPane().add(lblEmail);
		
		frame.getContentPane().add(textField);
		textField_1.setColumns(10);
		textField_1.setBounds(120, 127, 86, 20);
		
		frame.getContentPane().add(textField_1);
		textField_2.setColumns(10);
		textField_2.setBounds(120, 167, 86, 20);
		
		frame.getContentPane().add(textField_2);
		
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		textField_3 = new JFormattedTextField(format);
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_3.setText("");
			}
		});
		textField_3.setText("dd.mm.yyyy");
		
		textField_3.setColumns(10);
		textField_3.setBounds(120, 245, 86, 20);
		
		frame.getContentPane().add(textField_3);
		textField_4.setColumns(10);
		textField_4.setBounds(120, 285, 86, 20);
		
		textField_5 = new JPasswordField();
		textField_5.setColumns(10);
		textField_5.setBounds(120, 207, 86, 20);
		frame.getContentPane().add(textField_5);
		
		
		frame.getContentPane().add(textField_4);

		btnSignIn.setBounds(32, 365, 89, 23);
		
		frame.getContentPane().add(btnSignIn);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.setVisible(true);
				frame.dispose();
				
			}
		});
		btnCancel.setBounds(157, 365, 89, 23);
		
		frame.getContentPane().add(btnCancel);
		lblPleaseEnterPersonal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPleaseEnterPersonal.setBounds(32, 26, 316, 24);
		
		frame.getContentPane().add(lblPleaseEnterPersonal);
		
		JRadioButton rdbtnUser = new JRadioButton("User");
		buttonGroup.add(rdbtnUser);
		rdbtnUser.setBounds(32, 320, 59, 23);
		frame.getContentPane().add(rdbtnUser);
		
		JRadioButton rdbtnPublisher = new JRadioButton("Publisher");
		buttonGroup.add(rdbtnPublisher);
		rdbtnPublisher.setBounds(120, 320, 86, 23);
		frame.getContentPane().add(rdbtnPublisher);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(32, 205, 78, 24);
		frame.getContentPane().add(lblPassword);
		

		
		
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(buttonGroup.isSelected(buttonGroup.getSelection())
					&& textField.getText()!=null&& textField_1.getText()!=null&& textField_2.getText()!=null
					&& textField_3.getText()!=null&& textField_4.getText()!=null && textField_5!=null) {
					
					String[] info = new String[6];
					String filepath = System.getProperty("user.dir");
					JSONHelper helper = new JSONHelper();
					info[0] = textField.getText();
					info[1] = textField_1.getText();
					info[2] = textField_2.getText();
					info[3] = textField_5.getText();
					info[4] = textField_3.getText();
					info[5] = textField_4.getText();
		
			        
					
					if(rdbtnUser.isSelected()) {
						filepath = (filepath+"\\customer.json");
						helper.AddToDatabase(filepath, info,"User");
						
						
					}else if(rdbtnPublisher.isSelected()){
						filepath = (filepath+"\\publisher.json"); 
						helper.AddToDatabase(filepath, info, "Publisher");
					}
					
					
					
					
					
				}
				
			}
		});
		
	}
}
