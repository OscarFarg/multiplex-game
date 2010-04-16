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
		newPlayerKnop.setBounds(0,0,153,22);
		
		skipLevelKnop = new JLabel();
		this.add(skipLevelKnop);
		skipLevelKnop.addMouseListener(this);
		skipLevelKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/skipLevelKnop.png")));
		skipLevelKnop.setBounds(0,50,147,24);
		
		viewHighscoresKnop = new JLabel();
		viewHighscoresKnop.addMouseListener(this);
		this.add(viewHighscoresKnop);
		viewHighscoresKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/viewHighscoresKnop.png")));
		viewHighscoresKnop.setBounds(0,100,223,26);
		
		helpKnop = new JLabel();
		helpKnop.addMouseListener(this);
		this.add(helpKnop);
		helpKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/helpKnop.png")));
		helpKnop.setBounds(0,150,87,26);
		
		creditsKnop = new JLabel();
		creditsKnop.addMouseListener(this);
		this.add(creditsKnop);
		creditsKnop.setIcon(new ImageIcon(getClass().getClassLoader().getResource("multiplex/spelementen/images/creditsKnop.png")));
		creditsKnop.setBounds(0,200,122,24);
		
		setVisible(true);
	}
	
}
