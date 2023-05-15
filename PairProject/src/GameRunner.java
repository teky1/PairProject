import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameRunner implements ActionListener {
	private Game game;
	private GamePanel gamePanel;
	private MainScreen menu;
	private Timer timer;
	private boolean started;
	private int currentLevel;
	private int maxLevel;

	private long lastFrame;
	private long timeStarted;

	public GameRunner() {
		game = new Game();
		gamePanel = new GamePanel(game, this);
		menu = new MainScreen(this);

		maxLevel = 30;
		started = false;
	}

	public boolean getStarted() {
		return started;
	}

	public void start(boolean isRandom) {
		if (isRandom) {
			currentLevel = 0;
		} else {
			currentLevel = 1;
		}
		setupGameloop();
		startGameloop();
	}

	public void startGameloop() {
		started = true;
		timeStarted = System.currentTimeMillis();
		lastFrame = System.currentTimeMillis() % 1000000;
		timer = new Timer(1, this);
		timer.setInitialDelay(0);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		calculateFrame();
		gamePanel.renderFrame();
	}
	
	public void setupGameloop(){
		game.loadLevel(currentLevel);

		GamePanel.startFrame(gamePanel);
		lastFrame = System.currentTimeMillis()%1000000;
		calculateFrame();
		gamePanel.renderFrame();
	}

	public void calculateFrame() {

		Vector mousePos = new Vector(gamePanel.getMousePosition());
		Platform platform = game.getPlatform();
		
		double platformPos = mousePos.getX();
		if(mousePos.getX() < 13*3 + platform.getDimX()/2) {
			platformPos = 13*3 + platform.getDimX()/2;
		} else if(mousePos.getX() > (185*3 - platform.getDimX()/2)) {
			platformPos = 185*3 - platform.getDimX()/2;
		}
		
		platform.setPos(new Vector(platformPos, platform.getPos().getY()));

	    boolean bricksActive = false;
	    boolean ballsActive = false;
	    boolean asteroidsActive = false;
		long currTime = System.currentTimeMillis() % 1000000;
		double timeDelta = (double) (currTime - lastFrame) / 1000.;

		ArrayList<Ball> balls = game.getBalls();
		for (Ball ball : balls) {
			platform.handleCollisions(ball);
			ball.update(timeDelta);

			if (ball.isActive()) {
				ballsActive = true;
			}

			for (Brick brick : game.getLevel().getBricks()) {
				if(brick.isActive()) {
					brick.handleCollisions(ball);
					bricksActive = true;
				}
			}
			
			for(Asteroid a : game.getLevel().getAsteroids()) {
				if(a.isActive()) {
					asteroidsActive = true;
				}
			}
		}
		
		for(Brick brick : game.getLevel().getBricks()) {
			for (Asteroid a : game.getLevel().getAsteroids()) {
				if(a.isActive() && brick.isActive()) {
					brick.handleCollisions(a);
				}
				
			}
		}

		ArrayList<PowerUp> powerups = game.getPowerups();
		for (PowerUp powerup : powerups) {
			powerup.update(timeDelta);
		}
		
		if(!bricksActive && !asteroidsActive) {
			game.reset();
			if (currentLevel > 0 && currentLevel < maxLevel) {
				currentLevel++;
				game.loadLevel(currentLevel);
			} else if (currentLevel == 0) {
				game.loadLevel(0);
			} else {
				timer.stop();
				gamePanel.close();
				new GameOver(true, this, game.getLives(), currentLevel);
			}
		}
		if (!ballsActive) {
			if(game.getLives()>1) {
				game.setLives(game.getLives()-1);
				ArrayList<Ball> b = game.getBalls();
				b.add(new Ball(game));
				game.setBalls(b);
			} else {
				timer.stop();
				gamePanel.close();
				new GameOver(false, this, game.getLives(), currentLevel);
			}
			
		}

		for (int i = 0; i < game.getLevel().getAsteroids().size(); i++) {
			game.getLevel().getAsteroids().get(i).update(timeDelta);
		}
		lastFrame = currTime;
	}
	

	public static void main(String[] args) {
		GameRunner game = new GameRunner();
	}

}
