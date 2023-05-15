public class ShortPowerUp extends PowerUp{
	
	private Game game;
	
	ShortPowerUp(Vector pos, Game g) {
		super(pos, g);
		
		game = g;
		
		setSprite("powerup_short.png");
	}
	
	public void onCollect() {
		
		int platformWidth = game.getPlatform().getDimX();
		
		if(platformWidth-20 > 20) {
			game.getPlatform().setWidth(platformWidth-20);
		}
		
	}
	
}
