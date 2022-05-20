import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopDirection {

	private JFrame frmShop;
	
	private GameManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopDirection window = new ShopDirection();
					window.frmShop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShopDirection() {
		initialize();
	}
	
	public ShopDirection(GameManager manager) {
		this.manager = manager;
		initialize();
		frmShop.setVisible(true);
	}
	
	public void closeWindow() {
		frmShop.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShop = new JFrame();
		frmShop.setTitle("Shop");
		frmShop.setBounds(100, 100, 253, 371);
		frmShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShop.getContentPane().setLayout(null);
		
		JLabel lblChooseWhichShop = new JLabel("Buy");
		lblChooseWhichShop.setFont(new Font("Dialog", Font.BOLD, 17));
		lblChooseWhichShop.setBounds(101, 12, 63, 31);
		frmShop.getContentPane().add(lblChooseWhichShop);
		
		JLabel lblSale = new JLabel("Sale");
		lblSale.setFont(new Font("Dialog", Font.BOLD, 17));
		lblSale.setBounds(101, 128, 63, 31);
		frmShop.getContentPane().add(lblSale);
		
		JButton btnNewButton = new JButton("Monster");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopMonsterScreen();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(66, 55, 117, 25);
		frmShop.getContentPane().add(btnNewButton);
		
		JButton btnItem = new JButton("Item");
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopItemScreen();
			}
		});
		btnItem.setBounds(66, 91, 117, 25);
		frmShop.getContentPane().add(btnItem);
		
		JButton btnNewButton_1 = new JButton("Monster");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchSaleMonsterScreen;
			}
		});
		btnNewButton_1.setBounds(66, 171, 117, 25);
		frmShop.getContentPane().add(btnNewButton_1);
		
		JButton btnFood = new JButton("Food");
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchSaleItemScreen();
			}
		});
		btnFood.setBounds(66, 208, 117, 25);
		frmShop.getContentPane().add(btnFood);
		
		JButton btnEquipment = new JButton("Equipment");
		btnEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchSaleEquipmentScreen();
			}
		});
		btnEquipment.setBounds(66, 245, 117, 25);
		frmShop.getContentPane().add(btnEquipment);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
				closeWindow();
			}
		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 17));
		btnExit.setBounds(66, 303, 117, 25);
		frmShop.getContentPane().add(btnExit);
	}
}
