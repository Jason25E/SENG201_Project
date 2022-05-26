import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * The class SaleMonsterScreen
 * Display all the monster that are in the monster list
 * Can sell monster from the monster list
 * @author fye15, zde19
 *
 */
public class SaleMonsterScreen {

	private JFrame frmSaleMonster;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private GameManager manager;
	private Monster selectedMonster = null;
	
	/**
	 * The variable require one parameter
	 * @param manager of the type GameManager
	 * run the initialize
	 * set the frmMain visible
	 */
	public SaleMonsterScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmSaleMonster.setLocationRelativeTo(null);
		frmSaleMonster.setVisible(true);
	}
	
	/**
	 * The variable 
	 * set the frmMain dispose
	 */
	public void closeWindow() {
		frmSaleMonster.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int MonsterListSize = manager.getPlayer().getMonsterList().size();
		ArrayList<Monster> MonsterList = manager.getPlayer().getMonsterList();
		int monster_selling_info = manager.getMonster_selling_info();
		int current_day = manager.getCurrentDay();
		
		/**
		 * A frame with the title "Sale - Monster"
		 */
		frmSaleMonster = new JFrame();
		frmSaleMonster.setTitle("Sale - Monster");
		frmSaleMonster.setBounds(100, 100, 309, 454);
		frmSaleMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSaleMonster.getContentPane().setLayout(null);
		
		/**
		 * A label recive massage from sale button
		 */
		JLabel label_4 = new JLabel("");
		label_4.setForeground(Color.RED);
		label_4.setBounds(12, 356, 267, 15);
		frmSaleMonster.getContentPane().add(label_4);
		
		/**
		 * Check if the size of the monster list is equals or greater than 1
		 */
		if (MonsterListSize >= 1) {
			/**
			 * Set the first monster to the first monster in the monster list
			 * set skill0 to the monster skill
			 * set MonsterName0 to monster name
			 * set SkillName0 to monster skill name
			 */
			Monster FirstMonster = manager.getPlayer().getMonsterList().get(0);
			Skill Skill0 = FirstMonster.getMonsterSkill();
			String MonsterName0 = FirstMonster.getMonsterName();
			String SkillName0 = Skill0.getSkillName();
			
			/**
			 * Set the label with the calculting MonsterPrice
			 */
			int MonsterPrice0 = (int) (FirstMonster.getMonsterAttack() * 1.5);
			JLabel label = new JLabel("$" + MonsterPrice0);
			label.setFont(new Font("Dialog", Font.BOLD, 15));
			label.setBounds(25, 63, 50, 50);
			frmSaleMonster.getContentPane().add(label);
			
			/**
			 * set the JRadioButton to monster name
			 * set selectedMonster if selected
			 */
			JRadioButton rdbtnMonster = new JRadioButton(MonsterName0);
			buttonGroup.add(rdbtnMonster);
			rdbtnMonster.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedMonster = MonsterList.get(0);

				}
			});
			rdbtnMonster.setBounds(63, 54, 124, 32);
			frmSaleMonster.getContentPane().add(rdbtnMonster);
			
			/**
			 * check if the monster have an equip on them or not
			 * yes, show the button
			 */
			if (FirstMonster.getMonsterEquipment() != null) {
				Equipment Equipment0 = FirstMonster.getMonsterEquipment();
				String EquipmentName0 = Equipment0.getItemID();
				JButton btnEquipment = new JButton(EquipmentName0);
				btnEquipment.setBounds(178, 94, 109, 25);
				frmSaleMonster.getContentPane().add(btnEquipment);
				
			}
			
			/**
			 * Set the button to the monster skill name
			 */
			JButton btnSkill = new JButton(SkillName0);
			btnSkill.setBounds(63, 94, 109, 25);
			frmSaleMonster.getContentPane().add(btnSkill);
			
			/**
			 * Set the label to the monster image 
			 */
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Monster/" + FirstMonster.getMonsterID() + ".png")));
			lblNewLabel.setBounds(171, 54, 116, 65);
			frmSaleMonster.getContentPane().add(lblNewLabel);
			
			
		}
		
		/**
		 * Check if the size of the monster list is equals or greater than 2
		 */
		if (MonsterListSize >= 2) {
			/**
			 * Set the second monster to the second monster in the monster list
			 * set skill0 to the monster skill
			 * set MonsterName0 to monster name
			 * set SkillName0 to monster skill name
			 */
			Monster SecondMonster = manager.getPlayer().getMonsterList().get(1);
			Skill Skill1 = SecondMonster.getMonsterSkill();
			String SkillName1 = Skill1.getSkillName();
			String MonsterName1 = SecondMonster.getMonsterName();
			
			/**
			 * Set the label with the calculting MonsterPrice
			 */
			int MonsterPrice1 = (int) (SecondMonster.getMonsterAttack() * 1.5);
			JLabel label_1 = new JLabel("$" + MonsterPrice1);
			label_1.setFont(new Font("Dialog", Font.BOLD, 15));
			label_1.setBounds(25, 140, 50, 50);
			frmSaleMonster.getContentPane().add(label_1);
			
			/**
			 * Set the button to the monster skill name
			 */
			JButton btnSkill_2= new JButton(SkillName1);
			btnSkill_2.setBounds(63, 171, 109, 25);
			frmSaleMonster.getContentPane().add(btnSkill_2);
			
			/**
			 * set the JRadioButton to monster name
			 * set selectedMonster if selected
			 */
			JRadioButton rdbtnMonster_1 = new JRadioButton(MonsterName1);
			buttonGroup.add(rdbtnMonster_1);
			rdbtnMonster_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedMonster = MonsterList.get(1);

				}
			});
			rdbtnMonster_1.setBounds(63, 131, 124, 32);
			frmSaleMonster.getContentPane().add(rdbtnMonster_1);
			
			/**
			 * check if the monster have an equip on them or not
			 * yes, show the button
			 */
			if (SecondMonster.getMonsterEquipment() != null) {
				Equipment Equipment1 = SecondMonster.getMonsterEquipment();
				String EquipmentName1 = Equipment1.getItemID();
				JButton btnEquipment_2 = new JButton(EquipmentName1);
				btnEquipment_2.setBounds(178, 171, 109, 25);
				frmSaleMonster.getContentPane().add(btnEquipment_2);
			
			}
			
			/**
			 * Set the label to the monster image 
			 */
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Monster/" + SecondMonster.getMonsterID() + ".png")));
			lblNewLabel_1.setBounds(178, 131, 116, 65);
			frmSaleMonster.getContentPane().add(lblNewLabel_1);
			
			
		}
		
		/**
		 * Check if the size of the monster list is equals or greater than 3
		 */
		if (MonsterListSize >= 3) {
			/**
			 * Set the third monster to the third monster in the monster list
			 * set skill0 to the monster skill
			 * set MonsterName0 to monster name
			 * set SkillName0 to monster skill name
			 */
			Monster ThirdMonster = manager.getPlayer().getMonsterList().get(2);
			Skill Skill2 = ThirdMonster.getMonsterSkill();
			String SkillName2 = Skill2.getSkillName();
			String MonsterName2 = ThirdMonster.getMonsterName();
			
			/**
			 * Set the label with the calculting MonsterPrice
			 */
			int MonsterPrice2 = (int) (ThirdMonster.getMonsterAttack() * 1.5);
			JLabel label_2 = new JLabel("$" + MonsterPrice2);
			label_2.setFont(new Font("Dialog", Font.BOLD, 15));
			label_2.setBounds(25, 217, 50, 50);
			frmSaleMonster.getContentPane().add(label_2);
			
			/**
			 * Set the button to the monster skill name
			 */
			JButton btnSkill_3 = new JButton(SkillName2);
			btnSkill_3.setBounds(63, 248, 109, 25);
			frmSaleMonster.getContentPane().add(btnSkill_3);
			
			/**
			 * set the JRadioButton to monster name
			 * set selectedMonster if selected
			 */
			JRadioButton rdbtnMonster_2 = new JRadioButton(MonsterName2);
			buttonGroup.add(rdbtnMonster_2);
			rdbtnMonster_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedMonster = MonsterList.get(2);

				}
			});
			rdbtnMonster_2.setBounds(63, 208, 124, 32);
			frmSaleMonster.getContentPane().add(rdbtnMonster_2);
			
			/**
			 * check if the monster have an equip on them or not
			 * yes, show the button
			 */
			if (ThirdMonster.getMonsterEquipment() != null) {
				Equipment Equipment2 = ThirdMonster.getMonsterEquipment();
				String EquipmentName2 = Equipment2.getItemID();
				JButton btnEquipment_3 = new JButton(EquipmentName2);
				btnEquipment_3.setBounds(178, 248, 109, 25);
				frmSaleMonster.getContentPane().add(btnEquipment_3);
			}
			
			/**
			 * Set the label to the monster image 
			 */
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Monster/" + ThirdMonster.getMonsterID() + ".png")));
			lblNewLabel_2.setBounds(171, 208, 116, 65);
			frmSaleMonster.getContentPane().add(lblNewLabel_2);
			
			
			
		}
		
		/**
		 * Check if the size of the monster list is equals or greater than 4
		 */
		if (MonsterListSize >= 4) {
			/**
			 * Set the fourth monster to the fourth monster in the monster list
			 * set skill0 to the monster skill
			 * set MonsterName0 to monster name
			 * set SkillName0 to monster skill name
			 */
			Monster FourthMonster = manager.getPlayer().getMonsterList().get(3);
			Skill Skill3 = FourthMonster.getMonsterSkill();
			String SkillName3 = Skill3.getSkillName();
			String MonsterName3 = FourthMonster.getMonsterName();
			
			/**
			 * Set the label with the calculting MonsterPrice
			 */
			int MonsterPrice3 = (int) (FourthMonster.getMonsterAttack() * 1.5);
			JLabel label_3 = new JLabel("$" + MonsterPrice3);
			label_3.setFont(new Font("Dialog", Font.BOLD, 15));
			label_3.setBounds(25, 294, 50, 50);
			frmSaleMonster.getContentPane().add(label_3);
			
			/**
			 * Set the button to the monster skill name
			 */
			JButton btnSkill_4= new JButton(SkillName3);
			btnSkill_4.setBounds(63, 325, 109, 25);
			frmSaleMonster.getContentPane().add(btnSkill_4);
			
			/**
			 * set the JRadioButton to monster name
			 * set selectedMonster if selected
			 */
			JRadioButton rdbtnMonster_3 = new JRadioButton(MonsterName3);
			buttonGroup.add(rdbtnMonster_3);
			rdbtnMonster_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedMonster = MonsterList.get(3);

				}
			});
			rdbtnMonster_3.setBounds(63, 285, 124, 32);
			frmSaleMonster.getContentPane().add(rdbtnMonster_3);
			
			/**
			 * check if the monster have an equip on them or not
			 * yes, show the button
			 */
			if (FourthMonster.getMonsterEquipment() != null) {
				Equipment Equipment3 = FourthMonster.getMonsterEquipment();
				String EquipmentName3 = Equipment3.getItemID();
				JButton btnEquipment_4 = new JButton(EquipmentName3);
				btnEquipment_4.setBounds(178, 325, 109, 25);
				frmSaleMonster.getContentPane().add(btnEquipment_4);
			}	
			
			/**
			 * Set the label to the monster image 
			 */
			JLabel lblNewLabel_2_1 = new JLabel("New label");
			lblNewLabel_2_1.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Monster/" + FourthMonster.getMonsterID() + ".png")));
			lblNewLabel_2_1.setBounds(171, 285, 116, 65);
			frmSaleMonster.getContentPane().add(lblNewLabel_2_1);
		}
		
		/**
		 * The button with the name "Exit"
		 * press launch ShopDirectionScreen
		 * close window
		 */
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopDirectionScreen();
				closeWindow();
			}
		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(207, 383, 80, 30);
		frmSaleMonster.getContentPane().add(btnExit);
		
		/**
		 * The button with the name "Sell"
		 */
		JButton btnUse = new JButton("Sell");
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * check if selectedMonster is null
				 * yes, set SalePrice with the calculation, run soldMonster, launch SaleMonsterScreen, close window
				 * no, sent a message to label_4 say "Please select a monster to sale"
				 */
				if (selectedMonster != null) {
					int SalePrice = (int) (selectedMonster.getMonsterLevel() * monster_selling_info + 100 + current_day *2);
					manager.getPlayer().soldMonster(selectedMonster, SalePrice, selectedMonster.getMonsterEquipment());
					manager.launchSaleMonsterScreen();
					closeWindow();
					
				} else {
					label_4.setText("Please select a monster to sale");
				}
			
			}
		});
		btnUse.setBounds(12, 383, 80, 30);
		frmSaleMonster.getContentPane().add(btnUse);
		
		/**
		 * set the goldAmount to the gold amount of the player
		 * a lable with the goldAmount and a coin image
		 */
		int goldAmount = manager.getPlayer().getGoldAmount();
		JLabel lblGold = new JLabel(Integer.toString(goldAmount));
		lblGold.setIcon(new ImageIcon(SaleMonsterScreen.class.getResource("/Images/Coin.png")));
		lblGold.setBounds(12, 12, 100, 30);
		frmSaleMonster.getContentPane().add(lblGold);
		

	}
}
