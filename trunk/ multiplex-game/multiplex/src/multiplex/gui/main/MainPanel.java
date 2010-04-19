package multiplex.gui.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import multiplex.gui.AppPanel;

public class MainPanel extends JPanel implements MouseListener
{
	private JLabel newPlayerKnop, skipLevelKnop, creditsKnop, viewHighscoresKnop, helpKnop, startKnop, loadKnop, 
		levelOmhoogKnop, levelOmlaagKnop, spelerOmhoogKnop, spelerOmlaagKnop; // de knoppen
	
	private int level = 1; //het geselecteerde level
	private AppPanel appPanel;
	String[] levelArray = {" ", "001 -------------------------- Level 1 ------------------------", "002 -------------------------- Level 2 ------------------------", "003 -------------------------- Level 3 ------------------------", "004 -------------------------- Level 4 ------------------------", "005 -------------------------- Level 5 ------------------------", "006 -------------------------- Level 6 ------------------------", " "};

	public MainPanel(AppPanel appPanel)
	{
		setLayout(null); //null layout, zodat je de knoppen zelf kan positioneren
		
		this.appPanel = appPanel;

		// teken de knop "new player" en hang er een mouselistener aan
		newPlayerKnop = new JLabel(); //knop is een JLabel
		newPlayerKnop.addMouseListener(this); //hang er een mouselistener aan, knop moet op een muisklik reageren
		this.add(newPlayerKnop); 
		newPlayerKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/newPlayerKnop.png"))); //knop is een afbeelding
		newPlayerKnop.setBounds(17,271,148,18); // het plaatje moet op exact de juiste plaats verschijnen
		
		// teken de knop "skip level" en hang er een mouselistener aan
		skipLevelKnop = new JLabel();
		this.add(skipLevelKnop);
		skipLevelKnop.addMouseListener(this);
		skipLevelKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/skipLevelKnop.png")));
		skipLevelKnop.setBounds(17,296,130,18);
		
		// teken de knop "view highscores" en hang er een mouselistener aan
		viewHighscoresKnop = new JLabel();
		viewHighscoresKnop.addMouseListener(this);
		this.add(viewHighscoresKnop);
		viewHighscoresKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/viewHighscoresKnop.png")));
		viewHighscoresKnop.setBounds(17,321,208,19);
		
		// teken de knop "help" en hang er een mouselistener aan
		helpKnop = new JLabel();
		helpKnop.addMouseListener(this);
		this.add(helpKnop);
		helpKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/helpKnop.png")));
		helpKnop.setBounds(17,346,71,18);
		
		// teken de knop "credits" en hang er een mouselistener aan
		creditsKnop = new JLabel();
		creditsKnop.addMouseListener(this);
		this.add(creditsKnop);
		creditsKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/creditsKnop.png")));
		creditsKnop.setBounds(17,371,108,18);
		
		// teken de knop "start" en hang er een mouselistener aan
		startKnop = new JLabel();
		this.add(startKnop);
		startKnop.addMouseListener(this);
		startKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/startKnop.png")));
		startKnop.setBounds(19,215,66,48);
		
		// teken de knop "load" en hang er een mouselistener aan
		loadKnop = new JLabel();
		this.add(loadKnop);
		loadKnop.addMouseListener(this);
		loadKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/loadKnop.png")));
		loadKnop.setBounds(119,215,54,50);
		
		// teken de knop "level-list" met de pijl omhoog, en hang er een mouselistener aan.
		levelOmhoogKnop = new JLabel();
		this.add(levelOmhoogKnop);
		levelOmhoogKnop.addMouseListener(this);
		levelOmhoogKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/levelUpKnop.png")));
		levelOmhoogKnop.setBounds(286,208,326,20);
		
		// teken de knop "level-list" met de pijl omlaag, en hang er een mouselistener aan.
		levelOmlaagKnop = new JLabel();
		this.add(levelOmlaagKnop);
		levelOmlaagKnop.addMouseListener(this);
		levelOmlaagKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/levelDownKnop.png")));
		levelOmlaagKnop.setBounds(286,286,326,20);
		
		// teken de knop "player" met de pijl omhoog, en hang er een mouselistener aan.
		spelerOmhoogKnop = new JLabel();
		this.add(spelerOmhoogKnop);
		spelerOmhoogKnop.addMouseListener(this);
		spelerOmhoogKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/spelerUpKnop.png")));
		spelerOmhoogKnop.setBounds(215,91,110,20);
		
		// teken de knop "player" met de pijl omlaag, en hang er een mouselistener aan.
		spelerOmlaagKnop = new JLabel();
		this.add(spelerOmlaagKnop);
		spelerOmlaagKnop.addMouseListener(this);
		spelerOmlaagKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/spelerDownKnop.png")));
		spelerOmlaagKnop.setBounds(215,169,110,20);
		
		setVisible(true);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/titelMenuGrafisch.png")).getImage(),0, 0, getWidth(), getHeight(), null);
		
		g.setColor(new Color(227, 17, 17));
		g.setFont(new Font("Lucida Sans", Font.BOLD, 16 ));
		
		g.drawString(levelArray[level - 1], 300, 247);
		g.drawString(levelArray[level], 300, 264);
		g.drawString(levelArray[level + 1], 300, 281);
	}
	
	public void mouseClicked(MouseEvent e) //voor elke knop een apart event
	{
		if (e.getSource() == newPlayerKnop) //als er op "new player" geklikt wordt
		{
			System.out.println("maak nieuwe speler");
		}
		else if (e.getSource() == skipLevelKnop) // als er op "skip level" geklikt wordt
		{
			System.out.println("level overslaan"); 
		}
		else if (e.getSource() == viewHighscoresKnop) // als er op "view highscores" geklikt wordt
		{
			System.out.println("highscores weergeven");
		}
		else if (e.getSource() == helpKnop) //als er op "help" geklikt wordt
		{
			System.out.println("laat helpscherm zien");
		}
		else if (e.getSource() == creditsKnop) //als er op "credits" geklikt wordt
		{
			System.out.println("laat credits zien");
		}
		else if (e.getSource() == startKnop) //als er op "start" geklikt wordt
		{
			System.out.println("spel starten");
		}
		else if (e.getSource() == loadKnop) //als er op "load" geklikt wordt
		{
			System.out.println("spel laden");
		}
		else if (e.getSource() == levelOmhoogKnop) //als er op "level-list" (met de pijl omhoog) geklikt wordt
		{
			System.out.println("levelOmhoogKnop");
			level--;
			if (level == 0) // level mag niet kleiner zijn dan 1, er is geen level 0
			{
				level = 1;
			}
			repaint();
		}
		else if (e.getSource() == levelOmlaagKnop) //als er op "level-list" (met de pijl omlaag) geklikt wordt
		{
			System.out.println("levelOmlaagKnop");
			level++;
			if (level == levelArray.length - 1) //de laatste regel in de array is leeg, om een out of bounds exception te voorkomen
			{
				level = levelArray.length - 2;// als level te hoog wordt, terug naar het toegestane maximum
			}
			repaint();
		}
		else if (e.getSource() == spelerOmhoogKnop) //als er op "speler" (met de pijl omhoog) geklikt wordt
		{
			System.out.println("spelerOmhoogKnop");
		}
		else if (e.getSource() == spelerOmlaagKnop) //als er op "speler" (met de pijl omlaag) geklikt wordt
		{
			System.out.println("spelerOmlaagKnop");
		}
		

	}
	public void mouseEntered(MouseEvent e) {} 
	public void mouseExited(MouseEvent e)  {} //deze worden niet gebruikt
	public void mousePressed(MouseEvent e)  {}
	public void mouseReleased(MouseEvent e) {} 
}
