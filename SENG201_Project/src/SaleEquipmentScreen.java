import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class SaleEquipmentScreen {

	private JFrame frame;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private GameManager manager;
	private Item selectedEquipment = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleEquipmentScreen window = new SaleEquipmentScreen();
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
	public SaleEquipmentScreen() {
		initialize();
	}
	
	public SaleEquipmentScreen(GameManager manager) {
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
		int EquipmentListSize = manager.getPlayer().getEquipmentList().size();
		ArrayList<Item> EquipmentList = manager.getPlayer().getEquipmentList();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(12, 314, 267, 15);
		label.setForeground(Color.RED);
		frame.getContentPane().add(label);
		
		/**/
		

		
		if (EquipmentListSize >= 1) {
			Item FirstEquipment = manager.getPlayer().getEquipmentList().get(0);
			
			int FirstEquipmentQuanitty = FirstEquipment.getQuantity();
			String FirstEquipmentQuanittyString = "";
			if (FirstEquipmentQuanitty >= 10) {
				FirstEquipmentQuanittyString = "x" + FirstEquipmentQuanitty;
			} else {
				FirstEquipmentQuanittyString = "x0" + FirstEquipmentQuanitty;
			}
			
			String FirstEquipmentName = FirstEquipment.getItemID();
			JRadioButton rdbtnNameOfEquip0 = new JRadioButton(FirstEquipmentName);
			rdbtnNameOfEquip0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedEquipment = EquipmentList.get(0);
				}
			});
			buttonGroup.add(rdbtnNameOfEquip0);
			rdbtnNameOfEquip0.setBounds(12, 54, 177, 33);
			frame.getContentPane().add(rdbtnNameOfEquip0);
			
			JLabel lblX_4 = new JLabel(FirstEquipmentQuanittyString);
			lblX_4.setForeground(Color.BLACK);
			lblX_4.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_4.setBounds(222, 86, 42, 24);
			frame.getContentPane().add(lblX_4);
			

			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + FirstEquipmentName + ".png")));
			lblNewLabel_3.setBounds(203, 54, 61, 56);
			frame.getContentPane().add(lblNewLabel_3);
			
			int EquipmentPrice0 = FirstEquipment.getSellingPrice();
			JLabel lblPrice = new JLabel("$" + EquipmentPrice0);
			lblPrice.setBounds(119, 95, 70, 15);
			frame.getContentPane().add(lblPrice);
			

		}
		
		if (EquipmentListSize >= 2) {
			Item SecondEquipment = manager.getPlayer().getEquipmentList().get(1);
			
			int SecondEquipmentQuanitty = SecondEquipment.getQuantity();
			String SecondEquipmentQuanittyString = "";
			if (SecondEquipmentQuanitty >= 10) {
				SecondEquipmentQuanittyString = "x" + SecondEquipmentQuanitty;
			} else {
				SecondEquipmentQuanittyString = "x0" + SecondEquipmentQuanitty;
			}
			
			String SecondEquipmentName = SecondEquipment.getItemID();
			JRadioButton rdbtnNameOfEquip1 = new JRadioButton(SecondEquipmentName);
			rdbtnNameOfEquip1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedEquipment = EquipmentList.get(0);
				}
			});
			buttonGroup.add(rdbtnNameOfEquip1);
			rdbtnNameOfEquip1.setBounds(12, 118, 177, 33);
			frame.getContentPane().add(rdbtnNameOfEquip1);
			
			JLabel lblX_5 = new JLabel(SecondEquipmentQuanittyString);
			lblX_5.setForeground(Color.BLACK);
			lblX_5.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_5.setBounds(222, 150, 42, 24);
			frame.getContentPane().add(lblX_5);
			
			JLabel lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + SecondEquipmentName + ".png")));
			lblNewLabel_1_1.setBounds(203, 118, 61, 56);
			frame.getContentPane().add(lblNewLabel_1_1);
			
			int EquipmentPrice1 = SecondEquipment.getSellingPrice();
			JLabel lblPrice_1 = new JLabel("$" + EquipmentPrice1);
			lblPrice_1.setBounds(119, 159, 70, 15);
			frame.getContentPane().add(lblPrice_1);


		}
		
		if (EquipmentListSize >= 3) {
			Item ThirdEquipment = manager.getPlayer().getEquipmentList().get(2);
			
			int ThirdEquipmentQuanitty = ThirdEquipment.getQuantity();
			String ThirdEquipmentQuanittyString = "";
			if (ThirdEquipmentQuanitty >= 10) {
				ThirdEquipmentQuanittyString = "x" + ThirdEquipmentQuanitty;
			} else {
				ThirdEquipmentQuanittyString = "x0" + ThirdEquipmentQuanitty;
			}
			
			String ThirdEquipmentName = ThirdEquipment.getItemID();
			JRadioButton rdbtnNameOfEquip2 = new JRadioButton(ThirdEquipmentName);
			rdbtnNameOfEquip2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedEquipment = EquipmentList.get(0);
				}
			});
			buttonGroup.add(rdbtnNameOfEquip2);
			rdbtnNameOfEquip2.setBounds(12, 182, 177, 33);
			frame.getContentPane().add(rdbtnNameOfEquip2);
			
			JLabel lblX_6 = new JLabel(ThirdEquipmentQuanittyString);
			lblX_6.setForeground(Color.BLACK);
			lblX_6.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_6.setBounds(222, 214, 42, 24);
			frame.getContentPane().add(lblX_6);
			
			
			JLabel lblNewLabel_2_1 = new JLabel("");
			lblNewLabel_2_1.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + ThirdEquipmentName + ".png")));
			lblNewLabel_2_1.setBounds(203, 182, 61, 56);
			frame.getContentPane().add(lblNewLabel_2_1);
			
			int EquipmentPrice2 = ThirdEquipment.getSellingPrice();
			JLabel lblPrice_1_1 = new JLabel("$" + EquipmentPrice2);
			lblPrice_1_1.setBounds(119, 223, 70, 15);
			frame.getContentPane().add(lblPrice_1_1);
			
		}
		
		if (EquipmentListSize >= 4) {
			Item FourthEquipment = manager.getPlayer().getEquipmentList().get(3);
			
			int FourthEquipmentQuanitty = FourthEquipment.getQuantity();
			String FourthEquipmentQuanittyString = "";
			if (FourthEquipmentQuanitty >= 10) {
				FourthEquipmentQuanittyString = "x" + FourthEquipmentQuanitty;
			} else {
				FourthEquipmentQuanittyString = "x0" + FourthEquipmentQuanitty;
			}
			
			String FourthEquipmentName = FourthEquipment.getItemID();
			JRadioButton rdbtnNameOfEquip3 = new JRadioButton(FourthEquipmentName);
			rdbtnNameOfEquip3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedEquipment = EquipmentList.get(0);
				}
			});
			buttonGroup.add(rdbtnNameOfEquip3);
			rdbtnNameOfEquip3.setBounds(12, 246, 177, 33);
			frame.getContentPane().add(rdbtnNameOfEquip3);
			
			JLabel lblX_7 = new JLabel(FourthEquipmentQuanittyString);
			lblX_7.setForeground(Color.BLACK);
			lblX_7.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_7.setBounds(222, 274, 42, 24);
			frame.getContentPane().add(lblX_7);
			
			JLabel lblNewLabel_3_1 = new JLabel("");
			lblNewLabel_3_1.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + FourthEquipmentName + ".png")));
			lblNewLabel_3_1.setBounds(203, 246, 61, 56);
			frame.getContentPane().add(lblNewLabel_3_1);
			
			int EquipmentPrice3 = FourthEquipment.getSellingPrice();
			JLabel lblPrice_1_2 = new JLabel("$" + EquipmentPrice3);
			lblPrice_1_2.setBounds(119, 287, 70, 15);
			frame.getContentPane().add(lblPrice_1_2);
			
			
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
				if (selectedEquipment != null) {
					int SalePrice = selectedEquipment.getSellingPrice();
					manager.getPlayer().soldEquipment(selectedEquipment);
					manager.launchSaleEquipmentScreen();
					closeWindow();

				} else {
					label.setText("Please select an Equipment to sale");
				}
			}
		});
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(12, 341, 80, 30);
		frame.getContentPane().add(btnUse);
		
		int goldAmount = manager.getPlayer().getGoldAmount();
		JLabel lblGold = new JLabel(Integer.toString(goldAmount));
		lblGold.setIcon(new ImageIcon(SaleEquipmentScreen.class.getResource("/Images/Coin.png")));
		lblGold.setBounds(12, 12, 100, 30);
		frame.getContentPane().add(lblGold);
		

		

	}
}	

