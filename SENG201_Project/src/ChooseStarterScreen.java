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

	private JFrame frmChooseAStarter;
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
					window.frmChooseAStarter.setVisible(true);
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
		frmChooseAStarter.setVisible(true);
	}
	
	public void closeWindow() {
		frmChooseAStarter.dispose();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		float shop_info = manager.getShop_info();
		int current_day = manager.getCurrentDay();
		float monster_heal_rate = manager.getStart_gold_info();
		int MonsterLevelTwo = manager.RandomMonsterLevelInShopTwo;
		int MonsterLevel = manager.RandomMonsterLevelInShop;
		/**
		 * initialize the four monster that allow the player to choose
		 */
		Skill batSkill = new Skill("Bit", "Has a base power of 12", 12);
		Monster bat = new Monster("Bat", "Bat", MonsterLevel, "Common", 12 + 2 * MonsterLevel, 10 + 2 * MonsterLevel, 200 + Math.round(3 * monster_heal_rate * MonsterLevel), 30, batSkill);
		
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", MonsterLevel, "Common", 7 + 1 * MonsterLevel, 10 + 3 * MonsterLevel, 200 + Math.round((float)3.5 * monster_heal_rate * MonsterLevel), 60, slimeSkill);
		
		Skill ghostSkill = new Skill("Dive", "Has a base power of 12", 12);
		Monster ghost = new Monster("Ghost", "Ghost", MonsterLevel, "Common", 8 + 2 * MonsterLevel, 17 + 3 * MonsterLevel, 200 + Math.round(3 * monster_heal_rate * MonsterLevel), 30, ghostSkill);
		
		
		Skill skeletonSkill = new Skill("Slash", "Has a base power of 12", 12);
		Monster skeleton = new Monster("Skeleton", "Skeleton", MonsterLevelTwo, "Common", 13 + 3 * MonsterLevel, 15 + 2 * MonsterLevel, 200 + Math.round(2 * monster_heal_rate * MonsterLevel), 25, skeletonSkill);
		/**
		 * initialize the frame
		 */
		frmChooseAStarter = new JFrame();
		frmChooseAStarter.setTitle("Choose a starter");
		frmChooseAStarter.setBounds(100, 100, 657, 346);
		frmChooseAStarter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChooseAStarter.getContentPane().setLayout(null);
		
		JLabel lblChooseAStarting = new JLabel("Choose a starting monster for your team");
		lblChooseAStarting.setFont(new Font("Dialog", Font.BOLD, 16));
		lblChooseAStarting.setBounds(140, 22, 386, 23);
		frmChooseAStarter.getContentPane().add(lblChooseAStarting);
		
		JLabel lblMonsterIcon = new JLabel("");
		lblMonsterIcon.setIcon(new ImageIcon(ChooseStarterScreen.class.getResource("/Images/Monster/Bat.png")));
		lblMonsterIcon.setToolTipText(bat.getMonsterInfo());
		lblMonsterIcon.setBounds(29, 128, 149, 121);
		frmChooseAStarter.getContentPane().add(lblMonsterIcon);
		
		JLabel lblMonsterIcon_2 = new JLabel("");
		lblMonsterIcon_2.setIcon(new ImageIcon(ChooseStarterScreen.class.getResource("/Images/Monster/Slime.png")));
		lblMonsterIcon_2.setToolTipText(slime.getMonsterInfo());
		lblMonsterIcon_2.setBounds(218, 114, 108, 119);
		frmChooseAStarter.getContentPane().add(lblMonsterIcon_2);
		
		JLabel lblMonsterIcon_3 = new JLabel("");
		lblMonsterIcon_3.setIcon(new ImageIcon(ChooseStarterScreen.class.getResource("/Images/Monster/Skeleton.png")));
		lblMonsterIcon_3.setToolTipText(skeleton.getMonsterInfo());
		lblMonsterIcon_3.setBounds(483, 101, 141, 132);
		frmChooseAStarter.getContentPane().add(lblMonsterIcon_3);
		
		JLabel lblMonsterIcon_4 = new JLabel("");
		lblMonsterIcon_4.setIcon(new ImageIcon(ChooseStarterScreen.class.getResource("/Images/Monster/Ghost.png")));
		lblMonsterIcon_4.setToolTipText(ghost.getMonsterInfo());
		lblMonsterIcon_4.setBounds(344, 105, 128, 144);
		frmChooseAStarter.getContentPane().add(lblMonsterIcon_4);
		
		textField = new JTextField();
		textField.setBounds(269, 277, 128, 19);
		frmChooseAStarter.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Enter a name for your monster:");
		lblNewLabel_4.setBounds(29, 277, 235, 16);
		frmChooseAStarter.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(29, 255, 497, 15);
		frmChooseAStarter.getContentPane().add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Bat");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = bat;
				textField.setText(selectedMonster.getMonsterName());
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(66, 69, 49, 23);
		frmChooseAStarter.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Slime");
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = slime;
				textField.setText(selectedMonster.getMonsterName());
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(228, 69, 69, 23);
		frmChooseAStarter.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Ghost");
		rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = ghost;
				textField.setText(selectedMonster.getMonsterName());
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(369, 69, 76, 23);
		frmChooseAStarter.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Skeleton");
		rdbtnNewRadioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMonster = skeleton;
				textField.setText(selectedMonster.getMonsterName());
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(502, 69, 94, 23);
		frmChooseAStarter.getContentPane().add(rdbtnNewRadioButton_3);
		
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
		frmChooseAStarter.getContentPane().add(btnNewButton);
	}
}
