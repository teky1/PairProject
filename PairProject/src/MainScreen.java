import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainScreen extends JPanel {
	JFrame frame;
	JPanel panel;
	JLabel title, logo;
	JButton playButton;
	
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
		playButton = new JButton("Start");
//		playButton = new JButton(new ImageIcon(""));
		playButton.setBounds(10,10,110,60);
		panel.add(playButton);

		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println("ok");
			}
		});
	}
	public static void main(String args[]) {
		new MainScreen();
	}
}
