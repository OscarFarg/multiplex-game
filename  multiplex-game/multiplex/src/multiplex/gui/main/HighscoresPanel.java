package multiplex.gui.main;

import java.awt.*;
import java.awt.event.*;
import multiplex.gui.main.MainPanel;
import javax.swing.*;

public class HighscoresPanel extends JPanel implements MouseListener
{
	private JLabel backKnop;
	private MainPanel mainPanel;
	
	public HighscoresPanel(MainPanel mainPanel)
	{
		setLayout(null); 
		this.setBounds(0, 0, 646, 410);
		this.mainPanel = mainPanel;
		backKnop = new JLabel();
		this.add(backKnop);
		backKnop.addMouseListener(this);
		backKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/backKnop.png")));
		backKnop.setBounds(24,298,78,76);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/highscores.png")).getImage(),0, 0, getWidth(), getHeight(), null);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		if (e.getSource() == backKnop)
		{
			System.out.println("terug naar hoofdmenu");
			this.setVisible(false);
			
			mainPanel.setVisible(true);
		}
	}
	
	public void mouseEntered(MouseEvent e) {} 
	public void mouseExited(MouseEvent e)  {} //deze worden niet gebruikt
	public void mousePressed(MouseEvent e)  {}
	public void mouseReleased(MouseEvent e) {} 

}
