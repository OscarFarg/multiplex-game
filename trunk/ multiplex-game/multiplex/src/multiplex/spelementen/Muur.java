package multiplex.spelementen;

import multiplex.level.Level;

public class Muur extends StatischObject {

	public Muur(Level level)
	{
		super(level); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/muur.png"));
	}
	

}
