package multiplex.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class MultiplexApp extends JFrame implements WindowListener
{

	private AppPanel appPanel = new AppPanel();
	
	public MultiplexApp()
	{

		this.setSize(648,428); 
		this.setLocation(300,100);
		//this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Multiplex v0.02");
		this.setContentPane(appPanel);
		this.setVisible(true);
		this.addWindowListener(this);
		
	}
	
	public static void main(String[] args) {
		new MultiplexApp();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		appPanel.getMainPanel().saveSettings();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

