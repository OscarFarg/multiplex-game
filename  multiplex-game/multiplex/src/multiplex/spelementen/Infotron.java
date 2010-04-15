package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import multiplex.botsing.Botsing;
import multiplex.level.Level;

public class Infotron extends DynamischObject implements IsEetbaar, KanVallen {

	public Infotron(Level level)
	{
		super(level); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/infotron.png"));
	}

	public void tekenAfbeelding(Graphics g)
	{
		Image im = getAfbeelding().getImage();
		g.drawImage(im, 0, 0, getWidth(), getHeight(), 224, 0, 256, 32, this);
	}

	@Override
	public void eet() {
		currentLevel.remove(this);
		currentLevel.repaint();		
	}

	@Override
	public void val() {
		SpelElement element = currentLevel.getElementAt(new Point(getX(), getY() + 32));
		if (element == null)
		{
			this.setLocation(getX(), getY()- 32);
			repaint();
			currentLevel.repaint();
		}
	}
}
