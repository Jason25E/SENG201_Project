import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;

public class ItemScreen {

	private JFrame frmMyItems;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private GameManager manager;
	private Item selectedFood = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemScreen window = new ItemScreen();
					window.frmMyItems.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ItemScreen() {
		initialize();
	}
	
	public ItemScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmMyItems.setVisible(true);
	}
	
	public void closeWindow() {
		frmMyItems.dispose();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int ItemListSize = manager.getPlayer().getFoodList().size();
		ArrayList<Item> ItemList = manager.getPlayer().getFoodList();
		
		frmMyItems = new JFrame();
		frmMyItems.setTitle("My Item");
		frmMyItems.setBounds(100, 100, 274, 401);
		frmMyItems.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyItems.getContentPane().setLayout(null);
		
		JLabel lblEffect = new JLabel("");
		lblEffect.setBounds(22, 270, 248, 22);
		frmMyItems.getContentPane().add(lblEffect);
		
		String[] monsterName = new String[4];
		int index = 0;
		for (Monster i: manager.getPlayer().getMonsterList()) {
			monsterName[index] = i.getMonsterName();
			index += 1;
		}
		JComboBox<String> comboBox = new JComboBox<>(monsterName);
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(146, 298, 114, 24);
		frmMyItems.getContentPane().add(comboBox);

		if (ItemListSize >= 1) {
			Item FirstItem = manager.getPlayer().getFoodList().get(0);
			
			int FirstItemQuanitty = FirstItem.getQuantity();
			String FirstItemQuanittyString = "";
			if (FirstItemQuanitty >= 10) {
				FirstItemQuanittyString = "x" + FirstItemQuanitty;
			} else {
				FirstItemQuanittyString = "x0" + FirstItemQuanitty;
			}
			
			JLabel lblX = new JLabel(FirstItemQuanittyString);
			lblX.setForeground(Color.BLACK);
			lblX.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX.setBounds(218, 40, 42, 24);
			frmMyItems.getContentPane().add(lblX);
			
			String FirstItemName = FirstItem.getItemID();
			JRadioButton rdbtnNameOfItem = new JRadioButton(FirstItemName);
			rdbtnNameOfItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(0);
					lblEffect.setForeground(Color.BLACK);
					lblEffect.setText(selectedFood.getItemEffect());
				}
			});
			buttonGroup.add(rdbtnNameOfItem);
			rdbtnNameOfItem.setBounds(8, 8, 177, 56);
			frmMyItems.getContentPane().add(rdbtnNameOfItem);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + FirstItemName + ".png")));
			lblNewLabel.setBounds(199, 8, 61, 56);
			frmMyItems.getContentPane().add(lblNewLabel);
			
		} 
		
		if (ItemListSize >= 2) {
			Item SecondItem = manager.getPlayer().getFoodList().get(1);
			
			int SecondItemQuanitty = SecondItem.getQuantity();
			String SecondItemQuanittyString = "";
			if (SecondItemQuanitty >= 10) {
				SecondItemQuanittyString = "x" + SecondItemQuanitty;
			} else {
				SecondItemQuanittyString = "x0" + SecondItemQuanitty;
			}
			
			JLabel lblX_1 = new JLabel(SecondItemQuanittyString);
			lblX_1.setForeground(Color.BLACK);
			lblX_1.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_1.setBounds(218, 104, 42, 24);
			frmMyItems.getContentPane().add(lblX_1);
			
			String SecondItemName = SecondItem.getItemID();
			JRadioButton rdbtnNameOfItem_1 = new JRadioButton(SecondItemName);
			rdbtnNameOfItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(1);
					lblEffect.setForeground(Color.BLACK);
					lblEffect.setText(selectedFood.getItemEffect());
				}
			});
			buttonGroup.add(rdbtnNameOfItem_1);
			rdbtnNameOfItem_1.setBounds(8, 72, 177, 56);
			frmMyItems.getContentPane().add(rdbtnNameOfItem_1);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + SecondItemName + ".png")));
			lblNewLabel_4.setBounds(199, 72, 61, 56);
			frmMyItems.getContentPane().add(lblNewLabel_4);
			
		} 
		
		if (ItemListSize >= 3) {
			Item ThirdItem = manager.getPlayer().getFoodList().get(2);
			
			int ThirdItemQuanitty = ThirdItem.getQuantity();
			String ThirdItemQuanittyString = "";
			if (ThirdItemQuanitty >= 10) {
				ThirdItemQuanittyString = "x" + ThirdItemQuanitty;
			} else {
				ThirdItemQuanittyString = "x0" + ThirdItemQuanitty;
			}
			
			JLabel lblX_2 = new JLabel(ThirdItemQuanittyString);
			lblX_2.setForeground(Color.BLACK);
			lblX_2.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_2.setBounds(218, 168, 42, 24);
			frmMyItems.getContentPane().add(lblX_2);
			
			String ThirdItemName = ThirdItem.getItemID();
			JRadioButton rdbtnNameOfItem_2 = new JRadioButton(ThirdItemName);
			rdbtnNameOfItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(2);
					lblEffect.setForeground(Color.BLACK);
					lblEffect.setText(selectedFood.getItemEffect());
				}
			});
			buttonGroup.add(rdbtnNameOfItem_2);
			rdbtnNameOfItem_2.setBounds(8, 136, 177, 56);
			frmMyItems.getContentPane().add(rdbtnNameOfItem_2);

			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + ThirdItemName + ".png")));
			lblNewLabel_1.setBounds(199, 136, 61, 56);
			frmMyItems.getContentPane().add(lblNewLabel_1);
			
			
		} 
		
		if (ItemListSize == 4){
			Item FourthItem = manager.getPlayer().getFoodList().get(3);
			
			int FourthItemQuanitty = FourthItem.getQuantity();
			String FourthItemQuanittyString = "";
			if (FourthItemQuanitty >= 10) {
				FourthItemQuanittyString = "x" + FourthItemQuanitty;
			} else {
				FourthItemQuanittyString = "x0" + FourthItemQuanitty;
			}
			
			JLabel lblX_3 = new JLabel(FourthItemQuanittyString);
			lblX_3.setForeground(Color.BLACK);
			lblX_3.setFont(new Font("Dialog", Font.BOLD, 20));
			lblX_3.setBounds(218, 245, 42, 24);
			frmMyItems.getContentPane().add(lblX_3);
			
			String FourthItemName = FourthItem.getItemID();
			JRadioButton rdbtnNameOfItem_3 = new JRadioButton(FourthItemName);
			rdbtnNameOfItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					selectedFood = ItemList.get(3);
					lblEffect.setForeground(Color.BLACK);
					lblEffect.setText(selectedFood.getItemEffect());
				}
			});
			buttonGroup.add(rdbtnNameOfItem_3);
			rdbtnNameOfItem_3.setBounds(8, 200, 177, 56);
			frmMyItems.getContentPane().add(rdbtnNameOfItem_3);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + FourthItemName + ".png")));
			lblNewLabel_2.setBounds(199, 200, 61, 56);
			frmMyItems.getContentPane().add(lblNewLabel_2);
			
		}
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
				closeWindow();
			}
		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(175, 332, 80, 30);
		frmMyItems.getContentPane().add(btnExit);
		
		JButton btnUse = new JButton("Use");
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBox.getSelectedIndex();
				lblEffect.setForeground(Color.RED);
				if (selectedFood != null) {
					manager.getPlayer().getMonsterList().get(index).useFood((Food)selectedFood);
					lblEffect.setText("Success");
				} else {
					lblEffect.setText("Please select a food to use");
				}
			}
		});
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(12, 332, 80, 30);
		frmMyItems.getContentPane().add(btnUse);
		
		JLabel lblNewLabel_3 = new JLabel("Monster to use: ");
		lblNewLabel_3.setBounds(22, 301, 121, 15);
		frmMyItems.getContentPane().add(lblNewLabel_3);

	}
}
