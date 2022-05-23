import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The class summary
 * Display the total score of the player
 * @author fye15, zde19
 *
 */
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
		frmSummary.setBounds(100, 100, 285, 301);
		frmSummary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSummary.getContentPane().setLayout(null);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSummary.setBounds(98, 22, 101, 15);
		frmSummary.getContentPane().add(lblSummary);
		
		JLabel lblPlayer = new JLabel("Player: ");
		lblPlayer.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPlayer.setBounds(48, 70, 70, 15);
		frmSummary.getContentPane().add(lblPlayer);
		
		String playerName = manager.getPlayer().getPlayerID();
		JLabel lblPlayerName = new JLabel(playerName);
		lblPlayerName.setBounds(120, 70, 154, 15);
		frmSummary.getContentPane().add(lblPlayerName);
		
		
		JLabel lblDayPlay = new JLabel("Day played: ");
		lblDayPlay.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDayPlay.setBounds(48, 105, 105, 15);
		frmSummary.getContentPane().add(lblDayPlay);
		
		int dayPlayed = manager.getCurrentDay();
		JLabel lblDayPlayText = new JLabel("" + dayPlayed);
		lblDayPlayText.setBounds(170, 105, 85, 15);
		frmSummary.getContentPane().add(lblDayPlayText);
		
		
		JLabel lblFoldEarned = new JLabel("Gold Earned: ");
		lblFoldEarned.setFont(new Font("Dialog", Font.BOLD, 15));
		lblFoldEarned.setBounds(48, 140, 117, 15);
		frmSummary.getContentPane().add(lblFoldEarned);
		
		int goldEarned = manager.getPlayer().getGoldEarned();
		JLabel lblFoldEarnedText = new JLabel("" + goldEarned);
		lblFoldEarnedText.setBounds(170, 140, 104, 15);
		frmSummary.getContentPane().add(lblFoldEarnedText);
		
		
		JLabel lblTotalScore = new JLabel("Total Score:");
		lblTotalScore.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTotalScore.setBounds(48, 175, 101, 15);
		frmSummary.getContentPane().add(lblTotalScore);
		
		int totalScore = manager.getPlayer().getScore();
		JLabel lblTotalScoreText = new JLabel("" + totalScore);
		lblTotalScoreText.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTotalScoreText.setBounds(170, 175, 100, 15);
		frmSummary.getContentPane().add(lblTotalScoreText);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameManager newManager = new GameManager();
				newManager.launchStartScreen();
				closeWindow();
			}
		});
		btnFinish.setBounds(82, 220, 117, 35);
		frmSummary.getContentPane().add(btnFinish);
	}
}
