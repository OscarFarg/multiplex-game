package multiplex.gui;

import javax.swing.*;

public class MultiplexApp extends JFrame
{

	private AppPanel appPanel = new AppPanel();
	
	public MultiplexApp()
	{

		this.setSize(652, 438); //438
		this.setLocation(300,100);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Multiplex v0.01");
		this.setContentPane(appPanel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MultiplexApp();
	}

}

