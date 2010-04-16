package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import multiplex.level.Level;

public class Zonk extends DynamischObject implements IsDuwbaar, KanVallen, ActionListener {

	private boolean vallend;
	private boolean opBodem = false;

	public Zonk(Level level)
	{
		super(level); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/zonk.png"));
		actieTimer = new Timer(10, this);

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
				if (!(this.getY() + 36 > (currentLevel.getLevelHeight()*32)))
				{
					this.setLocation(getX(), getY() + 4);
					currentLevel.repaint();
				}
				else
				{
					System.out.println("stop");
					actieTimer.stop();
					vallend = false;
					opBodem = true;
				}
			}

		}
	}
}
