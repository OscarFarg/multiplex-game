package multiplex.gui.editor;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import multiplex.level.LevelMap;

public class LevelPanel extends JPanel {

	private LevelMap levelMap;
	private ArrayList<ElementLabel> elementList = new ArrayList<ElementLabel>();
	public LevelPanel()
	{
		this.setLayout(null);
		levelMap = new LevelMap(12,10);

		addLabels();

	}

	public void addLabels()
	{
		this.removeAll();
		elementList = new ArrayList<ElementLabel>();
		
		

		for (int i = 0; i < levelMap.getLevelWidth() ; i++)
			for (int j = 0; j < levelMap.getLevelHeight(); j++)
			{
				ElementLabel elementLabel = new ElementLabel(i, j);
				elementLabel.setText("" + levelMap.getLevel()[i][j]);
				elementList.add(elementLabel);
				add(elementLabel);
				
			}
		revalidate();
	}

	public void createLevelMap()
	{
		int[][] level = levelMap.getLevel();
		for (int i = 0; i < elementList.size(); i++)
		{
			int x = elementList.get(i).x;
			int y = elementList.get(i).y;
			int waarde = Integer.parseInt(elementList.get(i).getText());
			levelMap.setElements(x, y, waarde);
		}
	}
	
	public LevelMap getLevelMap() {
		return levelMap;
	}

	public void setLevelMap(LevelMap levelMap) {
		this.levelMap = levelMap;
	}

}
