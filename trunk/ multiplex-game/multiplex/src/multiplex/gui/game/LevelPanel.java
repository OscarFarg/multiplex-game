package multiplex.gui.game;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import multiplex.gui.AppPanel;
import multiplex.level.Level;
import multiplex.spelementen.SpelElement;


public class LevelPanel extends JPanel implements ActionListener {

	private Level currentLevel;
	private AppPanel appPanel;
	private Timer updateDataPanelTimer;

	public LevelPanel(AppPanel appPanel)
	{
		this.appPanel = appPanel;
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		updateDataPanelTimer = new Timer(250, this);

		AbstractAction saveGame = new AbstractAction(){

			public void actionPerformed(ActionEvent e) {
				saveGame();
			}
		};

		AbstractAction loadGame = new AbstractAction(){

			public void actionPerformed(ActionEvent e) {
				loadGame();
			}
		};
		
	

		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("F3"), "saveGame");
		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("F4"), "loadGame");

		this.getActionMap().put("saveGame", saveGame);
		this.getActionMap().put("loadGame", loadGame);

	}

	public void startGame()
	{
		this.currentLevel = new Level(appPanel, appPanel.getMainPanel().getSettings().getLevelList().get(appPanel.getMainPanel().getSettings().getCurrentPlayer().getCurrentLevel()));
		//this.setSize(currentLevel.getWidth() + 10, currentLevel.getHeight() + 10);
		currentLevel.setLocation(5, 5);
		this.add(currentLevel);
		currentLevel.startLevel();
		updateDataPanelTimer.start();
	}

	public void endGame()
	{
		this.remove(currentLevel);
		updateDataPanelTimer.stop();
	}

	public void saveGame()
	{
		currentLevel.pauseGame();
		FileDialog fDialog = new FileDialog(new JFrame(), "Bestand opslaan...", FileDialog.SAVE);
		fDialog.setVisible(true);

		String bestandsnaam = fDialog.getDirectory() + fDialog.getFile();
		try
		{
			currentLevel.getMurphy().removeKeyListener(currentLevel.getMurphy());
			ObjectOutputStream objectSaver = new ObjectOutputStream(new FileOutputStream(bestandsnaam));
			objectSaver.writeObject(currentLevel);
			objectSaver.close();
		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Er is een fout opgetreden bij het schrijven.", 
					"Bewaren van het spel is mislukt.", JOptionPane.ERROR_MESSAGE);
		} finally
		{
			currentLevel.getMurphy().addKeyListener(currentLevel.getMurphy());
		}
		currentLevel.resumeGame();
	}

	public void loadGame()
	{
		currentLevel.pauseGame();

		FileDialog fDialog = new FileDialog(new JFrame(), "Bestand laden...", FileDialog.LOAD);
		fDialog.setVisible(true);

		String bestandsnaam = fDialog.getDirectory() + fDialog.getFile();

		try {
			this.remove(currentLevel);
			ObjectInputStream objectLoader = new ObjectInputStream(new FileInputStream(bestandsnaam));
			currentLevel = (Level) objectLoader.readObject();
			currentLevel.getMurphy().addKeyListener(currentLevel.getMurphy());
			for (SpelElement e : currentLevel.getElementList())
			{
				e.restart();
			}
			this.add(currentLevel);
			repaint();
		} 
		catch (IOException ioEx){} 
		catch (ClassNotFoundException classEx) {}
		currentLevel.resumeGame();
	}
	
	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		appPanel.getGamePanel().getLevelDataPanel().setInfotronCount(currentLevel.getAantalInfotrons());
	}
}
