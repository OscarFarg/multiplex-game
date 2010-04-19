package multiplex.gui.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import multiplex.level.Level;

public class LevelDataPanel extends JPanel {
	
	private Level currentLevel;
	private int infotronCount = 0;
	
	public LevelDataPanel(Level level)
	{
		this.currentLevel = level;
		this.setBackground(Color.BLACK);
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//Teken het achtergrond plaatje
		g.drawImage(createImageIcon("leveldata.png").getImage(), 0, 0, getWidth(), 48, this);
		
		//Teken de tekst
		g.setColor(new Color(227, 17, 17));
		g.setFont(new Font("Lucida Sans", Font.BOLD, 16 ));
		
		//Naam vakje
		g.drawString("Naam", 145, 19);
		
		//Tijd vakjes
		g.drawString("00", 322, 20);
		g.drawString("00", 371, 20);
		g.drawString("00", 419, 20);
		
		g.setColor(new Color(112, 146, 227));

		//Level Nr
		g.drawString("001", 34, 42);
		
		//Level Naam
		g.drawString("----- TEST LEVEL -----", 130, 42);
		
		//Infotron count
		g.drawString(Integer.toString(infotronCount), 546, 42);
		
		
		
	}
	
	protected ImageIcon createImageIcon(String path)
	{
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		}
		else {
			System.err.println("Kan bestand niet vinden: " + path);
			return null;
		}
	}

	public int getInfotronCount() {
		return infotronCount;
	}

	public void setInfotronCount(int infotronCount) {
		this.infotronCount = infotronCount;
		repaint();
	}

	
}
