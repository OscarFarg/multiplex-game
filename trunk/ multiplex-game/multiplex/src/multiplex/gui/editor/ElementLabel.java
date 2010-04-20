package multiplex.gui.editor;

import java.awt.Font;

import javax.swing.JTextField;

public class ElementLabel extends JTextField {
	public int x;
	public int y;
	
	public ElementLabel(int x, int y)
	{
		super(1);
		this.setFont(new Font(this.getFont().getFontName(), Font.BOLD, 15));
		this.setHorizontalAlignment(JTextField.CENTER);
		this.x = x;
		this.y = y;
		this.setBounds(x * 25, y * 25, 25, 25);
	}
}
