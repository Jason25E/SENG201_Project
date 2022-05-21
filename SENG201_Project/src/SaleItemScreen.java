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

public class SaleItemScreen {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private GameManager manager;
	private Item selectedFood = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleItemScreen window = new SaleItemScreen();
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
	public SaleItemScreen() {
		initialize();
	}
	
	public SaleItemScreen(GameManager manager) {
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
		int ItemListSize = manager.getPlayer().getFoodList().size();
		ArrayList<Item> ItemList = manager.getPlayer().getFoodList();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 299, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(16, 314, 267, 15);
		label.setForeground(Color.RED);
		frame.getContentPane().add(label);
		
		if (ItemListSize >= 1) {
			Item FirstItem = manager.getPlayer().getFoodList().get(0);
			
			int FirstItemQuanitty = FirstItem.getQuantity();
			String FirstItemQuanittyString = "";
			if (FirstItemQuanitty >= 10) {
				FirstItemQuanittyString = "x" + FirstItemQuanitty;
			} else {
				FirstItemQuanittyString = "x0" + FirstItemQuanitty;
			}
			
			String FirstItemName = FirstItem.getItemID();
			JRadioButton rdbtnNameOfItem = new JRadioButton(FirstItemName);
			rdbtnNameOfItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(0);
				}
			});
			
			int ItemPrice0 = FirstItem.getSellingPrice();
			JLabel lblPrice = new JLabel("$" + ItemPrice0);
			lblPrice.setBounds(119, 95, 70, 15);
			frame.getContentPane().add(lblPrice);
			rdbtnNameOfItem.setBounds(12, 54, 177, 30);
			frame.getContentPane().add(rdbtnNameOfItem);
			
			JLabel lblX = new JLabel(FirstItemQuanittyString);
			lblX.setForeground(Color.BLACK);
			lblX.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX.setBounds(222, 86, 42, 24);
			frame.getContentPane().add(lblX);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + FirstItemName + ".png")));
			lblNewLabel.setBounds(203, 54, 61, 56);
			frame.getContentPane().add(lblNewLabel);
			
			
		}
		
		if (ItemListSize >= 2) {
			Item SecondItem = manager.getPlayer().getFoodList().get(1);
			
			int SecondItemQuanitty = SecondItem.getQuantity();
			String SecondItemQuanittyString = "";
			if (SecondItemQuanitty >= 10) {
				SecondItemQuanittyString = "x" + SecondItemQuanitty;
			} else {
				SecondItemQuanittyString = "x0" + SecondItemQuanitty;
			}
			

			String SecondItemName = SecondItem.getItemID();
			JRadioButton rdbtnNameOfItem_1 = new JRadioButton(SecondItemName);
			rdbtnNameOfItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(1);
				}
			});
			
			int ItemPrice1 = SecondItem.getSellingPrice();
			JLabel lblPrice_1 = new JLabel("$" + ItemPrice1);
			lblPrice_1.setBounds(119, 159, 70, 15);
			frame.getContentPane().add(lblPrice_1);
			rdbtnNameOfItem_1.setBounds(12, 118, 177, 33);
			frame.getContentPane().add(rdbtnNameOfItem_1);
			
			JLabel lblX_1 = new JLabel(SecondItemQuanittyString);
			lblX_1.setForeground(Color.BLACK);
			lblX_1.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_1.setBounds(222, 150, 42, 24);
			frame.getContentPane().add(lblX_1);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + SecondItemName + ".png")));
			lblNewLabel_4.setBounds(203, 118, 61, 56);
			frame.getContentPane().add(lblNewLabel_4);
			
			
		}
		
		if (ItemListSize >= 3) {
			Item ThirdItem = manager.getPlayer().getFoodList().get(2);
			
			int ThirdItemQuanitty = ThirdItem.getQuantity();
			String ThirdItemQuanittyString = "";
			if (ThirdItemQuanitty >= 10) {
				ThirdItemQuanittyString = "x" + ThirdItemQuanitty;
			} else {
				ThirdItemQuanittyString = "x0" + ThirdItemQuanitty;
			}
			
			String ThirdItemName = ThirdItem.getItemID();
			JRadioButton rdbtnNameOfItem_2 = new JRadioButton(ThirdItemName);
			rdbtnNameOfItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(2);
				}
			});
			
			int ItemPrice2 = ThirdItem.getSellingPrice();
			JLabel lblPrice_1_1 = new JLabel("$" + ItemPrice2);
			lblPrice_1_1.setBounds(119, 223, 70, 15);
			frame.getContentPane().add(lblPrice_1_1);
			rdbtnNameOfItem_2.setBounds(12, 182, 177, 33);
			frame.getContentPane().add(rdbtnNameOfItem_2);
			
			JLabel lblX_2 = new JLabel(ThirdItemQuanittyString);
			lblX_2.setForeground(Color.BLACK);
			lblX_2.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_2.setBounds(222, 214, 42, 24);
			frame.getContentPane().add(lblX_2);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + ThirdItemName + ".png")));
			lblNewLabel_1.setBounds(203, 182, 61, 56);
			frame.getContentPane().add(lblNewLabel_1);

		}
		
		if (ItemListSize >= 4) {
			Item FourthItem = manager.getPlayer().getFoodList().get(3);
			
			int FourthItemQuanitty = FourthItem.getQuantity();
			String FourthItemQuanittyString = "";
			if (FourthItemQuanitty >= 10) {
				FourthItemQuanittyString = "x" + FourthItemQuanitty;
			} else {
				FourthItemQuanittyString = "x0" + FourthItemQuanitty;
			}
			
			String FourthItemName = FourthItem.getItemID();
			JRadioButton rdbtnNameOfItem_3 = new JRadioButton(FourthItemName);
			rdbtnNameOfItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(3);
				}
			});
			
			int ItemPrice3 = FourthItem.getSellingPrice();
			JLabel lblPrice_1_2 = new JLabel("$" + ItemPrice3);
			lblPrice_1_2.setBounds(119, 287, 70, 15);
			frame.getContentPane().add(lblPrice_1_2);
			rdbtnNameOfItem_3.setBounds(12, 246, 177, 33);
			frame.getContentPane().add(rdbtnNameOfItem_3);
			
			JLabel lblX_3 = new JLabel(FourthItemQuanittyString);
			lblX_3.setForeground(Color.BLACK);
			lblX_3.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_3.setBounds(222, 278, 42, 24);
			frame.getContentPane().add(lblX_3);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + FourthItemName + ".png")));
			lblNewLabel_2.setBounds(203, 246, 61, 56);
			frame.getContentPane().add(lblNewLabel_2);

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
		frame.getContentPane().add(btnExit);
		
		JButton btnUse = new JButton("Sell");
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectedFood != null) {
					int SalePrice = selectedFood.getSellingPrice();
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
		frame.getContentPane().add(btnUse);
		
		int goldAmount = manager.getPlayer().getGoldAmount();
		JLabel lblGold = new JLabel(Integer.toString(goldAmount));
		lblGold.setIcon(new ImageIcon(SaleItemScreen.class.getResource("/Images/Coin.png")));
		lblGold.setBounds(12, 12, 100, 30);
		frame.getContentPane().add(lblGold);
		
		
	}
}
