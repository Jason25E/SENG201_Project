import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Color;

public class SetupScreen {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
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
	public SetupScreen() {
		
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
		
		JLabel lblWhatIsYour = new JLabel("What is your name");
		lblWhatIsYour.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWhatIsYour.setBounds(125, 7, 200, 20);
		frame.getContentPane().add(lblWhatIsYour);
		
		textField = new JTextField();
		textField.setBounds(115, 39, 200, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("How many days would you like to last for?");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(24, 76, 400, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblChooseADifficulty = new JLabel("Choose a difficulty");
		lblChooseADifficulty.setFont(new Font("Dialog", Font.BOLD, 16));
		lblChooseADifficulty.setBounds(125, 156, 200, 20);
		frame.getContentPane().add(lblChooseADifficulty);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.setBounds(24, 198, 117, 25);
		frame.getContentPane().add(btnEasy);
		
		JButton btnNormal = new JButton("Normal");
		btnNormal.setBounds(169, 198, 117, 25);
		frame.getContentPane().add(btnNormal);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(307, 198, 117, 25);
		frame.getContentPane().add(btnHard);
		
		JSlider slider = new JSlider();
		slider.setMinimum(5);
		slider.setMaximum(15);
		slider.setBounds(115, 120, 200, 25);
		frame.getContentPane().add(slider);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setBounds(319, 235, 117, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
