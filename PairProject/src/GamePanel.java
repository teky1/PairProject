import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements MouseListener {
	
	// Represent the respective instances of game and game runner
	private Game game;
	private GameRunner gameRunner;
	private JFrame parentFrame;
	private int lives;
	private Image img;
	private Image colon1;
	private Image colon2;
	private Image[] nums;
	// 
	private int width;
	private int height;
	
	//Inititialize  stfuf and setup listeners
	public GamePanel(Game game, GameRunner gameRunner) {
		this.game = game;
		this.gameRunner = gameRunner;
		this.width = 600;
		this.height = 600;
		this.lives = game.getLives();
		
		this.img = new ImageIcon(getClass().getClassLoader().
				getResource("Lives.png")).getImage().
				getScaledInstance(100, 12, java.awt.Image.SCALE_SMOOTH);
		this.colon1 = new ImageIcon(getClass().getClassLoader().
				getResource("colon.png")).getImage().
				getScaledInstance(3, 3, java.awt.Image.SCALE_SMOOTH);
		this.colon2 = new ImageIcon(getClass().getClassLoader().
				getResource("colon.png")).getImage().
				getScaledInstance(3, 3, java.awt.Image.SCALE_SMOOTH);
		
		this.nums = new Image[5];
		for(int i=0; i<5; i++) {
			nums[i] = new ImageIcon(getClass().getClassLoader().
					getResource(String.valueOf(i+1)+".png")).getImage().
					getScaledInstance(10, 12, java.awt.Image.SCALE_SMOOTH);
		}
		
//		this.lifeNum = new ImageIcon(getClass().getClassLoader().
//				getResource(String.valueOf(lives)+".png")).getImage().
//				getScaledInstance(10, 12, java.awt.Image.SCALE_SMOOTH);
		
		addMouseListener(this);
	}
	
	public void setParentFrame(JFrame frame) {
		parentFrame = frame;
	}
	
	public void close() {
		parentFrame.setVisible(false);
	}
	
	public int getDimX() {
		return width;
	}
	
	public int getDimY() {
		return height;
	}
	
	/* Gets the current mouse position relative to the top left
	 * corner of the JPanel
	 */
	public Point getMousePosition() {
		PointerInfo mouseInfo = MouseInfo.getPointerInfo();
		Point mousePos = mouseInfo.getLocation();
		
		SwingUtilities.convertPointFromScreen(mousePos, this);
		
		return mousePos;
	}
	
	public void renderFrame() {
		repaint();
	}
	
	public static void startFrame(GamePanel gamePanel) {
		JFrame.setDefaultLookAndFeelDecorated(false);
		gamePanel.setSize(new Dimension(gamePanel.width, gamePanel.height));
		gamePanel.setPreferredSize(new Dimension(gamePanel.getDimX(), gamePanel.getDimY()));
		
		JFrame graphFrame = new JFrame("Astro Breaker");
		graphFrame.setResizable(false);
		graphFrame.setSize(new Dimension(gamePanel.getDimX()+11, gamePanel.getDimY()+11));
		graphFrame.setPreferredSize(new Dimension(gamePanel.getDimX()+11, gamePanel.getDimY()+11));
		graphFrame.setContentPane(gamePanel);
		graphFrame.pack();
		graphFrame.setVisible(true);
		graphFrame.setDefaultCloseOperation(graphFrame.EXIT_ON_CLOSE);
		gamePanel.setParentFrame(graphFrame);
	}
	
	private void renderGameObject(GameObject obj, Image sprite, Graphics2D g) {
		g.drawImage(sprite, obj.getTopLeftPos().getIntX(), obj.getTopLeftPos().getIntY(), null);
	}
	
	public void paintComponent(Graphics graphics) {
		
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		
		g.drawImage(game.getBackgroundImg(), 0, 0, null);
		
		Platform platform = game.getPlatform();
		renderGameObject(platform, platform.getSprite(), g);
		
		
		
		
		ArrayList<Ball> balls = game.getBalls();
		for(Ball ball : balls) {
			renderGameObject(ball, ball.getSprite(), g);
		}
    	
    	ArrayList<PowerUp> powerups = game.getPowerups();
		for(PowerUp powerup : powerups) {
			renderGameObject(powerup, powerup.getSprite(), g);
		}

		for(Brick brick : game.getLevel().getBricks()) {
			renderGameObject(brick, brick.getSprite(), g);
			renderGameObject(brick, brick.getDamageOverlay(), g);
    }
		
		for(Asteroid asteroid : game.getLevel().getAsteroids()) {
			renderGameObject(asteroid, asteroid.getSprite(), g);
		}
		
		
		g.drawImage(img, 400, 16, null);
		g.drawImage(colon1, 505, 19, null);
		g.drawImage(colon2, 505, 25, null);
		if(game.getLives()>0) {
			g.drawImage(nums[game.getLives()-1], 520, 16, null);
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		ArrayList<Ball> balls = game.getBalls();
		for(Ball ball : balls) {
			ball.start();
		}
		
	}

}
