package multiplex.gui.game;

import javax.swing.JPanel;
import multiplex.gui.AppPanel;

public class GamePlayPanel extends JPanel {
	
	@SuppressWarnings("unused")
	private AppPanel appPanel; //word wel gebruikt. Eclipse spaced em.
	//private Level currentLevel;
	private LevelPanel levelPanel;
	private LevelDataPanel levelDataPanel;
	
	public GamePlayPanel(AppPanel appPanel)
	{
		this.appPanel = appPanel;
		this.setLayout(null);
		this.setLocation(0,0);
		this.setSize(646, 410);
		levelPanel = new LevelPanel(appPanel);
		//currentLevel = levelPanel.getCurrentLevel();
		levelDataPanel = new LevelDataPanel();
		this.add(levelPanel);
		levelDataPanel.setBounds(0, 362, 644, 48);
		this.add(levelDataPanel, 0);
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
