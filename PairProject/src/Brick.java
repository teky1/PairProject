import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brick extends GameObject {
	
	private Game game;
	
	private int health;
	private Hitbox hitbox;
	
	private Image damageOverlay;
	
	Brick(Game g) {
		super(new Vector());
		
		game = g;
		setDim(32, 16);
		setSprite("brick"+((int)(Math.random()*5))+".png");
		setHealth(3);
		
	}
	
	public void handleCollisions(MovingGameObject obj) {
		
		if(!isActive()) {
			return;
		}
		
		double objX = obj.getPos().getX();
		double objY = obj.getPos().getY();
		double objR = obj.getDimX()/2; //object radius
		
		double brickX = getPos().getX();
		double brickY = getPos().getY();
		
		boolean collisionOccurred = false;
		
		// left wall
		if(objX+objR >= brickX - getDimX()/2 && objX <= brickX - getDimX()/2 && Math.abs(objY-brickY)<getDimY()/2+objR) {
			obj.setVelocity(new Vector(-1*Math.abs(obj.getVelocity().getX()), obj.getVelocity().getY()));
			collisionOccurred = true;
		}
		
		// right wall
		if(objX-objR <= brickX + getDimX()/2 && objX >= brickX + getDimX()/2 && Math.abs(objY-brickY)<getDimY()/2+objR) {
			obj.setVelocity(new Vector(Math.abs(obj.getVelocity().getX()), obj.getVelocity().getY()));
			collisionOccurred = true;
		}
		
		// bottom wall
		if(objY-objR <= brickY + getDimY()/2 && objY >= brickY + getDimY()/2 && Math.abs(objX-brickX)<getDimX()/2+objR) {
			obj.setVelocity(new Vector(obj.getVelocity().getX(), Math.abs(obj.getVelocity().getY())));
			collisionOccurred = true;
		}
		
		// top wall
		if(objY+objR >= brickY - getDimY()/2 && objY <= brickY - getDimY()/2 && Math.abs(objX-brickX)<getDimX()/2+objR) {
			obj.setVelocity(new Vector(obj.getVelocity().getX(), -1*Math.abs(obj.getVelocity().getY())));
			collisionOccurred = true;
		}
		
		if(collisionOccurred && obj.getClass().toString().contains("Ball")) {
			setHealth(health-1);
		}
		
		
	}
	
	public void setHealth(int health) {
		if(health >= 3) {
			this.health = 3;
		} else if(health <= 0) {
			this.health = 0;
			damageOverlay = null;
			setActive(false);
			
			if(Math.random()<=.5) {
				game.spawnPowerup(getPos());
			}
			
		} else {
			this.health = health;
			try {
			    damageOverlay = ImageIO.read(getClass().getClassLoader().getResource("crack"+(3-this.health)+".png")).
						getScaledInstance(getDimX(), getDimY(), 0);
			} catch (IOException e) {
				System.out.println("Certain sprites not found.");
				e.printStackTrace();
			}
		}
		
		
	}
	
	public Image getDamageOverlay() {
		if(3-health == 0 || 3-health == 3) {
			return null;
		}
		return damageOverlay;
	}
	
	
	
}
