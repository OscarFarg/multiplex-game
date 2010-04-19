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
		this.setLocation(0,0);
		this.setSize(646, 410);
		levelPanel = new LevelPanel(appPanel);
		currentLevel = levelPanel.getCurrentLevel();
		levelDataPanel = new LevelDataPanel(currentLevel);
		this.add(levelPanel);
		levelDataPanel.setBounds(0, 362, 644, 48);
		this.add(levelDataPanel);
	}
	
	public void startGame()
	{
		levelPanel.startGame();
	}
	
	public void endGame()
	{
		levelPanel.endGame();
	}

	public LevelDataPanel getLevelDataPanel() {
		return levelDataPanel;
	}
	

}
