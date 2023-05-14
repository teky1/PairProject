
public class Asteroid extends MovingGameObject {
	
	private int health;
	private Game game;
	
	Asteroid(Vector pos, Vector vel, Game g) {
		super(pos, vel);
		game = g;
		setDim(20,20);
		setHealth(3);
	}
	
	public void start() {
		double angle = Math.random() * 2 * Math.PI/3 + Math.PI;
		int magnitude = 250;
		setVelocity((new Vector(Math.cos(angle), Math.sin(angle))).multiply(magnitude));
	}
	
	public void update(double timeDelta) {
		
		if(testForCollisions()) {
			setVelocity(getVelocity().add(game.getBall().getVelocity().multiply(0.5)));
			game.getBall().setVelocity(game.getBall().getVelocity().add(getVelocity().multiply(0.5)));
		}
		
		setPos(getPos().add(getVelocity().multiply(timeDelta)));
		
		if(getPos().getX() <= 13*3 || getPos().getX() >= 185*3) {
			this.setVelocity(getVelocity().multiply(new Vector(-1, 1)));
		}
		
		if(getPos().getY() <= 13*3 || getPos().getY() >= 500) {
			this.setVelocity(getVelocity().multiply(new Vector(1, -1)));
		}
		
	}
	
	
	public boolean testForCollisions() {
		return (getPos().getX()-game.getBall().getPos().getX()<=30 || getPos().getY()-game.getBall().getPos().getY()<=30);
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
	
}
	
	
