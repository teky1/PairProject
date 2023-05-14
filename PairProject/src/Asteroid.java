
public class Asteroid extends MovingGameObject {
	
	private int health;
	private Game game;
	
	Asteroid(Vector pos, Vector vel, Game g) {
		super(pos, vel);
		game = g;
		setDim(30,30);
		setHealth(3);
	}
	
	public void update(double timeDelta) {
		
		if(testForAsteroidCollisions()) {
			setVelocity(getVelocity().multiply(new Vector(1, -1)));
		}
		
		if(testForBallCollisions()) {
			setVelocity(getVelocity().multiply(new Vector(1, -0.9)));
			game.getBall().setVelocity(game.getBall().getVelocity().multiply(new Vector(1, -1)));
			// preventing crashes for now
			if(getHealth()!=1) {
				setHealth(getHealth()-1);
			}
			
		}
		
		setPos(getPos().add(getVelocity().multiply(timeDelta)));
		
		if(getPos().getX() <= (13*3+15) || getPos().getX() >= (185*3-15)) {
			this.setVelocity(getVelocity().multiply(new Vector(-1, 1)));
		}
		
		if(getPos().getY() <= (13*3+15) || getPos().getY() >= 485) {
			this.setVelocity(getVelocity().multiply(new Vector(1, -1)));
		}
		
	}
	
	public boolean testForBallCollisions() {
		return (Math.abs(getPos().getX()-game.getBall().getPos().getX())<=20 &&
				Math.abs(getPos().getY()-game.getBall().getPos().getY())<=20);
	}
	
	public boolean testForAsteroidCollisions() {
		for(int i=0; i<game.getLevel().getAsteroids().size(); i++) {
			if(game.getLevel().getAsteroids().get(i)!=this) {
				if(Math.abs(getPos().getX()-game.getLevel().getAsteroids().get(i).getPos().getX())<=30 &&
				   Math.abs(getPos().getY()-game.getLevel().getAsteroids().get(i).getPos().getY())<=30) {
					return true;
				}
			}
			
		}
		return false;
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
	
	
