import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MainScreen {

	private JFrame frame;
	private GameManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnShop = new JButton("Shop");
		btnShop.setBounds(33, 86, 150, 200);
		frame.getContentPane().add(btnShop);
		
		JButton btnMonster = new JButton("Monster");
		btnMonster.setBounds(45, 325, 130, 40);
		frame.getContentPane().add(btnMonster);
		
		JLabel lblNewLabel = new JLabel("Score: 100");
		lblNewLabel.setBounds(257, 24, 142, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDays = new JLabel("Day");
		lblDays.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDays.setBounds(547, 16, 47, 29);
		frame.getContentPane().add(lblDays);
		
		JButton btnShop_1 = new JButton("Battle!");
		btnShop_1.setBounds(249, 86, 150, 200);
		frame.getContentPane().add(btnShop_1);
		
		JButton btnMonster_1 = new JButton("Item");
		btnMonster_1.setBounds(261, 325, 130, 40);
		frame.getContentPane().add(btnMonster_1);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.setToolTipText("a");
		btnSleep.setBounds(460, 86, 150, 200);
		frame.getContentPane().add(btnSleep);
		
		JButton btnEquipment = new JButton("Equipment");
		btnEquipment.setBounds(472, 325, 130, 40);
		frame.getContentPane().add(btnEquipment);
		
		JLabel lblNewLabel_1 = new JLabel("100");
		lblNewLabel_1.setIcon(new ImageIcon(MainScreen.class.getResource("/Images/Coin.png")));
		lblNewLabel_1.setBounds(12, 11, 100, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("12");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(599, 24, 35, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("day(s) remains");
		lblNewLabel_3.setBounds(529, 51, 105, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("3");
		lblNewLabel_4.setBounds(505, 51, 35, 15);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
