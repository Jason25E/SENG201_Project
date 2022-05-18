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

public class MainScreen {

	private JFrame frame;
	private GameManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}
	
	public MainScreen(GameManager manager) {
		this.manager = manager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnShop = new JButton("Shop");
		btnShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manager.launchShopItemScreen();
				closeWindow();
			}
		});
		btnShop.setBounds(33, 86, 150, 200);
		frame.getContentPane().add(btnShop);
		
		JButton btnMonster = new JButton("Monster");
		btnMonster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manager.launchMonsterScreen();
				closeWindow();
			}
		});
		btnMonster.setBounds(45, 325, 130, 40);
		frame.getContentPane().add(btnMonster);
		
		int score = manager.getPlayer().getScore();
		String score_string = "Score: " + Integer.toString(score);
		JLabel lblNewLabel = new JLabel(score_string);
		lblNewLabel.setBounds(257, 24, 142, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDays = new JLabel("Day");
		lblDays.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDays.setBounds(547, 16, 47, 29);
		frame.getContentPane().add(lblDays);
		
		JButton btnBattle = new JButton("Battle!");
		btnBattle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manager.launchSelectBattleScreen();
				closeWindow();
			}
		});
		btnBattle.setBounds(249, 86, 150, 200);
		frame.getContentPane().add(btnBattle);
		
		JButton btnMonster_1 = new JButton("Item");
		btnMonster_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manager.launchItemScreen();
				closeWindow();
			}
		});
		btnMonster_1.setBounds(261, 325, 130, 40);
		frame.getContentPane().add(btnMonster_1);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.sleep();
			}
		});
		btnSleep.setToolTipText("a");
		btnSleep.setBounds(460, 86, 150, 200);
		frame.getContentPane().add(btnSleep);
		
		JButton btnEquipment = new JButton("Equipment");
		btnEquipment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manager.launchEquipmentScreen();
				closeWindow();
			}
		});
		btnEquipment.setBounds(472, 325, 130, 40);
		frame.getContentPane().add(btnEquipment);
		
		int goldAmount = manager.getPlayer().getGoldAmount();
		JLabel lblNewLabel_1 = new JLabel(Integer.toString(goldAmount));
		lblNewLabel_1.setIcon(new ImageIcon(MainScreen.class.getResource("/Images/Coin.png")));
		lblNewLabel_1.setBounds(12, 11, 100, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		int curretDay = manager.getCurrentDay();
		JLabel lblNewLabel_2 = new JLabel(Integer.toString(curretDay));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(599, 24, 35, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("day(s) remains");
		lblNewLabel_3.setBounds(529, 51, 105, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		int dayRemains = manager.getDayRemain();
		JLabel lblNewLabel_4 = new JLabel(Integer.toString(dayRemains));
		lblNewLabel_4.setBounds(505, 51, 35, 15);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
