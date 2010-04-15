package multiplex.gui;

import java.awt.Color;
import javax.swing.*;


public class MultiplexApp extends JFrame
{
	private MainPanel mainPanel = new MainPanel();
	private GamePlayPanel gamePanel = new GamePlayPanel(this);
	
	public MultiplexApp()
	{
		this.setSize(640, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(gamePanel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MultiplexApp();
	}

}
