import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class EquipmentScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentScreen window = new EquipmentScreen();
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
	public EquipmentScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 276, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUse = new JButton("Use");
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(8, 268, 80, 30);
		frame.getContentPane().add(btnUse);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(173, 268, 80, 30);
		frame.getContentPane().add(btnExit);
		
		JRadioButton rdbtnNameOfEquip = new JRadioButton("Sword");
		rdbtnNameOfEquip.setBounds(8, 12, 177, 56);
		frame.getContentPane().add(rdbtnNameOfEquip);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Sword.png")));
		lblNewLabel.setBounds(199, 12, 61, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnAxe = new JRadioButton("Axe");
		rdbtnAxe.setBounds(8, 76, 177, 56);
		frame.getContentPane().add(rdbtnAxe);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Axe.png")));
		lblNewLabel_1.setBounds(199, 76, 61, 56);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnHelmet = new JRadioButton("Helmet");
		rdbtnHelmet.setBounds(8, 140, 177, 56);
		frame.getContentPane().add(rdbtnHelmet);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Helmet.png")));
		lblNewLabel_2.setBounds(199, 140, 61, 56);
		frame.getContentPane().add(lblNewLabel_2);
		
		JRadioButton rdbtnSheild = new JRadioButton("Sheild");
		rdbtnSheild.setBounds(8, 204, 177, 56);
		frame.getContentPane().add(rdbtnSheild);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(EquipmentScreen.class.getResource("/Images/Shield.png")));
		lblNewLabel_3.setBounds(199, 204, 61, 56);
		frame.getContentPane().add(lblNewLabel_3);
	}

}
