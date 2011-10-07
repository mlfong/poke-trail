import javax.swing.JDialog;

/**
 * Runs the demo meeting requirements for M5
 * The idea is that a new game will create a GameInitObj to be 
 * processed into the game logic.
 * This is object will also be created to resume a parsed game save.
 * 
 */
public class M5Main {
	public static GameInitObj gameData = new GameInitObj();

	public static void main(String[] args) {
		try {
			Startup dialog = new Startup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
