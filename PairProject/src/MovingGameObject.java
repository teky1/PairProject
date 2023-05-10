
public class MovingGameObject extends GameObject {
	
	private int velocityX;
	private int velocityY;
	
	MovingGameObject(int x, int y, int vx, int vy) {
		super(x, y);
		
		velocityX = vx;
		velocityY = vy;
	}
	
	public int getVelX() {
		return velocityX;
	}
	
	public int getVelY() {
		return velocityY;
	}
	
	public void setVelX(int newVx) {
		velocityX = newVx;
	}
	
	public void setVelY(int newVy) {
		velocityY = newVy;
	} 

}
