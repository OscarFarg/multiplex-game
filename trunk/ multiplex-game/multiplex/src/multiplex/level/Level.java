package multiplex.level;

import java.awt.Color;

import javax.swing.JPanel;

import multiplex.spelementen.*;

public class Level extends JPanel {

	public Level()
	{
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.add(new Murphy());
	}
}
