import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel {
	
	// Represent the respective instances of game and game runner
	private Game game;
	private GameRunner gameRunner;
	
	// 
	private int width;
	private int height;
	
	//Inititialize  stfuf and setup listeners
	public GamePanel(Game game, GameRunner gameRunner) {
		this.game = game;
		this.gameRunner = gameRunner;
		this.width = 600;
		this.height = 600;
	}
	
	/* Gets the current mouse position relative to the top left
	 * corner of the JPanel
	 */
	public Point getMousePosition() {
		PointerInfo mouseInfo = MouseInfo.getPointerInfo();
		Point mousePos = mouseInfo.getLocation();
		
		SwingUtilities.convertPointFromScreen(mousePos, this);
		
		return mousePos;
	}
	
	public void renderFrame() {
		repaint();
	}
	
	public void paintComponent(Graphics graphics) {
		
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		
		
		
		
		
	}

}
