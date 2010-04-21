package multiplex.gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import multiplex.gui.editor.EditorApp;
import multiplex.gui.game.GamePlayPanel;
import multiplex.gui.main.MainPanel;

public class AppPanel extends JPanel {

	private MainPanel mainPanel = new MainPanel(this);
	private GamePlayPanel gamePanel = new GamePlayPanel(this);
	private Action showHelp, showThreads, showEditor;

	public AppPanel()
	{
		this.setLayout(null);
		//this.add(gamePanel); //opstarten in level
		this.add(mainPanel); //opstarten in menu
		this.createAction();
		this.setFocusable(true);

		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "showHelp");
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F8"), "showEditor");
		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("F12"), "showThreads");

		this.getActionMap().put("showHelp", showHelp);
		this.getActionMap().put("showEditor", showEditor);
		this.getActionMap().put("showThreads", showThreads);
	}

	public void createAction()
	{
		showHelp = new AbstractAction(){
			public void actionPerformed(ActionEvent e)
			{
				if (gamePanel.getLevelPanel().getCurrentLevel() != null && 
						gamePanel.getLevelPanel().getCurrentLevel().isPlaying())
				{
					if (gamePanel.getLevelPanel().getCurrentLevel().isPaused())
					{
						mainPanel.removeHelp();
						mainPanel.setVisible(false);
						gamePanel.setVisible(true);
						gamePanel.getLevelPanel().getCurrentLevel().getMurphy().requestFocus();
						gamePanel.getLevelPanel().getCurrentLevel().resumeGame();
					}
					else
					{
						gamePanel.getLevelPanel().getCurrentLevel().pauseGame();
						gamePanel.setVisible(false);
						mainPanel.setVisible(true);
						mainPanel.showHelp();
					}
				}
			}
		};
		
		showThreads = new AbstractAction(){

			public void actionPerformed(ActionEvent e) {
				getThreads();
			}
		};
		
		showEditor = new AbstractAction(){

			public void actionPerformed(ActionEvent e) {
				new EditorApp();
			}
		};
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public GamePlayPanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePlayPanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void getThreads()
	{
		// Walk up all the way to the root thread group
		ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
		ThreadGroup parent;
		while ((parent = rootGroup.getParent()) != null) {
			rootGroup = parent;
		}

		listThreads(rootGroup, "");

	}

	public static void listThreads(ThreadGroup group, String indent) {
		System.out.println(indent + "Group[" + group.getName() + 
				":" + group.getClass()+"]");
		int nt = group.activeCount();
		Thread[] threads = new Thread[nt*2 + 10]; //nt is not accurate
		nt = group.enumerate(threads, false);

		// List every thread in the group
		for (int i=0; i<nt; i++) {
			Thread t = threads[i];
			System.out.println(indent + "  Thread[" + t.getName() 
					+ ":" + t.getClass() + "]");
		}

		// Recursively list all subgroups
		int ng = group.activeGroupCount();
		ThreadGroup[] groups = new ThreadGroup[ng*2 + 10];
		ng = group.enumerate(groups, false);

		for (int i=0; i<ng; i++) {
			listThreads(groups[i], indent + "  ");
		}
	}
}
