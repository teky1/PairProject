import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;

public class Level {
	
	private ArrayList<Asteroid> asteroidList;
	private ArrayList<Brick> brickList;
	private ArrayList<Integer> healthPoints;
	
	Level() {
		asteroidList = new ArrayList<Asteroid>();
		brickList = new ArrayList<Brick>();
	}

	public ArrayList<Asteroid> getAsteroids() {
		return (ArrayList<Asteroid>) asteroidList.clone();
	}
	
	public void setAsteroids(ArrayList<Asteroid> asteroids) {
		asteroidList = (ArrayList<Asteroid>) asteroids.clone();
	}
	
	public ArrayList<Brick> getBricks() {
		return (ArrayList<Brick>) brickList.clone();
	}
	
	public void setBricks(ArrayList<Brick> bricks) {
		brickList = (ArrayList<Brick>) bricks.clone();
	}
	
}
