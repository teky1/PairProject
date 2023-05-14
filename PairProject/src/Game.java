import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Game {
	
	private ArrayList<Ball> balls;
	private ArrayList<PowerUp> powerups;
	private Platform platform;
	private Level level;
	private Image backgroundImg;
	private int lives;
	
	Game() {
		
		reset();
		
		this.lives = 5;
		
		try {
		    backgroundImg = ImageIO.read(getClass().getClassLoader().getResource("background.png")).
					getScaledInstance(600, 600, 0);
		} catch (IOException e) {
			System.out.println("backgroudn sprites not found.");
			e.printStackTrace();
		}
	}
	
	public void reset() {
		this.balls = new ArrayList<Ball>();
		this.balls.add(new Ball(this));
		
		this.powerups = new ArrayList<PowerUp>();
		
		this.platform = new Platform(this);
		this.level = new Level();
	}
	
	public int getLives() {
		return lives;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public Image getBackgroundImg() {
		
		return backgroundImg;
		
	}
	
	public void loadLevel(int levelCode) {
		
		level = new Level();
		ArrayList<Brick> bricks = new ArrayList<Brick>();
		
		
		for(int i = 0; i < 20; i++) {
			Brick b = new Brick(this);
			b.setPos(new Vector(3*Math.random()*150+60, 3*Math.random()*120+60));
			bricks.add(b);
		}
		
		level.setBricks(bricks);
		
	}
	
	public ArrayList<Ball> getBalls() {
		return (ArrayList<Ball>) balls.clone();
	}
	
	public void setBalls(ArrayList<Ball> newBalls) {
		balls = (ArrayList<Ball>) newBalls.clone();
	}
	
	public ArrayList<PowerUp> getPowerups() {
		return (ArrayList<PowerUp>) powerups.clone();
	}
	
	public void setPowerups(ArrayList<PowerUp> newPowerups) {
		powerups = (ArrayList<PowerUp>) newPowerups.clone();
	}
	
	public void spawnPowerup(Vector pos) {
		powerups.add(new BallsPowerUp(pos, this));
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
