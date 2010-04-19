package multiplex.level;

import java.util.ArrayList;

import multiplex.spelementen.interfaces.KanVallen;

public class ValChecker extends Thread {

	private Level currentLevel;
	private KanVallen element;

	private boolean firstrun = true;

	public ValChecker(Level level)
	{
		currentLevel = level;
	}

	public ValChecker(KanVallen element) {
		this.element = element;
	}

	public void run() {
		if (currentLevel == null)
		{
			while (!element.isOpBodem())
				try {
					if (firstrun)
					{
						firstrun = !firstrun;
						Thread.sleep(1000);
					}
					else
						Thread.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					element.val();
				}
		}
		else
		{
			while (currentLevel.getVallenList().size() > 0)
			{
				ArrayList<KanVallen> vallenList = currentLevel.getVallenList();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
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

}
