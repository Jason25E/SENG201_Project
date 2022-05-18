import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SaleItemScreen {

	private JFrame frame;
	private GameManager manager;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 292, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
			}
		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(195, 518, 80, 30);
		frame.getContentPane().add(btnExit);
		
		JButton btnUse = new JButton("Sale");
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(8, 518, 80, 30);
		frame.getContentPane().add(btnUse);
		
		JRadioButton rdbtnNameOfItem = new JRadioButton("Watermelon");
		rdbtnNameOfItem.setBounds(8, 8, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem);
		
		JLabel lblX = new JLabel("x01");
		lblX.setForeground(Color.BLACK);
		lblX.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX.setBounds(218, 40, 42, 24);
		frame.getContentPane().add(lblX);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SaleItemScreen.class.getResource("/Images/Food/Watermelons.png")));
		lblNewLabel.setBounds(199, 8, 61, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNameOfItem_1 = new JRadioButton("Sandwich");
		rdbtnNameOfItem_1.setBounds(8, 72, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem_1);
		
		JLabel lblX_1 = new JLabel("x01");
		lblX_1.setForeground(Color.BLACK);
		lblX_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX_1.setBounds(218, 104, 42, 24);
		frame.getContentPane().add(lblX_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(SaleItemScreen.class.getResource("/Images/Food/Sandwich.png")));
		lblNewLabel_4.setBounds(199, 72, 61, 56);
		frame.getContentPane().add(lblNewLabel_4);
		
		JRadioButton rdbtnNameOfItem_2 = new JRadioButton("Steak");
		rdbtnNameOfItem_2.setBounds(8, 136, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem_2);
		
		JLabel lblX_2 = new JLabel("x01");
		lblX_2.setForeground(Color.BLACK);
		lblX_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX_2.setBounds(218, 168, 42, 24);
		frame.getContentPane().add(lblX_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SaleItemScreen.class.getResource("/Images/Food/Steaks.png")));
		lblNewLabel_1.setBounds(199, 136, 61, 56);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnNameOfItem_3 = new JRadioButton("Coffee");
		rdbtnNameOfItem_3.setBounds(8, 200, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem_3);
		
		JLabel lblX_3 = new JLabel("x01");
		lblX_3.setForeground(Color.BLACK);
		lblX_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX_3.setBounds(218, 232, 42, 24);
		frame.getContentPane().add(lblX_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SaleItemScreen.class.getResource("/Images/Food/Coffee.png")));
		lblNewLabel_2.setBounds(199, 200, 61, 56);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnMonster = new JButton("Monster");
		btnMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchSaleMonsterScreen();
			}
		});
		btnMonster.setFont(new Font("Dialog", Font.BOLD, 10));
		btnMonster.setBounds(101, 518, 80, 30);
		frame.getContentPane().add(btnMonster);
		
		JRadioButton rdbtnNameOfEquip = new JRadioButton("Sword");
		rdbtnNameOfEquip.setBounds(8, 262, 177, 56);
		frame.getContentPane().add(rdbtnNameOfEquip);
		
		JLabel lblX_4 = new JLabel("x01");
		lblX_4.setForeground(Color.BLACK);
		lblX_4.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX_4.setBounds(218, 294, 42, 24);
		frame.getContentPane().add(lblX_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(SaleItemScreen.class.getResource("/Images/Equipment/Sword.png")));
		lblNewLabel_3.setBounds(199, 262, 61, 56);
		frame.getContentPane().add(lblNewLabel_3);
		
		JRadioButton rdbtnAxe = new JRadioButton("Axe");
		rdbtnAxe.setBounds(8, 326, 177, 56);
		frame.getContentPane().add(rdbtnAxe);
		
		JLabel lblX_5 = new JLabel("x01");
		lblX_5.setForeground(Color.BLACK);
		lblX_5.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX_5.setBounds(218, 358, 42, 24);
		frame.getContentPane().add(lblX_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(SaleItemScreen.class.getResource("/Images/Equipment/Axe.png")));
		lblNewLabel_1_1.setBounds(199, 326, 61, 56);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JRadioButton rdbtnHelmet = new JRadioButton("Helmet");
		rdbtnHelmet.setBounds(8, 390, 177, 56);
		frame.getContentPane().add(rdbtnHelmet);
		
		JLabel lblX_6 = new JLabel("x01");
		lblX_6.setForeground(Color.BLACK);
		lblX_6.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX_6.setBounds(218, 422, 42, 24);
		frame.getContentPane().add(lblX_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(SaleItemScreen.class.getResource("/Images/Equipment/Helmet.png")));
		lblNewLabel_2_1.setBounds(199, 390, 61, 56);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JRadioButton rdbtnSheild = new JRadioButton("Sheild");
		rdbtnSheild.setBounds(8, 454, 177, 56);
		frame.getContentPane().add(rdbtnSheild);
		
		JLabel lblX_7 = new JLabel("x01");
		lblX_7.setForeground(Color.BLACK);
		lblX_7.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX_7.setBounds(218, 482, 42, 24);
		frame.getContentPane().add(lblX_7);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(SaleItemScreen.class.getResource("/Images/Equipment/Shield.png")));
		lblNewLabel_3_1.setBounds(199, 454, 61, 56);
		frame.getContentPane().add(lblNewLabel_3_1);
	}

}
