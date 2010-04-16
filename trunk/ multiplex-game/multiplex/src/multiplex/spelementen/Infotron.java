package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import multiplex.botsing.Botsing;
import multiplex.level.Level;

public class Infotron extends DynamischObject implements IsEetbaar, KanVallen, ActionListener {

	private boolean vallend;
	private boolean opBodem = false;


	public Infotron(Level level)
	{
		super(level); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/infotron.png"));
		actieTimer = new Timer(10, this);
	}

	public void tekenAfbeelding(Graphics g)
	{
		Image im = getAfbeelding().getImage();
		g.drawImage(im, 0, 0, getWidth(), getHeight(), 224, 0, 256, 32, this);
	}

	@Override
	public void eet() {
		currentLevel.remove(this);
		currentLevel.getEetbaarList().remove(this);
		currentLevel.getElementList().remove(this);
		currentLevel.repaint();		
	}

	@Override
	public void val() {
		SpelElement element = currentLevel.getElementAt(new Point(getX(), getY() + 32));
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
