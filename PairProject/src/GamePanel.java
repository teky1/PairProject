import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel implements MouseMotionListener, MouseListener{
	private Game game;
	private GameRunner gameRunner;
	private int width;
	private int height;
	
	// Inititialize stfuf and setup listeners
	public GamePanel(Game game, GameRunner gameRunner) {
		this.game = game;
		this.gameRunner = gameRunner;
		this.width = 500;
		this.height = 500;
		this.addMouseMotionListener(new Clicker());
		this.addMouseListener(new Clicker());
	}
	
	/* Gets the current mouse position relative to the top left
	 * corner of the JPanel
	 */
	public 
	
	public void paintComponent(Graphics g) {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e) {
		
	}
	
	public void mouseMoved(MouseEvent e) {
		
	}
	
}
