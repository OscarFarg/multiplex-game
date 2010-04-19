package multiplex.spelementen;

import multiplex.botsing.Botsing;
import multiplex.level.Level;
import multiplex.spelementen.interfaces.KanVallen;

public class CollisionChecker extends Thread {

	private Vijand vijand;
	private Murphy murphy;

	public CollisionChecker(Vijand vijand, Murphy murphy)
	{
		this.vijand = vijand;
		this.murphy = murphy;
	}

	public void run()
	{
		while (true)
		{
			try {
				Thread.sleep(100);
				if (Botsing.raakt(vijand, murphy))
				{
					vijand.collision();
					murphy.ontplof();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}
	}
}
