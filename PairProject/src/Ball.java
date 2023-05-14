import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ball extends MovingGameObject {
	
	private Game game;
	private boolean startState;
	private int speed;
	
	public Ball(Game g) {
		super(new Vector(), new Vector());
		game = g;
		
		startState = true;
		
		setDim(10, 10);
		setSprite("ball.png");
	}
	
	public void start() {
		if(!startState) {
			return;
		}
		startState = false;
		
		double angle = Math.random() * 2 * Math.PI/3 + 7*Math.PI/6;
		int magnitude = 250;
		setVelocity((new Vector(Math.cos(angle), Math.sin(angle))).multiply(magnitude));
		
	}
	
	public void update(double timeDelta) {
		
		if(!isActive()) {
			return;
		}
		
		if(startState) {
			setPos(game.getPlatform().getPos().add(new Vector(0, -getDimX()/2 - game.getPlatform().getDimY()/2)));
			return;
		}
		
		setPos(getPos().add(getVelocity().multiply(timeDelta)));
		
		
		// wall collisions
		if(getPos().getX() <= 13*3 + getDimX()/2) {
			setVelocity(new Vector(Math.abs(getVelocity().getX()), getVelocity().getY()));
		}
		
		if(getPos().getX() >= 185*3 - getDimX()/2) {
			setVelocity(new Vector(-Math.abs(getVelocity().getX()), getVelocity().getY()));

		}
		
		if(getPos().getY() <= 13*3 + getDimY()/2) {
			setVelocity(new Vector(getVelocity().getX(), Math.abs(getVelocity().getY())));
		}
		
		if(getPos().getY() >= 620) {
//			setVelocity(new Vector(getVelocity().getX(), -Math.abs(getVelocity().getY())));
			setActive(false);
		}
		
	}
}
