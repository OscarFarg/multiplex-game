package multiplex.spelementen;

import multiplex.level.Level;

public class Vijand extends DynamischObject
{
	private CollisionChecker collisionChecker;
	
	public Vijand(Level level)
	{
		super(level);
		collisionChecker = new CollisionChecker(this, level.getMurphy());
		collisionChecker.start();
	}
	
	public void collision()
	{
		currentLevel.removeElement(this);
	}	
}
