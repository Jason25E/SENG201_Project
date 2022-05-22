import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleResultScreen {

	private JFrame frmBattleResult;
	
	private GameManager manager;
	private int baseGoldReceive = 50;
	private int baseScoreReceive = 100;
	private Monster enemy = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleResultScreen window = new BattleResultScreen();
					window.frmBattleResult.setVisible(true);
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
	
	public BattleResultScreen(GameManager manager, Monster enemy) {
		this.manager = manager;
		this.enemy = enemy;
		initialize();
		frmBattleResult.setVisible(true);
	}
	
	public void closeWindow() {
		frmBattleResult.dispose();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBattleResult = new JFrame();
		frmBattleResult.setTitle("Battle Result");
		frmBattleResult.setBounds(100, 100, 285, 209);
		frmBattleResult.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattleResult.getContentPane().setLayout(null);
		
		int goldReceive = baseGoldReceive + enemy.getMonsterAttack() + enemy.getMonsterMaxHealthPoint() / 10;
		int scoreGain = baseScoreReceive + enemy.getMonsterAttack() + enemy.getMonsterDefence() + enemy.getMonsterMaxHealthPoint();
		
		/**
		 * Check if there are monster alive in the party to determine the battle result
		 */
		boolean monsterAlive = manager.getPlayer().canMonstersBattle();

		JLabel lblBattleResult = new JLabel();
		lblBattleResult.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBattleResult.setBounds(110, 21, 93, 15);
		frmBattleResult.getContentPane().add(lblBattleResult);
		if (monsterAlive == true) {
			lblBattleResult.setText("Vitory!");
			manager.getPlayer().gainGold(goldReceive);
			manager.getPlayer().gainScore(scoreGain);
		} else {
			lblBattleResult.setText("Defeated");
			goldReceive = 0;
			scoreGain = 0;
		}
		
		JLabel lblGold = new JLabel("Gold:");
		lblGold.setFont(new Font("Dialog", Font.BOLD, 15));
		lblGold.setBounds(73, 50, 70, 20);
		frmBattleResult.getContentPane().add(lblGold);
		
		JLabel label = new JLabel("" + goldReceive);
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(160, 48, 70, 20);
		frmBattleResult.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Score:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(73, 80, 70, 20);
		frmBattleResult.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("" + scoreGain);
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(160, 80, 70, 20);
		frmBattleResult.getContentPane().add(label_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
				closeWindow();
			}
		});
		btnBack.setBounds(82, 129, 117, 35);
		frmBattleResult.getContentPane().add(btnBack);
	}

}
