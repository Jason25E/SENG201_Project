import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class SelectBattleScreen {

	private JFrame frame;
	
	private GameManager manager;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectBattleScreen window = new SelectBattleScreen();
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
	public SelectBattleScreen() {
		initialize();
	}
	
	public SelectBattleScreen(GameManager manager) {
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
		frame.setBounds(100, 100, 590, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnMonster = new JRadioButton("monster");
		rdbtnMonster.setForeground(Color.BLACK);
		rdbtnMonster.setBounds(12, 8, 130, 38);
		frame.getContentPane().add(rdbtnMonster);
		
		JButton btnExit_1 = new JButton("Battle!");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchBattleScreen();
			}
		});
		btnExit_1.setBounds(27, 229, 130, 30);
		frame.getContentPane().add(btnExit_1);
		
		JButton btnBuy = new JButton("Exit");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
			}
		});
		btnBuy.setBounds(446, 229, 130, 30);
		frame.getContentPane().add(btnBuy);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SelectBattleScreen.class.getResource("/Images/RedDragons.png")));
		label.setBounds(12, 54, 130, 120);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SelectBattleScreen.class.getResource("/Images/GreenDragons.png")));
		label_1.setBounds(235, 54, 130, 120);
		frame.getContentPane().add(label_1);
		
		JRadioButton rdbtnMonster_1 = new JRadioButton("monster");
		rdbtnMonster_1.setForeground(Color.BLACK);
		rdbtnMonster_1.setBounds(235, 8, 130, 38);
		frame.getContentPane().add(rdbtnMonster_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SelectBattleScreen.class.getResource("/Images/BlueDragons.png")));
		label_2.setBounds(450, 54, 130, 120);
		frame.getContentPane().add(label_2);
		
		JRadioButton rdbtnMonster_2 = new JRadioButton("monster");
		rdbtnMonster_2.setForeground(Color.BLACK);
		rdbtnMonster_2.setBounds(450, 8, 130, 38);
		frame.getContentPane().add(rdbtnMonster_2);
	}
}
