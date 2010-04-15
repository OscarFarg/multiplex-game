package multiplex.spelementen;

public class Exit extends StatischObject {
	
	public Exit()
	{
		super(); //nodig zodat de breedte, hoogte en doorzichtigheid worden ingesteld.
		this.setAfbeelding(createImageIcon("images/exit.png"));
	}
	
	public void eindeLevel()
	{
		System.out.println("Einde van level");
	}
}
