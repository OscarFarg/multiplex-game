package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import multiplex.constanten.Richting;
import multiplex.level.Level;

public class Murphy extends SpelElement implements KeyListener {

	private Richting richting = Richting.START;
	private Level currentLevel;

	public Murphy(int x, int y, Level level)
	{
		this(level);
		this.setxPos(x);
		this.setyPos(y);
		this.setLocation(xPos, yPos);
	}

	public Murphy(Level level)
	{
		super();
		this.currentLevel = level;
		this.setAfbeelding(createImageIcon("images/murphy2.png"));
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();

	}

	public void setLocation(int x, int y)
	{
		super.setLocation(x, y);
		this.setxPos(x);
		this.setyPos(y);
	}

	public void setLocation(Point p)
	{
		super.setLocation(p);
		this.setxPos(p.x);
		this.setyPos(p.y);
	}

	public void tekenAfbeelding(Graphics g)
	{

		Image im = getAfbeelding().getImage();

		switch (richting)
		{
		case START:
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 300, 160, 332, 192, this);
			break;
		case BOVEN:
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 0, 32, 32, 64, this);
			break;
		case ONDER: 
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 0, 64, 32, 96, this);
			break;
		case LINKS:
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 0, 32, 32, 64, this);
			break;
		case RECHTS: 
			g.drawImage(im, 0, 0, getWidth(), getHeight(), 0, 64, 32, 96, this);
			break;

		}


	}

	public void beweeg(Richting richting)
	{
		switch (richting)
		{
		case BOVEN: 
			this.setyPos(yPos - 32); break;
		case ONDER: 
			this.setyPos(yPos + 32); break;
		case LINKS: 
			this.setxPos(xPos - 32); break;
		case RECHTS: 
			this.setxPos(xPos + 32); break;
		}
		this.setLocation(xPos, yPos);
		repaint();
	}

	public Richting getRichting() {
		return richting;
	}

	public void setRichting(Richting richting) {
		this.richting = richting;
	}

	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		switch (ke.getKeyCode())
		{
		case KeyEvent.VK_UP :
			setRichting(Richting.BOVEN) ; break;
		case KeyEvent.VK_DOWN :
			setRichting(Richting.ONDER) ; break;
		case KeyEvent.VK_LEFT :
			setRichting(Richting.LINKS) ; break;
		case KeyEvent.VK_RIGHT :
			setRichting(Richting.RECHTS) ; break;
		}

		beweeg(richting);

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}




}
