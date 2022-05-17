import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ShopItemScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopItemScreen window = new ShopItemScreen();
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
	public ShopItemScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 569, 306);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGold = new JLabel("gold");
		lblGold.setBounds(12, 12, 70, 15);
		frame.getContentPane().add(lblGold);
		
		JLabel lblItemsForSale = new JLabel("Items for sale");
		lblItemsForSale.setBounds(228, 9, 150, 20);
		frame.getContentPane().add(lblItemsForSale);
		
		JRadioButton rdbtnItem = new JRadioButton("Watermelon");
		rdbtnItem.setBounds(38, 35, 100, 41);
		frame.getContentPane().add(rdbtnItem);
		
		JRadioButton rdbtnItem_1 = new JRadioButton("item1");
		rdbtnItem_1.setBounds(171, 35, 100, 41);
		frame.getContentPane().add(rdbtnItem_1);
		
		JButton btnBuy = new JButton("buy");
		btnBuy.setBounds(360, 233, 130, 30);
		frame.getContentPane().add(btnBuy);
		
		JButton btnExit = new JButton("Monster");
		btnExit.setBounds(231, 233, 117, 30);
		frame.getContentPane().add(btnExit);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.setBounds(89, 233, 130, 30);
		frame.getContentPane().add(btnExit_1);
		
		JRadioButton rdbtnItem_1_1 = new JRadioButton("item1");
		rdbtnItem_1_1.setBounds(437, 35, 100, 41);
		frame.getContentPane().add(rdbtnItem_1_1);
		
		JRadioButton rdbtnItem_2 = new JRadioButton("item1");
		rdbtnItem_2.setBounds(304, 35, 100, 41);
		frame.getContentPane().add(rdbtnItem_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ShopItemScreen.class.getResource("/Images/Watermelons.png")));
		label.setBounds(56, 84, 65, 65);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ShopItemScreen.class.getResource("/Images/Steaks.png")));
		label_1.setBounds(189, 84, 65, 65);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ShopItemScreen.class.getResource("/Images/Axe.png")));
		label_2.setBounds(322, 84, 65, 65);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(ShopItemScreen.class.getResource("/Images/Helmet.png")));
		label_3.setBounds(455, 84, 65, 65);
		frame.getContentPane().add(label_3);
		
		JLabel lblAttack = new JLabel("attack +10");
		lblAttack.setBounds(228, 189, 207, 15);
		frame.getContentPane().add(lblAttack);
	}
}
