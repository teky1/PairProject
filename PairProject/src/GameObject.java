import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;


/*
 * GameObject: Represents a game object that has a positiion, and sprite
 * */
public class GameObject {
	
	
	// Position of center of game object
	Vector pos;
	
	// Intended dimensions of GameObject when rendered
	private int dimX;
	private int dimY;
	
	// Spryte
	private Image sprite;
	private String spriteLocation;
	
	private boolean active;
	
	// Initializes position of gameobj
	GameObject(Vector pos) {
		this.pos = pos.copy();
		
		spriteLocation = "";
		active = true;
	}
	
	public Vector getTopLeftPos() {
		return new Vector(
					getPos().getX()-getDimX()/2,
					getPos().getY()-getDimY()/2
				);
	}
	
	public Vector getPos() {
		return pos.copy();
	}
	
	public void setPos(Vector newPos) {
		pos = newPos;
	}
	
	public int getDimX() {
		return dimX;
	}
	
	public int getDimY() {
		return dimY;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean b) {
		active = b;
	}
	
	public void setDim(int x, int y) {
		this.dimX = x;
		this.dimY = y;
		
		if(!spriteLocation.equals("")) {
			setSprite(spriteLocation);
		}
	}
	
	// returns sprite
	public Image getSprite() {
		if(!active) {
			return null;
		}
		return sprite;
	}
	
	// changes sprite
	public void setSprite(String newSprite) {
		if(newSprite == null) {
			sprite = null;
			spriteLocation = "";
			return;
		}
		try {
		    sprite = ImageIO.read(getClass().getClassLoader().getResource(newSprite)).
					getScaledInstance(getDimX(), getDimY(), 0);
		    spriteLocation = newSprite;
		} catch (IOException e) {
			System.out.println("Certain sprites not found.");
			e.printStackTrace();
		}
	}
	
	// called on each frame
	public void update(double timeDelta) {
		
	}
	
	
	
}
