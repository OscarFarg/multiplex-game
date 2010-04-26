package multiplex.gui.editor;


import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import multiplex.level.LevelMap;

public class LevelPanel extends JPanel {

	private LevelMap levelMap;
	private ArrayList<ElementLabel> elementList = new ArrayList<ElementLabel>();
	
	public LevelPanel()
	{
		this.setLayout(null);
		levelMap = new LevelMap(21,11);
		addLabels();

	}

	public void addLabels()
	{
		this.removeAll();
		this.repaint();
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
		this.setPreferredSize(new Dimension(levelMap.getLevelWidth() * 25, levelMap.getLevelHeight() * 25));

	}

	public void createLevelMap()
	{
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
