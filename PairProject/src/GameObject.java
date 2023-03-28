import java.awt.Image;


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
		
	}
	
	// returns sprite
	public Image getSprite() {
		return sprite;
	}
	
	// changes sprite
	public void setSprite(Image newSprite) {
		sprite = newSprite;
	}
	
	
	
}
