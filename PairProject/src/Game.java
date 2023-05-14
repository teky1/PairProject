import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Game {
	
	private Ball ball;
	private Platform platform;
	private Level level;
	private Image backgroundImg;
	
	Game() {
		
		this.ball = new Ball(this);
		this.platform = new Platform(this);
		this.level = new Level();
		
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
		
//		level = new Level();
//		ArrayList<Brick> bricks = new ArrayList<Brick>();
//		Brick b1 = new Brick();
//		b1.setPos(new Vector(250, 250));
//		Brick b2 = new Brick();
//		b2.setPos(new Vector(100, 100));
//		Brick b3 = new Brick();
//		b3.setPos(new Vector(400, 200));
//		Brick b4 = new Brick();
//		b4.setPos(new Vector(300, 400));
//		bricks.add(b1);
//		bricks.add(b2);
//		bricks.add(b3);
//		bricks.add(b4);
//		level.setBricks(bricks);
		
		level = new Level();
		ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
		Asteroid a1 = new Asteroid(new Vector(100, 100), new Vector(Math.random()*100, 100), this);
		Asteroid a2 = new Asteroid(new Vector(180, 250), new Vector(Math.random()*100, 100), this);
		Asteroid a3 = new Asteroid(new Vector(300, 418), new Vector(Math.random()*100, 100), this);
		asteroids.add(a1);
		asteroids.add(a2);
		asteroids.add(a3);
		level.setAsteroids(asteroids);
		
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
