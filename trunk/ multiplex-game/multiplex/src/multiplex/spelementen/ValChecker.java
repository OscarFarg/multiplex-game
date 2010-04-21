package multiplex.spelementen;

import multiplex.spelementen.interfaces.KanVallen;

public class ValChecker extends Thread {

	private KanVallen element;

	private boolean running = true;

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
					Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
					element.val();
			}
			interrupt();
	}

}
