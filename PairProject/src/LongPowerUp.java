
public class LongPowerUp extends PowerUp{
	
	private Game game;
	
	LongPowerUp(Vector pos, Game g) {
		super(pos, g);
		
		game = g;
		
		setSprite("powerup_long.png");
	}
	
	public void onCollect() {
		
		int platformWidth = game.getPlatform().getDimX();
		
		if(platformWidth+20 <= 200) {
			game.getPlatform().setWidth(platformWidth+20);
		}
		
	}
	
}
