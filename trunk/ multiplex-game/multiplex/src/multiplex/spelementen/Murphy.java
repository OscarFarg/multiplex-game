package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import multiplex.constanten.Richting;

public class Murphy extends SpelElement implements KeyListener {

	private Richting richting = Richting.START;

	public Murphy()
	{
		this.setSize(BREEDTE, HOOGTE);
		this.setAfbeelding(createImageIcon("images/murphy2.png"));
		this.setOpaque(false);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		this.setxPos(10);
		this.setyPos(10);
		this.setLocation(xPos, yPos);
	}

	public void tekenAfbeelding(Graphics g)
	{

		Image im = getAfbeelding().getImage();
		if ( g.drawImage( im, 0, 0, 0, 0, this ) )
		{
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
