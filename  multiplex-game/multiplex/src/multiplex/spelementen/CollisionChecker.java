package multiplex.spelementen;

import multiplex.botsing.Botsing;

public class CollisionChecker extends Thread {

	private Vijand vijand;
	private Murphy murphy;
	private boolean alive = false;

	public CollisionChecker(Vijand vijand, Murphy murphy)
	{
		this.vijand = vijand;
		this.murphy = murphy;
	}

	public void stopThread()
	{
		alive = false;
	}
	
	public void run()
	{
		while (alive)
		{
			try {
				Thread.sleep(100);
				if (Botsing.raakt(vijand, murphy))
				{
					vijand.collision();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		interrupt();
	}
}
