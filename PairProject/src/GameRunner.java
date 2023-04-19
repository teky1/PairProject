import javax.swing.JPanel;

public class GameRunner {
	private JPanel panel;
	
	public GameRunner() {
		panel = new GamePanel(new Game(), this);
		MainScreen mainScreen = new MainScreen();
	}
	
	public static void main(String[] args) {
		GameRunner game = new GameRunner();
	}
}
