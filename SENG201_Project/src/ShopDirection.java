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
		frmShop.setBounds(100, 100, 245, 204);
		frmShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShop.getContentPane().setLayout(null);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopMonsterScreen();
				closeWindow();
			}
		});
		btnBuy.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBuy.setBounds(37, 12, 168, 70);
		frmShop.getContentPane().add(btnBuy);
		
		JButton btnSale = new JButton("Sale");
		btnSale.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSale.setBounds(37, 94, 168, 70);
		frmShop.getContentPane().add(btnSale);
	}
}
