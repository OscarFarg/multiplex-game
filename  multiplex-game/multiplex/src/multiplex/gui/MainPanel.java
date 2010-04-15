package multiplex.gui;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel
{
	private JButton newPlayerKnop, skipLevelKnop, viewHighscores, helpKnop, creditsKnop;
	private ImageIcon newPlayer;

	public MainPanel()
	{
		setLayout(null);
		setBackground(new Color(82, 82, 82));
		newPlayer = new ImageIcon("images/newPlayer.png");
		newPlayerKnop = new JButton(newPlayer);
		add(newPlayerKnop, 0, 0);
	}
}
