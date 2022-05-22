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
import java.awt.Font;
import javax.swing.ButtonGroup;

public class SelectBattleScreen {

	private JFrame frmSelectBattle;
	
	private GameManager manager;
	private Monster selectedEnemy = null;
	private int enemyIndex = 0;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectBattleScreen window = new SelectBattleScreen();
					window.frmSelectBattle.setVisible(true);
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
		frmSelectBattle.setVisible(true);
	}
	
	public void closeWindow() {
		frmSelectBattle.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Initialize the enemy Monsters that can be battle against.
		 */
		int monsterLevel = manager.getCurrentDay();
		float difficulty = manager.getShop_info();
		int current_day = manager.getCurrentDay();
		ArrayList<Monster> EnemyMonsterList1 = new ArrayList<Monster>();
		ArrayList<Monster> EnemyMonsterList2 = new ArrayList<Monster>();
		int enemy_heal_increase = 0;
		if (current_day > 1) {
			enemy_heal_increase = (current_day - 1) * 10;
		}
		
		
		Skill batSkill = new Skill("Bit", "Has a base power of 12", 12);
		Monster bat = new Monster("Bat", "Bat", monsterLevel, "Common", Math.round(difficulty * (12 + 2 * monsterLevel)), Math.round(difficulty * (15 + 2 * monsterLevel)), 150 + enemy_heal_increase, 20, batSkill);
		
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", monsterLevel, "Common", Math.round(difficulty * (9 + 1 * monsterLevel)), Math.round(difficulty * (17 + 3 * monsterLevel)), 150 + enemy_heal_increase, 40, slimeSkill);
		
		Skill ghostSkill = new Skill("Dive", "Has a base power of 12", 12);
		Monster ghost = new Monster("Ghost", "Ghost", monsterLevel, "Common", Math.round(difficulty * (9 + 2 * monsterLevel)), Math.round(difficulty * (20 + 3 * monsterLevel)), 150 + enemy_heal_increase, 20, ghostSkill);
		
		Skill skeletonSkill = new Skill("Slash", "Has a base power of 12", 12);
		Monster skeleton = new Monster("Skeleton", "Skeleton", monsterLevel, "Common", Math.round(difficulty * (12 + 3 * monsterLevel)), Math.round(difficulty * (20 + 2 * monsterLevel)), 150 + enemy_heal_increase, 10, skeletonSkill);
		
		Skill witchSkill = new Skill("Thunder", "Has a base power of 12", 12);
		Monster witch = new Monster("Witch", "Witch", monsterLevel, "Rare", Math.round(difficulty * (17 + 3 * monsterLevel)), Math.round(difficulty * (15 + 1 * monsterLevel)), 120 + enemy_heal_increase, 20, witchSkill);
		
		Skill demonSkill = new Skill("Inferno", "Has a base power of 14", 14);
		Monster demon = new Monster("Demon", "Demon", monsterLevel, "Rare", Math.round(difficulty * (12 + 2 * monsterLevel)), Math.round(difficulty * (15 + 3 * monsterLevel)), 150 + enemy_heal_increase, 20, demonSkill);
		
		Skill redDragonSkill = new Skill("Slash", "Has a base power of 15", 15);
		Monster redDragon = new Monster("RedDragons", "RedDragons", monsterLevel, "Rare", Math.round(difficulty * (15 + 2 * monsterLevel)), Math.round(difficulty * (20 + 2 * monsterLevel)), 250, 20, redDragonSkill);
		
		Skill greenDragonSkill = new Skill("S.Slash", "Has a base power of 16", 16);
		Monster greenDragon = new Monster("GreenDragons", "GreenDragons", monsterLevel, "S.Rare", Math.round(difficulty * (15 + 2 * monsterLevel)), Math.round(difficulty * (20 + 2 * monsterLevel)), 300, 40, greenDragonSkill);
		
		Skill blueDragonSkill = new Skill("SS.Slash", "Has a base power of 18", 18);
		Monster blueDragon = new Monster("BlueDragons", "BlueDragons", monsterLevel, "SS.Rare", Math.round(difficulty * (15 + 1 * monsterLevel)), Math.round(difficulty * (20 + 1 * monsterLevel)), 500, 20, blueDragonSkill);
		
		EnemyMonsterList1.add(bat);
		EnemyMonsterList1.add(slime);
		EnemyMonsterList1.add(ghost);
		EnemyMonsterList1.add(skeleton);
		EnemyMonsterList1.add(witch);
		EnemyMonsterList1.add(demon);
		EnemyMonsterList2.add(redDragon);
		EnemyMonsterList2.add(greenDragon);
		EnemyMonsterList2.add(blueDragon);
		
		frmSelectBattle = new JFrame();
		frmSelectBattle.setTitle("Select Battle");
		frmSelectBattle.setBounds(100, 100, 590, 302);
		frmSelectBattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSelectBattle.getContentPane().setLayout(null);
		
		JLabel lblMessage = new JLabel();
		lblMessage.setFont(new Font("Dialog", Font.BOLD, 11));
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(180, 237, 247, 15);
		frmSelectBattle.getContentPane().add(lblMessage);
		
		/**
		 * First Enemy
		 */
		Monster RandomEnemyMonster0 = EnemyMonsterList1.get(manager.RandomEnemy);
		if (current_day == 15) {
			RandomEnemyMonster0 = EnemyMonsterList2.get(0);
		}
		
		Monster firstEnemy = RandomEnemyMonster0; 
		String firstEnemyName = firstEnemy.getMonsterID();
		JRadioButton rdbtnMonster = new JRadioButton(firstEnemyName);
		buttonGroup.add(rdbtnMonster);
		rdbtnMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedEnemy = firstEnemy;
				enemyIndex = 1;
			}
		});
		
		String imageSourceOne = "/Images/Monster/" + firstEnemyName + ".png";
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(imageSourceOne)));
		label.setBounds(15, 86, 130, 120);
		frmSelectBattle.getContentPane().add(label);
		
		rdbtnMonster.setForeground(Color.BLACK);
		rdbtnMonster.setBounds(15, 40, 130, 38);
		frmSelectBattle.getContentPane().add(rdbtnMonster);
		
		/**
		 * Second Enemy
		 */
		Monster RandomEnemyMonster1 = EnemyMonsterList1.get(manager.RandomEnemyTwo);
		if (current_day == 15) {
			RandomEnemyMonster1 = EnemyMonsterList2.get(1);
		}
		
		Monster secondEnemy = RandomEnemyMonster1;
		String secondEnemyName = secondEnemy.getMonsterID();
		JRadioButton rdbtnMonster_1 = new JRadioButton(secondEnemyName);
		buttonGroup.add(rdbtnMonster_1);
		rdbtnMonster_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedEnemy = secondEnemy;
				enemyIndex = 2;
			}
		});
		
		String imageSourceTwo = "/Images/Monster/" + secondEnemyName + ".png";
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(imageSourceTwo)));
		label_1.setBounds(231, 86, 130, 120);
		frmSelectBattle.getContentPane().add(label_1);
		
		rdbtnMonster_1.setForeground(Color.BLACK);
		rdbtnMonster_1.setBounds(231, 40, 130, 38);
		frmSelectBattle.getContentPane().add(rdbtnMonster_1);
		
		/**
		 * Third Enemy
		 */
		Monster RandomEnemyMonster2 = EnemyMonsterList1.get(manager.RandomEnemyThree);
		if (current_day == 5) {
			RandomEnemyMonster2 = EnemyMonsterList2.get(0);
		} else if (current_day == 10) {
			RandomEnemyMonster2 = EnemyMonsterList2.get(1);
		} else if (current_day == 15) {
			RandomEnemyMonster2 = EnemyMonsterList2.get(2);
		}
		
		Monster thirdEnemy = RandomEnemyMonster2;
		String thirdEnemyName = thirdEnemy.getMonsterID();
		JRadioButton rdbtnMonster_2 = new JRadioButton(thirdEnemyName);
		buttonGroup.add(rdbtnMonster_2);
		rdbtnMonster_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedEnemy = thirdEnemy;
				enemyIndex = 3;
			}
		});
		
		String imageSourceThree = "/Images/Monster/" + thirdEnemyName + ".png";
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SelectBattleScreen.class.getResource(imageSourceThree)));
		label_2.setBounds(446, 86, 130, 120);
		frmSelectBattle.getContentPane().add(label_2);
		
		rdbtnMonster_2.setForeground(Color.BLACK);
		rdbtnMonster_2.setBounds(446, 40, 130, 38);
		frmSelectBattle.getContentPane().add(rdbtnMonster_2);
		
		/**
		 * Other Functions
		 */
		JButton btnExit_1 = new JButton("Battle!");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** Find out which monster can battle in the order they are in the Monster List */
				boolean canBattle = false;
				for (Monster i: manager.getPlayer().getMonsterList()) {
					if (i.getMonsterCurrentHealthPoint() > 0 && canBattle == false) {
						canBattle = true;
					}
				}
				if (canBattle == true) {
					if (enemyIndex == 1 && manager.getBattleEnemy() == false) {
						manager.changeBattleEnemy(true);
						manager.launchBattleScreen(selectedEnemy);
						closeWindow();
					} else if (enemyIndex == 2 && manager.getBattleEnemyTwo() == false) {
						manager.changeBattleEnemyTwo(true);
						manager.launchBattleScreen(selectedEnemy);
						closeWindow();
					} else if (enemyIndex == 3 && manager.getBattleEnemyThree() == false) {
						manager.changeBattleEnemyThree(true);
						manager.launchBattleScreen(selectedEnemy);
						closeWindow();
					} else if (enemyIndex == 0) {
						lblMessage.setText("Please select an enemy");
					} else {
						lblMessage.setText("You already battle this enemy today");
					}
				} else {
					lblMessage.setText("No Monster can battle");
				}
			}
		});
		btnExit_1.setBounds(27, 229, 130, 30);
		frmSelectBattle.getContentPane().add(btnExit_1);
		
		JButton btnBuy = new JButton("Exit");
		btnBuy.setForeground(new Color(255, 255, 255));
		btnBuy.setBackground(new Color(255, 51, 102));
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
				closeWindow();
			}
		});
		btnBuy.setBounds(430, 229, 130, 30);
		frmSelectBattle.getContentPane().add(btnBuy);
		
		JLabel lblChooseAEnemy = new JLabel("Choose a enemy to battle");
		lblChooseAEnemy.setFont(new Font("Dialog", Font.BOLD, 14));
		lblChooseAEnemy.setBounds(186, 18, 215, 15);
		frmSelectBattle.getContentPane().add(lblChooseAEnemy);
		

	}
}
