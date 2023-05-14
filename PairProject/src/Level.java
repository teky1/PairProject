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
		
	}
	
	Level(ArrayList<Asteroid> asteroids, ArrayList<Brick> bricks) {
		asteroidList = asteroids;
		brickList = bricks;
		if(asteroidList==null) {
			
		}
		
		
		/*
		 * @Dia ---> read what i wrote in loadLevel function comment -Joel
		 * 
		 * 
		BufferedReader lineReader = new BufferedReader(new FileReader(locations));
		String line;
		try {
			while((line = lineReader.readLine())!=null) {
				int delimiter = line.indexOf(",");
				int x = Integer.parseInt(line.substring(0, delimiter));
				int y = Integer.parseInt(line.substring(delimiter+1));
				asteroidList.add(new Asteroid(x, y));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
	}
	
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
	
	public static Level load(int levelCode) throws FileNotFoundException {
		// @DIA PUT LEVEL LOAD CODE HERE AND HAVE IT RETURN A POPULATED LEVEL
		// THIS IS TEST CODE IM LEAVING HERE FOR NOW -Joel
		
		ArrayList<Asteroid> a = new ArrayList<Asteroid>();
		ArrayList<Brick> b = new ArrayList<Brick>();
		
		if(levelCode==1) {
			Vector position;
			Vector velocity;
			int x=0, y=0;
			for(int i=0; i<15; i++) {
				position = new Vector(x, y);
				velocity = new Vector(75, 75);
//				b.add(new Brick(position, velocity));
				x+=40;
				y+=20;
			}
		}
		
		return new Level(null, null);
		
		
	}
	
	public void update() {
		
	}
	
}
