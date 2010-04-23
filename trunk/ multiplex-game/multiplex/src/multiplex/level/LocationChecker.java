package multiplex.level;

import multiplex.spelementen.Murphy;

public class LocationChecker {
	private Level currentLevel;
	private Murphy murphy;

	public LocationChecker(Level level, Murphy murphy)
	{
		this.currentLevel = level;
		this.murphy = murphy;
	}

	public void moveX()
	{
		int murphyX = murphy.getLocation().x;

		if (murphyX > 640)
		{
			System.out.println(currentLevel.getLocation().x);
			currentLevel.setLocation((-1 * murphyX)  + 323, currentLevel.getY());
		}
	}


	public void moveY()
	{
		int murphyY = murphy.getLocation().y;

		if (murphyY > 400)
		{
			currentLevel.setLocation(currentLevel.getY(), (-1 * murphyY) + 181);
		}
		currentLevel.repaint();
	}

	public void moveLevel()
	{

	}
}
