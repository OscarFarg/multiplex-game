package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import multiplex.botsing.Botsing;
import multiplex.level.Level;
import multiplex.spelementen.interfaces.IsEetbaar;
import multiplex.spelementen.interfaces.KanVallen;

public class Infotron extends DynamischObject implements IsEetbaar, KanVallen, ActionListener {

	private boolean vallend;
	private boolean opBodem = false;

	transient private ValChecker valChecker;

	public Infotron(Level level)
	{
		super(level); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/infotron.png"));
		actieTimer = new Timer(20, this);
		valChecker = new ValChecker(this);
		valChecker.start();
	}

	public void tekenAfbeelding(Graphics g)
	{
		if (ontplof)
		{
			super.tekenAfbeelding(g);
		}
		else
		{
			Image im = getAfbeelding().getImage();
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 224, 0, 256, 32, this);
		}

	}

	@Override
	public void eet() {
		currentLevel.verminderInfotron();
		currentLevel.removeElement(this);
		if (!opBodem)
			this.valChecker.stopThread();
		actieTimer.stop();
	}

	@Override
	public void val() {
		if (!paused)
		{
			SpelElement element = currentLevel.getElementAt(new Point(getX(), getY() + 32), this);
			if (!vallend)
			{
				if (element == null)
				{
					actieTimer.start();
				}
				else
				{
					vallend = false;
					actieTimer.stop();
				}
			}
		}
	}

	public void stopValChecker()
	{
		valChecker.stopThread();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!paused)
		{
			if (e.getSource() == ontplofTimer)
			{
				actieTimer.stop();
				super.actionPerformed(e);
				if (ontplofTeller == 7)
					valChecker.stopThread();
			}
			if (e.getSource() == actieTimer)
			{
				if (!opBodem)
				{
					if (!(this.getY() + 40 > (currentLevel.getLevelHeight()*32)))
					{
						this.setLocation(getX(), getY() + 8);
						currentLevel.repaint();
						if (Botsing.raakt(this, currentLevel.getMurphy()))
						{
							if ((this.getX() == currentLevel.getMurphy().getxPos()) 
									&& this.getY() <= currentLevel.getMurphy().getyPos() - 32)
							{
								currentLevel.removeElement(this);
								this.actieTimer.stop();
								valChecker.stopThread();
								currentLevel.getMurphy().ontplof();
							}

						}
					}
					else
					{
						actieTimer.stop();
						vallend = false;
						opBodem = true;
					}
				}
				else
					valChecker = null;

			}
		}
	}

	@Override
	public boolean isOpBodem() {
		return opBodem;
	}

	@Override
	public boolean isVallend() {
		return vallend;
	}

	@Override
	public void restart() {
		valChecker = new ValChecker(this);
		valChecker.start();		
	}
}
