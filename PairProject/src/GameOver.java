import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GameOver {
	JFrame frame;
	JPanel panel;
	JLabel win, lose, levelReached, level, livesRemaining, lives, clickAnywhere;
	JButton returnToMain;
	JLabel[] colon = new JLabel[4];
	
	public GameOver(boolean won, GameRunner gr) {
		
		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 600, 600);
			}
		};
		
		this.frame = new JFrame("Game Over");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		panel.setPreferredSize(new Dimension(600, 600));
		panel.setLayout(null);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		
		if (won) {
			Image img = new ImageIcon(getClass().getClassLoader().
					getResource("You won!.png")).getImage().
					getScaledInstance(300, 36, java.awt.Image.SCALE_SMOOTH);
			win = new JLabel(new ImageIcon(img));
			win.setBounds(150, 150, 300, 36);
			panel.add(win);
			win.setVisible(true);
		} else {
			Image img = new ImageIcon(getClass().getClassLoader().
					getResource("You lost!.png")).getImage().
					getScaledInstance(300, 36, java.awt.Image.SCALE_SMOOTH);
			lose = new JLabel(new ImageIcon(img));
			lose.setBounds(130, 150, 340, 36);
			panel.add(lose);
			lose.setVisible(true);
		}
		
		int levelNum = 1;
		Image img = new ImageIcon(getClass().getClassLoader().
				getResource("Level reached.png")).getImage().
				getScaledInstance(219, 16, java.awt.Image.SCALE_SMOOTH);
		levelReached = new JLabel(new ImageIcon(img));
		levelReached.setBounds(175, 250, 219, 16);
		panel.add(levelReached);
		levelReached.setVisible(true);
		for (int i=0; i<4; i++) {
			colon[i] = new JLabel(new ImageIcon(getClass().
					getClassLoader().getResource("colon.png")));
			panel.add(colon[i]);
			colon[i].setVisible(true);
		}
		colon[0].setBounds(397,254,4,4);
		colon[1].setBounds(397,262,4,4);
		img = new ImageIcon(getClass().getClassLoader().
				getResource(String.valueOf(levelNum)+".png")).getImage().
				getScaledInstance(14, 16, java.awt.Image.SCALE_SMOOTH);
		level = new JLabel(new ImageIcon(img));
		level.setBounds(413, 250, 14, 16);
		panel.add(level);
		level.setVisible(true);
		
		if (won) {
			int livesNum = 0;
			img = new ImageIcon(getClass().getClassLoader().
					getResource("Lives remaining.png")).getImage().
					getScaledInstance(250, 16, java.awt.Image.SCALE_SMOOTH);
			levelReached = new JLabel(new ImageIcon(img));
			levelReached.setBounds(155, 300, 250, 16);
			panel.add(levelReached);
			levelReached.setVisible(true);
			colon[2].setBounds(408,304,4,4);
			colon[3].setBounds(408,312,4,4);
			img = new ImageIcon(getClass().getClassLoader().
					getResource(String.valueOf(livesNum)+".png")).getImage().
					getScaledInstance(14, 16, java.awt.Image.SCALE_SMOOTH);
			lives = new JLabel(new ImageIcon(img));
			lives.setBounds(424, 300, 14, 16);
			panel.add(lives);
			lives.setVisible(true);
		}
		
		img = new ImageIcon(getClass().getClassLoader().
				getResource("click anywhere.png")).getImage().
				getScaledInstance(300, 42, java.awt.Image.SCALE_SMOOTH);
		clickAnywhere = new JLabel(new ImageIcon(img));
		clickAnywhere.setBounds(150, 350, 300, 42);
		panel.add(clickAnywhere);
		clickAnywhere.setVisible(true);
		
		returnToMain = new JButton();
		returnToMain.setBounds(0, 0, 600, 600);
		returnToMain.setOpaque(false);
		returnToMain.setContentAreaFilled(false);
		returnToMain.setBorderPainted(false);
		panel.add(returnToMain);
		returnToMain.setVisible(true);
		returnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new GameRunner();
			}
		});
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 600);
	}
	public static void main(String[] args) {
		//new GameOver();
	}
}