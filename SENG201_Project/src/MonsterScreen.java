import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MonsterScreen {

	private JFrame frame;
	
	private GameManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonsterScreen window = new MonsterScreen();
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
	public MonsterScreen() {
		initialize();
	}
	
	public MonsterScreen(GameManager manager) {
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
		frame.setBounds(100, 100, 301, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnMonster = new JRadioButton("Monster1");
		rdbtnMonster.setBounds(63, 8, 99, 32);
		frame.getContentPane().add(rdbtnMonster);
		
		JButton btnEquipment = new JButton("Equipment");
		btnEquipment.setBounds(178, 48, 109, 25);
		frame.getContentPane().add(btnEquipment);
		
		JButton btnSkill = new JButton("Skill1");
		btnSkill.setBounds(63, 48, 109, 25);
		frame.getContentPane().add(btnSkill);
		
		JButton btnEquipment_1_1 = new JButton("Skill2");
		btnEquipment_1_1.setBounds(63, 125, 109, 25);
		frame.getContentPane().add(btnEquipment_1_1);
		
		JRadioButton rdbtnMonster_1 = new JRadioButton("Monster1");
		rdbtnMonster_1.setBounds(63, 85, 109, 32);
		frame.getContentPane().add(rdbtnMonster_1);
		
		JButton btnEquipment_2 = new JButton("Equipment");
		btnEquipment_2.setBounds(178, 125, 109, 25);
		frame.getContentPane().add(btnEquipment_2);
		
		JButton btnEquipment_1_2 = new JButton("Skill3");
		btnEquipment_1_2.setBounds(63, 202, 109, 25);
		frame.getContentPane().add(btnEquipment_1_2);
		
		JRadioButton rdbtnMonster_2 = new JRadioButton("Monster1");
		rdbtnMonster_2.setBounds(63, 162, 109, 32);
		frame.getContentPane().add(rdbtnMonster_2);
		
		JButton btnEquipment_3 = new JButton("Equipment");
		btnEquipment_3.setBounds(178, 202, 109, 25);
		frame.getContentPane().add(btnEquipment_3);
		
		JButton btnEquipment_1_3 = new JButton("Skill4");
		btnEquipment_1_3.setBounds(63, 279, 109, 25);
		frame.getContentPane().add(btnEquipment_1_3);
		
		JRadioButton rdbtnMonster_3 = new JRadioButton("Monster1");
		rdbtnMonster_3.setBounds(63, 239, 109, 32);
		frame.getContentPane().add(rdbtnMonster_3);
		
		JButton btnEquipment_4 = new JButton("Equipment");
		btnEquipment_4.setBounds(178, 279, 109, 25);
		frame.getContentPane().add(btnEquipment_4);
		
		JLabel lblShowInfoAbout = new JLabel("Show info about the skill/equipment");
		lblShowInfoAbout.setBounds(35, 316, 224, 15);
		frame.getContentPane().add(lblShowInfoAbout);
		
		JButton btnEquipment_1_3_1 = new JButton("Swap Order");
		btnEquipment_1_3_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEquipment_1_3_1.setBounds(12, 351, 130, 25);
		frame.getContentPane().add(btnEquipment_1_3_1);
		
		JButton btnEquipment_4_1 = new JButton("Exit");
		btnEquipment_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchMainScreen();
			}
		});
		btnEquipment_4_1.setBounds(157, 351, 130, 25);
		frame.getContentPane().add(btnEquipment_4_1);
		
		JLabel label_1 = new JLabel("2");
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setBounds(25, 94, 50, 50);
		frame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("1");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(25, 17, 50, 50);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("3");
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(25, 171, 50, 50);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setFont(new Font("Dialog", Font.BOLD, 20));
		label_3.setBounds(25, 248, 50, 50);
		frame.getContentPane().add(label_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MonsterScreen.class.getResource("/Images/Monster/Unknowns.png")));
		lblNewLabel.setBounds(171, 8, 116, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MonsterScreen.class.getResource("/Images/Monster/Demon.png")));
		lblNewLabel_1.setBounds(178, 85, 116, 65);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(MonsterScreen.class.getResource("/Images/Monster/Slime.png")));
		lblNewLabel_2.setBounds(171, 162, 116, 65);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon(MonsterScreen.class.getResource("/Images/Monster/Witch.png")));
		lblNewLabel_2_1.setBounds(171, 239, 116, 65);
		frame.getContentPane().add(lblNewLabel_2_1);
	}

}
