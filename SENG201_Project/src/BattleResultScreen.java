import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * This class BattleResult 
 * The gold gain in every battle 
 * The score gain in every battle 
 * And the updated monster state after every battle
 * @author fye15, zde19
 *
 */

public class BattleResultScreen {
	
	/** Initialize the Variables use in the file */
	
	private JFrame frmBattleResult;
	private GameManager manager;
	private int baseGoldReceive = 50;
	private int baseScoreReceive = 100;
	private Monster enemy = null;

	/**
	 * Create the application.
	 * BattleResultScreen require the parameters 
	 * manager of type GameManager
	 * enemy of type Monster 
	 */
	public BattleResultScreen(GameManager manager, Monster enemy) {
		this.manager = manager;
		this.enemy = enemy;
		initialize();
		frmBattleResult.setLocationRelativeTo(null);
		frmBattleResult.setVisible(true);
	}
	
	/**
	 * Close the application.
	 */
	public void closeWindow() {
		frmBattleResult.dispose();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		float gold_receive_rate = manager.getStart_gold_info();
		float score_gain_rate = manager.getShop_info();
		int total_gold = manager.getPlayer().getGoldAmount();
		int current_day = manager.getCurrentDay();
		int monster_price = Math.round((150 + current_day * 5) * score_gain_rate);
		frmBattleResult = new JFrame();
		frmBattleResult.setTitle("Battle Result");
		frmBattleResult.setBounds(100, 100, 349, 459);
		frmBattleResult.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattleResult.getContentPane().setLayout(null);
		
		/**
		 * Calculate gold receive and score gain after the battle.
		 */
		int goldReceive = Math.round((baseGoldReceive + enemy.getMonsterAttack() + enemy.getMonsterMaxHealthPoint() / 10) * gold_receive_rate);
		int scoreGain = Math.round(baseScoreReceive + enemy.getMonsterAttack() + enemy.getMonsterDefence() + enemy.getMonsterMaxHealthPoint() * score_gain_rate);
		
		/**
		 * Check if there are monster alive in the party to determine the battle result
		 */
		boolean monsterAlive = manager.getPlayer().canMonstersBattle();
		
		/**
		 * Display the battle result
		 */
		JLabel lblBattleResult = new JLabel();
		lblBattleResult.setText("Vicoty");
		lblBattleResult.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBattleResult.setBounds(141, 24, 93, 15);
		frmBattleResult.getContentPane().add(lblBattleResult);
		/** set the text to victory if win the battle and add the gold and score the player */
		if (monsterAlive == true) {
			lblBattleResult.setText("Vitory!");
			manager.getPlayer().gainGold(goldReceive);
			manager.getPlayer().gainScore(scoreGain);
			/** set the text to defeated if lose the battle as well as gold and score gain to zero */
		} else {
			lblBattleResult.setText("Defeated");
			goldReceive = 0;
			scoreGain = 0;
		}
		
		/**
		 * A label display the text "Gold:"
		 */
		JLabel lblGold = new JLabel("Gold:");
		lblGold.setFont(new Font("Dialog", Font.BOLD, 15));
		lblGold.setBounds(90, 53, 70, 20);
		frmBattleResult.getContentPane().add(lblGold);
		
		/**
		 * A label display the gold receive after every battle
		 */
		JLabel label = new JLabel("" + goldReceive);
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(180, 51, 70, 20);
		frmBattleResult.getContentPane().add(label);
		
		/**
		 * A label display the text "Score:"
		 */
		JLabel lblNewLabel = new JLabel("Score:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(90, 83, 70, 20);
		frmBattleResult.getContentPane().add(lblNewLabel);
		
		/**
		 * A label display the score gain after every battle
		 */
		JLabel label_1 = new JLabel("" + scoreGain);
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(180, 83, 70, 20);
		frmBattleResult.getContentPane().add(label_1);
		
		/**
		 * A button which allow you to go back to 
		 * If win it go back to the main screen
		 * lose go to summary screen
		 */
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (monsterAlive == false && total_gold < monster_price) {
					manager.launchSummaryScreen();
				} else {
					manager.launchMainScreen();
				}
				closeWindow();
			}
		});
		btnBack.setBounds(109, 385, 117, 35);
		frmBattleResult.getContentPane().add(btnBack);
		
		/** Display the First Monster in party */
		Monster firstMonster = manager.getPlayer().getMonsterList().get(0);
		JLabel lblMonsterIcon = new JLabel();
		lblMonsterIcon.setIcon(new ImageIcon(BattleResultScreen.class.getResource("/Images/Monster/" + firstMonster.getMonsterID() + ".png")));
		lblMonsterIcon.setBounds(27, 115, 134, 120);
		lblMonsterIcon.setToolTipText(firstMonster.getFullMonsterInfo());
		frmBattleResult.getContentPane().add(lblMonsterIcon);
		
		/** Display Second Monster if there is monster in the monster list */
		if (manager.getPlayer().getMonsterList().size() >= 2) {
			Monster secondMonster = manager.getPlayer().getMonsterList().get(1);
			JLabel lblMonsterIcon_2 = new JLabel();
			lblMonsterIcon_2.setIcon(new ImageIcon(BattleResultScreen.class.getResource("/Images/Monster/" + secondMonster.getMonsterID() + ".png")));
			lblMonsterIcon_2.setBounds(190, 115, 134, 120);
			lblMonsterIcon_2.setToolTipText(secondMonster.getFullMonsterInfo());
			frmBattleResult.getContentPane().add(lblMonsterIcon_2);
		}
		
		/** Display Third Monster if there is monster in the monster list */
		if (manager.getPlayer().getMonsterList().size() >= 3) {
			Monster thirdMonster = manager.getPlayer().getMonsterList().get(2);
			JLabel lblMonsterIcon_3 = new JLabel();
			lblMonsterIcon_3.setIcon(new ImageIcon(BattleResultScreen.class.getResource("/Images/Monster/" + thirdMonster.getMonsterID() + ".png")));
			lblMonsterIcon_3.setBounds(26, 247, 134, 120);
			lblMonsterIcon_3.setToolTipText(thirdMonster.getFullMonsterInfo());
			frmBattleResult.getContentPane().add(lblMonsterIcon_3);
		}
		
		/** Display Fourth Monster if there is monster in the monster list */
		if (manager.getPlayer().getMonsterList().size() >= 4) {
			Monster fourthMonster = manager.getPlayer().getMonsterList().get(3);
			JLabel lblMonsterIcon_4 = new JLabel();
			lblMonsterIcon_4.setIcon(new ImageIcon(BattleResultScreen.class.getResource("/Images/Monster/" + fourthMonster.getMonsterID() + ".png")));
			lblMonsterIcon_4.setBounds(190, 247, 134, 120);
			lblMonsterIcon_4.setToolTipText(fourthMonster.getFullMonsterInfo());
			frmBattleResult.getContentPane().add(lblMonsterIcon_4);
		}
	}
}
