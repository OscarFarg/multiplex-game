package multiplex.settings;

import java.io.Serializable;
import java.util.ArrayList;

import multiplex.level.Level;

public class Player implements Serializable {
	
	private String name;
	private int playTime;
	
	private ArrayList<Level> levelList;
	private ArrayList<Level> skippedLevels;
	private Level currentLevel;
	private Settings settings;
	
	public Player(String name, Settings settings)
	{
		this.settings = settings;
		this.name = name;
		this.levelList = settings.getLevelList();
		this.skippedLevels = new ArrayList<Level>();
		Level l = new Level();
		l.setLevelId(1);
		this.currentLevel = l; 
	}
	
	
	public ArrayList<Level> getSkippedLevels()
	{
		return skippedLevels;
	}
	
	public void skipLevel(Level level)
	{
		if (skippedLevels.size() < 3)
		{
			skippedLevels.add(level);
		}
	}


	public int getPlayTime() {
		return playTime;
	}


	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}


	public String getName() {
		return name;
	}


	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}


	public Level getCurrentLevel() {
		return currentLevel;
	}
}
