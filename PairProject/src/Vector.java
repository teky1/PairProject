import java.awt.Point;

// Represents a 2D Vector
public class Vector extends Point.Double{
	// takes in posX and posY and passes it into superclass
	Vector() {
		super(0, 0);
	}
	Vector(double posX, double posY) {
		super(posX, posY);
	}
	Vector(Point p) {
		super(p.getX(), p.getY());
	}
	Vector(int posX, int posY) {
		super((double)posX, (double)posY);
	}
	// adds two vectors together returning the result
	public Vector add(Vector other) {
		return new Vector(getX()+other.getX(), getY()+other.getY());
	}
	
	public Vector multiply(double multiplier) {
		return new Vector(getX()*multiplier, getY()*multiplier);
	}
	
	public Vector multiply(Vector multiplier) {
		return new Vector(getX() * multiplier.getX(), getY() * multiplier.getY());
	}
	
	public int getIntX() {
		return (int) getX();
	}
	
	public int getIntY() {
		return (int) getY();
	}
	
	public Vector copy() {
		return new Vector(getX(), getY());
	}
}
