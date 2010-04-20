package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.*;

import multiplex.level.Level;
import multiplex.botsing.Botsing;

public class SnikSnak extends Vijand implements Runnable
{
	private int richting = 1;
	private final int DELAY = 200;

	public SnikSnak(Level level)
	{
		super(level);
		this.setAfbeelding(createImageIcon("images/SnikSnaks.png"));

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
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 95, 1, 127, 33, this);
			break;
		case 2: 
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 415, 0, 447, 32, this);
			break;
		case 3:
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 304, 32, 336, 64, this);
			break;
		case 1: 
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 2, 61, 34, 93, this);
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
			{
				try {
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if( !checkRichting((richting + 3) % 4) ) //als links vol is
				{
					if( !checkRichting(richting) ) // als rechtdoor vol zit
					{
						if ( !checkRichting((richting + 1) % 4) ) // als rechts vol zit
						{
							if( !checkRichting((richting + 2) % 4) ) //als achter vol zit
							{
								//verander dan alleen de richting maar beweeg niet
								richting = (richting + 3) % 4;
								repaint();
								try {
									Thread.sleep(DELAY);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							else
							{
								// ga terug
								richting = (richting + 2) % 4;
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
						else
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
						}
					}
					else
					{
						// ga rechtdoor
						if(richting == 1 || richting == 3)
						{
							if(xPos <= 0 || xPos >= (currentLevel.getLevelWidth() * 32) + 32)
							{
								if( !checkRichting((richting + 3) % 4) ) //als links vol is
								{//check links
									if ( !checkRichting((richting + 1) % 4) ) // als rechts vol zit
									{
										if( !checkRichting((richting + 2) % 4) ) //als achter vol zit
										{
											//verander dan alleen de richting maar beweeg niet
											richting = (richting + 3) % 4;
											repaint();
											try {
												Thread.sleep(DELAY);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}
										else
										{
											// ga terug
											richting = (richting + 2) % 4;
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
									else
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
									}
								}
								else
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
							else
							{
								//ga recht door
								try {
									Thread.sleep(DELAY);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								beweeg(richting);
								repaint();
							}
						}
						if(richting == 2 || richting == 0)
						{
							if(yPos <= 0 || yPos >= (currentLevel.getLevelHeight() * 32) - 32)
							{
								if( !checkRichting((richting + 3) % 4) ) //als links vol is
								{//check links
									if ( !checkRichting((richting + 1) % 4) ) // als rechts vol zit
									{
										if( !checkRichting((richting + 2) % 4) ) //als achter vol zit
										{
											//verander dan alleen de richting maar beweeg niet
											richting = (richting + 3) % 4;
											repaint();
											try {
												Thread.sleep(DELAY);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}
										else
										{
											// ga terug
											richting = (richting + 2) % 4;
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
									else
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
									}
								}
								else
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
							else
							{
								//ga recht door
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
				}
				else
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
	}
}
