import java.awt.Image;
import java.awt.Point;

public class Ball extends GameObject {
	
	
	public Ball() {
		super(0, 0);
		
	}
	
	public Point.Double getPos() {
		return pos;
	}
	
	public int getDimX() {
		return dimX;
	}
	
	public int getDimY() {
		return dimY;
	}
	
	public void setDimX(int x) {
		dimX = x;
	}
	
	public void setDimY(int y) {
		dimY = y;
	}
	
}
