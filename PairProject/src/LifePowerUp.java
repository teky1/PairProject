
public class LifePowerUp extends PowerUp{
	
	private Game game;
	
	LifePowerUp(Vector pos, Game g) {
		super(pos, g);
		
		game = g;
		
		setSprite("powerup_health.png");
	}
	
	public void onCollect() {
		
		if(game.getLives()<5) {
			game.setLives(game.getLives()+1);
		}
		
	}
	
}
