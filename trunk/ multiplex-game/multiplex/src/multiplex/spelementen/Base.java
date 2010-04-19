package multiplex.spelementen;

import multiplex.level.Level;
import multiplex.spelementen.interfaces.IsEetbaar;

public class Base extends StatischObject implements IsEetbaar {

	public Base(Level level)
	{
		super(level); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/base.png"));
	}

	@Override
	public void eet() {
		currentLevel.remove(this);
		currentLevel.getEetbaarList().remove(this);
		currentLevel.getElementList().remove(this);
		currentLevel.repaint();
		
	}
}
