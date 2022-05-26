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
 * The class SaleItemScreen
 * Display all the food that are in the food list
 * Can sell food from the food list
 * @author fye15, zde19
 *
 */
public class SaleItemScreen {

	private JFrame frmSaleEquipment;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private GameManager manager;
	private Item selectedFood = null;
	
	/**
	 * The variable require one parameter
	 * @param manager of the type GameManager
	 * run the initialize
	 * set the frmMain visible
	 */
	public SaleItemScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmSaleEquipment.setLocationRelativeTo(null);
		frmSaleEquipment.setVisible(true);
	}
	
	/**
	 * The variable 
	 * set the frmMain dispose
	 */
	public void closeWindow() {
		frmSaleEquipment.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int ItemListSize = manager.getPlayer().getFoodList().size();
		ArrayList<Item> ItemList = manager.getPlayer().getFoodList();
		
		/**
		 * A frame with title "Sale - Food"
		 */
		frmSaleEquipment = new JFrame();
		frmSaleEquipment.setTitle("Sale - Food");
		frmSaleEquipment.setBounds(100, 100, 299, 414);
		frmSaleEquipment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSaleEquipment.getContentPane().setLayout(null);
		
		/**
		 * A label recive the information from sale
		 */
		JLabel label = new JLabel("");
		label.setBounds(16, 314, 267, 15);
		label.setForeground(Color.RED);
		frmSaleEquipment.getContentPane().add(label);
		
		/**
		 * Check if the size of the food list is equals or greater than 1
		 */
		if (ItemListSize >= 1) {
			/**
			 * Set the first food to the first food in the food list
			 * set quantity to food quantity
			 * check if quantity if greater or equal to 10
			 */
			Item FirstItem = manager.getPlayer().getFoodList().get(0);
			int FirstItemQuanitty = FirstItem.getQuantity();
			String FirstItemQuanittyString = "";
			if (FirstItemQuanitty >= 10) {
				FirstItemQuanittyString = "x" + FirstItemQuanitty;
			} else {
				FirstItemQuanittyString = "x0" + FirstItemQuanitty;
			}
			JLabel lblX = new JLabel(FirstItemQuanittyString);
			lblX.setForeground(Color.BLACK);
			lblX.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX.setBounds(222, 86, 42, 24);
			frmSaleEquipment.getContentPane().add(lblX);
			
			/**
			 * Set the first food name to the first food id
			 */
			String FirstItemName = FirstItem.getItemID();
			JRadioButton rdbtnNameOfItem = new JRadioButton(FirstItemName);
			buttonGroup.add(rdbtnNameOfItem);
			rdbtnNameOfItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(0);
				}
			});
			
			/**
			 * Set the label to the selling price of the first food
			 */
			int ItemPrice0 = FirstItem.getSellingPrice();
			JLabel lblPrice = new JLabel("$" + ItemPrice0);
			lblPrice.setBounds(119, 95, 70, 15);
			frmSaleEquipment.getContentPane().add(lblPrice);
			rdbtnNameOfItem.setBounds(12, 54, 177, 30);
			frmSaleEquipment.getContentPane().add(rdbtnNameOfItem);
			

			/**
			 * A label show the first food image
			 */
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + FirstItemName + ".png")));
			lblNewLabel.setBounds(203, 54, 61, 56);
			frmSaleEquipment.getContentPane().add(lblNewLabel);
			
			
		}
		
		/**
		 * Check if the size of the food list is equals or greater than 2
		 */
		if (ItemListSize >= 2) {
			/**
			 * Set the second food to the first food in the equipment list
			 * set quantity to food quantity
			 * check if quantity if greater or equal to 10
			 */
			Item SecondItem = manager.getPlayer().getFoodList().get(1);
			int SecondItemQuanitty = SecondItem.getQuantity();
			String SecondItemQuanittyString = "";
			if (SecondItemQuanitty >= 10) {
				SecondItemQuanittyString = "x" + SecondItemQuanitty;
			} else {
				SecondItemQuanittyString = "x0" + SecondItemQuanitty;
			}
			JLabel lblX_1 = new JLabel(SecondItemQuanittyString);
			lblX_1.setForeground(Color.BLACK);
			lblX_1.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_1.setBounds(222, 150, 42, 24);
			frmSaleEquipment.getContentPane().add(lblX_1);

			/**
			 * Set the second food name to the second food id
			 */
			String SecondItemName = SecondItem.getItemID();
			JRadioButton rdbtnNameOfItem_1 = new JRadioButton(SecondItemName);
			buttonGroup.add(rdbtnNameOfItem_1);
			rdbtnNameOfItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(1);
				}
			});
			
			/**
			 * Set the label to the selling price of the second food
			 */
			int ItemPrice1 = SecondItem.getSellingPrice();
			JLabel lblPrice_1 = new JLabel("$" + ItemPrice1);
			lblPrice_1.setBounds(119, 159, 70, 15);
			frmSaleEquipment.getContentPane().add(lblPrice_1);
			rdbtnNameOfItem_1.setBounds(12, 118, 177, 33);
			frmSaleEquipment.getContentPane().add(rdbtnNameOfItem_1);
			

			/**
			 * A label show the second food image
			 */
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + SecondItemName + ".png")));
			lblNewLabel_4.setBounds(203, 118, 61, 56);
			frmSaleEquipment.getContentPane().add(lblNewLabel_4);
			
			
		}
		
		/**
		 * Check if the size of the food list is equals or greater than 3
		 */
		if (ItemListSize >= 3) {
			/**
			 * Set the third food to the first food in the equipment list
			 * set quantity to food quantity
			 * check if quantity if greater or equal to 10
			 */
			Item ThirdItem = manager.getPlayer().getFoodList().get(2);
			int ThirdItemQuanitty = ThirdItem.getQuantity();
			String ThirdItemQuanittyString = "";
			if (ThirdItemQuanitty >= 10) {
				ThirdItemQuanittyString = "x" + ThirdItemQuanitty;
			} else {
				ThirdItemQuanittyString = "x0" + ThirdItemQuanitty;
			}
			JLabel lblX_2 = new JLabel(ThirdItemQuanittyString);
			lblX_2.setForeground(Color.BLACK);
			lblX_2.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_2.setBounds(222, 214, 42, 24);
			frmSaleEquipment.getContentPane().add(lblX_2);
			
			/**
			 * Set the third food name to the third food id
			 */
			String ThirdItemName = ThirdItem.getItemID();
			JRadioButton rdbtnNameOfItem_2 = new JRadioButton(ThirdItemName);
			buttonGroup.add(rdbtnNameOfItem_2);
			rdbtnNameOfItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(2);
				}
			});
			
			/**
			 * Set the label to the selling price of the third food
			 */
			int ItemPrice2 = ThirdItem.getSellingPrice();
			JLabel lblPrice_1_1 = new JLabel("$" + ItemPrice2);
			lblPrice_1_1.setBounds(119, 223, 70, 15);
			frmSaleEquipment.getContentPane().add(lblPrice_1_1);
			rdbtnNameOfItem_2.setBounds(12, 182, 177, 33);
			frmSaleEquipment.getContentPane().add(rdbtnNameOfItem_2);
			

			/**
			 * A label show the third food image
			 */
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + ThirdItemName + ".png")));
			lblNewLabel_1.setBounds(203, 182, 61, 56);
			frmSaleEquipment.getContentPane().add(lblNewLabel_1);

		}
		
		/**
		 * Check if the size of the food list is equals or greater than 3
		 */
		if (ItemListSize >= 4) {
			/**
			 * Set the fourth food to the first food in the equipment list
			 * set quantity to food quantity
			 * check if quantity if greater or equal to 10
			 */
			Item FourthItem = manager.getPlayer().getFoodList().get(3);
			int FourthItemQuanitty = FourthItem.getQuantity();
			String FourthItemQuanittyString = "";
			if (FourthItemQuanitty >= 10) {
				FourthItemQuanittyString = "x" + FourthItemQuanitty;
			} else {
				FourthItemQuanittyString = "x0" + FourthItemQuanitty;
			}
			JLabel lblX_3 = new JLabel(FourthItemQuanittyString);
			lblX_3.setForeground(Color.BLACK);
			lblX_3.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_3.setBounds(222, 278, 42, 24);
			frmSaleEquipment.getContentPane().add(lblX_3);
			
			/**
			 * Set the fourth food name to the fourth food id
			 */
			String FourthItemName = FourthItem.getItemID();
			JRadioButton rdbtnNameOfItem_3 = new JRadioButton(FourthItemName);
			buttonGroup.add(rdbtnNameOfItem_3);
			rdbtnNameOfItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(3);
				}
			});
			
			/**
			 * Set the label to the selling price of the fourth food
			 */
			int ItemPrice3 = FourthItem.getSellingPrice();
			JLabel lblPrice_1_2 = new JLabel("$" + ItemPrice3);
			lblPrice_1_2.setBounds(119, 287, 70, 15);
			frmSaleEquipment.getContentPane().add(lblPrice_1_2);
			rdbtnNameOfItem_3.setBounds(12, 246, 177, 33);
			frmSaleEquipment.getContentPane().add(rdbtnNameOfItem_3);
			

			/**
			 * A label show the fourth food image
			 */
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + FourthItemName + ".png")));
			lblNewLabel_2.setBounds(203, 246, 61, 56);
			frmSaleEquipment.getContentPane().add(lblNewLabel_2);

		}
		

		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopDirectionScreen();
				closeWindow();
			}
		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(199, 341, 80, 30);
		frmSaleEquipment.getContentPane().add(btnExit);
		
		JButton btnUse = new JButton("Sell");
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectedFood != null) {
					manager.getPlayer().soldItem(selectedFood);
					manager.launchSaleItemScreen();
					closeWindow();

				} else {
					label.setText("Please select an item to sale");
				}
			}
		});
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(12, 341, 80, 30);
		frmSaleEquipment.getContentPane().add(btnUse);
		
		/**
		 * set the goldAmount to the gold amount of the player
		 * a lable with the goldAmount and a coin image
		 */
		int goldAmount = manager.getPlayer().getGoldAmount();
		JLabel lblGold = new JLabel(Integer.toString(goldAmount));
		lblGold.setIcon(new ImageIcon(SaleItemScreen.class.getResource("/Images/Coin.png")));
		lblGold.setBounds(12, 12, 100, 30);
		frmSaleEquipment.getContentPane().add(lblGold);
		
		
	}
}
