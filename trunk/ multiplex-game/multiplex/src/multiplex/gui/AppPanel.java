package multiplex.gui;

import javax.swing.JPanel;

import multiplex.gui.game.GamePlayPanel;
import multiplex.gui.main.MainPanel;

public class AppPanel extends JPanel {
	
	private MainPanel mainPanel = new MainPanel(this);
	private GamePlayPanel gamePanel = new GamePlayPanel(this);
	
	public AppPanel()
	{
		this.setLayout(null);
		//this.add(gamePanel); //opstarten in level
		this.add(mainPanel); //opstarten in menu
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public GamePlayPanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePlayPanel gamePanel) {
		this.gamePanel = gamePanel;
	}
}
