package multiplex.gui.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainPanel extends JPanel implements MouseListener
{
	private JLabel newPlayerKnop, skipLevelKnop, creditsKnop, viewHighscoresKnop, helpKnop;

	public MainPanel()
	{
		setLayout(null);
		setBackground(new Color(130, 130, 130));
		
		newPlayerKnop = new JLabel();
		newPlayerKnop.addMouseListener(this);
		this.add(newPlayerKnop);
		newPlayerKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/newPlayerKnop.png")));
		newPlayerKnop.setBounds(17,263,148,18);
		
		skipLevelKnop = new JLabel();
		this.add(skipLevelKnop);
		skipLevelKnop.addMouseListener(this);
		skipLevelKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/skipLevelKnop.png")));
		skipLevelKnop.setBounds(17,288,130,18);
		
		viewHighscoresKnop = new JLabel();
		viewHighscoresKnop.addMouseListener(this);
		this.add(viewHighscoresKnop);
		viewHighscoresKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/viewHighscoresKnop.png")));
		viewHighscoresKnop.setBounds(17,313,208,19);
		
		helpKnop = new JLabel();
		helpKnop.addMouseListener(this);
		this.add(helpKnop);
		helpKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/helpKnop.png")));
		helpKnop.setBounds(17,338,71,18);
		
		creditsKnop = new JLabel();
		creditsKnop.addMouseListener(this);
		this.add(creditsKnop);
		creditsKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/creditsKnop.png")));
		creditsKnop.setBounds(17,363,108,18);
		
		setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e) 
	{
		if (e.getSource() == newPlayerKnop)
		{
			System.out.println("maak nieuwe speler");
		}
		else if (e.getSource() == skipLevelKnop)
		{
			System.out.println("level overslaan");
		}
		else if (e.getSource() == viewHighscoresKnop)
		{
			System.out.println("highscores weergeven");
		}
		else if (e.getSource() == helpKnop)
		{
			System.out.println("laat helpscherm zien");
		}
		else if (e.getSource() == creditsKnop)
		{
			System.out.println("laat credits zien");
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e)  {}
	public void mousePressed(MouseEvent e)  {}
	public void mouseReleased(MouseEvent e) {} 
}
