import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameRunner implements ActionListener {
	private Game game;
	private GamePanel gamePanel;
	private MainScreen menu;
	private Timer timer;
	private boolean started;
	
	private long lastFrame;
	private long timeStarted;
	
	
	public GameRunner() {
		game = new Game();
		gamePanel = new GamePanel(game, this);
//		menu = new MainScreen();
		
		started = false;	
	}
	
	public boolean getStarted() {
		return started;
	}
	
	public void startGameloop() {
    	started = true;
    	timeStarted = System.currentTimeMillis();
    	lastFrame = System.currentTimeMillis()%1000000;
    	timer = new Timer(1, this);
    	timer.setInitialDelay(0);
    	timer.start();
    }
	
	public void actionPerformed(ActionEvent e) {
		calculateFrame();
		gamePanel.renderFrame();
	}
	
	public void setupGameloop(){
	       
	       /*
	        * Include code that intiializes stuff in Game with relevent information
	        * 
	        * */
			game.loadLevel(0);
		
	       
	       GamePanel.startFrame(gamePanel);
	       lastFrame = System.currentTimeMillis()%1000000;
	       calculateFrame();
	       gamePanel.renderFrame();
	}
	
	public void calculateFrame() {
		
		Vector mousePos = new Vector(gamePanel.getMousePosition());
		Platform platform = game.getPlatform();
		platform.setPos(new Vector(mousePos.getX(), platform.getPos().getY()));
		
		long currTime = System.currentTimeMillis()%1000000;
    	double timeDelta = (double)(currTime - lastFrame)/1000.;
    	
    	game.getBall().update(timeDelta);
    	for(int i=0; i<game.getLevel().getAsteroids().size(); i++) {
    		game.getLevel().getAsteroids().get(i).update(timeDelta);
    	}
    	lastFrame = currTime;
	}
	
	
	
	public static void main(String[] args) {
		GameRunner game = new GameRunner();
		game.setupGameloop();
		game.startGameloop();
	}

}
