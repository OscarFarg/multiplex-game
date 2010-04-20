package multiplex.gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import multiplex.gui.game.GamePlayPanel;
import multiplex.gui.main.MainPanel;

public class AppPanel extends JPanel {

	private MainPanel mainPanel = new MainPanel(this);
	private GamePlayPanel gamePanel = new GamePlayPanel(this);
	private Action showHelp;
	private Action testAction;


	public AppPanel()
	{
		this.setLayout(null);
		//this.add(gamePanel); //opstarten in level
		this.add(mainPanel); //opstarten in menu
		this.createAction();
		this.setFocusable(true);

		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "showHelp");
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F2"), "resumeGame");

		this.getActionMap().put("showHelp", showHelp);
		this.getActionMap().put("resumeGame", testAction);

	}

	public void createAction()
	{
		showHelp = new AbstractAction(){
			public void actionPerformed(ActionEvent e)
			{
				if (gamePanel.getLevelPanel().getCurrentLevel() != null && 
						gamePanel.getLevelPanel().getCurrentLevel().isPlaying())
				{
					if (gamePanel.getLevelPanel().getCurrentLevel().isPaused())
					{
						mainPanel.removeHelp();
						mainPanel.setVisible(false);
						gamePanel.setVisible(true);
						gamePanel.getLevelPanel().getCurrentLevel().getMurphy().requestFocus();
						gamePanel.getLevelPanel().getCurrentLevel().resumeGame();
					}
					else
					{
						gamePanel.getLevelPanel().getCurrentLevel().pauseGame();
						gamePanel.setVisible(false);
						mainPanel.setVisible(true);
						mainPanel.showHelp();
					}
				}
			}
		};
		testAction = new AbstractAction(){
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Ga verder");
				gamePanel.getLevelPanel().getCurrentLevel().resumeGame();
			}
		};
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
