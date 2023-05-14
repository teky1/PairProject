
public class PowerUp extends MovingGameObject {
	
	private Game game;
	
	PowerUp(Vector pos, Game g) {
		super(pos, new Vector(0, 75));
		game = g;
		
		setDim(16, 16);
	}
	
	public void update(double timeDelta) {
		
		setPos(getPos().add(getVelocity().multiply(timeDelta)));
		
		Platform p = game.getPlatform();
		
		// available methods in Platform: p.getDimX(), p.getDimY(), p.getPos().getX(), p.getPos().getY()
		// all the same methods are available in this current class using this.getDimX() and so on

		double halfWidthPlatform = p.getDimX() / 2.0;
		double halfHeightPlatform = p.getDimY() / 2.0;
		double halfWidthClass = this.getDimX() / 2.0;
		double halfHeightClass = this.getDimY() / 2.0;
		
		double minXPlatform = p.getPos().getX() - halfWidthPlatform;
		double maxXPlatform = p.getPos().getX() + halfWidthPlatform;
		double minYPlatform = p.getPos().getY() - halfHeightPlatform;
		double maxYPlatform = p.getPos().getY() + halfHeightPlatform;
		double minXClass = this.getPos().getX() - halfWidthClass;
		double maxXClass = this.getPos().getX() + halfWidthClass;
		double minYClass = this.getPos().getY() - halfHeightClass;
		double maxYClass = this.getPos().getY() + halfHeightClass;

		boolean xOverlap = minXPlatform <= maxXClass && maxXPlatform >= minXClass;
		boolean yOverlap = minYPlatform <= maxYClass && maxYPlatform >= minYClass;

		if (xOverlap && yOverlap && isActive()) {
			setActive(false);
		    onCollect();
		}
		
	}
	
	// to be specialized
	public void onCollect() {
		
	}
	
}
