package multiplex.level;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;
import multiplex.spelementen.*;

public class Level extends JPanel {

	private Murphy player = new Murphy();
	private ArrayList<SpelElement> elementList = new ArrayList<SpelElement>();
	private ArrayList<Vijand> vijandList = new ArrayList<Vijand>();
	
	public Level()
	{
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.add(new Murphy());
	}
	
	public void showLaadDialog()
	{
		
	}
	
	public void showLevel()
	{
		for ()
	}
	
	public void showLoadingError()
	{
		
	}
	
	public void startLevel()
	{
		
	}
	
	public SpelElement getElement()
	{
		return null;
		
	}
	
	public int getElementCount()
	{
		return 0;
		
	}
	
	public SpelElement getElementAt(Point location)
	{
		return null;
	}
	
	public void tekenSpelElement(int ElementNr)
	{
		
	}
	
	public void pauseGame()
	{
		
	}
	
	public void saveGame()
	{
		
	}
	
	public void resumeGame()
	{
		
	}
	
	public void doUitgespeeld()
	{
		
	}
	

}
