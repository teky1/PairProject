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
		startState = false;
		
		double angle = Math.random() * 2 * Math.PI/3 + 7*Math.PI/6;
		int magnitude = 400;
		setVelocity((new Vector(Math.cos(angle), Math.sin(angle))).multiply(magnitude));
		
	}
	
	public void update(double timeDelta) {
		
		if(startState) {
			setPos(game.getPlatform().getPos().add(new Vector(0, -getDimX()/2 - game.getPlatform().getDimY()/2)));
			return;
		}
		
		setPos(getPos().add(getVelocity().multiply(timeDelta)));
		
		
		// wall collisions
		if(getPos().getX() <= 13*3) {
			setVelocity(getVelocity().multiply(new Vector(-1, 1)));
//			setPos(getPos().add(new Vector(-2*(getPos().getX()-13*3), 0)));
		}
		
		if(getPos().getX() >= 185*3) {
			setVelocity(getVelocity().multiply(new Vector(-1, 1)));
//			setPos(getPos().add(new Vector(-2*(getPos().getX()-185*3), 0)));
		}
		
		if(getPos().getY() <= 13*3) {
			setVelocity(getVelocity().multiply(new Vector(1, -1)));
//			setPos(getPos().add(new Vector(0, -2*(getPos().getY()-13*3))));
		}
		
		if(getPos().getY() >= 550) {
			setVelocity(getVelocity().multiply(new Vector(1, -1)));
		}
		
	}
}
