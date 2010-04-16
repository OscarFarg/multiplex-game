package multiplex.gui;

import javax.swing.*;

import multiplex.gui.game.GamePlayPanel;
import multiplex.gui.main.MainPanel;

public class MultiplexApp extends JFrame
{
	private MainPanel mainPanel = new MainPanel();
	private GamePlayPanel gamePanel = new GamePlayPanel(this);
	
	public MultiplexApp()
	{
		this.setSize(648, 438);
		this.setLocation(300,100);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Multiplex v0.01");
		//this.setContentPane(mainPanel);
		this.setContentPane(gamePanel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MultiplexApp();
	}

}