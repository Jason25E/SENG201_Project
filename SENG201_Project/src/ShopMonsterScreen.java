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
import javax.swing.ImageIcon;

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
		frame.setBounds(100, 100, 590, 302);
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
		rdbtnMonster.setBounds(12, 35, 130, 38);
		frame.getContentPane().add(rdbtnMonster);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.setBounds(27, 229, 130, 30);
		frame.getContentPane().add(btnExit_1);
		
		JButton btnItem = new JButton("Item");
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnItem.setBounds(240, 229, 117, 30);
		frame.getContentPane().add(btnItem);
		
		JButton btnBuy = new JButton("buy");
		btnBuy.setBounds(446, 229, 130, 30);
		frame.getContentPane().add(btnBuy);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ShopMonsterScreen.class.getResource("/Images/ShopDemon.png")));
		label.setBounds(12, 81, 130, 120);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ShopMonsterScreen.class.getResource("/Images/ShopSlime.png")));
		label_1.setBounds(235, 81, 130, 120);
		frame.getContentPane().add(label_1);
		
		JRadioButton rdbtnMonster_1 = new JRadioButton("monster");
		rdbtnMonster_1.setForeground(Color.BLACK);
		rdbtnMonster_1.setBounds(235, 35, 130, 38);
		frame.getContentPane().add(rdbtnMonster_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ShopMonsterScreen.class.getResource("/Images/ShopGhost.png")));
		label_2.setBounds(450, 81, 130, 120);
		frame.getContentPane().add(label_2);
		
		JRadioButton rdbtnMonster_2 = new JRadioButton("monster");
		rdbtnMonster_2.setForeground(Color.BLACK);
		rdbtnMonster_2.setBounds(450, 35, 130, 38);
		frame.getContentPane().add(rdbtnMonster_2);
	}
}
