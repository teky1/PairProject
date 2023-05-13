
public class Asteroid extends MovingGameObject {
	
	private int health;
	
	
	Asteroid(int posX, int posY, int velX, int velY) {
		super(posX, posY, velX, velY);
		
		setDim(20,20);
		setHealth(3);
		
	}
	
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
		if(health <= 0) {
			setSprite(null);
			return;
		} else if (health > 3) {
			newHealth = 3;
		}
		
		setSprite("asteroid"+newHealth+".png");
	}
	
	
