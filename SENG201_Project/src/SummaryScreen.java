import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SummaryScreen {

	private JFrame frmSummary;
	
	private GameManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SummaryScreen window = new SummaryScreen();
					window.frmSummary.setVisible(true);
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

	public SummaryScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmSummary.setVisible(true);
	}
	
	public void closeWindow() {
		frmSummary.dispose();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSummary = new JFrame();
		frmSummary.setTitle("Summary");
		frmSummary.setBounds(100, 100, 285, 380);
		frmSummary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSummary.getContentPane().setLayout(null);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSummary.setBounds(98, 22, 101, 15);
		frmSummary.getContentPane().add(lblSummary);
		
		JLabel lblTotalScore = new JLabel("Total Score:");
		lblTotalScore.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTotalScore.setBounds(48, 252, 101, 15);
		frmSummary.getContentPane().add(lblTotalScore);
		
		int totalScore = manager.getPlayer().getScore();
		JLabel lblNewLabel = new JLabel("" + totalScore);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(174, 252, 70, 15);
		frmSummary.getContentPane().add(lblNewLabel);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameManager newManager = new GameManager();
				newManager.launchStartScreen();
				closeWindow();
			}
		});
		btnFinish.setBounds(82, 291, 117, 35);
		frmSummary.getContentPane().add(btnFinish);
		
		JLabel lblNewLabel_1 = new JLabel("Player: ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(48, 69, 70, 15);
		frmSummary.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(120, 69, 115, 15);
		frmSummary.getContentPane().add(lblNewLabel_2);
	}
}
