import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainScreen extends JPanel {
	JFrame frame;
	JPanel panel;
	JLabel title, logo;
	JButton tutorial, playButton, randomButton;
	Image backgroundImage;
	
	public MainScreen() {
		try {
			backgroundImage = ImageIO.read(getClass().getClassLoader().
					getResource("title-screen.png")).getScaledInstance(600, 600, 0);
		} catch (IOException e) {
			System.out.println("Background image not found.");
			e.printStackTrace();
		}
		
		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, null);
			}
		};
		
		this.frame = new JFrame("Mainscreen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		panel.setPreferredSize(new Dimension(600, 600));
		panel.setLayout(null);
		
		int buttonLength = 3*99;
		int buttonHeight = 3*17;
		Image tutorialImg = new ImageIcon(getClass().getClassLoader().
				getResource("tutorial-button.png")).getImage().
				getScaledInstance(buttonLength, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		Image playImg = new ImageIcon(getClass().getClassLoader().
				getResource("play-button.png")).getImage().
				getScaledInstance(buttonLength, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		Image randomImg = new ImageIcon(getClass().getClassLoader().
				getResource("random-button.png")).getImage().
				getScaledInstance(buttonLength, buttonHeight, java.awt.Image.SCALE_SMOOTH);
		tutorial = new JButton(new ImageIcon(tutorialImg));
		playButton = new JButton(new ImageIcon(playImg));
		randomButton = new JButton(new ImageIcon(randomImg));

		playButton.setBounds(150, 300, buttonLength, buttonHeight);
		randomButton.setBounds(150, 375, buttonLength, buttonHeight);
		tutorial.setBounds(150, 450, buttonLength, buttonHeight);
		playButton.setOpaque(false);
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false);
		randomButton.setOpaque(false);
		randomButton.setContentAreaFilled(false);
		randomButton.setBorderPainted(false);
		tutorial.setOpaque(false);
		tutorial.setContentAreaFilled(false);
		tutorial.setBorderPainted(false);
		
		panel.add(playButton);
		panel.add(randomButton);
		panel.add(tutorial);
		tutorial.setVisible(true);
		playButton.setVisible(true);
		randomButton.setVisible(true);
		
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.setVisible(true);
		randomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    g.drawImage(backgroundImage, 0, 0, this);
	  }
	public static void main(String[] args) {
		new MainScreen();
	}
}
