import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;


/*
 * GameObject: Represents a game object that has a positiion, and sprite
 * */
public class GameObject {
	
	
	// Position of center of game object
	private double posX;
	private double posY;
	
	// Intended dimensions of GameObject when rendered
	private int dimX;
	private int dimY;
	
	// Spryte
	private Image sprite;
	
	// Initializes position of gameobj
	GameObject(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getDimX() {
		return dimX;
	}
	
	public int getDimY() {
		return dimY;
	}
	
	public void setDim(int x, int y) {
		this.dimX = x;
		this.dimY = y;
	}
	
	// returns sprite
	public Image getSprite() {
		return sprite;
	}
	
	// changes sprite
	public void setSprite(String newSprite) {
		try {
		    Image sprite = ImageIO.read(getClass().getClassLoader().getResource(newSprite)).
					getScaledInstance(getDimX(), getDimY(), 0);
		} catch (IOException e) {
			System.out.println("Certain sprites not found.");
			e.printStackTrace();
		}
	}
	
	// called on each frame
	public void update(double timeDelta) {
		
	}
	
	
	
}
