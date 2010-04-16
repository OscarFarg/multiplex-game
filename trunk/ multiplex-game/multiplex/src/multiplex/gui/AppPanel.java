package multiplex.gui;

import javax.swing.JPanel;

import multiplex.gui.game.GamePlayPanel;
import multiplex.gui.main.MainPanel;

public class AppPanel extends JPanel {
	
	private MainPanel mainPanel = new MainPanel();
	private GamePlayPanel gamePanel = new GamePlayPanel(this);
	
	public AppPanel()
	{
		this.setLayout(null);
		gamePanel.setLocation(0,0);
		gamePanel.setSize(646, 428);
		mainPanel.setBounds(0, 0, 646, 428);
		this.add(gamePanel);
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
