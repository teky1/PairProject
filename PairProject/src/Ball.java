import java.awt.Image;
import java.awt.Point;

public class Ball extends GameObject {
	
	private Image sprite;
	private Point.double pos;
	private int dimX;
	private int dimY;
	
	public Ball() {
		
	}
	
	public int getPos() {
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
