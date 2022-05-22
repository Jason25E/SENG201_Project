import java.awt.EventQueue;
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

public class SaleMonsterScreen {

	private JFrame frmSaleMonster;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private GameManager manager;
	private Monster selectedMonster = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleMonsterScreen window = new SaleMonsterScreen();
					window.frmSaleMonster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaleMonsterScreen() {
		initialize();
	}
	
	public SaleMonsterScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmSaleMonster.setVisible(true);
	}
	
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
		
		frmSaleMonster = new JFrame();
		frmSaleMonster.setTitle("Sale - Monster");
		frmSaleMonster.setBounds(100, 100, 309, 454);
		frmSaleMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSaleMonster.getContentPane().setLayout(null);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(Color.RED);
		label_4.setBounds(12, 356, 267, 15);
		frmSaleMonster.getContentPane().add(label_4);
		
		if (MonsterListSize >= 1) {
			Monster FirstMonster = manager.getPlayer().getMonsterList().get(0);
			Skill Skill0 = FirstMonster.getMonsterSkill();
			String MonsterName0 = FirstMonster.getMonsterName();
			String SkillName0 = Skill0.getSkillName();
			
			int MonsterPrice0 = (int) (FirstMonster.getMonsterAttack() * 1.5);
			JLabel label = new JLabel("$" + MonsterPrice0);
			label.setFont(new Font("Dialog", Font.BOLD, 15));
			label.setBounds(25, 63, 50, 50);
			frmSaleMonster.getContentPane().add(label);
			
			
			JRadioButton rdbtnMonster = new JRadioButton(MonsterName0);
			rdbtnMonster.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedMonster = MonsterList.get(0);

				}
			});
			rdbtnMonster.setBounds(63, 54, 124, 32);
			frmSaleMonster.getContentPane().add(rdbtnMonster);
			
			if (FirstMonster.getMonsterEquipment() != null) {
				Equipment Equipment0 = FirstMonster.getMonsterEquipment();
				String EquipmentName0 = Equipment0.getItemID();
				JButton btnEquipment = new JButton(EquipmentName0);
				btnEquipment.setBounds(178, 94, 109, 25);
				frmSaleMonster.getContentPane().add(btnEquipment);
				
			}
			
			
			JButton btnSkill = new JButton(SkillName0);
			btnSkill.setBounds(63, 94, 109, 25);
			frmSaleMonster.getContentPane().add(btnSkill);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Monster/" + FirstMonster.getMonsterID() + ".png")));
			lblNewLabel.setBounds(171, 54, 116, 65);
			frmSaleMonster.getContentPane().add(lblNewLabel);
			
			
		}
		
		if (MonsterListSize >= 2) {
			Monster SecondMonster = manager.getPlayer().getMonsterList().get(1);
			Skill Skill1 = SecondMonster.getMonsterSkill();
			String SkillName1 = Skill1.getSkillName();
			String MonsterName1 = SecondMonster.getMonsterName();
			
			int MonsterPrice1 = (int) (SecondMonster.getMonsterAttack() * 1.5);
			JLabel label_1 = new JLabel("$" + MonsterPrice1);
			label_1.setFont(new Font("Dialog", Font.BOLD, 15));
			label_1.setBounds(25, 140, 50, 50);
			frmSaleMonster.getContentPane().add(label_1);
			
			JButton btnSkill_2= new JButton(SkillName1);
			btnSkill_2.setBounds(63, 171, 109, 25);
			frmSaleMonster.getContentPane().add(btnSkill_2);
			
			JRadioButton rdbtnMonster_1 = new JRadioButton(MonsterName1);
			rdbtnMonster_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedMonster = MonsterList.get(1);

				}
			});
			rdbtnMonster_1.setBounds(63, 131, 124, 32);
			frmSaleMonster.getContentPane().add(rdbtnMonster_1);
			
			if (SecondMonster.getMonsterEquipment() != null) {
				Equipment Equipment1 = SecondMonster.getMonsterEquipment();
				String EquipmentName1 = Equipment1.getItemID();
				JButton btnEquipment_2 = new JButton(EquipmentName1);
				btnEquipment_2.setBounds(178, 171, 109, 25);
				frmSaleMonster.getContentPane().add(btnEquipment_2);
			
			}
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Monster/" + SecondMonster.getMonsterID() + ".png")));
			lblNewLabel_1.setBounds(178, 131, 116, 65);
			frmSaleMonster.getContentPane().add(lblNewLabel_1);
			
			
		}
		
		if (MonsterListSize >= 3) {
			Monster ThirdMonster = manager.getPlayer().getMonsterList().get(2);
			Skill Skill2 = ThirdMonster.getMonsterSkill();
			String SkillName2 = Skill2.getSkillName();
			String MonsterName2 = ThirdMonster.getMonsterName();
			
			int MonsterPrice2 = (int) (ThirdMonster.getMonsterAttack() * 1.5);
			JLabel label_2 = new JLabel("$" + MonsterPrice2);
			label_2.setFont(new Font("Dialog", Font.BOLD, 15));
			label_2.setBounds(25, 217, 50, 50);
			frmSaleMonster.getContentPane().add(label_2);
			
			JButton btnSkill_3 = new JButton(SkillName2);
			btnSkill_3.setBounds(63, 248, 109, 25);
			frmSaleMonster.getContentPane().add(btnSkill_3);
			
			
			JRadioButton rdbtnMonster_2 = new JRadioButton(MonsterName2);
			rdbtnMonster_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedMonster = MonsterList.get(2);

				}
			});
			rdbtnMonster_2.setBounds(63, 208, 124, 32);
			frmSaleMonster.getContentPane().add(rdbtnMonster_2);
			
			
			if (ThirdMonster.getMonsterEquipment() != null) {
				Equipment Equipment2 = ThirdMonster.getMonsterEquipment();
				String EquipmentName2 = Equipment2.getItemID();
				JButton btnEquipment_3 = new JButton(EquipmentName2);
				btnEquipment_3.setBounds(178, 248, 109, 25);
				frmSaleMonster.getContentPane().add(btnEquipment_3);
			}
				
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Monster/" + ThirdMonster.getMonsterID() + ".png")));
			lblNewLabel_2.setBounds(171, 208, 116, 65);
			frmSaleMonster.getContentPane().add(lblNewLabel_2);
			
			
			
		}
		
		if (MonsterListSize >= 4) {
			Monster FourthMonster = manager.getPlayer().getMonsterList().get(3);
			Skill Skill3 = FourthMonster.getMonsterSkill();
			String SkillName3 = Skill3.getSkillName();
			String MonsterName3 = FourthMonster.getMonsterName();
			
			int MonsterPrice3 = (int) (FourthMonster.getMonsterAttack() * 1.5);
			JLabel label_3 = new JLabel("$" + MonsterPrice3);
			label_3.setFont(new Font("Dialog", Font.BOLD, 15));
			label_3.setBounds(25, 294, 50, 50);
			frmSaleMonster.getContentPane().add(label_3);
			
			JButton btnSkill_4= new JButton(SkillName3);
			btnSkill_4.setBounds(63, 325, 109, 25);
			frmSaleMonster.getContentPane().add(btnSkill_4);
			
			JRadioButton rdbtnMonster_3 = new JRadioButton(MonsterName3);
			rdbtnMonster_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedMonster = MonsterList.get(3);

				}
			});
			rdbtnMonster_3.setBounds(63, 285, 124, 32);
			frmSaleMonster.getContentPane().add(rdbtnMonster_3);
			
			if (FourthMonster.getMonsterEquipment() != null) {
				Equipment Equipment3 = FourthMonster.getMonsterEquipment();
				String EquipmentName3 = Equipment3.getItemID();
				JButton btnEquipment_4 = new JButton(EquipmentName3);
				btnEquipment_4.setBounds(178, 325, 109, 25);
				frmSaleMonster.getContentPane().add(btnEquipment_4);
			}	
			
			
			JLabel lblNewLabel_2_1 = new JLabel("New label");
			lblNewLabel_2_1.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Monster/" + FourthMonster.getMonsterID() + ".png")));
			lblNewLabel_2_1.setBounds(171, 285, 116, 65);
			frmSaleMonster.getContentPane().add(lblNewLabel_2_1);
		}
		
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
		
		JButton btnUse = new JButton("Sell");
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		int goldAmount = manager.getPlayer().getGoldAmount();
		JLabel lblGold = new JLabel(Integer.toString(goldAmount));
		lblGold.setIcon(new ImageIcon(SaleMonsterScreen.class.getResource("/Images/Coin.png")));
		lblGold.setBounds(12, 12, 100, 30);
		frmSaleMonster.getContentPane().add(lblGold);
		

	}
}
