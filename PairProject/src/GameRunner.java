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
		menu = new MainScreen();
		
		started = false;	
	}
	
	public boolean getStarted() {
		return started;
	}
	
	public void startGameloop() {
    	started = true;
    	timeStarted = System.currentTimeMillis();
    	lastFrame = System.currentTimeMillis()%1000000;
    	timer = new Timer(20, this);
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
	       
	       GamePanel.startFrame(gamePanel);
	       lastFrame = System.currentTimeMillis()%1000000;
	       calculateFrame();
	       gamePanel.renderFrame();
	}
	
	public void calculateFrame() {
		
	}
	
	
	
	public static void main(String[] args) {
		GameRunner game = new GameRunner();
	}

}
