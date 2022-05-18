import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BattleScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleScreen window = new BattleScreen();
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
	public BattleScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAttack = new JButton("Attack");
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAttack.setBounds(34, 232, 117, 25);
		frame.getContentPane().add(btnAttack);
		
		JButton btnSkill = new JButton("Skill");
		btnSkill.setBounds(163, 232, 117, 25);
		frame.getContentPane().add(btnSkill);
		
		JButton btnDefence = new JButton("Defence");
		btnDefence.setBounds(292, 232, 117, 25);
		frame.getContentPane().add(btnDefence);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BattleScreen.class.getResource("/Images/MonsterFlip/Bat.png")));
		label.setBounds(21, 67, 130, 120);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(BattleScreen.class.getResource("/Images/Monster/BlueDragons.png")));
		label_1.setBounds(298, 67, 130, 120);
		frame.getContentPane().add(label_1);
		
		JLabel lblHeal = new JLabel("Heal");
		lblHeal.setBounds(45, 29, 70, 15);
		frame.getContentPane().add(lblHeal);
		
		JLabel lblHeal_1 = new JLabel("Heal");
		lblHeal_1.setBounds(314, 29, 70, 15);
		frame.getContentPane().add(lblHeal_1);
	}

}
