package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;

public class Infotron extends DynamischObject {
	
	public Infotron()
	{
		super(); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/infotron.png"));
	}
	
	public void tekenAfbeelding(Graphics g)
	{
		Image im = getAfbeelding().getImage();
		g.drawImage(im, 0, 0, getWidth(), getHeight(), 224, 0, 256, 32, this);
	}
}
