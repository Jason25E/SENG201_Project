import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopItemScreen {

	private JFrame frmShopItem;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private GameManager manager;
	private Item selectedItem = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopItemScreen window = new ShopItemScreen();
					window.frmShopItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShopItemScreen() {
		initialize();
	}
	
	public ShopItemScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmShopItem.setVisible(true);
	}
	
	public void closeWindow() {
		frmShopItem.dispose();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Initialize the Foods and Equipments that appears in shop.
		 */
		ArrayList<Item> FoodList = new ArrayList<Item>();
		/* Food(String foodName, String foodEffect, int purchasePrice, int sellingPrice, int heal, int attack, int defence) */
		Food smallHeal = new Food("Watermelons", "Recover 20 HP", 5, 2, 20, 0, 0);
		Food bigHeal = new Food("Sandwich", "Recover 70 HP", 15, 7, 70, 0, 0);
		Food gainAttack = new Food("Steaks", "Increase 10 Attack", 10, 5, 0, 10, 0);
		Food gainDefence = new Food("Coffee", "Increase 10 Defence", 10, 5, 0, 0, 10);
		FoodList.add(smallHeal);
		FoodList.add(bigHeal);
		FoodList.add(gainAttack);
		FoodList.add(gainDefence);
		
		ArrayList<Item> EquipmentList = new ArrayList<Item>();
		/* Equipment(String equipmentName, String equipmentEffect, int purchasePrice, int sellingPrice, int attack, int defence) */
		Equipment gainSmallAttack = new Equipment("Sword", "Increase 20 Attack", 20, 10, 20, 0);
		Equipment gainBigAttack = new Equipment("Axe", "Increase 40 Attack", 30, 15, 40, 0);
		Equipment gainSmallDefence = new Equipment("Helmet", "Increase 20 Defence", 20, 10, 0, 20);
		Equipment gainBigDefence = new Equipment("Shield", "Increase 40 Defence", 30, 15, 0, 40);
		EquipmentList.add(gainSmallAttack);
		EquipmentList.add(gainBigAttack);
		EquipmentList.add(gainSmallDefence);
		EquipmentList.add(gainBigDefence);
		
		/**
		 * Initialize the frame itself.
		 */
		frmShopItem = new JFrame();
		frmShopItem.setTitle("Shop - Item");
		frmShopItem.getContentPane().setForeground(Color.RED);
		frmShopItem.setBounds(100, 100, 569, 321);
		frmShopItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShopItem.getContentPane().setLayout(null);
		
		int goldAmount = manager.getPlayer().getGoldAmount();
		JLabel lblGold = new JLabel(Integer.toString(goldAmount));
		lblGold.setIcon(new ImageIcon(ShopItemScreen.class.getResource("/Images/Coin.png")));
		lblGold.setBounds(12, 11, 100, 40);
		frmShopItem.getContentPane().add(lblGold);
		
		JLabel lblItemsForSale = new JLabel("Items for sale");
		lblItemsForSale.setBounds(228, 9, 150, 20);
		frmShopItem.getContentPane().add(lblItemsForSale);
		
		JLabel lblEffect = new JLabel("");
		lblEffect.setBounds(228, 215, 207, 15);
		frmShopItem.getContentPane().add(lblEffect);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(42, 215, 144, 15);
		frmShopItem.getContentPane().add(lblMessage);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectedItem != null) {
					int price = selectedItem.getPurchasePrice();
					if (manager.getPlayer().getGoldAmount() >= price) {
						if (selectedItem instanceof Food) {
							manager.getPlayer().buyFood(selectedItem, price);
						} else {
							manager.getPlayer().buyEquipment(selectedItem, price);
						}
						lblMessage.setText("Success");
						lblGold.setText(Integer.toString(manager.getPlayer().getGoldAmount()));
					} else {
						lblMessage.setText("Not enough gold");
					}
				} else {
					lblMessage.setText("No item is selected");
				}

			}
		});
		btnBuy.setBounds(39, 243, 130, 30);
		frmShopItem.getContentPane().add(btnBuy);
		
		JButton btnExit = new JButton("Check out Monsters");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopMonsterScreen();
				closeWindow();
			}
		});
		btnExit.setBounds(202, 243, 175, 30);
		frmShopItem.getContentPane().add(btnExit);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopDirectionScreen();
				closeWindow();
			}
		});
		btnExit_1.setBackground(new Color(255, 51, 102));
		btnExit_1.setForeground(new Color(255, 255, 255));
		btnExit_1.setBounds(408, 243, 130, 30);
		frmShopItem.getContentPane().add(btnExit_1);
		
		/**
		 * Item one for sale in shop
		 */
		String ItemNameOne = FoodList.get(0).getItemID();
		JRadioButton rdbtnItem = new JRadioButton(ItemNameOne);
		rdbtnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedItem = FoodList.get(0);
				lblEffect.setText(selectedItem.getItemEffect());
			}
		});
		buttonGroup.add(rdbtnItem);
		rdbtnItem.setBounds(30, 52, 121, 41);
		frmShopItem.getContentPane().add(rdbtnItem);
		
		String ImageSourceOne = "/Images/Food/" + ItemNameOne + ".png";
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ShopItemScreen.class.getResource(ImageSourceOne)));
		label.setBounds(57, 101, 65, 65);
		frmShopItem.getContentPane().add(label);
		
		int ItemPriceOne = FoodList.get(0).getPurchasePrice();
		JLabel label_4 = new JLabel("$ " + ItemPriceOne);
		label_4.setBounds(66, 178, 56, 15);
		frmShopItem.getContentPane().add(label_4);
		
		/**
		 * Item two for sale in shop
		 */
		String ItemNameTwo = FoodList.get(manager.RandomFoodInShop).getItemID();
		JRadioButton rdbtnItem_1 = new JRadioButton(ItemNameTwo);
		rdbtnItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedItem = FoodList.get(manager.RandomFoodInShop);
				lblEffect.setText(selectedItem.getItemEffect());
			}
		});
		buttonGroup.add(rdbtnItem_1);
		rdbtnItem_1.setBounds(172, 52, 100, 41);
		frmShopItem.getContentPane().add(rdbtnItem_1);
		
		String ImageSourceTwo = "/Images/Food/" + ItemNameTwo + ".png";
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ShopItemScreen.class.getResource(ImageSourceTwo)));
		label_1.setBounds(190, 101, 65, 65);
		frmShopItem.getContentPane().add(label_1);
		
		int ItemPriceTwo = FoodList.get(manager.RandomFoodInShop).getPurchasePrice();
		JLabel lblNewLabel = new JLabel("$ " + ItemPriceTwo);
		lblNewLabel.setBounds(190, 178, 70, 15);
		frmShopItem.getContentPane().add(lblNewLabel);
		
		/**
		 * Item three for sale in shop
		 */
		String ItemNameThree = EquipmentList.get(manager.RandomEquipmentInShop).getItemID();
		JRadioButton rdbtnItem_2 = new JRadioButton(ItemNameThree);
		rdbtnItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedItem = EquipmentList.get(manager.RandomEquipmentInShop);
				lblEffect.setText(selectedItem.getItemEffect());
			}
		});
		buttonGroup.add(rdbtnItem_2);
		rdbtnItem_2.setBounds(305, 52, 100, 41);
		frmShopItem.getContentPane().add(rdbtnItem_2);

		
		String ImageSourceThree = "/Images/Equipment/" + ItemNameThree + ".png";
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ShopItemScreen.class.getResource(ImageSourceThree)));
		label_2.setBounds(323, 101, 65, 65);
		frmShopItem.getContentPane().add(label_2);
		
		int ItemPriceThree = EquipmentList.get(manager.RandomEquipmentInShop).getPurchasePrice();
		JLabel lblNewLabel_1 = new JLabel("$ " + ItemPriceThree);
		lblNewLabel_1.setBounds(323, 178, 70, 15);
		frmShopItem.getContentPane().add(lblNewLabel_1);
		
		/**
		 * Item four for sale in shop
		 */
		String ItemNameFour = EquipmentList.get(manager.RandomEquipmentInShopTwo).getItemID();
		JRadioButton rdbtnItem_1_1 = new JRadioButton(ItemNameFour);
		rdbtnItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedItem = EquipmentList.get(manager.RandomEquipmentInShopTwo);
				lblEffect.setText(selectedItem.getItemEffect());
			}
		});
		buttonGroup.add(rdbtnItem_1_1);
		rdbtnItem_1_1.setBounds(438, 52, 100, 41);
		frmShopItem.getContentPane().add(rdbtnItem_1_1);
		
		String ImageSourceFour = "/Images/Equipment/" + ItemNameFour + ".png";
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(ShopItemScreen.class.getResource(ImageSourceFour)));
		label_3.setBounds(456, 101, 65, 65);
		frmShopItem.getContentPane().add(label_3);
		
		int ItemPriceFour = EquipmentList.get(manager.RandomEquipmentInShopTwo).getPurchasePrice();
		JLabel lblNewLabel_2 = new JLabel("$ " + ItemPriceFour);
		lblNewLabel_2.setBounds(468, 178, 70, 15);
		frmShopItem.getContentPane().add(lblNewLabel_2);
	}
}
