import java.util.ArrayList;

public class BallsPowerUp extends PowerUp {

	private Game game;
	
	BallsPowerUp(Vector pos, Game g) {
		super(pos, g);
		
		game = g;
		setSprite("powerup_balls.png");
	}
	
	public void onCollect() {
		Ball ball1 = new Ball(game);
		Ball ball2 = new Ball(game);
		ball1.start();
		ball2.start();
		
		ArrayList<Ball> balls = game.getBalls();
		
		for(Ball ball : balls) {
			if(ball.isActive()) {
				ball1.setPos(ball.getPos());
				ball2.setPos(ball.getPos());
			}
		}
		
		balls.add(ball1);
		balls.add(ball2);
		game.setBalls(balls);
	}
	
	

}
