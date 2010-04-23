package multiplex.gui.editor;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class ElementLabel extends JTextField implements FocusListener {
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
		this.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		this.selectAll();
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
