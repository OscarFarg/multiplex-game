package multiplex.gui.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import multiplex.gui.AppPanel;

public class MainPanel extends JPanel implements MouseListener
{
	private JLabel newPlayerKnop, skipLevelKnop, creditsKnop, viewHighscoresKnop, helpKnop, startKnop, loadKnop, 
		levelOmhoogKnop, levelOmlaagKnop, spelerOmhoogKnop, spelerOmlaagKnop;

	private AppPanel appPanel;

	public MainPanel(AppPanel appPanel)
	{
		setLayout(null);
		setBackground(Color.PINK);
		this.appPanel = appPanel;

		
		newPlayerKnop = new JLabel();
		newPlayerKnop.addMouseListener(this);
		this.add(newPlayerKnop);
		newPlayerKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/newPlayerKnop.png")));
		newPlayerKnop.setBounds(17,271,148,18);
		
		skipLevelKnop = new JLabel();
		this.add(skipLevelKnop);
		skipLevelKnop.addMouseListener(this);
		skipLevelKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/skipLevelKnop.png")));
		skipLevelKnop.setBounds(17,296,130,18);
		
		viewHighscoresKnop = new JLabel();
		viewHighscoresKnop.addMouseListener(this);
		this.add(viewHighscoresKnop);
		viewHighscoresKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/viewHighscoresKnop.png")));
		viewHighscoresKnop.setBounds(17,321,208,19);
		
		helpKnop = new JLabel();
		helpKnop.addMouseListener(this);
		this.add(helpKnop);
		helpKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/helpKnop.png")));
		helpKnop.setBounds(17,346,71,18);
		
		creditsKnop = new JLabel();
		creditsKnop.addMouseListener(this);
		this.add(creditsKnop);
		creditsKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/creditsKnop.png")));
		creditsKnop.setBounds(17,371,108,18);
		
		startKnop = new JLabel();
		this.add(startKnop);
		startKnop.addMouseListener(this);
		startKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/startKnop.png")));
		startKnop.setBounds(19,215,66,48);
		
		loadKnop = new JLabel();
		this.add(loadKnop);
		loadKnop.addMouseListener(this);
		loadKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/loadKnop.png")));
		loadKnop.setBounds(119,215,54,50);
		
		levelOmhoogKnop = new JLabel();
		this.add(levelOmhoogKnop);
		levelOmhoogKnop.addMouseListener(this);
		levelOmhoogKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/levelUpKnop.png")));
		levelOmhoogKnop.setBounds(286,208,326,20);
		
		spelerOmlaagKnop = new JLabel();
		this.add(spelerOmlaagKnop);
		spelerOmlaagKnop.addMouseListener(this);
		spelerOmlaagKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/levelDownKnop.png")));
		spelerOmlaagKnop.setBounds(286,286,326,20);
		
		spelerOmhoogKnop = new JLabel();
		this.add(spelerOmhoogKnop);
		spelerOmhoogKnop.addMouseListener(this);
		spelerOmhoogKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/spelerUpKnop.png")));
		spelerOmhoogKnop.setBounds(215,91,110,20);
		
		spelerOmlaagKnop = new JLabel();
		this.add(spelerOmlaagKnop);
		spelerOmlaagKnop.addMouseListener(this);
		spelerOmlaagKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/spelerDownKnop.png")));
		spelerOmlaagKnop.setBounds(215,169,110,20);
		
		setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/titelMenuGrafisch.png")).getImage(),0, 0, getWidth(), getHeight(), null);
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
