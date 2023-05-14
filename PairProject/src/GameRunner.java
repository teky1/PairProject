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

		maxLevel = 3;
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

	public void setupGameloop() {

		/*
		 * Include code that intiializes stuff in Game with relevent information
		 * 
		 */
		game.loadLevel(0);

		GamePanel.startFrame(gamePanel);
		lastFrame = System.currentTimeMillis() % 1000000;
		calculateFrame();
		gamePanel.renderFrame();
	}

	public void calculateFrame() {

		Vector mousePos = new Vector(gamePanel.getMousePosition());
		Platform platform = game.getPlatform();
		platform.setPos(new Vector(mousePos.getX(), platform.getPos().getY()));

		long currTime = System.currentTimeMillis() % 1000000;
		double timeDelta = (double) (currTime - lastFrame) / 1000.;

		boolean bricksActive = false;
		boolean ballsActive = false;

		ArrayList<Ball> balls = game.getBalls();
		for (Ball ball : balls) {
			platform.handleCollisions(ball);
			ball.update(timeDelta);

			if (ball.isActive()) {
				ballsActive = true;
			}

			for (Brick brick : game.getLevel().getBricks()) {
				brick.handleCollisions(ball);
				if (brick.isActive()) {
					bricksActive = true;
				}
			}
		}

		ArrayList<PowerUp> powerups = game.getPowerups();
		for (PowerUp powerup : powerups) {
			powerup.update(timeDelta);
		}

		if (!bricksActive) {
			game.reset();
			if (currentLevel > 0 && currentLevel < maxLevel) {
				currentLevel++;
				game.loadLevel(currentLevel);
			} else if (currentLevel == 0) {
				game.loadLevel(0);
			}
		}
		if (!ballsActive) {
			System.out.println("lose");
		}

		for (int i = 0; i < game.getLevel().getAsteroids().size(); i++) {
			game.getLevel().getAsteroids().get(i).update(timeDelta);
		}
		lastFrame = currTime;
	}

	public static void main(String[] args) {
		GameRunner game = new GameRunner();
//		game.setupGameloop();
//		game.startGameloop();
	}

}
