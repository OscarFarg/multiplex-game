package multiplex.gui;

import java.awt.Color;
import javax.swing.JPanel;
import multiplex.level.Level;

public class GamePlayPanel extends JPanel {
	
	private MultiplexApp app;
	private Level currentLevel;
	
	public GamePlayPanel(MultiplexApp app)
	{
		this.app = app;
		this.setLayout(null);
		currentLevel = new Level();
		this.add(currentLevel);
	}

}
