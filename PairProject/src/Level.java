import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;

public class Level {
	
	private ArrayList<Asteroid> asteroidList;
	
	Level(File locations) throws FileNotFoundException {
		asteroidList = new ArrayList<Asteroid>();
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
		}
		
		
	}
	
	public boolean testForCollision(Ball b) {
		
		return false;
	}
	
	public void updateBlocks() {
		
	}
	
}
