import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		
		JRadioButton rdbtnNameOfItem = new JRadioButton("Name of item");
		rdbtnNameOfItem.setBounds(8, 8, 252, 60);
		frame.getContentPane().add(rdbtnNameOfItem);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExit.setBounds(180, 281, 80, 30);
		frame.getContentPane().add(btnExit);
		
		JButton btnUse = new JButton("Use");
		btnUse.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUse.setBounds(12, 281, 80, 30);
		frame.getContentPane().add(btnUse);
		
		JRadioButton rdbtnNameOfItem_1 = new JRadioButton("Name of item");
		rdbtnNameOfItem_1.setBounds(8, 72, 252, 60);
		frame.getContentPane().add(rdbtnNameOfItem_1);
		
		JRadioButton rdbtnNameOfItem_2 = new JRadioButton("Name of item");
		rdbtnNameOfItem_2.setBounds(8, 136, 252, 60);
		frame.getContentPane().add(rdbtnNameOfItem_2);
		
		JRadioButton rdbtnNameOfItem_3 = new JRadioButton("Name of item");
		rdbtnNameOfItem_3.setBounds(8, 200, 252, 60);
		frame.getContentPane().add(rdbtnNameOfItem_3);
	}
}
