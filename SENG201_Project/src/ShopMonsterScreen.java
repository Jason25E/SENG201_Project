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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGold = new JLabel("gold");
		lblGold.setBounds(27, 12, 70, 15);
		frame.getContentPane().add(lblGold);
		
		JLabel lblMonstersForSale = new JLabel("Monsters for sale");
		lblMonstersForSale.setBounds(143, 9, 150, 20);
		frame.getContentPane().add(lblMonstersForSale);
		
		JRadioButton rdbtnMonster = new JRadioButton("monster");
		rdbtnMonster.setForeground(Color.BLACK);
		rdbtnMonster.setBounds(8, 65, 100, 150);
		frame.getContentPane().add(rdbtnMonster);
		
		JRadioButton rdbtnMonster_1 = new JRadioButton("monster");
		rdbtnMonster_1.setForeground(Color.BLACK);
		rdbtnMonster_1.setBounds(112, 65, 100, 150);
		frame.getContentPane().add(rdbtnMonster_1);
		
		JRadioButton rdbtnMonster_2 = new JRadioButton("monster");
		rdbtnMonster_2.setForeground(Color.BLACK);
		rdbtnMonster_2.setBounds(216, 65, 100, 150);
		frame.getContentPane().add(rdbtnMonster_2);
		
		JRadioButton rdbtnMonster_3 = new JRadioButton("monster");
		rdbtnMonster_3.setForeground(Color.BLACK);
		rdbtnMonster_3.setBounds(319, 65, 100, 150);
		frame.getContentPane().add(rdbtnMonster_3);
		
		JButton btnBuy = new JButton("buy");
		btnBuy.setBounds(306, 227, 130, 30);
		frame.getContentPane().add(btnBuy);
		
		JButton btnItem = new JButton("Item");
		btnItem.setBounds(177, 227, 117, 30);
		frame.getContentPane().add(btnItem);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(48, 227, 117, 30);
		frame.getContentPane().add(btnExit);
	}
}
