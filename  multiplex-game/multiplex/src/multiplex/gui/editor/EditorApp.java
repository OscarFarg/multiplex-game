package multiplex.gui.editor;

import javax.swing.JFrame;

public class EditorApp extends JFrame {
	
	public EditorApp()
	{
		this.setSize(800,600); 
		this.setLocation(300,100);
		this.setResizable(false);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new EditorPanel());
		this.setTitle("Multiplex v0.02 Editor");
		this.setVisible(true);
	}
}
