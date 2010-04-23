package multiplex.level;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import multiplex.gui.AppPanel;
import multiplex.spelementen.*;
import multiplex.spelementen.interfaces.IsEetbaar;

public class Level extends JPanel {

	private Murphy murphy;
	private Exit exit;
	private AppPanel appPanel;
	private String levelName;
	
	private int levelId;

	private ArrayList<SpelElement> elementList = new ArrayList<SpelElement>();

	private LevelMap levelMap;

	private int levelWidth, levelHeight; //hoogte van het level. in vakjes, niet pixels.
	private int aantalInfotrons;
	private boolean paused;
	private boolean playing;

	public Level(AppPanel appPanel, LevelMap levelMap)
	{
		this.appPanel = appPanel;

		this.setBackground(Color.BLACK);
		this.setLayout(null);
		aantalInfotrons = 0;
		this.levelMap = levelMap;
		this.levelName = levelMap.getLevelName();
		this.setLevelWidth(levelMap.getLevelWidth());
		this.setLevelHeight(levelMap.getLevelHeight());
		this.setSize(getLevelWidth() * 32, getLevelHeight() * 32);


		AbstractAction pauseGame = new AbstractAction(){

			public void actionPerformed(ActionEvent e) {
				pauseGame();
			}
		};


		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("F2"), "pauseGame");

		this.getActionMap().put("pauseGame", pauseGame);

	}

	public AppPanel getAppPanel() {
		return appPanel;
	}

	public void setAppPanel(AppPanel appPanel) {
		this.appPanel = appPanel;
	}

	public void startLevel()
	{
		murphy = new Murphy(this);
		showLevel(levelMap.getLevel());
		murphy.setFocusable(true);
		murphy.requestFocus();

		setPlaying(true);
		resumeGame();
	}

	public void showLevel(int[][] level)
	{
		for (int i = 0; i < level.length; i++)
			for (int j = 0; j < level[i].length; j++)
			{
				Point location = new Point(i* 32, j * 32);
				switch (level[i][j])
				{
				case -1: break;													//-1: Lege plek
				case 0: addElement(new Muur(this), location); break; 			//0: Muur toevoegen
				case 1: addElement(new Base(this), location); break; 			//1: Base toevoegen
				case 2: addElement(new Zonk(this), location); break; 			//2: Zonk toevoegen
				case 3: addElement(new Infotron(this), location); aantalInfotrons++ ;break; 		//3: Infotron
				case 4: addElement(new Disk(this), location); break;			//4: Disk
				case 5: break;		//5: Port
				case 6: addElement(new SnikSnak(this), location); break;		//6: SnikSnak
				case 7: addElement(new Bug(this), location); break;				//7: Bug
				case 8: addElement(exit = new Exit(this), location); break; 	//8: Exit
				case 9: addElement(murphy, location); break; 					//9: murphy
				}
			}
	}

	public void addElement(SpelElement element, Point location)
	{
		elementList.add(element);
		element.setLocation(location);
		if (element == murphy)
			this.add(element, 0);

		this.add(element);
	}

	public void removeElement(SpelElement element)
	{
		this.remove(element);
		this.getElementList().remove(element);
		this.repaint();
		element = null;
	}

	public int getAantalInfotrons() {
		return aantalInfotrons;
	}

	public void setAantalInfotrons(int aantalInfotrons) {
		this.aantalInfotrons = aantalInfotrons;
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
		if (element instanceof IsEetbaar)
			return true;
		else
			return false;
	}

	public void verminderInfotron()
	{
		aantalInfotrons--;
	}

	public SpelElement getElement()
	{
		return null;

	}

	public SpelElement getElementAt(Point location, SpelElement element)
	{
		if (location.x >= 0 && location.y >= 0)
		{
			for (int i = 0; i < elementList.size(); i++)
			{
				Point elementLocation = elementList.get(i).getLocation();

				if ((elementLocation.y == location.y) && (elementLocation.x == location.x))
				{
					if (elementList.get(i) == exit)
						if (element == murphy)
							exit.doUitgespeeld();
					return elementList.get(i);
				}
			}
		}
		return null;
	}

	public void pauseGame()
	{
		if (paused)
		{
			resumeGame();
		}
		else
		{
			for (SpelElement e : elementList)
				e.setPaused(true);
			setPaused(true);
		}
	}


	public void resumeGame()
	{
		for (SpelElement e : elementList)
			e.setPaused(false);
		setPaused(false);
		murphy.requestFocus();
	}

	public void doUitgespeeld()
	{
		if(aantalInfotrons == 0)
		{
			eindeLevel();
		}
	}

	public void eindeLevel()
	{
		appPanel.remove(appPanel.getGamePanel());
		appPanel.getMainPanel().setVisible(true);
		appPanel.getGamePanel().endGame();
		appPanel.repaint();
		stopThreads();
		setPlaying(false);
	}

	public void stopThreads()
	{
		for (int i = 0; i < elementList.size(); i++)
		{
			try {
				Zonk zonk = (Zonk) elementList.get(i);
				zonk.stopValChecker();
			} catch (Exception e1)
			{
				try
				{
					Infotron infi = (Infotron) elementList.get(i);
					infi.stopValChecker();
				} catch (Exception e2) {}
			}
		}
	}


	public String getLevelName() {
		return levelName;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public int getLevelId() {
		return levelId;
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

}
