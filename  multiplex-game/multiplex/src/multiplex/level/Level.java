package multiplex.level;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import multiplex.gui.AppPanel;
import multiplex.gui.MultiplexApp;
import multiplex.spelementen.*;
import multiplex.spelementen.interfaces.IsDuwbaar;
import multiplex.spelementen.interfaces.IsEetbaar;
import multiplex.spelementen.interfaces.KanVallen;

public class Level extends JPanel {

	private Murphy murphy;
	private Exit exit;
	private AppPanel appPanel;

	private ArrayList<SpelElement> elementList = new ArrayList<SpelElement>();
	private ArrayList<Vijand> vijandList = new ArrayList<Vijand>();
	private ArrayList<IsEetbaar> eetbaarList = new ArrayList<IsEetbaar>();
	private ArrayList<KanVallen> vallenList = new ArrayList<KanVallen>();
	private ArrayList<IsDuwbaar> duwerList = new ArrayList<IsDuwbaar>();

	private ValChecker valChecker = new ValChecker(this);
	private int levelWidth, levelHeight; //hoogte van het level. in vakjes, niet pixels.

	public Level(AppPanel appPanel)
	{
		this.appPanel = appPanel;
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.showLevel(createFirstLevel()); 
	}
	
	public int[][] createFirstLevel()
	{
		this.setLevelWidth(40);
		this.setLevelHeight(11);
		this.setSize(getLevelWidth() * 32, getLevelHeight() * 32);
		return new int[][] {
				{8, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
				{1, 1, 6, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, -1, 9, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1}
		};
	}

	public void addElement(SpelElement element, Point location)
	{
		elementList.add(element);
		element.setLocation(location);
		if (element == murphy)
			this.add(element, 0);
		else
		{
			if (element instanceof IsEetbaar) {
				IsEetbaar eetbaar = (IsEetbaar) element;
				eetbaarList.add(eetbaar);
			} 
			if (element instanceof KanVallen) {
				KanVallen valler = (KanVallen) element;
				vallenList.add(valler);
			} 
			if (element instanceof IsDuwbaar) {
				IsDuwbaar duwbaar = (IsDuwbaar) element;
				duwerList.add(duwbaar);
			}
		}

		this.add(element);
	}

	public void removeElement(SpelElement element)
	{
		this.remove(element);
		this.getElementList().remove(element);
		this.repaint();
	}
	public void showLevel(int[][] level)
	{
		for (int i = 0; i < level.length; i++)
			for (int j = 0; j < level[i].length; j++)
			{
				Point location = new Point(j* 32, i * 32);
				switch (level[i][j])
				{
				case -1: break;													//-1: Lege plek
				case 0: addElement(new Muur(this), location); break; 			//0: Muur toevoegen
				case 1: addElement(new Base(this), location); break; 			//1: Base toevoegen
				case 2: addElement(new Zonk(this), location); break; 			//2: Zonk toevoegen
				case 3: addElement(new Infotron(this), location); break; 		//3: Infotron
				case 4: addElement(new Disk(this), location); break;			//4: Disk
				case 5: break;		//5: Port
				case 6: addElement(new SnikSnak(this), location); break;		//6: SnikSnak
				case 7: addElement(new Bug(this), location); break;				//7: Bug
				case 8: addElement(exit = new Exit(this), location); break; 	//8: Exit
				case 9: addElement(murphy = new Murphy(this), location); break; //9: murphy
				}
			}


		if (murphy.getxPos() > 640)
		{
			if ((this.getLevelWidth()*32)- 640 < murphy.getxPos())
			{
				System.out.println("helemaal rechts");
				this.setLocation(620 - (this.getLevelWidth()*32), this.getY());
			}
			else
				this.setLocation(this.getX() - (murphy.getxPos() - 320), this.getY());
		}
	}

	public Murphy getMurphy() {
		return murphy;
	}

	public void setMurphy(Murphy murphy) {
		this.murphy = murphy;
	}

	public ArrayList<SpelElement> getElementList() {
		return elementList;
	}

	public void setElementList(ArrayList<SpelElement> elementList) {
		this.elementList = elementList;
	}

	public ArrayList<Vijand> getVijandList() {
		return vijandList;
	}

	public void setVijandList(ArrayList<Vijand> vijandList) {
		this.vijandList = vijandList;
	}

	public ArrayList<IsEetbaar> getEetbaarList() {
		return eetbaarList;
	}

	public void setEetbaarList(ArrayList<IsEetbaar> eetbaarList) {
		this.eetbaarList = eetbaarList;
	}

	public int getLevelWidth() {
		return levelWidth;
	}

	public void setLevelWidth(int levelWidth) {
		this.levelWidth = levelWidth;
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


	public void showLaadDialog()
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
		if (location.x >= 0 && location.y >= 0)
		{
			for (int i = 0; i < elementList.size(); i++)
			{
				Point elementLocation = elementList.get(i).getLocation();

				if ((elementLocation.y == location.y) && (elementLocation.x == location.x))
				{
					if (elementList.get(i) == exit)
						exit.eindeLevel();
					return elementList.get(i);
				}
			}
		}
		return null;
	}

	public ArrayList<KanVallen> getVallenList() {
		return vallenList;
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
		appPanel.remove(appPanel.getGamePanel());
		appPanel.add(appPanel.getMainPanel());
		appPanel.repaint();
	}

	public void eindeLevel()
	{
		appPanel.remove(appPanel.getGamePanel());
		appPanel.add(appPanel.getMainPanel());
		appPanel.repaint();
	}

}
