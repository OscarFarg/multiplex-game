package multiplex.gui.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainPanel extends JPanel implements MouseListener
{
	private JLabel newPlayerKnop, skipLevelKnop, creditsKnop, viewHighscoresKnop, helpKnop, startKnop, loadKnop;

	public MainPanel()
	{
		setLayout(null);
		setBackground(Color.PINK);
		
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
		
		startKnop = new JLabel();
		this.add(startKnop);
		startKnop.addMouseListener(this);
		startKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/startKnop.png")));
		startKnop.setBounds(19,207,66,48);
		
		loadKnop = new JLabel();
		this.add(loadKnop);
		loadKnop.addMouseListener(this);
		loadKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/loadKnop.png")));
		loadKnop.setBounds(119,207,54,50);
		
		
		//Is handiger in de paint component.
		
		/*
		titelMenuGrafisch = new JLabel();
		this.add(titelMenuGrafisch);
		titelMenuGrafisch.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/titelMenuGrafisch.png")));
		titelMenuGrafisch.setBounds(0,0,640,400);
		*/
		
		setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/titelMenuGrafisch2.png")).getImage(),0, 0, getWidth(), getHeight(), null);
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
		else if (e.getSource() == startKnop)
		{
			System.out.println("spel starten");
		}
		else if (e.getSource() == loadKnop)
		{
			System.out.println("spel laden");
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e)  {}
	public void mousePressed(MouseEvent e)  {}
	public void mouseReleased(MouseEvent e) {} 
}
