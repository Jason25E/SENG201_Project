import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.Font;

/**
 * The class ShopMonsterScreen
 * Display three random monster in the monsterlist
 * Player will be able to buy monster to play game
 * @author zde19
 *
 */
public class ShopMonsterScreen {

	private JFrame frmShopMonsters;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private GameManager manager;
	private int purchasePrice = 150;
	private Monster selectedMonster = null;
	private int selectedMonsterPrice;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMonsterScreen window = new ShopMonsterScreen();
					window.frmShopMonsters.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShopMonsterScreen() {
		initialize();
	}
	
	public ShopMonsterScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmShopMonsters.setVisible(true);
	}
	
	public void closeWindow() {
		frmShopMonsters.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Initialize the Monsters that appear in shop.
		 */
		
		float shop_info = manager.getShop_info();
		int current_day = manager.getCurrentDay();
		float monster_heal_rate = manager.getStart_gold_info();
	int MonsterLevel = manager.RandomMonsterLevelInShop;
	purchasePrice = Math.round((purchasePrice + current_day * 5) * shop_info);
	ArrayList<Monster> MonsterList = new ArrayList<Monster>();
	
	Skill batSkill = new Skill("Bit", "Has a base power of 12", 12);
	Monster bat = new Monster("Bat", "Bat", MonsterLevel, "Common", 12 + 2 * MonsterLevel, 10 + 2 * MonsterLevel, 200 + Math.round(3 * monster_heal_rate * MonsterLevel), 30, batSkill);
	
	Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
	Monster slime = new Monster("Slime", "Slime", MonsterLevel, "Common", 7 + 1 * MonsterLevel, 10 + 3 * MonsterLevel, 200 + Math.round((float)3.5 * monster_heal_rate * MonsterLevel), 60, slimeSkill);
	
	Skill ghostSkill = new Skill("Dive", "Has a base power of 12", 12);
	Monster ghost = new Monster("Ghost", "Ghost", MonsterLevel, "Common", 8 + 2 * MonsterLevel, 17 + 3 * MonsterLevel, 200 + Math.round(3 * monster_heal_rate * MonsterLevel), 35, ghostSkill);
	
	int MonsterLevelTwo = manager.RandomMonsterLevelInShopTwo;
	Skill skeletonSkill = new Skill("Slash", "Has a base power of 12", 12);
	Monster skeleton = new Monster("Skeleton", "Skeleton", MonsterLevelTwo, "Common", 13 + 3 * MonsterLevel, 15 + 2 * MonsterLevel, 200 + Math.round(2 * monster_heal_rate * MonsterLevel), 25, skeletonSkill);
	
	Skill witchSkill = new Skill("Thunder", "Has a base power of 12", 12);
	Monster witch = new Monster("Witch", "Witch", MonsterLevelTwo, "Common", 17 + 4 * MonsterLevel, 8 + 1 * MonsterLevel, 180 + Math.round(2 * monster_heal_rate * MonsterLevel), 25, witchSkill);
	
	Skill demonSkill = new Skill("Inferno", "Has a base power of 14", 14);
	Monster demon = new Monster("Demon", "Demon", MonsterLevelTwo, "Common", 15 + 3 * MonsterLevel, 18 + 3 * MonsterLevel, 200 + Math.round(3 * monster_heal_rate * MonsterLevel), 30, demonSkill);
		
		MonsterList.add(bat);
		MonsterList.add(slime);
		MonsterList.add(ghost);
		MonsterList.add(skeleton);
		MonsterList.add(witch);
		MonsterList.add(demon);
		
		/**
		 * Initialize the frame itself.
		 */
		frmShopMonsters = new JFrame();
		frmShopMonsters.setTitle("Shop - Monster");
		frmShopMonsters.setBounds(100, 100, 590, 355);
		frmShopMonsters.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShopMonsters.getContentPane().setLayout(null);
		
		int goldAmount = manager.getPlayer().getGoldAmount();
		JLabel lblGold = new JLabel(Integer.toString(goldAmount));
		lblGold.setIcon(new ImageIcon(ShopMonsterScreen.class.getResource("/Images/Coin.png")));
		lblGold.setBounds(12, 11, 100, 40);
		frmShopMonsters.getContentPane().add(lblGold);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(423, 260, 164, 15);
		frmShopMonsters.getContentPane().add(lblMessage);
		
		JLabel lblNewLabel = new JLabel("Enter a name for the monster:");
		lblNewLabel.setBounds(42, 260, 231, 15);
		frmShopMonsters.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(276, 260, 130, 19);
		frmShopMonsters.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMonstersForSale = new JLabel("Monsters for sale");
		lblMonstersForSale.setBounds(225, 11, 150, 20);
		frmShopMonsters.getContentPane().add(lblMonstersForSale);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.closeShopMonsterScreen(ShopMonsterScreen.this);
			}
		});
		btnExit_1.setForeground(new Color(255, 255, 255));
		btnExit_1.setBackground(new Color(255, 51, 102));
		btnExit_1.setBounds(409, 288, 130, 30);
		frmShopMonsters.getContentPane().add(btnExit_1);
		
		JButton btnItem = new JButton("Check out Food & Equip.");
		btnItem.setFont(new Font("Dialog", Font.BOLD, 10));
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopItemScreen();
				closeWindow();
			}
		});
		btnItem.setBounds(203, 288, 175, 30);
		frmShopMonsters.getContentPane().add(btnItem);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectedMonster != null) {
					if (manager.getPlayer().getGoldAmount() >= selectedMonsterPrice) {
						if (manager.getPlayer().getMonsterList().size() <= manager.getPlayer().getMaxMonstersCanHave() - 1) {
							if (textField.getText().length() > 0 && textField.getText().length() < 13) {
								if (manager.getPlayer().sameMonsterName(textField.getText()) == false) {
									selectedMonster.setMonsterName(textField.getText());
									manager.getPlayer().buyMonster(selectedMonster, selectedMonsterPrice);
									lblGold.setText(Integer.toString(manager.getPlayer().getGoldAmount()));
									lblMessage.setText("Success");
								} else {
									lblMessage.setText("Name exist already");
								}
							} else {
								lblMessage.setText("Name 1 to 12 char. max");
							}
						} else {
							lblMessage.setText("Not enough space");
						}
					} else {
						lblMessage.setText("Not enough gold");
					}
				} else {
					lblMessage.setText("No monster is selected");
				}
			}
			}
		);
		btnBuy.setBounds(39, 288, 130, 30);
		frmShopMonsters.getContentPane().add(btnBuy);
		
		/**
		 * Monster one for sale in Shop
		 */
		int priceOne = purchasePrice;
		JLabel label_3 = new JLabel("$ " + priceOne);
		label_3.setBounds(67, 233, 70, 15);
		frmShopMonsters.getContentPane().add(label_3);
		
		Monster monsterOne = MonsterList.get(manager.RandomMonsterInShop);
		String MonsterNameOne = monsterOne.getMonsterID();
		JRadioButton rdbtnMonster = new JRadioButton(MonsterNameOne);
		rdbtnMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMessage.setText("");
				selectedMonster = monsterOne;
				selectedMonsterPrice = priceOne;
				textField.setText(MonsterNameOne + "_" + (int)((Math.random() * (999)) + 1));
			}
		});
		buttonGroup.add(rdbtnMonster);
		rdbtnMonster.setForeground(Color.BLACK);
		rdbtnMonster.setBounds(30, 55, 130, 38);
		frmShopMonsters.getContentPane().add(rdbtnMonster);
		
		String ImageSourceOne = "/Images/Monster/" + MonsterNameOne + ".png";
		JLabel labelMonsterIcon = new JLabel("");
		labelMonsterIcon.setIcon(new ImageIcon(ShopMonsterScreen.class.getResource(ImageSourceOne)));
		labelMonsterIcon.setToolTipText(monsterOne.getMonsterInfo());
		labelMonsterIcon.setBounds(22, 101, 130, 120);
		frmShopMonsters.getContentPane().add(labelMonsterIcon);
		
		/**
		 * Monster two for sale in Shop
		 */
		int priceTwo = purchasePrice;
		JLabel label_3_1 = new JLabel("$ " + priceTwo);
		label_3_1.setBounds(276, 233, 70, 15);
		frmShopMonsters.getContentPane().add(label_3_1);
		
		Monster monsterTwo = MonsterList.get(manager.RandomMonsterInShopTwo);
		String MonsterNameTwo = monsterTwo.getMonsterID();
		JRadioButton rdbtnMonster_1 = new JRadioButton(MonsterNameTwo);
		rdbtnMonster_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMessage.setText("");
				selectedMonster = monsterTwo;
				selectedMonsterPrice = priceTwo;
				textField.setText(MonsterNameTwo + "_" + (int)((Math.random() * (999)) + 1));
			}
		});
		buttonGroup.add(rdbtnMonster_1);
		rdbtnMonster_1.setForeground(Color.BLACK);
		rdbtnMonster_1.setBounds(250, 55, 130, 38);
		frmShopMonsters.getContentPane().add(rdbtnMonster_1);
		
		String ImageSourceTwo = "/Images/Monster/" + MonsterNameTwo + ".png";
		JLabel labelMonsterIcon_2 = new JLabel("");
		labelMonsterIcon_2.setIcon(new ImageIcon(ShopMonsterScreen.class.getResource(ImageSourceTwo)));
		labelMonsterIcon_2.setToolTipText(monsterTwo.getMonsterInfo());
		labelMonsterIcon_2.setBounds(245, 101, 130, 120);
		frmShopMonsters.getContentPane().add(labelMonsterIcon_2);
		
		/**
		 * Monster three for sale in Shop
		 */
		int priceThree = purchasePrice;
		JLabel label_3_1_1 = new JLabel("$ " + priceThree);
		label_3_1_1.setBounds(481, 233, 70, 15);
		frmShopMonsters.getContentPane().add(label_3_1_1);
		
		Monster monsterThree = MonsterList.get(manager.RandomMonsterInShopThree);
		String MonsterNameThree = monsterThree.getMonsterID();
		JRadioButton rdbtnMonster_2 = new JRadioButton(MonsterNameThree);
		rdbtnMonster_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMessage.setText("");
				selectedMonster = monsterThree;
				selectedMonsterPrice = priceThree;
				textField.setText(MonsterNameThree + "_" + (int)((Math.random() * (999)) + 1));
			}
		});
		buttonGroup.add(rdbtnMonster_2);
		rdbtnMonster_2.setForeground(Color.BLACK);
		rdbtnMonster_2.setBounds(460, 55, 130, 38);
		frmShopMonsters.getContentPane().add(rdbtnMonster_2);
		
		String ImageSourceThree = "/Images/Monster/" + MonsterNameThree + ".png";
		JLabel labelMonsterIcon_3 = new JLabel("");
		labelMonsterIcon_3.setIcon(new ImageIcon(ShopMonsterScreen.class.getResource(ImageSourceThree)));
		labelMonsterIcon_3.setToolTipText(monsterThree.getMonsterInfo());
		labelMonsterIcon_3.setBounds(438, 101, 130, 120);
		frmShopMonsters.getContentPane().add(labelMonsterIcon_3);
	}
	

}
