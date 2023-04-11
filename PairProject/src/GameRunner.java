import javax.swing.JPanel;

public class GameRunner {
	private JPanel panel;
	
	public GameRunner() {
		panel = new GamePanel(new Game(), this);
		
	}
	
	public static void main(String[] args) {
		GameRunner game = new GameRunner();
		System.out.println("yo");
		System.out.println("joel2");
		System.out.println("dia2");
		System.out.println("mard2");
		
		
	}
}
