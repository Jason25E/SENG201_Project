import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class SelectBattleScreen {

	private JFrame frame;
	
	private GameManager manager;
	private Monster selectedEnemy = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectBattleScreen window = new SelectBattleScreen();
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
	public SelectBattleScreen() {
		initialize();
	}
	
	public SelectBattleScreen(GameManager manager) {
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
		 * Initialize the enemy Monsters that can be battle against.
		 */
		ArrayList<Monster> EnemyMonsterList = new ArrayList<Monster>();
		Skill batSkill = new Skill("Bit", "Has a base power of 12", 12);
		Monster bat = new Monster("Bat", "Bat", "Common", 20, 10, 100, 20, batSkill);
		
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", "Common", 10, 10, 100, 40, slimeSkill);
		
		Skill ghostSkill = new Skill("Dive", "Has a base power of 12", 12);
		Monster ghost = new Monster("Ghost", "Ghost", "Common", 10, 20, 100, 20, ghostSkill);
		
		Skill skeletonSkill = new Skill("Slash", "Has a base power of 12", 12);
		Monster skeleton = new Monster("Skeleton", "Skeleton", "Common", 20, 20, 100, 10, skeletonSkill);
		
		Skill witchSkill = new Skill("Thunder", "Has a base power of 12", 12);
		Monster witch = new Monster("Witch", "Witch", "Common", 30, 10, 80, 20, witchSkill);
		
		Skill demonSkill = new Skill("Inferno", "Has a base power of 14", 14);
		Monster demon = new Monster("Demon", "Demon", "Common", 20, 10, 100, 20, demonSkill);
		
		Skill redDragonSkill = new Skill("Slash", "Has a base power of 15", 15);
		Monster redDragon = new Monster("RedDragons", "RedDragons", "Rare", 20, 10, 100, 20, redDragonSkill);
		
		Skill greenDragonSkill = new Skill("S.Slash", "Has a base power of 16", 16);
		Monster greenDragon = new Monster("GreenDragons", "GreenDragons", "S.Rare", 10, 10, 100, 40, greenDragonSkill);
		
		Skill blueDragonSkill = new Skill("SS.Slash", "Has a base power of 18", 18);
		Monster blueDragon = new Monster("BlueDragons", "BlueDragons", "SS.Rare", 10, 20, 100, 20, blueDragonSkill);
		
		EnemyMonsterList.add(bat);
		EnemyMonsterList.add(slime);
		EnemyMonsterList.add(ghost);
		EnemyMonsterList.add(skeleton);
		EnemyMonsterList.add(witch);
		EnemyMonsterList.add(demon);
		EnemyMonsterList.add(redDragon);
		EnemyMonsterList.add(greenDragon);
		EnemyMonsterList.add(blueDragon);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**
		 * First Enemy
		 */
		Monster firstEnemy = EnemyMonsterList.get(manager.RandomEnemy);
		String firstEnemyName = firstEnemy.getMonsterID();
		JRadioButton rdbtnMonster = new JRadioButton(firstEnemyName);
		rdbtnMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedEnemy = firstEnemy;
			}
		});
		
		String imageSourceOne = "/Images/Monster/" + firstEnemyName + ".png";
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(imageSourceOne)));
		label.setBounds(12, 54, 130, 120);
		frame.getContentPane().add(label);
		
		rdbtnMonster.setForeground(Color.BLACK);
		rdbtnMonster.setBounds(12, 8, 130, 38);
		frame.getContentPane().add(rdbtnMonster);
		
		/**
		 * Second Enemy
		 */
		Monster secondEnemy = EnemyMonsterList.get(manager.RandomEnemyTwo);
		String secondEnemyName = secondEnemy.getMonsterID();
		JRadioButton rdbtnMonster_1 = new JRadioButton(secondEnemyName);
		rdbtnMonster_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedEnemy = secondEnemy;
			}
		});
		
		String imageSourceTwo = "/Images/Monster/" + secondEnemyName + ".png";
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(imageSourceTwo)));
		label_1.setBounds(235, 54, 130, 120);
		frame.getContentPane().add(label_1);
		
		rdbtnMonster_1.setForeground(Color.BLACK);
		rdbtnMonster_1.setBounds(235, 8, 130, 38);
		frame.getContentPane().add(rdbtnMonster_1);
		
		/**
		 * Third Enemy
		 */
		Monster thirdEnemy = EnemyMonsterList.get(manager.RandomEnemyThree);
		String thirdEnemyName = thirdEnemy.getMonsterID();
		JRadioButton rdbtnMonster_2 = new JRadioButton(thirdEnemyName);
		rdbtnMonster_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedEnemy = thirdEnemy;
			}
		});
		
		String imageSourceThree = "/Images/Monster/" + thirdEnemyName + ".png";
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(imageSourceThree)));
		label_2.setBounds(450, 54, 130, 120);
		frame.getContentPane().add(label_2);
		
		rdbtnMonster_2.setForeground(Color.BLACK);
		rdbtnMonster_2.setBounds(450, 8, 130, 38);
		frame.getContentPane().add(rdbtnMonster_2);
		
		/**
		 * Other Functions
		 */
		JButton btnExit_1 = new JButton("Battle!");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchBattleScreen();
			}
		});
		btnExit_1.setBounds(27, 229, 130, 30);
		frame.getContentPane().add(btnExit_1);
		
		JButton btnBuy = new JButton("Exit");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
			}
		});
		btnBuy.setBounds(446, 229, 130, 30);
		frame.getContentPane().add(btnBuy);
	}
}
