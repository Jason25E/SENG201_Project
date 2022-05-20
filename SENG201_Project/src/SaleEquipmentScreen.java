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
		frame.setBounds(100, 100, 292, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
			rdbtnNameOfEquip0.setBounds(8, 12, 177, 56);
			frame.getContentPane().add(rdbtnNameOfEquip0);
			
			JLabel lblX_4 = new JLabel(FirstEquipmentQuanittyString);
			lblX_4.setForeground(Color.BLACK);
			lblX_4.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_4.setBounds(218, 44, 42, 24);
			frame.getContentPane().add(lblX_4);
			
			JLabel lblNewLabel_3 = new JLabel("/Images/Equipment/" + FirstEquipmentName + ".png");
			lblNewLabel_3.setBounds(199, 12, 61, 56);
			frame.getContentPane().add(lblNewLabel_3);
			

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
			rdbtnNameOfEquip1.setBounds(8, 76, 177, 56);
			frame.getContentPane().add(rdbtnNameOfEquip1);
			
			JLabel lblX_5 = new JLabel(SecondEquipmentQuanittyString);
			lblX_5.setForeground(Color.BLACK);
			lblX_5.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_5.setBounds(218, 108, 42, 24);
			frame.getContentPane().add(lblX_5);
			
			JLabel lblNewLabel_1_1 = new JLabel("/Images/Equipment/" + SecondEquipmentName + ".png");
			lblNewLabel_1_1.setBounds(199, 76, 61, 56);
			frame.getContentPane().add(lblNewLabel_1_1);
			

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
			rdbtnNameOfEquip2.setBounds(8, 140, 177, 56);
			frame.getContentPane().add(rdbtnNameOfEquip2);
			
			JLabel lblX_6 = new JLabel(ThirdEquipmentQuanittyString);
			lblX_6.setForeground(Color.BLACK);
			lblX_6.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_6.setBounds(218, 172, 42, 24);
			frame.getContentPane().add(lblX_6);
			
			JLabel lblNewLabel_2_1 = new JLabel("/Images/Equipment/" + ThirdEquipmentName + ".png");
			lblNewLabel_2_1.setBounds(199, 140, 61, 56);
			frame.getContentPane().add(lblNewLabel_2_1);
			
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
			rdbtnNameOfEquip3.setBounds(8, 204, 177, 56);
			frame.getContentPane().add(rdbtnNameOfEquip3);
			
			JLabel lblX_7 = new JLabel(FourthEquipmentQuanittyString);
			lblX_7.setForeground(Color.BLACK);
			lblX_7.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_7.setBounds(218, 232, 42, 24);
			frame.getContentPane().add(lblX_7);
			
			JLabel lblNewLabel_3_1 = new JLabel("/Images/Equipment/" + FourthEquipmentName + ".png");
			lblNewLabel_3_1.setBounds(199, 204, 61, 56);
			frame.getContentPane().add(lblNewLabel_3_1);
			
			
		}
	
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopDirectionScreen();
				closeWindow();
			}
		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(195, 268, 80, 30);
		frame.getContentPane().add(btnExit);
		
		
		JButton btnUse = new JButton("Sale");
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(8, 268, 80, 30);
		frame.getContentPane().add(btnUse);
		
	}
		

}	

