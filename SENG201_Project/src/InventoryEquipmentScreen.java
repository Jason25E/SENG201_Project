import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;

public class InventoryEquipmentScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryEquipmentScreen window = new InventoryEquipmentScreen();
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
	public InventoryEquipmentScreen() {
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
		
		JRadioButton rdbtnNameOfEquipment = new JRadioButton("Name of Equipment");
		rdbtnNameOfEquipment.setBounds(8, 8, 252, 60);
		frame.getContentPane().add(rdbtnNameOfEquipment);
		
		JRadioButton rdbtnNameOfEquipment_1 = new JRadioButton("Name of Equipment");
		rdbtnNameOfEquipment_1.setBounds(8, 72, 252, 60);
		frame.getContentPane().add(rdbtnNameOfEquipment_1);
		
		JRadioButton rdbtnNameOfEquipment_2 = new JRadioButton("Name of Equipment");
		rdbtnNameOfEquipment_2.setBounds(8, 136, 252, 60);
		frame.getContentPane().add(rdbtnNameOfEquipment_2);
		
		JRadioButton rdbtnNameOfEquipment_3 = new JRadioButton("Name of Equipment");
		rdbtnNameOfEquipment_3.setBounds(8, 200, 252, 60);
		frame.getContentPane().add(rdbtnNameOfEquipment_3);
		
		JButton btnUse = new JButton("Use");
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(8, 268, 80, 30);
		frame.getContentPane().add(btnUse);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(173, 268, 80, 30);
		frame.getContentPane().add(btnExit);
	}

}
