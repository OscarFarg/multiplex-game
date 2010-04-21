package multiplex.spelementen;

import multiplex.level.Level;

public class Vijand extends DynamischObject
{
	transient private CollisionChecker collisionChecker;
	
	public Vijand(Level level)
	{
		super(level);
		collisionChecker = new CollisionChecker(this, currentLevel.getMurphy());
		collisionChecker.start();
	}
	
	public void collision()
	{
		currentLevel.removeElement(this);
		collisionChecker.stopThread();
		currentLevel.getMurphy().ontplof();
	}
	
	public void restart()
	{
		collisionChecker = new CollisionChecker(this, currentLevel.getMurphy());
		collisionChecker.start();
	}
}
