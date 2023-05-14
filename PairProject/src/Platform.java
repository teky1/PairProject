
public class Platform extends GameObject {
	
	private Game game;
	
	Platform(Game g) {
		super(new Vector(0, 500));
		
		game = g;
		setDim(100, 12);
		setSprite("platform.png");
		
	}
	
	public void handleCollisions(MovingGameObject obj) {

		double objX = obj.getPos().getX();
		double objY = obj.getPos().getY();
		double objR = obj.getDimX()/2; //object radius
		
		double platformX = getPos().getX();
		double platformY = getPos().getY();
		
		
		// left wall
		if(objX+objR >= platformX - getDimX()/2 && objX <= platformX - getDimX()/2 && Math.abs(objY-platformY)<getDimY()/2+objR) {
			obj.setVelocity(new Vector(-1*Math.abs(obj.getVelocity().getX()), obj.getVelocity().getY()));
		}
		
		// right wall
		if(objX-objR <= platformX + getDimX()/2 && objX >= platformX + getDimX()/2 && Math.abs(objY-platformY)<getDimY()/2+objR) {
			obj.setVelocity(new Vector(Math.abs(obj.getVelocity().getX()), obj.getVelocity().getY()));
		}
		
		// bottom wall
//		if(objY-objR <= platformY + getDimY()/2 && objY >= platformY + getDimY()/2 && Math.abs(objX-platformX)<getDimX()/2+objR) {
//			obj.setVelocity(new Vector(obj.getVelocity().getX(), Math.abs(obj.getVelocity().getY())));
//		}
		
		// top wall
		if(objY+objR >= platformY - getDimY()/2 && objY <= platformY - getDimY()/2 && Math.abs(objX-platformX)<getDimX()/2+objR) {
//			obj.setVelocity(new Vector(obj.getVelocity().getX(), -1*Math.abs(obj.getVelocity().getY())));
			double magnitude = Math.hypot(obj.getVelocity().getX(), obj.getVelocity().getY());
			double angle = ((objX - platformX)/(getDimX()/2)) * Math.PI/3 - Math.PI/2;
			obj.setVelocity((new Vector(Math.cos(angle), Math.sin(angle))).multiply(magnitude));
		}
	}
	
	public void setWidth(int width) {
		setDim(width, getDimY());
	}
	
}
