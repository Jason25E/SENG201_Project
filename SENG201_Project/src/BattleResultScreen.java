import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class BattleResultScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleResultScreen window = new BattleResultScreen();
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
	public BattleResultScreen() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String Vitory = "Vitory!";
		String Defeated = "Defeated";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 285, 209);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBattleResult = new JLabel(Vitory);
		lblBattleResult.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBattleResult.setBounds(94, 12, 93, 15);
		frame.getContentPane().add(lblBattleResult);
		
		JLabel lblGold = new JLabel("Gold:");
		lblGold.setFont(new Font("Dialog", Font.BOLD, 15));
		lblGold.setBounds(73, 48, 70, 20);
		frame.getContentPane().add(lblGold);
		
		JLabel label = new JLabel("50");
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(150, 48, 70, 20);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Score:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(73, 80, 70, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("100");
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(150, 80, 70, 20);
		frame.getContentPane().add(label_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(84, 129, 117, 35);
		frame.getContentPane().add(btnBack);
	}

}
