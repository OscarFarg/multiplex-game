package test;

import javax.swing.JFrame;

public class TestApp extends JFrame {
	
	public TestApp()
	{
		setLayout(null);
		setSize(850, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Scroll Level Test");
		setVisible(true);
		add(new TestPanel(this));
	}
	
	public static void main(String args[])
	{
		new TestApp();
	}

}
