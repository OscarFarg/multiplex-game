package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import multiplex.botsing.Botsing;
import multiplex.level.Level;
import multiplex.spelementen.interfaces.IsDuwbaar;
import multiplex.spelementen.interfaces.KanVallen;

public class Zonk extends DynamischObject implements IsDuwbaar, KanVallen, ActionListener {

	private boolean vallend;
	private boolean opBodem = false;

	//private Timer valTimer;
	transient private ValChecker valChecker;

	public Zonk(Level level)
	{
		super(level); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/zonk.png"));

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
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 96, 0, 128, 32, this);
		}
	}

	@Override
	public void duw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void val() {
		if (!paused)
		{
			SpelElement element = currentLevel.getElementAt(new Point(getX(), getY() + 32), this);
			if (!vallend)
			{
				if (element == null) {
					actieTimer.start();
				}
				else {
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
							if (this.getX() == currentLevel.getMurphy().getxPos())
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
		actieTimer = new Timer(20, this);
		valChecker = new ValChecker(this);
		valChecker.start();
	}
}
