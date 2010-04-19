package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import multiplex.level.Level;
import multiplex.level.ValChecker;
import multiplex.spelementen.interfaces.IsDuwbaar;
import multiplex.spelementen.interfaces.KanVallen;

public class Zonk extends DynamischObject implements IsDuwbaar, KanVallen, ActionListener {

	private boolean vallend;
	private boolean opBodem = false;

	//private Timer valTimer;
	private ValChecker valChecker;

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
		Image im = getAfbeelding().getImage();
		g.drawImage(im, 0, 0, getWidth(), getHeight(), 96, 0, 128, 32, this);
	}

	@Override
	public void duw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void val() {
		SpelElement element = currentLevel.getElementAt(new Point(getX(), getY() + 32));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == actieTimer)
		{
			if (!opBodem)
			{
				if (!(this.getY() + 40 > (currentLevel.getLevelHeight()*32)))
				{
					this.setLocation(getX(), getY() + 8);
					currentLevel.repaint();
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

	@Override
	public boolean isOpBodem() {
		return opBodem;
	}

	@Override
	public boolean isVallend() {
		return vallend;
	}
}
