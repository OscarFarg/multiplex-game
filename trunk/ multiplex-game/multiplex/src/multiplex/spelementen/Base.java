package multiplex.spelementen;

public class Base extends StatischObject {

	public Base()
	{
		super(); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/base.png"));
	}
}
