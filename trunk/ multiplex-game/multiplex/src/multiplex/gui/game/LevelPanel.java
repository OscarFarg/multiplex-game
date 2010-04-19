package multiplex.gui.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

import multiplex.gui.AppPanel;
import multiplex.gui.MultiplexApp;
import multiplex.level.Level;

public class LevelPanel extends JPanel implements ActionListener {
	
	private Level currentLevel;
	private AppPanel appPanel;
	private Timer updateDataPanelTimer;
	
	public LevelPanel(AppPanel appPanel)
	{
		this.appPanel = appPanel;
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		updateDataPanelTimer = new Timer(250, this);
	}
	
	public void startGame()
	{
		this.currentLevel = new Level(appPanel);
		this.setSize(currentLevel.getWidth() + 10, currentLevel.getHeight() + 10);
		currentLevel.setLocation(5, 5);
		this.add(currentLevel);
		currentLevel.startLevel();
		updateDataPanelTimer.start();
	}
	
	public void endGame()
	{
		this.remove(currentLevel);
		updateDataPanelTimer.stop();
	}
	
	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		appPanel.getGamePanel().getLevelDataPanel().setInfotronCount(currentLevel.getAantalInfotrons());
	}
}
