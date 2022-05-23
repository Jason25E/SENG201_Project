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

/**
 * The class EquipmentScreen
 * Show all the equipment in the inventory 
 * Allow player to equip for the monster in the monster list
 * @author fye15, zde19
 *
 */
public class EquipmentScreen {

	private JFrame frmMyEquipment;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private GameManager manager;
	private Item selectedEquipment = null;
	
	/**
	 * The variable take one parameter
	 * @param manager of the type GameManager
	 */
	public EquipmentScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmMyEquipment.setVisible(true);
	}
	
	/**
	 * Close application
	 */
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
		
		/**
		 * A label takes the information fro the Use
		 */
		JLabel lblEffect = new JLabel("");
		lblEffect.setBounds(22, 268, 254, 22);
		frmMyEquipment.getContentPane().add(lblEffect);
		
		/**
		 * A comboBox takes all the monster in the monster list 
		 * Display each monster name the player
		 */
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
		
		/**
		 * Display the first equipment
		 * if there is a equipment in the list
		 */
		if (EquipmentListSize >= 1) {
			Item FirstEquipment = manager.getPlayer().getEquipmentList().get(0);
			
			/**
			 * A label shows the number of the first equipment
			 */
			int FirstEquipmentQuanitty = FirstEquipment.getQuantity();
			String FirstEquipmentQuanittyString = "";
			if (FirstEquipmentQuanitty >= 10) {
				FirstEquipmentQuanittyString = "x" + FirstEquipmentQuanitty;
			} else {
				FirstEquipmentQuanittyString = "x0" + FirstEquipmentQuanitty;
			}
			
			JLabel lblX = new JLabel(FirstEquipmentQuanittyString);
			lblX.setForeground(Color.BLACK);
			lblX.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX.setBounds(218, 44, 42, 24);
			frmMyEquipment.getContentPane().add(lblX);
			
			/**
			 * A RadioButton with the name of the first equipment
			 * Set the selectedEquipment to the first equipmet if selected
			 */
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
			
			/**
			 * A label show the image of the first equipment
			 */
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + FirstEquipmentName + ".png")));
			lblNewLabel.setBounds(199, 12, 61, 56);
			frmMyEquipment.getContentPane().add(lblNewLabel);
		}
		
		/**
		 * Display the second equipment
		 * if there is a equipment in the list
		 */
		if (EquipmentListSize >= 2) {
			Item SecondEquipment = manager.getPlayer().getEquipmentList().get(1);
			
			/**
			 * A label shows the number of the second equipment
			 */
			int SecondEquipmentQuanitty = SecondEquipment.getQuantity();
			String SecondEquipmentQuanittyString = "";
			if (SecondEquipmentQuanitty >= 10) {
				SecondEquipmentQuanittyString = "x" + SecondEquipmentQuanitty;
			} else {
				SecondEquipmentQuanittyString = "x0" + SecondEquipmentQuanitty;
			}
			JLabel lblX_1 = new JLabel(SecondEquipmentQuanittyString);
			lblX_1.setForeground(Color.BLACK);
			lblX_1.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_1.setBounds(218, 108, 42, 24);
			frmMyEquipment.getContentPane().add(lblX_1);
			
			/**
			 * A RadioButton with the name of the second equipment
			 * Set the selectedEquipment to the second equipmet if selected
			 */
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
			
			/**
			 * A label show the image of the second equipment
			 */
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + SecondEquipmentName + ".png")));
			lblNewLabel_1.setBounds(199, 76, 61, 56);
			frmMyEquipment.getContentPane().add(lblNewLabel_1);
			
		}
		
		/**
		 * Display the third equipment
		 * if there is a equipment in the list
		 */
		if (EquipmentListSize >= 3) {
			Item ThirdEquipment = manager.getPlayer().getEquipmentList().get(2);
			
			/**
			 * A label shows the number of the third equipment
			 */
			int ThirdEquipmentQuanitty = ThirdEquipment.getQuantity();
			String ThirdEquipmentQuanittyString = "";
			if (ThirdEquipmentQuanitty >= 10) {
				ThirdEquipmentQuanittyString = "x" + ThirdEquipmentQuanitty;
			} else {
				ThirdEquipmentQuanittyString = "x0" + ThirdEquipmentQuanitty;
			}
			JLabel lblX_1_1 = new JLabel(ThirdEquipmentQuanittyString);
			lblX_1_1.setForeground(Color.BLACK);
			lblX_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_1_1.setBounds(218, 172, 42, 24);
			frmMyEquipment.getContentPane().add(lblX_1_1);
			
			/**
			 * A RadioButton with the name of the third equipment
			 * Set the selectedEquipment to the third equipmet if selected
			 */
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
			
			/**
			 * A label show the image of the third equipment
			 */
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + ThirdEquipmentName + ".png")));
			lblNewLabel_2.setBounds(199, 140, 61, 56);
			frmMyEquipment.getContentPane().add(lblNewLabel_2);
		}
		
		/**
		 * Display the fourth equipment
		 * if there is a equipment in the list
		 */
		if (EquipmentListSize >= 4) {
			Item FourthEquipment = manager.getPlayer().getEquipmentList().get(3);
			
			/**
			 * A label shows the number of the forth equipment
			 */
			int FourthEquipmentQuanitty = FourthEquipment.getQuantity();
			String FourthEquipmentQuanittyString = "";
			if (FourthEquipmentQuanitty >= 10) {
				FourthEquipmentQuanittyString = "x" + FourthEquipmentQuanitty;
			} else {
				FourthEquipmentQuanittyString = "x0" + FourthEquipmentQuanitty;
			}
			JLabel lblX_1_2 = new JLabel(FourthEquipmentQuanittyString);
			lblX_1_2.setForeground(Color.BLACK);
			lblX_1_2.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_1_2.setBounds(218, 232, 42, 24);
			frmMyEquipment.getContentPane().add(lblX_1_2);
			
			/**
			 * A RadioButton with the name of the fourth equipment
			 * Set the selectedEquipment to the fourth equipmet if selected
			 */
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
			
			/**
			 * A label show the image of the fourth equipment
			 */
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Equipment/" + FourthEquipmentName + ".png")));
			lblNewLabel_3.setBounds(199, 204, 61, 56);
			frmMyEquipment.getContentPane().add(lblNewLabel_3);
		}
		
		/**
		 * A button with the name "Use"
		 * When press the button 
		 * 
		 * if selectedEquipment is selected
		 * Check if selectedEquipment quantity is greater than 0
		 * Yes, sent the "Success" message to the label lblEffect
		 * No, sent the "No equipment" message to the label lblEffect
		 * 
		 * Not selected 
		 * Sent the "Please select a Equip. to use" message to the label lblEffect
		 */
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
		
		/**
		 * A button with the name "Exit"
		 * If press, launch the MainScreen
		 */
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
		
		/**
		 * A label with the text "Monster to use:"
		 */
		JLabel lblNewLabel_4 = new JLabel("Monster to use:");
		lblNewLabel_4.setBounds(22, 295, 130, 15);
		frmMyEquipment.getContentPane().add(lblNewLabel_4);
		
	}
}
