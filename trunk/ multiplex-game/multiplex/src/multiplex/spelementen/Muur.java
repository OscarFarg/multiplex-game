package multiplex.spelementen;

public class Muur extends StatischObject {

	public Muur()
	{
		super(); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/muur.png"));
	}
	

}
