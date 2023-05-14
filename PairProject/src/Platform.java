
public class Platform extends GameObject {
	
	private Game game;
	
	Platform(Game g) {
		super(new Vector(0, 500));
		
		game = g;
		setDim(100, 12);
		setSprite("platform.png");
		
	}
	
	public void setWidth(int width) {
		setDim(width, getDimY());
	}
	
}
