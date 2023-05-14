import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game {
	
	private Ball ball;
	private Platform platform;
	private Level level;
	private Image backgroundImg;
	
	Game() {
		
		this.ball = new Ball(this);
		this.platform = new Platform(this);
		
		try {
		    backgroundImg = ImageIO.read(getClass().getClassLoader().getResource("background.png")).
					getScaledInstance(600, 600, 0);
		} catch (IOException e) {
			System.out.println("backgroudn sprites not found.");
			e.printStackTrace();
		}
	}
	
	public Image getBackgroundImg() {
		
		return backgroundImg;
		
	}
	
	public void loadLevel(int levelCode) {
		
		
	}
	
	public Ball getBall() {
		return ball;
	}
	
	public Platform getPlatform() {
		return platform;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void setLevel(Level newLevel) {
		level = newLevel;
	}
	
}
