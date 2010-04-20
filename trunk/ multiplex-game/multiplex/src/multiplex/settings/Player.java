package multiplex.settings;

import java.io.Serializable;
import java.util.ArrayList;

import multiplex.level.Level;

public class Player implements Serializable {
	
	private String name;
	private int playTime;
	
	//private ArrayList<Level> levelList;
	private ArrayList<Level> skippedLevels;
	private int currentLevel;
	
	public Player(String name)
	{
		//this.settings = settings;
		this.name = name;
		//this.levelList = settings.getLevelList();
		this.skippedLevels = new ArrayList<Level>();
		this.currentLevel = 0; 
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


	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}


	public int getCurrentLevel() {
		return currentLevel;
	}
}
