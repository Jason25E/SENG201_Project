import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class StartScreen {

	private JFrame frame;
	private GameManager manager;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
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
	public StartScreen(GameManager manager) {
		this.manager = manager;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMonsterFighter = new JLabel("Monster Fighter!");
		lblMonsterFighter.setFont(new Font("Karumbi", Font.BOLD, 66));
		lblMonsterFighter.setBounds(103, 33, 348, 97);
		frame.getContentPane().add(lblMonsterFighter);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setAction(action);
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.setBackground(new Color(0, 204, 102));
		btnNewGame.setBounds(200, 173, 136, 40);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnNewButton = new JButton("Setting");
		btnNewButton.setBounds(200, 225, 136, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quit");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(255, 51, 102));
		btnNewButton_1.setBounds(200, 277, 136, 40);
		frame.getContentPane().add(btnNewButton_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "New Game");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			manager.launchMainScreen(this.manager);
			manager.closeStartScreen();
		}
	}
}
