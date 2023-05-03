import java.awt.Image;
import java.awt.Point;

public class Ball extends GameObject {
	
	private Image sprite;
	private Point.Double pos;
	private int dimX = 5;
	private int dimY = 5;
	
	public Ball() {
		super(5, 5);
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
