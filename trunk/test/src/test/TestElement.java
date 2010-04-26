package test;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class TestElement extends JPanel implements KeyListener, MouseListener {

	private TestPanel level;

	public TestElement(TestPanel level)
	{
		this.level = level;
		this.setSize(32,32);
		this.setBackground(Color.RED);
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.setFocusable(true);
		this.requestFocus();
	}

	public void scrollLevel(int richting)
	{
		Rectangle rElement = this.getBounds();

		if (richting == 0) //omhoog
		{
			Rectangle rMovement =  new Rectangle(level.rView.x, level.rView.y + level.rView.height / 2, level.rView.width, level.rView.height / 2);


			if (!rMovement.contains(rElement))
			{
				System.out.println("error");
				if (level.getBounds().contains(new Point(level.rView.x, level.rView.y - 31)))
					level.rView.setLocation(level.rView.x, level.rView.y - 32);
			}	

		} else if (richting == 1) //beneden
		{
			Rectangle rMovement =  new Rectangle(level.rView.x, level.rView.y, level.rView.width, level.rView.height / 2);

			if (!rMovement.contains(rElement))
			{
				if (level.getBounds().contains(new Point(level.rView.x, level.rView.y + level.rView.height + 31)))
					level.rView.setLocation(level.rView.x, level.rView.y + 32);
			}	

		} else if (richting == 2) //links
		{
			Rectangle rMovement =  new Rectangle(level.rView.x + level.rView.width / 2, level.rView.y, level.rView.width / 2, level.rView.height);

			if (!rMovement.contains(rElement))
			{
				if (level.getBounds().contains(new Point(level.rView.x - 31, level.rView.y)))
					level.rView.setLocation(level.rView.x - 32, level.rView.y);
			}	

		} else if (richting == 3) //rechts
		{
			Rectangle rMovement =  new Rectangle(level.rView.x, level.rView.y, level.rView.width / 2, level.rView.height);

			if (!rMovement.contains(rElement))
			{
				if (level.getBounds().contains(new Point(level.rView.x + level.rView.width + 31, level.rView.y)))
					level.rView.setLocation(level.rView.x + 32, level.rView.y);
			}		
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
			switch (ke.getKeyCode())
			{
			case KeyEvent.VK_UP:
				setLocation(getX(), getY() - 32); scrollLevel(0); break;
			case KeyEvent.VK_DOWN:
				setLocation(getX(), getY() + 32); scrollLevel(1); break;
			case KeyEvent.VK_LEFT:
				setLocation(getX() - 32, getY()); scrollLevel(2); break;
			case KeyEvent.VK_RIGHT:
				setLocation(getX() + 32, getY()); scrollLevel(3); break;
			}
			level.repaint();
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.requestFocus();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
