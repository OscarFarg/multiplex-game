package multiplex.spelementen;

import multiplex.level.Level;

public class Exit extends StatischObject {
	
	public Exit(Level level)
	{
		super(level); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/exit.png"));
	}
	
	public void eindeLevel()
	{
		currentLevel.doUitgespeeld();
	}
}
