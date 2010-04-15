package multiplex.spelementen;

import java.util.ArrayList;

import multiplex.level.Level;

public class ValChecker extends Thread {

	private Level currentLevel;

	public ValChecker(Level level)
	{
		currentLevel = level;
	}

	public void start()
	{
		super.start();
	}

	public void run() {
		while (currentLevel.getVallenList().size() > 0)
		{
			ArrayList<KanVallen> vallenList = currentLevel.getVallenList();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				for (int i = 0; i < vallenList.size(); i++)
				{
					vallenList.get(i).val();
				}
			}

		}
	}

}
