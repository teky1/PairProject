import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ball extends MovingGameObject {
	
	private Game game;
	
	public Ball(Game g) {
		super(0, 0, 0, 0);
		game = g;
		
		setDim(10, 10);
		setSprite("ball.png");
	}
}
