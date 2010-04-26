package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class TestPanel extends JPanel {
	
	public TestApp app;
	public Rectangle rView;
	
	public TestPanel(TestApp app)
	{
		this.app = app;
		this.setLayout(null);
		this.setSize(800, 480);
		this.setBackground(Color.BLUE);
		this.add(new TestElement(this));
		rView = new Rectangle(256, 256);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		g.fillRect(rView.x, rView.y, rView.width, rView.width);
	}
}
