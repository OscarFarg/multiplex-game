package multiplex.spelementen;

import java.util.ArrayList;

import multiplex.spelementen.interfaces.KanVallen;

public class ValChecker extends Thread {

	private KanVallen element;

	private boolean firstrun = true;
	private boolean running = true;

	/*
	public ValChecker(Level level)
	{
		currentLevel = level;
	}*/

	public ValChecker(KanVallen element) {
		this.element = element;
	}

	public void stopThread()
	{
		running = false;
	}

	public void run() {
		while (running && !element.isOpBodem())
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
			interrupt();
	}

}