import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ball extends MovingGameObject {
	
	private Game game;
	
	public Ball(Game g) {
		game = g;
		super(0, 0, 0, 0);
		
		setDim(10, 10);
		setSprite("ball.png");
	}
	
	

	
}
