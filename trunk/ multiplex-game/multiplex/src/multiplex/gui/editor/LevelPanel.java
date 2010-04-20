package multiplex.gui.editor;

import java.util.ArrayList;
import javax.swing.JPanel;

import multiplex.level.LevelMap;

public class LevelPanel extends JPanel {

	private LevelMap levelMap;
	private ArrayList<ElementLabel> elementList = new ArrayList<ElementLabel>();
	public LevelPanel()
	{
		this.setLayout(null);
		levelMap = new LevelMap(19,11);

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
	}

	public void createLevelMap()
	{
		//int[][] level = levelMap.getLevel();
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
