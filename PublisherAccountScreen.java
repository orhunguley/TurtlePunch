package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import System.Publisher;
import System.User;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class PublisherAccountScreen {
	private static Publisher publisher;

	private JFrame frame;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JPanel panel_1;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;

	/**
	 * Launch the application.
	 */
	public static void PublisherScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublisherAccountScreen window = new PublisherAccountScreen(publisher);
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
	public PublisherAccountScreen(Publisher publisher) {
		this.publisher = publisher;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		layeredPane.setBounds(837, 11, 337, 539);

		frame.getContentPane().add(layeredPane);
		
		int y = 38;
		lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, y, 77, 24);
		layeredPane.add(lblNewLabel);
		
		y = y + 35;
		label = new JLabel("Surname:");
		label.setBounds(10, y, 77, 24);
		layeredPane.add(label);
		y = y + 35;

		label_1 = new JLabel("Username:");
		label_1.setBounds(10, y, 77, 24);
		layeredPane.add(label_1);
		y = y + 35;

		label_2 = new JLabel("Nationality:");
		label_2.setBounds(10, y, 77, 24);
		layeredPane.add(label_2);
		y = y + 35;

		label_3 = new JLabel("Birthdate:");
		label_3.setBounds(10, y, 77, 24);
		layeredPane.add(label_3);
		y = y + 35;

		label_4 = new JLabel("Email:");
		label_4.setBounds(10, y, 77, 24);
		layeredPane.add(label_4);
		
		label_5 = new JLabel("");
		label_5.setBounds(97, 43, 140, 14);
		layeredPane.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setBounds(97, 78, 140, 14);
		layeredPane.add(label_6);
		
		label_7 = new JLabel("");
		label_7.setBounds(97, 113, 140, 14);
		layeredPane.add(label_7);
		
		label_8 = new JLabel("");
		label_8.setBounds(97, 148, 140, 14);
		layeredPane.add(label_8);
		
		label_9 = new JLabel("");
		label_9.setBounds(97, 183, 140, 14);
		layeredPane.add(label_9);
		
		label_10 = new JLabel("");
		label_10.setBounds(97, 218, 140, 14);
		layeredPane.add(label_10);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 817, 28);
		frame.getContentPane().add(panel);

		JLabel lblGames = new JLabel("PUBLISHED GAMES");
		lblGames.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGames.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGames);
		
		
		String[] columnNames = {"Name",
                "Publisher",
                "Type",
                "Release Date",
                "Price"};
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 50, 817, 500);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable(data, columnNames);
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 817, 500);
		table.setFillsViewportHeight(true);
		panel_1.add(scrollPane);

		label_5.setText(publisher.getName());
		label_6.setText(publisher.getSurname());
		label_7.setText(publisher.getUsername());
		label_8.setText(publisher.getNationality());
		label_9.setText(publisher.getBirthdate());
		label_10.setText(publisher.getEmail());
	}
}
