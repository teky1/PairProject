import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainScreen extends JPanel {
	JFrame frame;
	JPanel panel;
	JLabel title, logo;
	JButton Tutorial, storyButton, randomButton;
	
	public MainScreen(JPanel panel) {
		this.frame = new JFrame("Main Screen");
		this.panel = panel;
		panel.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(600, 600));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.setContentPane(panel);
		frame.pack();
		Tutorial = new JButton("Tutorial");
		storyButton = new JButton("Story");
		randomButton = new JButton("Random");
//		Tutorial = new JButton(new ImageIcon(""));
//		storyButton = new JButton(new ImageIcon(""));
//		randomButton = new JButton(new ImageIcon(""));
		Tutorial.setBounds(10,10,110,60);
		storyButton.setBounds(130,10,110,60);
		randomButton.setBounds(250,10,110,60);
		panel.add(Tutorial);
		panel.add(storyButton);
		panel.add(randomButton);
		Tutorial.setVisible(true);
		storyButton.setVisible(true);
		randomButton.setVisible(true);
		
		Tutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		storyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.setVisible(true);
		randomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.setVisible(true);
	}
}
