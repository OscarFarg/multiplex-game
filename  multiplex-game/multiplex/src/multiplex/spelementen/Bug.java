package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import multiplex.level.Level;
import multiplex.spelementen.interfaces.IsEetbaar;

public class Bug extends Vijand implements ActionListener, IsEetbaar {

	private int actieTeller;
	private Timer randomTimer;
	private int randomTeller; 
	private int randomDelay = new Random().nextInt(4) + 1;

	public Bug(Level level) {
		super(level);
		this.setAfbeelding(createImageIcon("images/bug.png"));
		actieTimer = new Timer(100, this);
		randomTimer = new Timer(1000, this);
		randomTimer.start();

	}

	public void tekenAfbeelding(Graphics g)
	{
		if (ontplof)
		{
			super.tekenAfbeelding(g);
		}
		else
		{
			Image im = this.getAfbeelding().getImage();
			int clipX = actieTeller * 32;
			g.drawImage(im, 0, 0, getWidth(), getHeight(), clipX, 0, clipX + 32, 32, this);
		}

	}

	public void collision()
	{
		if (!isEetbaar())
			super.collision();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!paused)
		{			
			if (e.getSource() == randomTimer)
			{
				randomTeller++;
				if (randomTeller == randomDelay)
				{
					randomDelay = new Random().nextInt(4) + 1;
					randomTeller = 0;
					randomTimer.stop();
					actieTimer.start();
				}
			}
			if (e.getSource() == actieTimer)
			{
				actieTeller = ( actieTeller + 1 ) % 6;
				repaint();
				if (actieTeller == 5)
				{
					actieTimer.stop();
					randomTimer.start();
				}
			}
		}
	}

	public void restart()
	{
		super.restart();
		actieTimer = new Timer(100, this);
		randomTimer = new Timer(1000, this);
		randomTimer.start();
		
	}
	public boolean isEetbaar()
	{
		if (!actieTimer.isRunning())
			return true;
		else

			return false;
	}

	public void ontplof()
	{
		if (!paused)
		{
			randomTimer.stop();
			actieTimer.stop();
			super.ontplof();

		}
	}
	
	@Override
	public void eet() {
		if (isEetbaar())
		{
			currentLevel.removeElement(this);
			collisionChecker.stopThread();
		}
		else
			collision();
	}
}
