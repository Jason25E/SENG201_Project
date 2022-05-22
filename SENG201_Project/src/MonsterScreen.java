import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MonsterScreen {

	private JFrame frmMyMonsters;
	
	private GameManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonsterScreen window = new MonsterScreen();
					window.frmMyMonsters.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MonsterScreen() {
		initialize();
	}
	
	public MonsterScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmMyMonsters.setVisible(true);
	}
	
	public void closeWindow() {
		frmMyMonsters.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyMonsters = new JFrame();
		frmMyMonsters.setTitle("My Monster");
		frmMyMonsters.setBounds(100, 100, 301, 417);
		frmMyMonsters.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyMonsters.getContentPane().setLayout(null);
		
		JLabel lblShowInfoAbout = new JLabel("Show info about the skill/equip.");
		lblShowInfoAbout.setBounds(32, 320, 238, 15);
		frmMyMonsters.getContentPane().add(lblShowInfoAbout);
		
		/**
		 * First Monster
		 */
		JLabel label = new JLabel("1");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(25, 17, 50, 50);
		frmMyMonsters.getContentPane().add(label);
		
		Monster firstMonster = manager.getPlayer().getMonsterList().get(0);
		String monsterNameOne = firstMonster.getMonsterName();
		JCheckBox cbMonster = new JCheckBox(monsterNameOne);
		cbMonster.setBounds(63, 8, 109, 32);
		frmMyMonsters.getContentPane().add(cbMonster);
		
		if (firstMonster.getMonsterEquipment() != null) {
			/**
			 * Display the equipment of the first Monster if it has one
			 */
			Equipment equipmentOne = firstMonster.getMonsterEquipment();
			String equipmentNameOne = equipmentOne.getItemID();
			JButton btnEquipment = new JButton(equipmentNameOne);
			btnEquipment.addActionListener(new ActionListener() {
				/**
				 * Display the equipment effect of the first Monster has
				 */
				public void actionPerformed(ActionEvent arg0) {
					lblShowInfoAbout.setText(equipmentOne.getItemEffect());
				}
			});
			btnEquipment.setBounds(178, 48, 109, 25);
			frmMyMonsters.getContentPane().add(btnEquipment);
		}

		Skill skillOne = firstMonster.getMonsterSkill();
		String skillNameOne = skillOne.getSkillName();
		JButton btnSkill = new JButton(skillNameOne);
		btnSkill.addActionListener(new ActionListener() {
			/**
			 * Display the skill effect of first Monster has
			 */
			public void actionPerformed(ActionEvent arg0) {
				lblShowInfoAbout.setText(skillOne.getSkillEffect());
			}
		});
		btnSkill.setBounds(63, 48, 109, 25);
		frmMyMonsters.getContentPane().add(btnSkill);
		
		String imageSourceOne = "/Images/Monster/" + firstMonster.getMonsterID() + ".png";
		JLabel lblMonsterIcon = new JLabel();
		lblMonsterIcon.setIcon(new ImageIcon(MonsterScreen.class.getResource(imageSourceOne)));
		lblMonsterIcon.setToolTipText(firstMonster.getMonsterInfo());
		lblMonsterIcon.setBounds(171, 8, 116, 65);
		frmMyMonsters.getContentPane().add(lblMonsterIcon);

		/**
		 * Second Monster
		 */
		JLabel label_1 = new JLabel("2");
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setBounds(25, 94, 50, 50);
		frmMyMonsters.getContentPane().add(label_1);
		JCheckBox cbMonster_2 = new JCheckBox("Null");
		
		if (manager.getPlayer().getMonsterList().size() >= 2) {
			/**
			 * Try to get and set the info for second Monster only if it the player have the second Monster in the Monster Array
			 */
			Monster secondMonster = manager.getPlayer().getMonsterList().get(1);
			String monsterNameTwo = secondMonster.getMonsterName();
			cbMonster_2.setText(monsterNameTwo);
			cbMonster_2.setBounds(63, 85, 109, 32);
			frmMyMonsters.getContentPane().add(cbMonster_2);
			
			Skill skillTwo = secondMonster.getMonsterSkill();
			String skillNameTwo = skillTwo.getSkillName();
			JButton btnSKill2 = new JButton(skillNameTwo);
			btnSKill2.addActionListener(new ActionListener() {
				/**
				 * Display the skill effect of second Monster has
				 */
				public void actionPerformed(ActionEvent arg0) {
					lblShowInfoAbout.setText(skillTwo.getSkillEffect());
				}
			});
			btnSKill2.setBounds(63, 125, 109, 25);
			frmMyMonsters.getContentPane().add(btnSKill2);
			
			if (secondMonster.getMonsterEquipment() != null) {
				/**
				 * Display the equipment of the second Monster if it has one
				 */
				Equipment equipmentTwo = secondMonster.getMonsterEquipment();
				String equipmentNameTwo = equipmentTwo.getItemID();
				JButton btnEquipment_2 = new JButton(equipmentNameTwo);
				btnEquipment_2.addActionListener(new ActionListener() {
					/**
					 * Display the equipment effect of second Monster has
					 */
					public void actionPerformed(ActionEvent arg0) {
						lblShowInfoAbout.setText(equipmentTwo.getItemEffect());
					}
				});
				btnEquipment_2.setBounds(178, 125, 109, 25);
				frmMyMonsters.getContentPane().add(btnEquipment_2);
			}
			
			String imageSourceTwo = "/Images/Monster/" + secondMonster.getMonsterID() + ".png";
			JLabel lblMonsterIcon_2 = new JLabel();
			lblMonsterIcon_2.setIcon(new ImageIcon(MonsterScreen.class.getResource(imageSourceTwo)));
			lblMonsterIcon_2.setToolTipText(secondMonster.getMonsterInfo());
			lblMonsterIcon_2.setBounds(178, 85, 116, 65);
			frmMyMonsters.getContentPane().add(lblMonsterIcon_2);
		}
		
		/**
		 * Third monster
		 */
		JLabel label_2 = new JLabel("3");
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(25, 171, 50, 50);
		frmMyMonsters.getContentPane().add(label_2);
		JCheckBox cbMonster_3 = new JCheckBox("Null");
		
		if (manager.getPlayer().getMonsterList().size() >= 3) {
			/**
			 * Try to get and set the info for third Monster only if it the player have the third Monster in the Monster Array
			 */
			Monster thirdMonster = manager.getPlayer().getMonsterList().get(2);
			String monsterNameThird = thirdMonster.getMonsterName();
			cbMonster_3.setText(monsterNameThird);
			cbMonster_3.setBounds(63, 162, 109, 32);
			frmMyMonsters.getContentPane().add(cbMonster_3);
			
			Skill skillThree = thirdMonster.getMonsterSkill();
			String skillNameThree = skillThree.getSkillName();
			JButton btnSkill3= new JButton(skillNameThree);
			btnSkill3.addActionListener(new ActionListener() {
				/**
				 * Display the skill effect of third Monster has
				 */
				public void actionPerformed(ActionEvent arg0) {
					lblShowInfoAbout.setText(skillThree.getSkillEffect());
				}
			});
			btnSkill3.setBounds(63, 202, 109, 25);
			frmMyMonsters.getContentPane().add(btnSkill3);
			
			if (thirdMonster.getMonsterEquipment() != null) {
				/**
				 * Display the equipment of the third Monster if it has one
				 */
				Equipment equipmentThree = thirdMonster.getMonsterEquipment();
				String equipmentNameThree = equipmentThree.getItemID();
				JButton btnEquipment_3 = new JButton(equipmentNameThree);
				btnEquipment_3.addActionListener(new ActionListener() {
					/**
					 * Display the equipment effect of third Monster has
					 */
					public void actionPerformed(ActionEvent arg0) {
						lblShowInfoAbout.setText(equipmentThree.getItemEffect());
					}
				});
				btnEquipment_3.setBounds(178, 202, 109, 25);
				frmMyMonsters.getContentPane().add(btnEquipment_3);
			}

			
			String imageSourceThree = "/Images/Monster/" + thirdMonster.getMonsterID() + ".png";
			JLabel lblMonsterIcon_3 = new JLabel();
			lblMonsterIcon_3.setIcon(new ImageIcon(MonsterScreen.class.getResource(imageSourceThree)));
			lblMonsterIcon_3.setToolTipText(thirdMonster.getMonsterInfo());
			lblMonsterIcon_3.setBounds(171, 162, 116, 65);
			frmMyMonsters.getContentPane().add(lblMonsterIcon_3);
		}
		
		/**
		 * Fourth monster
		 */
		JLabel label_3 = new JLabel("4");
		label_3.setFont(new Font("Dialog", Font.BOLD, 20));
		label_3.setBounds(25, 248, 50, 50);
		frmMyMonsters.getContentPane().add(label_3);
		JCheckBox cbMonster_4 = new JCheckBox("Null");
		
		if (manager.getPlayer().getMonsterList().size() >= 4) {
			/**
			 * Try to get and set the info for fourth Monster only if it the player have the fourth Monster in the Monster Array
			 */
			Monster fourthMonster = manager.getPlayer().getMonsterList().get(3);
			String monsterNameFour = fourthMonster.getMonsterName();
			cbMonster_4.setText(monsterNameFour);
			cbMonster_4.setBounds(63, 239, 109, 32);
			frmMyMonsters.getContentPane().add(cbMonster_4);
			
			Skill skillFour = fourthMonster.getMonsterSkill();
			String skillNameFour = skillFour.getSkillName();
			JButton btnSkill4 = new JButton(skillNameFour);
			btnSkill4.addActionListener(new ActionListener() {
				/**
				 * Display the skill effect of fourth Monster has
				 */
				public void actionPerformed(ActionEvent arg0) {
					lblShowInfoAbout.setText(skillFour.getSkillEffect());
				}
			});
			btnSkill4.setBounds(63, 279, 109, 25);
			frmMyMonsters.getContentPane().add(btnSkill4);
			
			if (fourthMonster.getMonsterEquipment() != null) {
				/**
				 * Display the equipment of the fourth Monster if it has one
				 */
				Equipment equipmentFour = fourthMonster.getMonsterEquipment();
				String equipmentNameFour = equipmentFour.getItemID();
				JButton btnEquipment_4 = new JButton(equipmentNameFour);
				btnEquipment_4.addActionListener(new ActionListener() {
					/**
					 * Display the equipment effect of fourth Monster has
					 */
					public void actionPerformed(ActionEvent arg0) {
						lblShowInfoAbout.setText(equipmentFour.getItemEffect());
					}
				});
				btnEquipment_4.setBounds(178, 279, 109, 25);
				frmMyMonsters.getContentPane().add(btnEquipment_4);
			}

			String imageSourceFour= "/Images/Monster/" + fourthMonster.getMonsterID() + ".png";
			JLabel lblMonsterIcon_4 = new JLabel();
			lblMonsterIcon_4.setIcon(new ImageIcon(MonsterScreen.class.getResource(imageSourceFour)));
			lblMonsterIcon_4.setToolTipText(fourthMonster.getMonsterInfo());
			lblMonsterIcon_4.setBounds(171, 239, 116, 65);
			frmMyMonsters.getContentPane().add(lblMonsterIcon_4);
		}
		
		/**
		 * Other functions
		 */
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Dialog", Font.BOLD, 11));
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(35, 335, 250, 15);
		frmMyMonsters.getContentPane().add(lblMessage);
		
		JButton btnEquipment_1_3_1 = new JButton("Swap Order");
		btnEquipment_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Swap the order of the two Monsters that is selected.
				 */
				int numberOfselectedMonster = 0;
				int swapMonster = 5;
				int swapMonsterTwo = 5;
				if (cbMonster.isSelected() == true) {
					numberOfselectedMonster += 1;
					if (swapMonster == 5) {
						swapMonster = 0;
					}
				} if (cbMonster_2.isSelected() == true) {
					numberOfselectedMonster += 1;
					if (swapMonster == 5) {
						swapMonster = 1;
					} else if (swapMonsterTwo == 5) {
						swapMonsterTwo = 1;
					}
				} if (cbMonster_3.isSelected() == true) {
					numberOfselectedMonster += 1;
					if (swapMonster == 5) {
						swapMonster = 2;
					} else if (swapMonsterTwo == 5) {
						swapMonsterTwo = 2;
					}
				} if (cbMonster_4.isSelected() == true) {
					numberOfselectedMonster += 1;
					if (swapMonster == 5) {
						swapMonster = 3;
					} else if (swapMonsterTwo == 5) {
						swapMonsterTwo = 3;
					}
				}
				
				if (numberOfselectedMonster == 2) {
					Collections.swap(manager.getPlayer().getMonsterList(), swapMonster, swapMonsterTwo);
					manager.launchMonsterScreen();
					closeWindow();
				} else {
					lblMessage.setText("Please select only two Monsters");
				}
			}
		});
		btnEquipment_1_3_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEquipment_1_3_1.setBounds(12, 351, 130, 25);
		frmMyMonsters.getContentPane().add(btnEquipment_1_3_1);
		
		JButton btnEquipment_4_1 = new JButton("Exit");
		btnEquipment_4_1.setForeground(new Color(255, 255, 255));
		btnEquipment_4_1.setBackground(new Color(255, 51, 102));
		btnEquipment_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
				closeWindow();
			}
		});
		btnEquipment_4_1.setBounds(157, 351, 130, 25);
		frmMyMonsters.getContentPane().add(btnEquipment_4_1);
	}
}