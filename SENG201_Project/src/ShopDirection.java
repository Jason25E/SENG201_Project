import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * The class ShopDirection
 * Can launch 
 * SaleMonsterScreen
 * SaleItemScreen
 * SaleEquipmentScreen
 * ShopMonsterScreen
 * ShopItemScreen
 * @author fye15, zde19
 *
 */
public class ShopDirection {

	private JFrame frmShop;
	
	private GameManager manager;

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
		frmShop.setBounds(100, 100, 253, 356);
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
				closeWindow();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(66, 55, 117, 25);
		frmShop.getContentPane().add(btnNewButton);
		
		JButton btnItem = new JButton("Food & Equip.");
		btnItem.setFont(new Font("Dialog", Font.BOLD, 10));
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopItemScreen();
				closeWindow();
			}
		});
		btnItem.setBounds(66, 91, 117, 25);
		frmShop.getContentPane().add(btnItem);
		
		JButton btnNewButton_1 = new JButton("Monster");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchSaleMonsterScreen();
				closeWindow();
			}
		});
		btnNewButton_1.setBounds(66, 171, 117, 25);
		frmShop.getContentPane().add(btnNewButton_1);
		
		JButton btnFood = new JButton("Food");
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchSaleItemScreen();
				closeWindow();
			}
		});
		btnFood.setBounds(66, 208, 117, 25);
		frmShop.getContentPane().add(btnFood);
		
		JButton btnEquipment = new JButton("Equipment");
		btnEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchSaleEquipmentScreen();
				closeWindow();
			}
		});
		btnEquipment.setBounds(66, 245, 117, 25);
		frmShop.getContentPane().add(btnEquipment);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 51, 102));
		btnExit.setForeground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
				closeWindow();
			}
		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 17));
		btnExit.setBounds(66, 290, 117, 25);
		frmShop.getContentPane().add(btnExit);
	}
}
