import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel implements MouseMotionListener, MouseListener{
	
	// Represent the respective instances of game and game runner
	private Game game;
	private GameRunner gameRunner;
	
	// 
	private int width;
	private int height;
	
	// Inititialize stfuf and setup listeners
	public GamePanel(Game game, GameRunner gameRunner) {
		this.game = game;
		this.gameRunner = gameRunner;
		this.width = 500;
		this.height = 500;
		
		addMouse
	}
	
	/* Gets the current mouse position relative to the top left
	 * corner of the JPanel
	 */
	public 
	
	public void paintComponent(Graphics g) {
		
	}
}
