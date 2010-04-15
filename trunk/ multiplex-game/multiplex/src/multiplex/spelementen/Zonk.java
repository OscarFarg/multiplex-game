package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;

import multiplex.level.Level;

public class Zonk extends DynamischObject {
	
	public Zonk(Level level)
	{
		super(level); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/zonk.png"));
	}
	
	public void tekenAfbeelding(Graphics g)
	{
		Image im = getAfbeelding().getImage();
		g.drawImage(im, 0, 0, getWidth(), getHeight(), 96, 0, 128, 32, this);
	}
}
