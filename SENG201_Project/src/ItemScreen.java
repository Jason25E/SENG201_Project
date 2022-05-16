import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ItemScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemScreen window = new ItemScreen();
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
	public ItemScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 274, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNameOfItem = new JRadioButton("Watermelon");
		rdbtnNameOfItem.setBounds(8, 8, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(180, 281, 80, 30);
		frame.getContentPane().add(btnExit);
		
		JButton btnUse = new JButton("Use");
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(12, 281, 80, 30);
		frame.getContentPane().add(btnUse);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Watermelons.png")));
		lblNewLabel.setBounds(199, 8, 61, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNameOfItem_1 = new JRadioButton("Sandwich");
		rdbtnNameOfItem_1.setBounds(8, 72, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Sandwich.png")));
		lblNewLabel_4.setBounds(199, 72, 61, 56);
		frame.getContentPane().add(lblNewLabel_4);
		
		JRadioButton rdbtnNameOfItem_2 = new JRadioButton("Steak");
		rdbtnNameOfItem_2.setBounds(8, 136, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Steaks.png")));
		lblNewLabel_1.setBounds(199, 136, 61, 56);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnNameOfItem_3 = new JRadioButton("Coffee");
		rdbtnNameOfItem_3.setBounds(8, 200, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Coffee.png")));
		lblNewLabel_2.setBounds(199, 200, 61, 56);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
