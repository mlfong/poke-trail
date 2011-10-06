import javax.swing.JDialog;


public class M5Main {
	public static GameInitObj gameData = new GameInitObj();
	/**
	 * @param args
	 */
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
