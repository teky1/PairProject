
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
		
		if(!isActive()) {
			return;
		}
		
		if(testForBallCollisions()!=null && 
				!testForBallCollisions().getStartState()) {
			setVelocity(getVelocity().multiply(
					new Vector(1, -1)));
			Ball b = testForBallCollisions();
			Vector change = new Vector(b.getVelocity().getX(), 
					-1*Math.abs(b.getVelocity().getY()));
			b.setVelocity(change);
			setHealth(getHealth()-1);
		}
		
		setPos(getPos().add(getVelocity().multiply(timeDelta)));
		
		if(getPos().getX() <= (13*3+15)) {
			this.setVelocity(new Vector(Math.abs(
					getVelocity().getX()), getVelocity().getY()));
		}
		
		if(getPos().getX() >= (185*3-15)) {
			this.setVelocity(new Vector(-1*Math.abs(
					getVelocity().getX()), getVelocity().getY()));
		}
		
		
		if(getPos().getY() <= (13*3+15)) {
			this.setVelocity(new Vector(getVelocity().getX(), 
					Math.abs(getVelocity().getY())));
		}
		
		if(getPos().getY() >= 485) {
			this.setVelocity(new Vector(getVelocity().getX(), 
					-1*Math.abs(getVelocity().getY())));
		}
		
	}
	
	public Ball testForBallCollisions() {
		for(Ball b : game.getBalls()) {
			if (Math.abs(getPos().getX()-b.getPos().getX())<=20 &&
				Math.abs(getPos().getY()-b.getPos().getY())<=20) {
				return b;
			}
		}
		return null;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
		if(health <= 0) {
			setActive(false);
			setSprite(null);
			return;
		} else if (health > 3) {
			newHealth = 3;
		}
		
		setSprite("asteroid"+newHealth+".png");
	}
	
}
