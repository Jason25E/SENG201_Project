import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EquipmentScreen {

	private JFrame frmMyEquipment;
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
					EquipmentScreen window = new EquipmentScreen();
					window.frmMyEquipment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EquipmentScreen() {
		initialize();
	}
	
	public EquipmentScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmMyEquipment.setVisible(true);
	}
	
	public void closeWindow() {
		frmMyEquipment.dispose();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int EquipmentListSize = manager.getPlayer().getEquipmentList().size();
		ArrayList<Item> EquipmentList = manager.getPlayer().getEquipmentList();
		
		frmMyEquipment = new JFrame();
		frmMyEquipment.setTitle("My Equipment");
		frmMyEquipment.setBounds(100, 100, 276, 396);
		frmMyEquipment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyEquipment.getContentPane().setLayout(null);
		
		JLabel lblEffect = new JLabel("");
		lblEffect.setBounds(22, 268, 254, 22);
		frmMyEquipment.getContentPane().add(lblEffect);
		
		String[] monsterName = new String[4];
		int index = 0;
		for (Monster i: manager.getPlayer().getMonsterList()) {
			monsterName[index] = i.getMonsterName();
			index += 1;
		}
		JComboBox<String> comboBox = new JComboBox<>(monsterName);
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(146, 292, 114, 24);
		frmMyEquipment.getContentPane().add(comboBox);
		
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
					lblEffect.setForeground(Color.BLACK);
					lblEffect.setText(selectedEquipment.getItemEffect());
				}
			});
			buttonGroup.add(rdbtnNameOfEquip0);
			rdbtnNameOfEquip0.setBounds(8, 12, 177, 56);
			frmMyEquipment.getContentPane().add(rdbtnNameOfEquip0);
			
			JLabel lblX = new JLabel(FirstEquipmentQuanittyString);
			lblX.setForeground(Color.BLACK);
			lblX.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX.setBounds(218, 44, 42, 24);
			frmMyEquipment.getContentPane().add(lblX);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + FirstEquipmentName + ".png")));
			lblNewLabel.setBounds(199, 12, 61, 56);
			frmMyEquipment.getContentPane().add(lblNewLabel);
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
					selectedEquipment = EquipmentList.get(1);
					lblEffect.setForeground(Color.BLACK);
					lblEffect.setText(selectedEquipment.getItemEffect());
				}
			});
			buttonGroup.add(rdbtnNameOfEquip1);
			rdbtnNameOfEquip1.setBounds(8, 76, 177, 56);
			frmMyEquipment.getContentPane().add(rdbtnNameOfEquip1);
			
			JLabel lblX_1 = new JLabel(SecondEquipmentQuanittyString);
			lblX_1.setForeground(Color.BLACK);
			lblX_1.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_1.setBounds(218, 108, 42, 24);
			frmMyEquipment.getContentPane().add(lblX_1);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + SecondEquipmentName + ".png")));
			lblNewLabel_1.setBounds(199, 76, 61, 56);
			frmMyEquipment.getContentPane().add(lblNewLabel_1);
			
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
					selectedEquipment = EquipmentList.get(2);
					lblEffect.setForeground(Color.BLACK);
					lblEffect.setText(selectedEquipment.getItemEffect());
				}
			});
			buttonGroup.add(rdbtnNameOfEquip2);
			rdbtnNameOfEquip2.setBounds(8, 140, 177, 56);
			frmMyEquipment.getContentPane().add(rdbtnNameOfEquip2);
			
			JLabel lblX_1_1 = new JLabel(ThirdEquipmentQuanittyString);
			lblX_1_1.setForeground(Color.BLACK);
			lblX_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_1_1.setBounds(218, 172, 42, 24);
			frmMyEquipment.getContentPane().add(lblX_1_1);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + ThirdEquipmentName + ".png")));
			lblNewLabel_2.setBounds(199, 140, 61, 56);
			frmMyEquipment.getContentPane().add(lblNewLabel_2);
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
					selectedEquipment = EquipmentList.get(3);
					lblEffect.setForeground(Color.BLACK);
					lblEffect.setText(selectedEquipment.getItemEffect());
				}
			});
			buttonGroup.add(rdbtnNameOfEquip3);
			rdbtnNameOfEquip3.setBounds(8, 204, 177, 56);
			frmMyEquipment.getContentPane().add(rdbtnNameOfEquip3);
			
			JLabel lblX_1_2 = new JLabel(FourthEquipmentQuanittyString);
			lblX_1_2.setForeground(Color.BLACK);
			lblX_1_2.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_1_2.setBounds(218, 232, 42, 24);
			frmMyEquipment.getContentPane().add(lblX_1_2);
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + FourthEquipmentName + ".png")));
			lblNewLabel_3.setBounds(199, 204, 61, 56);
			frmMyEquipment.getContentPane().add(lblNewLabel_3);
		}
		

		JButton btnUse = new JButton("Use");
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBox.getSelectedIndex();
				lblEffect.setForeground(Color.RED);
				if (selectedEquipment != null) {
					if (selectedEquipment.getQuantity() > 0) {
						manager.getPlayer().getMonsterList().get(index).setMonsterEquipment((Equipment)selectedEquipment);
						lblEffect.setText("Success");
						manager.launchEquipmentScreen();
						closeWindow();
					} else {
						lblEffect.setText("No equipment");
					}
				} else {
					lblEffect.setText("Please select a Equip. to use");
				}
			}
		});
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(12, 325, 80, 30);
		frmMyEquipment.getContentPane().add(btnUse);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 51, 102));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
				closeWindow();
			}
		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(175, 325, 80, 30);
		frmMyEquipment.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_4 = new JLabel("Monster to use:");
		lblNewLabel_4.setBounds(22, 295, 130, 15);
		frmMyEquipment.getContentPane().add(lblNewLabel_4);
		
	}
}
