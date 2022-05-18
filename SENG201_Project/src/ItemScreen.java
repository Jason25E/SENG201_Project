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
import java.awt.Color;

public class ItemScreen {

	private JFrame frame;
	
	private GameManager manager;
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
	
	public ItemScreen(GameManager manager) {
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
		frame = new JFrame();
		frame.setBounds(100, 100, 274, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
			}
		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(180, 281, 80, 30);
		frame.getContentPane().add(btnExit);
		
		JButton btnUse = new JButton("Use");
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(12, 281, 80, 30);
		frame.getContentPane().add(btnUse);
		
		JRadioButton rdbtnNameOfItem = new JRadioButton("Watermelon");
		rdbtnNameOfItem.setBounds(8, 8, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem);
		
		JLabel lblX = new JLabel("x01");
		lblX.setForeground(Color.BLACK);
		lblX.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX.setBounds(218, 40, 42, 24);
		frame.getContentPane().add(lblX);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/Watermelons.png")));
		lblNewLabel.setBounds(199, 8, 61, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNameOfItem_1 = new JRadioButton("Sandwich");
		rdbtnNameOfItem_1.setBounds(8, 72, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem_1);
		
		JLabel lblX_1 = new JLabel("x01");
		lblX_1.setForeground(Color.BLACK);
		lblX_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX_1.setBounds(218, 104, 42, 24);
		frame.getContentPane().add(lblX_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/Sandwich.png")));
		lblNewLabel_4.setBounds(199, 72, 61, 56);
		frame.getContentPane().add(lblNewLabel_4);
		
		JRadioButton rdbtnNameOfItem_2 = new JRadioButton("Steak");
		rdbtnNameOfItem_2.setBounds(8, 136, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem_2);
		
		JLabel lblX_2 = new JLabel("x01");
		lblX_2.setForeground(Color.BLACK);
		lblX_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX_2.setBounds(218, 168, 42, 24);
		frame.getContentPane().add(lblX_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/Steaks.png")));
		lblNewLabel_1.setBounds(199, 136, 61, 56);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnNameOfItem_3 = new JRadioButton("Coffee");
		rdbtnNameOfItem_3.setBounds(8, 200, 177, 56);
		frame.getContentPane().add(rdbtnNameOfItem_3);
		
		JLabel lblX_3 = new JLabel("x01");
		lblX_3.setForeground(Color.BLACK);
		lblX_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblX_3.setBounds(218, 245, 42, 24);
		frame.getContentPane().add(lblX_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ItemScreen.class.getResource("/Images/Food/Coffee.png")));
		lblNewLabel_2.setBounds(199, 200, 61, 56);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
