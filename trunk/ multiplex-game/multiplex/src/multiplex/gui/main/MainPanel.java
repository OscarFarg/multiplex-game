package multiplex.gui.main;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;

import multiplex.gui.editor.EditorApp;
import multiplex.gui.main.HighscoresPanel;
import multiplex.gui.main.CreditsPanel;
import multiplex.gui.main.HelpPanel;
import multiplex.gui.AppPanel;
import multiplex.level.Level;
import multiplex.settings.Player;
import multiplex.settings.Settings;

public class MainPanel extends JPanel implements MouseListener, KeyListener
{
	private HighscoresPanel highscoresPanel = new HighscoresPanel(this);
	private CreditsPanel creditsPanel = new CreditsPanel(this);
	private HelpPanel helpPanel = new HelpPanel(this);

	private JLabel newPlayerKnop, skipLevelKnop, creditsKnop, viewHighscoresKnop, 
	helpKnop, startKnop, loadKnop, levelOmhoogKnop, levelOmlaagKnop, 
	spelerOmhoogKnop, spelerOmlaagKnop; // de knoppen

	private int level = 0; //het geselecteerde level
	private AppPanel appPanel;

	private ArrayList<Level> levelArray = new ArrayList<Level>();
	private ArrayList<Player> playerList;
	private Settings settings;

	private boolean playerInput;
	private boolean playerExists;
	private String newPlayer = "";

	public MainPanel(AppPanel appPanel)
	{
		setLayout(null); //null layout, zodat je de knoppen zelf kan positioneren

		this.setBounds(0, 0, 646, 410); //grootte van het veld
		this.appPanel = appPanel;
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		addButtons();

		loadSettings();

		setVisible(true);
	}

	public void loadSettings()
	{
		try {
			ObjectInputStream settingsLoader = new ObjectInputStream(new FileInputStream("settings.mtx"));
			settings = (Settings) settingsLoader.readObject();
			settings.createLevelList();
			repaint();

		} catch (IOException ioEx)
		{
			//System.out.println("Geen settings gevonden.");
			settings = new Settings(appPanel);
		} catch (ClassNotFoundException classEx) {
			//System.out.println("Geen settings gevonden.");
			settings = new Settings(appPanel);
		} finally {
			for (int i = 0; i < settings.getLevelList().size(); i++)
			{
				levelArray.add(new Level(appPanel, settings.getLevelList().get(i)));
			}
			playerList = settings.getPlayerList();
			if (settings.getCurrentPlayer() != null)
				level = settings.getCurrentPlayer().getCurrentLevel();
		}


	}

	public void saveSettings()
	{
		try
		{
			ObjectOutputStream objectSaver = new ObjectOutputStream(new FileOutputStream("settings.mtx"));
			objectSaver.writeObject(settings);
			objectSaver.close();
		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Er is een fout opgetreden bij het schrijven.", 
					"Bewaren van het spel is mislukt.", JOptionPane.ERROR_MESSAGE);
		}

	}

	//aparte methode op alle knoppen toe te voegen.
	public void addButtons()
	{
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

	}

	public Settings getSettings() {
		return settings;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/titelMenuGrafisch.png")).getImage(),0, 0, getWidth(), getHeight(), null);

		g.setColor(new Color(227, 17, 17));
		g.setFont(new Font("Lucida Sans", Font.BOLD, 16 ));

		//alleen tekenen als er levels in de lijst staan.
		if (levelArray.size() > 0)
		{
			//bovenste regel alleen tekenen als level groter is dan 0
			if (level > 0)
				g.drawString(levelArray.get(level - 1).getLevelName(), 300, 247);

			//middelste regel
			g.drawString(levelArray.get(level).getLevelName(), 300, 264);

			//onderste regel alleen tekenen als level kleiner is dan het aantal levels in levelArray
			if (level < levelArray.size() -1)
				g.drawString(levelArray.get(level + 1).getLevelName(), 300, 281);
		}

		if (playerList.size() > 0)
		{
			int i = playerList.indexOf(settings.getCurrentPlayer());

			//Huidige speler
			g.drawString(settings.getCurrentPlayer().getName(), 225, 145);

			g.setColor(new Color(112, 146, 227));

			//Huidige speler -1
			if (i > 0)
				g.drawString(settings.getPlayerList().get(i - 1).getName(), 225, 130);

			//Huidige speler + 1
			if (i + 1 < settings.getPlayerList().size())
				g.drawString(settings.getPlayerList().get(i + 1).getName(), 225, 160);
		}

		if (playerInput)
		{
			g.setColor(new Color(227, 17, 17));
			g.drawString("Voer een naam in: " + newPlayer, 315, 370);
		}

		if (playerExists)
		{
			g.setColor(new Color(227, 17, 17));
			g.drawString("Speler bestaat al", 315, 370);
		}

		if (settings.getCurrentPlayer() != null)
		{
			g.setColor(new Color(112, 146, 227));
			g.drawString(settings.getCurrentPlayer().getName(), 350, 125);
			g.drawString("000:00:00", 460, 125);
			g.drawString(Integer.toString(settings.getCurrentPlayer().getCurrentLevel()), 580, 125);

		}
	}

	public void mouseClicked(MouseEvent e) //voor elke knop een apart event
	{
		if (e.getSource() == newPlayerKnop) //als er op "new player" geklikt wordt
		{
			//settings.createPlayer(new Player("Oscar", settings));
			playerInput = true;
			this.requestFocus();
			repaint();
		}
		else if (e.getSource() == skipLevelKnop) // als er op "skip level" geklikt wordt
		{
			System.out.println("level overslaan"); 
		}
		else if (e.getSource() == viewHighscoresKnop) // als er op "view highscores" geklikt wordt
		{

			this.setVisible(false);
			appPanel.add(highscoresPanel);
			highscoresPanel.setVisible(true);
		}
		else if (e.getSource() == helpKnop) //als er op "help" geklikt wordt
		{

			this.setVisible(false);
			appPanel.add(helpPanel);
			helpPanel.setVisible(true);
		}
		else if (e.getSource() == creditsKnop) //als er op "credits" geklikt wordt
		{

			this.setVisible(false);
			appPanel.add(creditsPanel);
			creditsPanel.setVisible(true);
		}
		else if (e.getSource() == startKnop) //als er op "start" geklikt wordt
		{
			if (settings.getCurrentPlayer() != null)
			{
				this.setVisible(false);
				appPanel.add(appPanel.getGamePanel());
				appPanel.repaint();
				appPanel.getGamePanel().startGame();
				appPanel.repaint();
			}

		}
		else if (e.getSource() == loadKnop) //als er op "load" geklikt wordt
		{
			System.out.println("spel laden");
		}
		else if (e.getSource() == levelOmhoogKnop) //als er op "level-list" (met de pijl omhoog) geklikt wordt
		{
			if (level > 0)
				level--;

			settings.getCurrentPlayer().setCurrentLevel(level);
			repaint();
		}
		else if (e.getSource() == levelOmlaagKnop) //als er op "level-list" (met de pijl omlaag) geklikt wordt
		{
			if (level < levelArray.size() - 1)
				level++;
			settings.getCurrentPlayer().setCurrentLevel(level);
			repaint();
		}
		else if (e.getSource() == spelerOmhoogKnop) //als er op "speler" (met de pijl omhoog) geklikt wordt
		{
			int i = settings.getPlayerList().indexOf(settings.getCurrentPlayer());
			if (i > 0)
				settings.setCurrentPlayer(settings.getPlayerList().get(i - 1));
			repaint();
		}
		else if (e.getSource() == spelerOmlaagKnop) //als er op "speler" (met de pijl omlaag) geklikt wordt
		{
			int i= settings.getPlayerList().indexOf(settings.getCurrentPlayer());
			if (i + 1 < settings.getPlayerList().size())
				settings.setCurrentPlayer(settings.getPlayerList().get(i + 1));
			repaint();
		}


	}
	public void mouseEntered(MouseEvent e) {} 
	public void mouseExited(MouseEvent e)  {} //deze worden niet gebruikt
	public void mousePressed(MouseEvent e)  {}
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_BACK_SPACE:
			if (newPlayer.length() > 0)
			{
				newPlayer = newPlayer.substring(0, newPlayer.length() -1).toString();
			}
			break;
		case KeyEvent.VK_ENTER:
			playerInput = false;
			playerExists = settings.checkPlayerExists(new Player(newPlayer));
			settings.createPlayer(new Player(newPlayer));
			newPlayer = "";
			break;
		case KeyEvent.VK_F8:
			new EditorApp();
			break;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (playerInput)
		{
			if (newPlayer.length() < 7)
			{
				if (Character.isLetter(e.getKeyChar()))
					newPlayer = newPlayer + e.getKeyChar();
			}
			repaint();
		}
	} 

	@Override
	public void setVisible(boolean visible)
	{
		super.setVisible(visible);
		if (visible)
		{
			requestFocus();
		}
	}
}