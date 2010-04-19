package multiplex.spelementen;

import java.awt.Graphics;
import javax.swing.*;

import multiplex.level.Level;

public class SpelElement extends JPanel {

	protected ImageIcon afbeelding;
	protected final int BREEDTE = 32;
	protected final int HOOGTE = 32;
	protected int xPos, yPos;
	protected int levelX, levelY;
	protected Timer actieTimer;
	protected Level currentLevel;
	protected int elementType;

	public SpelElement(Level level)
	{
		this.currentLevel = level;
		this.setSize(BREEDTE, HOOGTE);
		this.setOpaque(false);
	}
	
	public SpelElement (Level level, int x, int y)
	{
		this(level);
		setLevelX(x);
		setLevelY(y);
	}
	public ImageIcon getAfbeelding() {
		return afbeelding;
	}

	public void setAfbeelding(ImageIcon afbeelding) {
		this.afbeelding = afbeelding;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		if (xPos >= 0 && xPos <= (currentLevel.getLevelWidth() * 32) - 32)
			this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		if (yPos >= 0 && yPos <= (currentLevel.getLevelHeight() * 32) - 32)
			this.yPos = yPos;
	}

	public Timer getActieTimer() {
		return actieTimer;
	}

	public void setActieTimer(Timer actieTimer) {
		this.actieTimer = actieTimer;
	}

	public int getLevelX() {
		return levelX;
	}
	public void setLevelX(int levelX) {
		this.levelX = levelX;
	}
	public int getLevelY() {
		return levelY;
	}
	public void setLevelY(int levelY) {
		this.levelY = levelY;
	}
	public int getElementType() {
		return elementType;
	}
	public void setElementType(int elementType) {
		this.elementType = elementType;
	}
	public void paintComponent(Graphics g)
	{ 
		super.paintComponent( g );
		if ( afbeelding != null )
			tekenAfbeelding( g );                        
	}

	protected ImageIcon createImageIcon(String path)
	{
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		}
		else {
			System.err.println("Kan bestand niet vinden: " + path);
			return null;
		}
	}
	public void tekenAfbeelding(Graphics g)
	{
		g.drawImage(afbeelding.getImage(), 0, 0, getWidth(), getHeight(), this);

	}

	public void ontplof()
	{

	}
}
