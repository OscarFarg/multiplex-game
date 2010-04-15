package multiplex.level;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;
import multiplex.spelementen.*;

public class Level extends JPanel {

	private Murphy player;
	private ArrayList<SpelElement> elementList = new ArrayList<SpelElement>();
	private ArrayList<Vijand> vijandList = new ArrayList<Vijand>();
	private int levelWidth, levelHeight; //hoogte van het level. in vakjes, niet pixels.
	
	public Level()
	{
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.createFirstLevel();
	}
	
	public int getLevelWidth() {
		return levelWidth;
	}

	public void setLevelWidth(int levelWidth) {
		this.levelWidth = levelWidth;
	}

	public void createFirstLevel()
	{
		this.setLevelWidth(20);
		this.setLevelHeight(6);
		int[][] level1 = new int[][] {
				{9, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 8},
				{1, 1, 2, 3, 3, 1, 2, 1, 1, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1},
				{1, 1, 1, 3, 1, 1, 1, 1, 3, 1, 2, 1, 1, 3, 2, 1, 3, 2, 1, 1},
				{1, 1, 1, 1, 1, 2, 2, 3, 1, 1, 1, 3, 1, 1, 2, 2, 2, 2, 1, 1},
				{1, 3, 2, 1, 1, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
				};
		
		for (int i = 0; i < level1.length; i++)
			for (int j = 0; j < level1[i].length; j++)
			{
				Point location = new Point(j* 32, i * 32);
				switch (level1[i][j])
				{
				case 0: addElement(new Muur(), location); break; //muur toevoegen
				case 1: addElement(new Base(), location); break; //base toevoegen
				case 2: addElement(new Zonk(), location); break; //Zonk toevoegen
				case 3: addElement(new Infotron(), location); break; //infotron
				case 8: addElement(new Exit(), location); break; //exit
				case 9: addElement(player = new Murphy(this), location); break; //murphy
				}
			}
		}
	
	public int getLevelHeight() {
		return levelHeight;
	}

	public void setLevelHeight(int levelHeight) {
		this.levelHeight = levelHeight;
	}

	public void addElement(SpelElement element, Point location)
	{
		element.setLocation(location);
		this.add(element);
	}
	
	public void showLaadDialog()
	{
		
	}
	
	public void showLevel()
	{
		
	}
	
	public void showLoadingError()
	{
		
	}
	
	public void startLevel()
	{
		
	}
	
	public SpelElement getElement()
	{
		return null;
		
	}
	
	public int getElementCount()
	{
		return 0;
		
	}
	
	public SpelElement getElementAt(Point location)
	{
		return null;
	}
	
	public void tekenSpelElement(int ElementNr)
	{
		
	}
	
	public void pauseGame()
	{
		
	}
	
	public void saveGame()
	{
		
	}
	
	public void resumeGame()
	{
		
	}
	
	public void doUitgespeeld()
	{
		
	}
	

}
