package multiplex.gui.game;

import javax.swing.JPanel;

import multiplex.gui.AppPanel;
import multiplex.gui.MultiplexApp;
import multiplex.level.Level;

public class GamePlayPanel extends JPanel {
	
	private AppPanel appPanel;
	private Level currentLevel;
	private LevelPanel levelPanel;
	private LevelDataPanel levelDataPanel;
	
	public GamePlayPanel(AppPanel appPanel)
	{
		this.appPanel = appPanel;
		this.setLayout(null);
		levelPanel = new LevelPanel(appPanel);
		levelDataPanel = new LevelDataPanel(currentLevel);
		this.add(levelPanel);
		//levelDataPanel.setLocation(0, 362);
		levelDataPanel.setBounds(0, 362, 644, 48);
		this.add(levelDataPanel);
	}

}
