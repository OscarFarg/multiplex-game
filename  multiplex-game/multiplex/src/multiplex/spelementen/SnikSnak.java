package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.*;

import multiplex.level.Level;
import multiplex.botsing.Botsing;

public class SnikSnak extends Vijand implements ActionListener, Runnable
{
	private int richting = 3;
	private final int DELAY = 250;

	public SnikSnak(Level level)
	{
		super(level);
		this.setAfbeelding(createImageIcon("images/SnikSnaks.png"));

		System.out.println("kaas");

		this.setLocation(xPos, yPos);
		Thread thread = new Thread(this);
		thread.start();
	}

	public void setLocation(int x, int y)
	{
		super.setLocation(x, y);
		this.setxPos(x);
		this.setyPos(y);
	}

	public void setLocation(Point p)
	{

		super.setLocation(p);
		this.setxPos(p.x);
		this.setyPos(p.y);

	}

	public void beweeg(int richting)
	{
		switch (richting)
		{
		case 0:
			this.setyPos(yPos - 32);
			break;
		case 2:
			this.setyPos(yPos + 32);
			break;
		case 3:
			this.setxPos(xPos - 32);
			break;
		case 1:
			this.setxPos(xPos + 32);
			break;
		}
		this.setLocation(xPos, yPos);
	}

	public void tekenAfbeelding(Graphics g)
	{
		Image im = getAfbeelding().getImage();

		switch (richting)
		{
		case 0:
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 350, 61, 382, 93, this);
			break;
		case 2: 
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 412, 63, 444, 95, this);
			break;
		case 3:
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 382, 61, 414, 93, this);
			break;
		case 1: 
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 446, 64, 478, 96, this);
			break;
		}
	}

	public boolean checkRichting(int richting)
	{
		SpelElement element = null;
		switch (richting)
		{
		case 0: 
			element = currentLevel.getElementAt(new Point(getxPos(), getyPos() - 32)); break;
		case 2: 
			element = currentLevel.getElementAt(new Point(getxPos(), getyPos() + 32)); break;
		case 3: 
			element = currentLevel.getElementAt(new Point(getxPos() - 32, getyPos())); break;
		case 1: 
			element = currentLevel.getElementAt(new Point(getxPos() + 32, getyPos())); break;
		}

		if (element != null)
		{
			if (!Botsing.raakt(this, element))
			{
				return true;
			}
			else
				return false;
		}
		return true;
	}

	public void run() 
	{		
		while (true)
		{


			while( !checkRichting((richting + 3) % 4) ) // zolang links vol zit
			{
				// ga rechtdoor
				beweeg(richting);
				repaint();
				try {
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if( !checkRichting(richting) ) // als rechtdoor vol zit
				{
					// ga rechts
					richting = (richting + 1) % 4; //verander de richting naar rechts
					repaint();
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					beweeg(richting);
					repaint();

					if( !checkRichting((richting + 1) % 4) ) // als rechts vol zit
					{
						// ga terug
						richting = (richting + 2) % 4;
						repaint();
						try {
							Thread.sleep(DELAY);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("twee");
						beweeg(richting);
						repaint();
					}
					else
					{
						richting =(richting + 3) % 4;
						repaint();
						try {
							Thread.sleep(DELAY);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						repaint();
						System.out.println("");
					}
				}
			}
			while( checkRichting((richting + 3) % 4) ) // zolang links leeg is
			{	
				richting = (richting + 3) % 4;
				repaint();
				try {
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				beweeg(richting);
				repaint();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
