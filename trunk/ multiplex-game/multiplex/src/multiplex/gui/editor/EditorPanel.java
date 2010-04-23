package multiplex.gui.editor;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import multiplex.level.LevelMap;

public class EditorPanel extends JPanel implements ActionListener {
	
	private JButton saveButton;
	private JButton loadButton;
	private JButton changeSizeButton;
	
	private JTextField levelWidth;
	private JTextField levelHeight;

	private LevelPanel levelPanel;
	
	public EditorPanel()
	{
		this.setLayout(new BorderLayout());
		saveButton = new JButton("Opslaan");
		loadButton = new JButton("Laden");
		changeSizeButton = new JButton("Wijzigen");

		
		levelWidth = new JTextField("12", 4);
		levelHeight = new JTextField("10", 4);
		
		levelPanel = new LevelPanel();
		
		saveButton.addActionListener(this);
		loadButton.addActionListener(this);
		changeSizeButton.addActionListener(this);
		
		JPanel knoppenBalk = new JPanel();
		knoppenBalk.add(saveButton);
		knoppenBalk.add(loadButton);
		knoppenBalk.add(new JLabel("Breedte:"));
		knoppenBalk.add(levelWidth);
		knoppenBalk.add(new JLabel("Hoogte:"));
		knoppenBalk.add(levelHeight);
		knoppenBalk.add(changeSizeButton);

		
		
		this.add(knoppenBalk, BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getViewport().add(levelPanel, null);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	public void saveMap()
	{
		try
		{
			String bestandsnaam = (JOptionPane.showInputDialog(null, "Voer een levelnaam in", "Level naam") + ".lvl");
			//TODO terug veranderen. /home/oscar/" toevoegen aan bestandsnaam.
			ObjectOutputStream objectSaver = new ObjectOutputStream(new FileOutputStream("C:/downloads/" + bestandsnaam));
			levelPanel.createLevelMap();
			levelPanel.getLevelMap().setLevelName(bestandsnaam.substring(0, bestandsnaam.lastIndexOf(".")));
			objectSaver.writeObject(levelPanel.getLevelMap());
			objectSaver.close();
		}
		catch(IOException ex)
		{
			System.out.println(ex.getStackTrace());
			JOptionPane.showMessageDialog(null, "Er is een fout opgetreden bij het schrijven.", 
					"Bewaren van het spel is mislukt.", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void loadMap()
	{
		FileDialog fDialog = new FileDialog(new JFrame(), "Open bestand", FileDialog.LOAD);
		fDialog.setVisible(true);
		String bestandsnaam = fDialog.getDirectory() + fDialog.getFile();
		try
		{
				ObjectInputStream objectLoader = new ObjectInputStream(new FileInputStream(bestandsnaam));
				levelPanel.setLevelMap((LevelMap) objectLoader.readObject());
				levelPanel.addLabels();
				objectLoader.close();

		}
		catch(IOException ex)
		{
			JOptionPane.showMessageDialog(null, "Er is een fout opgetreden bij het laden.", 
					"Laden van het spel is mislukt.", JOptionPane.WARNING_MESSAGE);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Er is een fout opgetreden bij het laden.", 
					"Laden van het spel is mislukt.", JOptionPane.WARNING_MESSAGE);
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveButton)
		{
			saveMap();
		}
		if (e.getSource() == loadButton)
		{
			loadMap();

		}
		if (e.getSource() == changeSizeButton)
		{
			levelPanel.getLevelMap().setLevelWidth(Integer.parseInt(levelWidth.getText()));
			levelPanel.getLevelMap().setLevelHeight(Integer.parseInt(levelHeight.getText()));

			levelPanel.addLabels();
			
		}
	}

}
