package multiplex.gui.game;

import javax.swing.JPanel;
import multiplex.gui.AppPanel;

public class GamePlayPanel extends JPanel {
	
	@SuppressWarnings("unused")
	private AppPanel appPanel; //word wel gebruikt. Eclipse spaced em.
	private LevelPanel levelPanel;
	private LevelDataPanel levelDataPanel;
	
	public GamePlayPanel(AppPanel appPanel)
	{
		this.appPanel = appPanel;
		this.setLayout(null);
		this.setLocation(0,0);
		this.setSize(646, 410);
		//this.setSize(600, 410);
		levelPanel = new LevelPanel(appPanel);
		levelPanel.setBounds(0, 0, 640, 352);
		this.add(levelPanel, 0);
		levelDataPanel = new LevelDataPanel();
		levelDataPanel.setBounds(0, 352, 640, 48);
		this.add(levelDataPanel, 1);
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

	public LevelPanel getLevelPanel() {
		return levelPanel;
	}
}
