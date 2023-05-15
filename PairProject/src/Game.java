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
		/*
		level = new Level();
		ArrayList<Brick> bricks = new ArrayList<Brick>();
		Brick b1 = new Brick();
		b1.setPos(new Vector(250, 250));
		Brick b2 = new Brick();
		b2.setPos(new Vector(100, 100));
		Brick b3 = new Brick();
		b3.setPos(new Vector(400, 200));
		Brick b4 = new Brick();
		b4.setPos(new Vector(300, 400));
		bricks.add(b1);
		bricks.add(b2);
		bricks.add(b3);
		bricks.add(b4);
		level.setBricks(bricks);
		*/
		level = new Level();
		ArrayList<Brick> bricks = new ArrayList<Brick>();
		ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
		int xPos = 70;
		int yPos = 70;
//		int xVel = 0;
//		int yVel = 0;
		if(levelCode==1) {
			for(xPos=59; xPos<570; xPos+=32) {
//				for(yPos=50; yPos<250; yPos+=16) {
				for(yPos=50; yPos<100; yPos+=16) {
					Brick b = new Brick(this);
					b.setPos(new Vector(xPos, yPos));
					bricks.add(b);
				}
			}
			Asteroid a1 = new Asteroid(new Vector(100, 100), new Vector(Math.random()*200, 200), this);
			Asteroid a2 = new Asteroid(new Vector(180, 250), new Vector(Math.random()*200, 200), this);
			Asteroid a3 = new Asteroid(new Vector(300, 418), new Vector(Math.random()*200, 200), this);
			asteroids.add(a1);
			asteroids.add(a2);
			asteroids.add(a3);
		} else if(levelCode==2) {
			for(xPos=59; xPos<570; xPos+=80) {
				for(yPos=50; yPos<250; yPos+=16) {
					Brick b = new Brick(this);
					b.setPos(new Vector(xPos, yPos));
					bricks.add(b);
				}
			}
//			for(int i=0; i<8; i++) {
//				Vector p = new Vector(Math.random()*400 + 70, Math.random()*400 + 70);
//				Vector v = new Vector(Math.random()*150, Math.random()*150);
//				asteroids.add(new Asteroid(p, v, this));
//			}
			
		} else if(levelCode==3) {
			for(xPos=59; xPos<570; xPos+=96) {
				for(yPos=50; yPos<250; yPos+=48) {
					Brick b = new Brick(this);
					b.setPos(new Vector(xPos, yPos));
					bricks.add(b);
				}
			}
			for(int i=0; i<5; i++) {
				Vector p = new Vector(Math.random()*400 + 70, Math.random()*400 + 260);
				Vector v = new Vector(Math.random()*100 + 50, Math.random()*100 + 50);
				asteroids.add(new Asteroid(p, v, this));
			}
		} else if(levelCode==0) { // randomized levels
			int limit = (int) (Math.random()*30 + 1);
			for(int i=0; i<limit; i++) {
				Brick b = new Brick(this);
				b.setPos(new Vector(450*Math.random()+60, 360*Math.random()+60));
				bricks.add(b);
			}
		}
//		level = new Level();
//		
//		
//		for(int i = 0; i < 20; i++) {
//			Brick b = new Brick(this);
//			b.setPos(new Vector(3*Math.random()*150+60, 3*Math.random()*120+60));
//			bricks.add(b);
//		}
		
		level.setBricks(bricks);
		level.setAsteroids(asteroids);
//		Asteroid a1 = new Asteroid(new Vector(100, 100), new Vector(Math.random()*200, 200), this);
//		Asteroid a2 = new Asteroid(new Vector(180, 250), new Vector(Math.random()*200, 200), this);
//		Asteroid a3 = new Asteroid(new Vector(300, 418), new Vector(Math.random()*200, 200), this);
//		asteroids.add(a1);
//		asteroids.add(a2);
//		asteroids.add(a3);
		
		
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
		double rand = Math.random();
		if(rand <= .3) {
			powerups.add(new BallsPowerUp(pos, this));
		} else if(rand <= .6) {
			powerups.add(new LongPowerUp(pos, this));
		} else if(rand <= .9) {
			powerups.add(new ShortPowerUp(pos, this));
		} else {
			powerups.add(new LifePowerUp(pos, this));
		}
		
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
