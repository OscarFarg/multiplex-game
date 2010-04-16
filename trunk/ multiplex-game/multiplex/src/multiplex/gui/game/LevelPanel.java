package multiplex.gui.game;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import multiplex.gui.AppPanel;
import multiplex.gui.MultiplexApp;
import multiplex.level.Level;

public class LevelPanel extends JPanel {
	
	private Level currentLevel;
	
	public LevelPanel(AppPanel appPanel)
	{
		this.setLayout(null);
		this.currentLevel = new Level(appPanel);
		this.setSize(currentLevel.getWidth() + 10, currentLevel.getHeight() + 10);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		currentLevel.setLocation(5, 5);
		this.add(currentLevel);
		
	}
}
