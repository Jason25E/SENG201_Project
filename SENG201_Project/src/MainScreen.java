import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		
		JLabel lblGold = new JLabel("gold");
		lblGold.setBounds(33, 24, 70, 15);
		frame.getContentPane().add(lblGold);
		
		JLabel lblDays = new JLabel("number of days");
		lblDays.setBounds(487, 24, 100, 15);
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
	}
}
