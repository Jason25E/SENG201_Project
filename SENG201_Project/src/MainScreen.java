import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The class MainScreen
 * Display the gold the player have 
 * Display the score the player have gain
 * Display the current day and the day remain
 * Lead to the window
 * ShopScreen
 * BattleScreen
 * ItemScreen
 * EquipmentScreen
 * MonsterScreen
 * @author fye15, zde19
 *
 */
public class MainScreen {

	private JFrame frmMain;
	private GameManager manager;

	/**
	 * The variable require one parameter
	 * @param manager of the type GameManager
	 * run the initialize
	 * set the frmMain visible
	 */
	public MainScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frmMain.setVisible(true);
	}
	
	/**
	 * The variable 
	 * set the frmMain dispose
	 */
	public void closeWindow() {
		frmMain.dispose();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * A frame with the name Main
		 */
		frmMain = new JFrame();
		frmMain.setTitle("Main");
		frmMain.setBounds(100, 100, 665, 433);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		
		/**
		 * A lable with the total gold of the paly has
		 * display a coin image
		 */
		int goldAmount = manager.getPlayer().getGoldAmount();
		JLabel lblNewLabel_1 = new JLabel(Integer.toString(goldAmount));
		lblNewLabel_1.setIcon(new ImageIcon(MainScreen.class.getResource("/Images/Coin.png")));
		lblNewLabel_1.setBounds(12, 11, 100, 40);
		frmMain.getContentPane().add(lblNewLabel_1);
		
		/**
		 * Show the current day
		 */
		int curretDay = manager.getCurrentDay();
		JLabel lblNewLabel_2 = new JLabel(Integer.toString(curretDay));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(599, 24, 35, 15);
		frmMain.getContentPane().add(lblNewLabel_2);
		
		/**
		 * Show the text"day(s) remains"
		 */
		JLabel lblNewLabel_3 = new JLabel("day(s) remains");
		lblNewLabel_3.setBounds(529, 51, 105, 15);
		frmMain.getContentPane().add(lblNewLabel_3);
		
		/**
		 * Show the day remain
		 */
		int dayRemains = manager.getDayRemain();
		JLabel lblNewLabel_4 = new JLabel(Integer.toString(dayRemains));
		lblNewLabel_4.setBounds(505, 51, 35, 15);
		frmMain.getContentPane().add(lblNewLabel_4);
		
		/**
		 * A button with the name "Shop"
		 * Press launch to ShopDirectionScreen
		 * close window
		 */
		JButton btnShop = new JButton("Shop");
		btnShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manager.launchShopDirectionScreen();
				closeWindow();
			}
		});
		btnShop.setBounds(33, 86, 150, 200);
		frmMain.getContentPane().add(btnShop);
		
		/**
		 * A button with the name "Monster"
		 * Press launch to MonsterScreen
		 * close window
		 */
		JButton btnMonster = new JButton("Monster");
		btnMonster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manager.launchMonsterScreen();
				closeWindow();
			}
		});
		btnMonster.setBounds(45, 325, 130, 40);
		frmMain.getContentPane().add(btnMonster);
		
		/**
		 * A label shows the total score of player
		 */
		int score = manager.getPlayer().getScore();
		String score_string = "Score: " + Integer.toString(score);
		JLabel lblNewLabel = new JLabel(score_string);
		lblNewLabel.setBounds(257, 24, 142, 15);
		frmMain.getContentPane().add(lblNewLabel);
		
		/**
		 * A label with the text "Day"
		 */
		JLabel lblDays = new JLabel("Day");
		lblDays.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDays.setBounds(547, 16, 47, 29);
		frmMain.getContentPane().add(lblDays);
		
		/**
		 * A Button with the name "Battle"
		 * press launch SelectBattleScreen
		 * close window
		 */
		JButton btnBattle = new JButton("Battle!");
		btnBattle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manager.launchSelectBattleScreen();
				closeWindow();
			}
		});
		btnBattle.setBounds(249, 86, 150, 200);
		frmMain.getContentPane().add(btnBattle);
		
		/**
		 * A button with the name "Food"
		 * press launch ItemScreen
		 * close window
		 */
		JButton btnMonster_1 = new JButton("Food");
		btnMonster_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manager.launchItemScreen();
				closeWindow();
			}
		});
		btnMonster_1.setBounds(261, 325, 130, 40);
		frmMain.getContentPane().add(btnMonster_1);
		
		/**
		 * A label recive the envet info
		 */
		JLabel lblEventInfo = new JLabel();
		lblEventInfo.setFont(new Font("Dialog", Font.BOLD, 10));
		lblEventInfo.setBounds(33, 375, 601, 15);
		frmMain.getContentPane().add(lblEventInfo);
		
		/**
		 * A button with the name "Sleep"
		 * press 
		 * if day remainn is one launch summary 
		 * else reset the current and day remain
		 */
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (manager.getDayRemain() == 1) {
					manager.launchSummaryScreen();
					closeWindow();
				} else {
					lblEventInfo.setText(manager.sleep());
					lblNewLabel_2.setText(Integer.toString(manager.getCurrentDay()));
					lblNewLabel_4.setText(Integer.toString(manager.getDayRemain()));
				}
			}
		});
		btnSleep.setToolTipText("Healed all monsters and move to next day");
		btnSleep.setBounds(460, 86, 150, 200);
		frmMain.getContentPane().add(btnSleep);
		
		/**
		 * A button with the name "Equipment"
		 * press launch EquipmentScreen
		 * close window
		 */
		JButton btnEquipment = new JButton("Equipment");
		btnEquipment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manager.launchEquipmentScreen();
				closeWindow();
			}
		});
		btnEquipment.setBounds(472, 325, 130, 40);
		frmMain.getContentPane().add(btnEquipment);
	}
}
