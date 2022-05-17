import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class ChooseStarterScreen {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	
	private GameManager manager;
	private String selectedMonster = "Null";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseStarterScreen window = new ChooseStarterScreen();
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
	public ChooseStarterScreen() {
		initialize();
	}
	
	public ChooseStarterScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 657, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChooseAStarting = new JLabel("Choose a starting monster for your team");
		lblChooseAStarting.setFont(new Font("Dialog", Font.BOLD, 16));
		lblChooseAStarting.setBounds(140, 22, 386, 23);
		frame.getContentPane().add(lblChooseAStarting);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ChooseStarterScreen.class.getResource("/Images/Bats.png")));
		lblNewLabel.setBounds(29, 128, 149, 121);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChooseStarterScreen.class.getResource("/Images/Slime.png")));
		lblNewLabel_1.setBounds(218, 114, 108, 119);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ChooseStarterScreen.class.getResource("/Images/Skeleton.png")));
		lblNewLabel_2.setBounds(483, 101, 141, 132);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ChooseStarterScreen.class.getResource("/Images/Ghost.png")));
		lblNewLabel_3.setBounds(344, 105, 128, 144);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(269, 277, 128, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Enter a name for your monster");
		lblNewLabel_4.setBounds(29, 277, 235, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(29, 255, 278, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Bat");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = "Bats";
				textField.setText(selectedMonster);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(66, 69, 49, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Slime");
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = "Slime";
				textField.setText(selectedMonster);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(228, 69, 69, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Ghost");
		rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = "Ghost";
				textField.setText(selectedMonster);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(369, 69, 76, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Skeleton");
		rdbtnNewRadioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = "Skeleton";
				textField.setText(selectedMonster);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(502, 69, 94, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String monsterName = textField.getText();
				if (selectedMonster != "Null") {
					if (monsterName.length() > 0 && monsterName.length() < 9) {
						int attack = 10;
						int defence = 10;	
						int healingAmount = 20;
						if (selectedMonster == "Bats") {
							attack = 20;
						} else if (selectedMonster == "Slime") {
							healingAmount = 40;
						} else if (selectedMonster == "Ghost") {
							defence = 20;
						} else {
							attack = 20;
							defence = 20;
							healingAmount = 10;
						}
						Monster newMonster = new Monster(selectedMonster, monsterName, "Common", attack, defence, 100, healingAmount, null);
						manager.getPlayer().addMonster(newMonster);
						manager.closeChooseStarterScreen(ChooseStarterScreen.this);
					} else {
						lblNewLabel_5.setText("Name must be between 1 to 8 letters");
					}
				} else {
					lblNewLabel_5.setText("Please select a monster");
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setBounds(507, 265, 117, 38);
		frame.getContentPane().add(btnNewButton);
		

	}
}
