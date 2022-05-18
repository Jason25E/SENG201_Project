import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class SummaryScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SummaryScreen window = new SummaryScreen();
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
	public SummaryScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 285, 209);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSummary.setBounds(98, 22, 101, 15);
		frame.getContentPane().add(lblSummary);
		
		JLabel lblTotalScore = new JLabel("Total Score:");
		lblTotalScore.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTotalScore.setBounds(61, 68, 101, 15);
		frame.getContentPane().add(lblTotalScore);
		
		JLabel lblNewLabel = new JLabel("200");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(171, 68, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(84, 119, 117, 35);
		frame.getContentPane().add(btnFinish);
	}

}
