import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGold = new JLabel("gold");
		lblGold.setBounds(12, 12, 70, 15);
		frame.getContentPane().add(lblGold);
		
		JLabel lblItemsForSale = new JLabel("Items for sale");
		lblItemsForSale.setBounds(164, 12, 150, 20);
		frame.getContentPane().add(lblItemsForSale);
		
		JRadioButton rdbtnItem = new JRadioButton("item1");
		rdbtnItem.setBounds(8, 68, 100, 100);
		frame.getContentPane().add(rdbtnItem);
		
		JRadioButton rdbtnItem_1 = new JRadioButton("item1");
		rdbtnItem_1.setBounds(112, 68, 100, 100);
		frame.getContentPane().add(rdbtnItem_1);
		
		JRadioButton rdbtnItem_2 = new JRadioButton("item1");
		rdbtnItem_2.setBounds(216, 68, 100, 100);
		frame.getContentPane().add(rdbtnItem_2);
		
		JRadioButton rdbtnItem_3 = new JRadioButton("item1");
		rdbtnItem_3.setBounds(320, 68, 100, 100);
		frame.getContentPane().add(rdbtnItem_3);
		
		JButton btnBuy = new JButton("buy");
		btnBuy.setBounds(303, 233, 130, 30);
		frame.getContentPane().add(btnBuy);
		
		JButton btnMonster = new JButton("Monster");
		btnMonster.setBounds(174, 233, 117, 30);
		frame.getContentPane().add(btnMonster);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(45, 233, 117, 30);
		frame.getContentPane().add(btnExit);
	}

}
