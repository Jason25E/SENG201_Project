import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class BattleScreen {

	private JFrame frmBattle;
	
	private GameManager manager;
	private Monster currentMonster = null;
	private Monster enemy = null;
	
	private int MyMonsterPower = 15;
	private int MyMonsterSkillPower = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleScreen window = new BattleScreen();
					window.frmBattle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BattleScreen() {
		initialize();
	}
	
	public BattleScreen(GameManager manager, Monster enemy) {
		this.manager = manager;
		this.enemy = enemy;
		initialize();
		frmBattle.setVisible(true);
	}
	
	public void closeWindow() {
		frmBattle.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBattle = new JFrame();
		frmBattle.setTitle("Battle");
		frmBattle.setBounds(100, 100, 450, 313);
		frmBattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattle.getContentPane().setLayout(null);
		
		/**
		 * Description of what happen in the battle
		 */
		JLabel lblDescription = new JLabel("");
		lblDescription.setBounds(34, 192, 378, 15);
		frmBattle.getContentPane().add(lblDescription);
		
		JLabel lblDescription_2 = new JLabel("");
		lblDescription_2.setBounds(34, 210, 378, 15);
		frmBattle.getContentPane().add(lblDescription_2);
		
		/**
		 * My Monster
		 */
		/** Find out which monster can battle in the order they are in the Monster List */
		currentMonster = manager.getPlayer().firstMonsterCanBattle();
		
		if (currentMonster != null) {
			currentMonster.addBattleAmountToday();
			/** Set and display the name of my Monster that currently in battle */
			String myMonsterName = currentMonster.getMonsterName();
			JLabel lblMyMonsterName = new JLabel(myMonsterName);
			lblMyMonsterName.setBounds(22, 12, 106, 15);
			frmBattle.getContentPane().add(lblMyMonsterName);
			
			/** Set and display the Health Point of my Monster that currently in battle */
			String myMonsterHP = "HP:  " + currentMonster.getMonsterCurrentHealthPoint() + "/" + currentMonster.getMonsterMaxHealthPoint();
			JLabel lblMyMonsterHP = new JLabel(myMonsterHP);
			lblMyMonsterHP.setBounds(22, 33, 99, 15);
			frmBattle.getContentPane().add(lblMyMonsterHP);
			
			/** Set and display the icon of my Monster that currently in battle */
			String myMonsterIcon = "/Images/MonsterFlip/" + currentMonster.getMonsterID() + ".png";
			JLabel lblMyMonsterIcon = new JLabel("");
			lblMyMonsterIcon.setIcon(new ImageIcon(BattleScreen.class.getResource(myMonsterIcon)));
			lblMyMonsterIcon.setBounds(21, 60, 130, 120);
			frmBattle.getContentPane().add(lblMyMonsterIcon);
			
			/**
			 * Enemy
			 */
			/** Set and display the name of enemy */
			String enemyName = enemy.getMonsterID();
			JLabel lblEnemyName = new JLabel(enemyName);
			lblEnemyName.setBounds(314, 12, 122, 15);
			frmBattle.getContentPane().add(lblEnemyName);
			
			/** Set and display the Health Point of enemy */
			String enemyHP = "HP:  " + enemy.getMonsterCurrentHealthPoint() + "/" + enemy.getMonsterMaxHealthPoint();
			JLabel lblEnemyHP = new JLabel(enemyHP);
			lblEnemyHP.setBounds(314, 33, 111, 15);
			frmBattle.getContentPane().add(lblEnemyHP);
			
			/** Set and display the icon of enemy */
			String enemyIcon = "/Images/Monster/" + enemyName + ".png";
			JLabel lblEnemyIcon = new JLabel("");
			lblEnemyIcon.setIcon(new ImageIcon(BattleScreen.class.getResource(enemyIcon)));
			lblEnemyIcon.setBounds(295, 60, 130, 120);
			frmBattle.getContentPane().add(lblEnemyIcon);
			
			/**
			 * Battle system
			 */
			/**
			 * Skill
			 */
			String skillPower = "Power " + currentMonster.getMonsterSkill().getSkillDamage() * MyMonsterSkillPower;
			JLabel lblSkillPower = new JLabel(skillPower);
			lblSkillPower.setFont(new Font("Dialog", Font.BOLD, 10));
			lblSkillPower.setBounds(200, 265, 70, 15);
			frmBattle.getContentPane().add(lblSkillPower);
			
			String skillName = currentMonster.getMonsterSkill().getSkillName();
			JButton btnSkill = new JButton(skillName);
			btnSkill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					/** Calculate the damage deals to each other */
					int enemyPower = (int)((Math.random() * (18)) + 12);
					int damageDealToEnemy = (MyMonsterPower * currentMonster.getMonsterAttack() * currentMonster.getMonsterSkill().getSkillDamage() * MyMonsterSkillPower / 80) - (enemy.getMonsterDefence() / 10);
					int damageDealByEnemy = enemyPower * enemy.getMonsterAttack() / 10 - (currentMonster.getMonsterDefence() / 10);
					
					/** Apply the damage */
					currentMonster.reduceCurrentHealthPoint(damageDealByEnemy);
					enemy.reduceCurrentHealthPoint(damageDealToEnemy);
					
					/** Display what happen */
					lblDescription.setText("" + currentMonster.getMonsterName() +" deals " + damageDealToEnemy + " damage to " + enemy.getMonsterName());
					lblDescription_2.setText("" + enemy.getMonsterName() +" deals " + damageDealByEnemy + " damage to " + currentMonster.getMonsterName());
					
					/** Display the Health Point after the damage */
					String myMonsterHP = "HP:  " + currentMonster.getMonsterCurrentHealthPoint() + "/" + currentMonster.getMonsterMaxHealthPoint();
					lblMyMonsterHP.setText(myMonsterHP);
					String enemyHP = "HP:  " + enemy.getMonsterCurrentHealthPoint() + "/" + enemy.getMonsterMaxHealthPoint();
					lblEnemyHP.setText(enemyHP);
					
					/** Set skill power back to 1 and reload its power */
					MyMonsterSkillPower = 1;
					lblSkillPower.setText("Power " + currentMonster.getMonsterSkill().getSkillDamage() * MyMonsterSkillPower);
					
					if (enemy.getMonsterCurrentHealthPoint() == 0) {
						manager.launchBattleResultScreen(enemy, BattleScreen.this);
					} else if (currentMonster.getMonsterCurrentHealthPoint() == 0) {
						currentMonster.setfaintedToday(true);
						if (manager.getPlayer().canMonstersBattle() == true) {
							manager.launchBattleScreen(enemy);
							closeWindow();
						} else {
							manager.launchBattleResultScreen(enemy, BattleScreen.this);
						}
					}
				}
			});
			btnSkill.setToolTipText("Reset skill power after use skill");
			btnSkill.setBounds(166, 237, 117, 25);
			frmBattle.getContentPane().add(btnSkill);
			
			/**
			 * Attack
			 */
			JLabel lblAttackPower = new JLabel("Power " + MyMonsterPower);
			lblAttackPower.setFont(new Font("Dialog", Font.BOLD, 10));
			lblAttackPower.setBounds(68, 265, 70, 15);
			frmBattle.getContentPane().add(lblAttackPower);
			
			JButton btnAttack = new JButton("Attack");
			btnAttack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					/** Calculate the damage deals to each other */
					int enemyPower = (int)((Math.random() * (13)) + 9);
					int damageDealToEnemy = (MyMonsterPower * currentMonster.getMonsterAttack() / 10) - (enemy.getMonsterDefence() / 5);
					int damageDealByEnemy = enemyPower * enemy.getMonsterAttack() / 10 - (currentMonster.getMonsterDefence() / 2);
					
					/** Apply the damage */
					currentMonster.reduceCurrentHealthPoint(damageDealByEnemy);
					enemy.reduceCurrentHealthPoint(damageDealToEnemy);
					
					/** Display what happen */
					lblDescription.setText("" + currentMonster.getMonsterName() +" deals " + damageDealToEnemy + " damage to " + enemy.getMonsterName());
					lblDescription_2.setText("" + enemy.getMonsterName() +" deals " + damageDealByEnemy + " damage to " + currentMonster.getMonsterName());
					
					/** Display the Health Point after the damage */
					String myMonsterHP = "HP:  " + currentMonster.getMonsterCurrentHealthPoint() + "/" + currentMonster.getMonsterMaxHealthPoint();
					lblMyMonsterHP.setText(myMonsterHP);
					String enemyHP = "HP:  " + enemy.getMonsterCurrentHealthPoint() + "/" + enemy.getMonsterMaxHealthPoint();
					lblEnemyHP.setText(enemyHP);
					
					/** Increase the power of skill and reload its power */
					MyMonsterSkillPower += 1;
					lblSkillPower.setText("Power " + currentMonster.getMonsterSkill().getSkillDamage() * MyMonsterSkillPower);
					
					if (enemy.getMonsterCurrentHealthPoint() == 0) {
						manager.launchBattleResultScreen(enemy, BattleScreen.this);
					} else if (currentMonster.getMonsterCurrentHealthPoint() == 0) {
						currentMonster.setfaintedToday(true);
						if (manager.getPlayer().canMonstersBattle() == true) {
							manager.launchBattleScreen(enemy);
							closeWindow();
						} else {
							manager.launchBattleResultScreen(enemy, BattleScreen.this);
						}
					}
				}
			});
			btnAttack.setToolTipText("Increase power of skill after attack");
			btnAttack.setBounds(34, 237, 117, 25);
			frmBattle.getContentPane().add(btnAttack);
			
			/**
			 * Defense
			 */
			JButton btnDefence = new JButton("Defence");
			btnDefence.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					/** Calculate the damage deals to each other */
					int enemyPower = (int)((Math.random() * (18)) + 12);
					int damageDealToEnemy = 0;
					int damageDealByEnemy = (enemyPower * enemy.getMonsterAttack() / 10 - (currentMonster.getMonsterDefence() / 10)) - currentMonster.getMonsterDefence() * 2;
					if (damageDealByEnemy < 5) {
						damageDealByEnemy = 5;
					}
					
					/** Apply the damage */
					currentMonster.reduceCurrentHealthPoint(damageDealByEnemy);
					enemy.reduceCurrentHealthPoint(damageDealToEnemy);
					
					/** Display what happen */
					lblDescription.setText("" + currentMonster.getMonsterName() +" deals " + damageDealToEnemy + " damage to " + enemy.getMonsterName());
					lblDescription_2.setText("" + enemy.getMonsterName() +" deals " + damageDealByEnemy + " damage to " + currentMonster.getMonsterName());
					
					/** Display the Health Point after the damage */
					String myMonsterHP = "HP:  " + currentMonster.getMonsterCurrentHealthPoint() + "/" + currentMonster.getMonsterMaxHealthPoint();
					lblMyMonsterHP.setText(myMonsterHP);
		
					
					/** Increase or set the power of skill back to 1 and reload its power */
					int random = (int)((Math.random() * (2 - 0)) + 0);
					if (random == 1) {
						MyMonsterSkillPower += 1;
					} else {
						MyMonsterSkillPower = 1;
					}
					lblSkillPower.setText("Power " + currentMonster.getMonsterSkill().getSkillDamage() * MyMonsterSkillPower);
					
					if (currentMonster.getMonsterCurrentHealthPoint() == 0) {
						currentMonster.setfaintedToday(true);
						if (manager.getPlayer().canMonstersBattle() == false) {
							manager.launchBattleResultScreen(enemy, BattleScreen.this);
						} else {
							manager.launchBattleScreen(enemy);
							closeWindow();
						}
					}
				}
			});
			btnDefence.setToolTipText("50% increase or reset power of skill after defence");
			btnDefence.setBounds(295, 237, 117, 25);
			frmBattle.getContentPane().add(btnDefence);
			
			JLabel lblDefenceStrength = new JLabel("Block " + currentMonster.getMonsterDefence() * 2 + " Dmg");
			lblDefenceStrength.setFont(new Font("Dialog", Font.BOLD, 10));
			lblDefenceStrength.setBounds(315, 265, 100, 15);
			frmBattle.getContentPane().add(lblDefenceStrength);
			
			} else {
				manager.launchBattleResultScreen(enemy, BattleScreen.this);
			}
		}


}
