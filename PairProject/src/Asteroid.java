
public class Asteroid extends MovingGameObject {
	
	private int health;
	
	
	Asteroid(Vector pos, Vector vel) {
		super(pos, vel);
		
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
	
	
