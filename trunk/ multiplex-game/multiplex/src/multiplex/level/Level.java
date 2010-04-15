package multiplex.level;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;
import multiplex.spelementen.*;

public class Level extends JPanel {

	private Murphy murphy;
	private ArrayList<SpelElement> elementList = new ArrayList<SpelElement>();
	private ArrayList<Vijand> vijandList = new ArrayList<Vijand>();
	private ArrayList<IsEetbaar> eetbaarList = new ArrayList<IsEetbaar>();
	private int levelWidth, levelHeight; //hoogte van het level. in vakjes, niet pixels.
	private int level1[][];

	public Level()
	{
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.createFirstLevel();
		this.showLevel();
	}

	public Murphy getMurphy() {
		return murphy;
	}

	public void setMurphy(Murphy murphy) {
		this.murphy = murphy;
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
		level1 = new int[][] {
				{8, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 2, 3, 3, 1, 2, 1, 1, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1},
				{1, 1, 1, 3, 1, 1, 1, 1, 3, 1, 2, 1, 1, 3, 2, 1, 3, 2, 1, 1},
				{1, 1, 1, 1, 1, 2, 2, 3, 1, 1, 1, 3, 1, 1, 2, 2, 2, 2, 1, 1},
				{1, 3, 2, 1, 1, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 9},
		};
	}

	public int getLevelHeight() {
		return levelHeight;
	}

	public void setLevelHeight(int levelHeight) {
		this.levelHeight = levelHeight;
	}

	public boolean isEetbaar(SpelElement element)
	{
		for (int i = 0; i < eetbaarList.size(); i ++)
		{
			if (element == (SpelElement) eetbaarList.get(i))
				return true;
		}
		return false;
	}
	
	public void addElement(SpelElement element, Point location)
	{
		elementList.add(element);
		element.setLocation(location);
		if (element == murphy)
			this.add(element, 0);
		else
			if (element instanceof IsEetbaar)
			{
				IsEetbaar eetbaar = (IsEetbaar) element;
				eetbaarList.add(eetbaar);
			}
		this.add(element);
	}

	public void showLaadDialog()
	{

	}

	public void showLevel()
	{
		for (int i = 0; i < level1.length; i++)
			for (int j = 0; j < level1[i].length; j++)
			{
				Point location = new Point(j* 32, i * 32);
				switch (level1[i][j])
				{
				case 0: addElement(new Muur(this), location); break; //muur toevoegen
				case 1: addElement(new Base(this), location); break; //base toevoegen
				case 2: addElement(new Zonk(this), location); break; //Zonk toevoegen
				case 3: addElement(new Infotron(this), location); break; //infotron
				case 8: addElement(new Exit(this), location); break; //exit
				case 9: addElement(murphy = new Murphy(this), location); break; //murphy
				}
			}
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
		if (location.x >= 0 && location.y >= 0)
		{
			for (int i = 0; i < elementList.size(); i++)
			{
				Point elementLocation = elementList.get(i).getLocation();

				if ((elementLocation.y == location.y) && (elementLocation.x == location.x))
				{
					return elementList.get(i);
				}
			}
		}
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
