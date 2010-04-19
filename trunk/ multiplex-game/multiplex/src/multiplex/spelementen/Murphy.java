package multiplex.spelementen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import multiplex.botsing.Botsing;
import multiplex.constanten.Richting;
import multiplex.level.Level;
import multiplex.spelementen.interfaces.IsEetbaar;

public class Murphy extends SpelElement implements KeyListener, ActionListener {

	private Richting richting = Richting.START;
	private Timer eindTimer;

	public Murphy(int x, int y, Level level)
	{
		this(level);
		this.setxPos(x);
		this.setyPos(y);
		this.setLocation(xPos, yPos);
	}

	public Murphy(Level level)
	{
		super(level);
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
		if (ontplof)
			super.tekenAfbeelding(g);
		else
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
	}

	public boolean checkRichting(Richting richting)
	{
		SpelElement element = null;
		switch (richting)
		{
		case BOVEN: 
			element = currentLevel.getElementAt(new Point(getxPos(), getyPos() - 32)); break;
		case ONDER: 
			element = currentLevel.getElementAt(new Point(getxPos(), getyPos() + 32)); break;
		case LINKS: 
			element = currentLevel.getElementAt(new Point(getxPos() - 32, getyPos())); break;
		case RECHTS: 
			element = currentLevel.getElementAt(new Point(getxPos() + 32, getyPos())); break;
		}

		if (element != null)
		{
			if (!Botsing.raakt(this, element))
			{
				return true;
			}
			else
				if (element instanceof IsEetbaar)
				{
					IsEetbaar eetbaar = (IsEetbaar) element;
					eetbaar.eet();
					return true;
				}
				else
					return false;
		}
		return true;
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
		case KeyEvent.VK_UP:
			setRichting(Richting.BOVEN); break;
		case KeyEvent.VK_DOWN:
			setRichting(Richting.ONDER); break;
		case KeyEvent.VK_LEFT:
			setRichting(Richting.LINKS); break;
		case KeyEvent.VK_RIGHT:
			setRichting(Richting.RECHTS); break;
		case KeyEvent.VK_ESCAPE:
			ontplof(); removeKeyListener(this); break;
		case KeyEvent.VK_M:
			getThreads(); break;

		}

		if (checkRichting(richting))
			beweeg(richting);
	}

	public void getThreads()
	{
		// Walk up all the way to the root thread group
		ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
		ThreadGroup parent;
		while ((parent = rootGroup.getParent()) != null) {
			rootGroup = parent;
		}

		listThreads(rootGroup, "");

	}

	public static void listThreads(ThreadGroup group, String indent) {
		System.out.println(indent + "Group[" + group.getName() + 
				":" + group.getClass()+"]");
		int nt = group.activeCount();
		Thread[] threads = new Thread[nt*2 + 10]; //nt is not accurate
		nt = group.enumerate(threads, false);

		// List every thread in the group
		for (int i=0; i<nt; i++) {
			Thread t = threads[i];
			System.out.println(indent + "  Thread[" + t.getName() 
					+ ":" + t.getClass() + "]");
		}

		// Recursively list all subgroups
		int ng = group.activeGroupCount();
		ThreadGroup[] groups = new ThreadGroup[ng*2 + 10];
		ng = group.enumerate(groups, false);

		for (int i=0; i<ng; i++) {
			listThreads(groups[i], indent + "  ");
		}
	}

	public void ontplof()
	{
		if (!ontplof)
		{
			this.setAfbeelding(createImageIcon("images/explosion.png"));
			ontplofTimer.start();
			ontplof = true;

			for (int i = -1; i < 2; i++)
				for (int j = -1; j < 2; j++)
				{
					int x = this.getxPos() + (i * 32);
					int y = this.getyPos() + (j * 32);
					Point p = new Point( x, y);
					SpelElement element = currentLevel.getElementAt(p);
					if (element == null)
					{
						element = new SpelElement(currentLevel);
						currentLevel.addElement(element, p);
						element.ontplof();
					}
					else
						if (element != this)
							element.ontplof();
				}
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		setRichting(Richting.START);
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void actionPerformed(ActionEvent e)
	{
		super.actionPerformed(e);
		if (e.getSource() == ontplofTimer)
		{
			if (ontplofTeller == 7)
			{

				eindTimer = new Timer(100, this);
				eindTimer.setInitialDelay(500);
				eindTimer.start();
			}
		}
		if (e.getSource() == eindTimer)
		{
			currentLevel.eindeLevel();
			eindTimer.stop();
		}
	}
}
