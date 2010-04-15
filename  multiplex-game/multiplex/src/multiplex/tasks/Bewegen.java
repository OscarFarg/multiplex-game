package multiplex.tasks;

import multiplex.constanten.Richting;
import multiplex.level.Level;
import multiplex.spelementen.Murphy;

public class Bewegen {
	
	
	public static void Execute(Level l, Richting r)
	{
		Murphy m = l.getMurphy();
		m.checkRichting(r);
	}
	

}
