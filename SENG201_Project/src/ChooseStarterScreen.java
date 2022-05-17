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
	private Monster selectedMonster = null;

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
		/**
		 * initialize the four monster that allow the player to choose
		 */
		Skill batSkill = new Skill("Bit", "Has a base power of 12", 12);
		Monster bat = new Monster("Bats", "Bat", "Common", 20, 10, 100, 20, batSkill);
		
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", "Common", 10, 10, 100, 40, slimeSkill);
		
		Skill ghostSkill = new Skill("Dive", "Has a base power of 12", 12);
		Monster ghost = new Monster("Ghost", "Ghost", "Common", 10, 20, 100, 20, ghostSkill);
		
		Skill skeletonSkill = new Skill("Slash", "Has a base power of 12", 12);
		Monster skeleton = new Monster("Skeleton", "Skeleton", "Common", 20, 20, 100, 10, skeletonSkill);
		
		/**
		 * initialize the frame
		 */
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
		lblNewLabel_5.setBounds(29, 255, 497, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Bat");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = bat;
				lblNewLabel_5.setText(bat.getMonsterInfo());
				textField.setText(selectedMonster.getMonsterName());
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(66, 69, 49, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Slime");
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = slime;
				lblNewLabel_5.setText(slime.getMonsterInfo());
				textField.setText(selectedMonster.getMonsterName());
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(228, 69, 69, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Ghost");
		rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = ghost;
				lblNewLabel_5.setText(ghost.getMonsterInfo());
				textField.setText(selectedMonster.getMonsterName());
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(369, 69, 76, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Skeleton");
		rdbtnNewRadioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = skeleton;
				lblNewLabel_5.setText(skeleton.getMonsterInfo());
				textField.setText(selectedMonster.getMonsterName());
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(502, 69, 94, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String monsterName = textField.getText();
				if (selectedMonster != null) {
					if (monsterName.length() > 0 && monsterName.length() < 9) {
						selectedMonster.setMonsterName(monsterName);
						manager.getPlayer().addMonster(selectedMonster);
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
		btnNewButton.setBounds(515, 265, 117, 38);
		frame.getContentPane().add(btnNewButton);
		

	}
}
