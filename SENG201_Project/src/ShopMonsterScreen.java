import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopMonsterScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMonsterScreen window = new ShopMonsterScreen();
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
	public ShopMonsterScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGold = new JLabel("gold");
		lblGold.setBounds(27, 12, 70, 15);
		frame.getContentPane().add(lblGold);
		
		JLabel lblMonstersForSale = new JLabel("Monsters for sale");
		lblMonstersForSale.setBounds(207, 9, 150, 20);
		frame.getContentPane().add(lblMonstersForSale);
		
		JRadioButton rdbtnMonster = new JRadioButton("monster");
		rdbtnMonster.setForeground(Color.BLACK);
		rdbtnMonster.setBounds(27, 35, 100, 150);
		frame.getContentPane().add(rdbtnMonster);
		
		JRadioButton rdbtnMonster_1 = new JRadioButton("monster");
		rdbtnMonster_1.setForeground(Color.BLACK);
		rdbtnMonster_1.setBounds(131, 35, 100, 150);
		frame.getContentPane().add(rdbtnMonster_1);
		
		JRadioButton rdbtnMonster_2 = new JRadioButton("monster");
		rdbtnMonster_2.setForeground(Color.BLACK);
		rdbtnMonster_2.setBounds(235, 35, 100, 150);
		frame.getContentPane().add(rdbtnMonster_2);
		
		JRadioButton rdbtnMonster_3 = new JRadioButton("monster");
		rdbtnMonster_3.setForeground(Color.BLACK);
		rdbtnMonster_3.setBounds(338, 35, 100, 150);
		frame.getContentPane().add(rdbtnMonster_3);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.setBounds(26, 230, 130, 30);
		frame.getContentPane().add(btnExit_1);
		
		JButton btnItem = new JButton("Item");
		btnItem.setBounds(168, 230, 117, 30);
		frame.getContentPane().add(btnItem);
		
		JButton btnMonster = new JButton("Sale");
		btnMonster.setBounds(297, 230, 117, 30);
		frame.getContentPane().add(btnMonster);
		
		JButton btnBuy = new JButton("buy");
		btnBuy.setBounds(426, 230, 130, 30);
		frame.getContentPane().add(btnBuy);
		
		JRadioButton rdbtnMonster_4 = new JRadioButton("monster");
		rdbtnMonster_4.setForeground(Color.BLACK);
		rdbtnMonster_4.setBounds(442, 35, 100, 150);
		frame.getContentPane().add(rdbtnMonster_4);
	}
}
