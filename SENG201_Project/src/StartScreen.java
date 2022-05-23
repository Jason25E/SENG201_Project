import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

/**
 * The class StartScreen
 * Can launch to 
 * SetupScreen
 * and quit
 * @author fye15, zde19
 *
 */
public class StartScreen {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	
	private GameManager manager;

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
	public StartScreen()
	{
		initialize();
	}
	
	public StartScreen(GameManager manager) {
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
		frame.setBounds(100, 100, 550, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMonsterFighter = new JLabel("Monster Fighter!");
		lblMonsterFighter.setFont(new Font("Karumbi", Font.BOLD, 66));
		lblMonsterFighter.setBounds(103, 33, 348, 97);
		frame.getContentPane().add(lblMonsterFighter);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewGame.setAction(action);
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.setBackground(new Color(0, 204, 102));
		btnNewGame.setBounds(200, 173, 136, 56);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnNewButton_1 = new JButton("Quit");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(255, 51, 102));
		btnNewButton_1.setBounds(200, 250, 136, 56);
		frame.getContentPane().add(btnNewButton_1);
	}
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "New Game");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			manager.closeStartScreen(StartScreen.this);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "Quit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			closeWindow();
		}
	}
}
