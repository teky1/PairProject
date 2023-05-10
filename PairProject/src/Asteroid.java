
public class Asteroid extends MovingGameObject {
	
	public int health;
	public 
	
	Asteroid(int posX, int posY, int velX, int velY) {
		super(posX, posY, velX, velY);
		
		setDim(20,20);
		setSprite();
		
	}
	
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	
	
