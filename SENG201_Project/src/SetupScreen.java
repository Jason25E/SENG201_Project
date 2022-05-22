import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupScreen {

	private JFrame frame;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private GameManager manager;
	private int numberOfDays = 15;
	private float start_gold_info = 0;
	private float shop_info = 0;
	private int monster_selling_info = 0;
	private float monster_skill_rate = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
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
	public SetupScreen() {
		initialize();
	}
	
	public SetupScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Close the application.
	 */
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 282);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWhatIsYour = new JLabel("What is your name");
		lblWhatIsYour.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWhatIsYour.setBounds(125, 7, 200, 20);
		frame.getContentPane().add(lblWhatIsYour);
		
		textField = new JTextField();
		textField.setBounds(115, 39, 200, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(Integer.toString(numberOfDays));
		lblNewLabel_1.setBounds(346, 120, 25, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("How many days would you like to last for?");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(24, 76, 400, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblChooseADifficulty = new JLabel("Choose a difficulty");
		lblChooseADifficulty.setFont(new Font("Dialog", Font.BOLD, 16));
		lblChooseADifficulty.setBounds(125, 156, 200, 20);
		frame.getContentPane().add(lblChooseADifficulty);
		
		JSlider slider = new JSlider();
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				numberOfDays = slider.getValue();
				lblNewLabel_1.setText(Integer.toString(numberOfDays));
			}
		});
		slider.setMinimum(5);
		slider.setMaximum(15);
		slider.setBounds(115, 120, 200, 25);
		frame.getContentPane().add(slider);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setBounds(319, 215, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop_info = 1;
				start_gold_info = 1;
				monster_selling_info = 4;
				monster_skill_rate = 1;
			}
		});
		buttonGroup.add(rdbtnEasy);
		rdbtnEasy.setFont(new Font("Dialog", Font.BOLD, 14));
		rdbtnEasy.setBounds(68, 184, 67, 23);
		frame.getContentPane().add(rdbtnEasy);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop_info = (float) 1.2;
				monster_selling_info = 3;
				start_gold_info = (float) 0.9;
				monster_skill_rate = (float) 1.1;
			}
		});
		buttonGroup.add(rdbtnNormal);
		rdbtnNormal.setFont(new Font("Dialog", Font.BOLD, 14));
		rdbtnNormal.setBounds(176, 184, 91, 23);
		frame.getContentPane().add(rdbtnNormal);
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop_info = (float) 1.4;
				start_gold_info = (float) 0.8;
				monster_selling_info = 2;
				monster_skill_rate = (float) 1.2;
				
			}
		});
		buttonGroup.add(rdbtnHard);
		rdbtnHard.setFont(new Font("Dialog", Font.BOLD, 14));
		rdbtnHard.setBounds(303, 184, 76, 23);
		frame.getContentPane().add(rdbtnHard);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setBounds(370, 125, 70, 15);
		frame.getContentPane().add(lblDays);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(23, 220, 302, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		/**
		 * If the input player name is valid and a difficulty is selected, then open up choose starter screen.
		 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Check if the player name is between 3 to 15 letter, including space.
				 */
				String playerName = textField.getText();
				if (playerName.matches("^[ A-Za-z]+$") == true && playerName.length() >= 3) {
					/**
					* Create a new player using the name as the one in the text field
					*/
					if (playerName.length() <= 15) {
						if (shop_info != 0) {
							Player player = new Player(playerName);
							manager.Setup(player, numberOfDays, shop_info, start_gold_info, monster_selling_info, monster_skill_rate);
							manager.closeSetupScreen(SetupScreen.this);
						} else {
							lblNewLabel_2.setText("Please select a difficulty");
						}
					} else {
						lblNewLabel_2.setText("Name must be between 3 to 15 letters");
					}
				} else {
					/**
					 * Display a message if player name is not valid.
					 */
					lblNewLabel_2.setText("Name must be between 3 to 15 letters");
				}
			}
		});
	}
}


