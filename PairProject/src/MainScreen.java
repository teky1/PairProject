import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainScreen extends JPanel {
	JFrame frame;
	JPanel panel;
	JLabel title, logo;
	JButton startButton, playButton, Tutorial;
	
	public MainScreen() {
		this.frame = new JFrame("Main Screen");
		this.panel = new JPanel();
		panel.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(800, 700));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		startButton = new JButton("Start");
//		startButton = new JButton(new ImageIcon(""));
		startButton.setBounds(10,10,110,60);
		panel.add(startButton);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficultySelection();
			}
		});
		frame.setVisible(true);
	}
	
	public void difficultySelection() {
		Tutorial = new JButton("Tutorial");
		playButton = new JButton("Play");
//		Tutorial = new JButton(new ImageIcon(""));
		Tutorial.setBounds(10,10,110,60);
		playButton.setBounds(130,10,110,60);
		panel.add(Tutorial);
//		playButton = new JButton(new ImageIcon(""));
		panel.add(playButton);
		Tutorial.setVisible(true);
		playButton.setVisible(true);
		startButton.setVisible(false);
		
		Tutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		new MainScreen();
	}
}
