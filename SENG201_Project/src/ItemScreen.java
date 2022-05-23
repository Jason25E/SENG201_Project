import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
/**
 * The class ItemScreen
 * Show all the food in the inventory 
 * Allow player to use to the monster in the monster list
 * @author fye15, zde19
 *
 */
public class ItemScreen {

	private JFrame frmMyItems;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private GameManager manager;
	private Item selectedFood = null;
	
	/**
	 * The variable require one parameter
	 * @param manager of the type GameManager
	 * set this manager to manager 
	 * run the initialize variable
	 * set the frmMyItems visible to true
	 */
	public ItemScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmMyItems.setVisible(true);
	}
	
	/**
	 * The variable
	 * set the frmMyItems dispose
	 */
	public void closeWindow() {
		frmMyItems.dispose();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int ItemListSize = manager.getPlayer().getFoodList().size();
		ArrayList<Item> ItemList = manager.getPlayer().getFoodList();
		
		/**
		 * A frame with the name "My Food"
		 */
		frmMyItems = new JFrame();
		frmMyItems.setTitle("My Food");
		frmMyItems.setBounds(100, 100, 274, 401);
		frmMyItems.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyItems.getContentPane().setLayout(null);
		
		/**
		 * A label recive information from "Use"
		 */
		JLabel lblEffect = new JLabel("");
		lblEffect.setBounds(22, 270, 248, 22);
		frmMyItems.getContentPane().add(lblEffect);
		
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
		comboBox.setBounds(146, 298, 114, 24);
		frmMyItems.getContentPane().add(comboBox);

		/**
		 * Display the first food
		 * if there is a food in the list
		 */
		if (ItemListSize >= 1) {
			Item FirstItem = manager.getPlayer().getFoodList().get(0);
			
			/**
			 * A label shows the number of the first food
			 */
			int FirstItemQuanitty = FirstItem.getQuantity();
			String FirstItemQuanittyString = "x0";
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
			
			/**
			 * A RadioButton with the name of the first food
			 * Set the selectedFood to the first food if selected
			 */
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
			
			/**
			 * A label show the image of the first food
			 */
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + FirstItemName + ".png")));
			lblNewLabel.setBounds(199, 8, 61, 56);
			frmMyItems.getContentPane().add(lblNewLabel);
			
		} 
		
		/**
		 * Display the secnod food
		 * if there is a food in the list
		 */
		if (ItemListSize >= 2) {
			Item SecondItem = manager.getPlayer().getFoodList().get(1);
			
			/**
			 * A label shows the number of the secnod food
			 */
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
			
			/**
			 * A RadioButton with the name of the second food
			 * Set the selectedFood to the second food if selected
			 */
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
			
			/**
			 * A label show the image of the second food
			 */
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + SecondItemName + ".png")));
			lblNewLabel_4.setBounds(199, 72, 61, 56);
			frmMyItems.getContentPane().add(lblNewLabel_4);
			
		} 
		
		/**
		 * Display the third food
		 * if there is a food in the list
		 */
		if (ItemListSize >= 3) {
			Item ThirdItem = manager.getPlayer().getFoodList().get(2);
			
			/**
			 * A label shows the number of the third food
			 */
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
			
			/**
			 * A RadioButton with the name of the third food
			 * Set the selectedFood to the third food if selected
			 */
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

			/**
			 * A label show the image of the third food
			 */
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + ThirdItemName + ".png")));
			lblNewLabel_1.setBounds(199, 136, 61, 56);
			frmMyItems.getContentPane().add(lblNewLabel_1);
			
			
		} 
		
		/**
		 * Display the fourth food
		 * if there is a food in the list
		 */
		if (ItemListSize == 4){
			Item FourthItem = manager.getPlayer().getFoodList().get(3);
			
			/**
			 * A label shows the number of the fourth food
			 */
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
			
			/**
			 * A RadioButton with the name of the fourth food
			 * Set the selectedFood to the fourth food if selected
			 */
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
			
			/**
			 * A label show the image of the fourth food
			 */
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/" + FourthItemName + ".png")));
			lblNewLabel_2.setBounds(199, 200, 61, 56);
			frmMyItems.getContentPane().add(lblNewLabel_2);
			
		}
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 51, 102));
		btnExit.setForeground(new Color(255, 255, 255));
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
					manager.getPlayer().getMonsterList().get(index).useFood((Food)selectedFood, manager.getPlayer());
					lblEffect.setText("Success");
					manager.launchItemScreen();
					closeWindow();
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
