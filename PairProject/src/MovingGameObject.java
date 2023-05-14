
public class MovingGameObject extends GameObject {
	
	private Vector velocity;
	
	MovingGameObject(Vector pos, Vector vel) {
		super(pos);
		
		velocity = vel.copy();
	}
	
	public Vector getVelocity() {
		return velocity.copy();
	}
	
	public void setVelocity(Vector newVelocity) {
		velocity = newVelocity;
	}

}
