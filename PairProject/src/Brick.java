import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brick extends GameObject {
	
	private int health;
	private Hitbox hitbox;
	
	private Image damageOverlay;
	
	Brick() {
		super(new Vector());
		
		setDim(32, 16);
		setSprite("brick"+((int)(Math.random()*5))+".png");
		
	}
	
	public void handleCollisions(MovingGameObject obj) {
		
	}
	
	public Image getDamageOverlay() {
		if(3-health == 0 || 3-health == 3) {
			return null;
		}
		
		try {
		    return ImageIO.read(getClass().getClassLoader().getResource("crack"+(3-health)+".png")).
					getScaledInstance(getDimX(), getDimY(), 0);
		} catch (IOException e) {
			System.out.println("Certain sprites not found.");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
