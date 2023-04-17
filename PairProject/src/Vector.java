import java.awt.Point;

// Represents a 2D Vector
public class Vector extends Point.Double{
	// takes in posX and posY and passes it into superclass
	Vector(double posX, double posY) {
		super(posX, posY);
	}
	Vector(int posX, int posY) {
		super((double)posX, (double)posY);
	}
	// adds two vectors together returning the result
	public Vector add(Vector other) {
		return new Vector(getX()+other.getX(), getY()+other.getY());
	}
}
