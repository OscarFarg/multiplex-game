package test;

import javax.swing.JFrame;

public class TestApp {
	
	public TestApp()
	{
		JFrame testFrame = new JFrame();
		testFrame.setTitle("Test");
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setSize(300, 300);
		testFrame.setLocation(300, 300);
		testFrame.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestApp();
	}

}
