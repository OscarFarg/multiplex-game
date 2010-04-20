package multiplex.level;

import java.io.Serializable;

public class LevelMap implements Serializable {
	private int levelHeight;
	private int levelWidth;
	private String levelName;
	private int[][] level;
	
	public LevelMap(int width, int height)
	{
		setLevelWidth(width);
		setLevelHeight(height);
	}

	public LevelMap()
	{
		this.levelName = "Level";
	}
	
	public void setLevel(int[][] level) {
		this.level = level;
	}

	public int[][] getLevel() {
		return level;
	}

	public void setLevelWidth(int levelWidth) {
		this.levelWidth = levelWidth;
		setLevel(new int[levelWidth][levelHeight]);
	}

	public int getLevelWidth() {
		return levelWidth;
	}

	public void setLevelHeight(int levelHeight) {
		this.levelHeight = levelHeight;
		setLevel(new int[levelWidth][levelHeight]);
	}

	public int getLevelHeight() {
		return levelHeight;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public void setElements(int x, int y, int waarde)
	{
		level[x][y] = waarde;
	}
	public String getLevelName() {
		return levelName;
	}
	
}
