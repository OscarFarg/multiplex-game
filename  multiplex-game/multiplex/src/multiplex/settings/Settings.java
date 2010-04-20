package multiplex.settings;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.tools.JavaFileManager.Location;

import multiplex.level.Level;
import multiplex.level.LevelMap;

public class Settings implements Serializable {

	private ArrayList<Level> levelList;
	private ArrayList<Player> playerList;
	private ArrayList<Player> rankingList;
	private Player currentPlayer;


	public Settings()
	{
		levelList = new ArrayList<Level>();
		playerList = new ArrayList<Player>();
		playerList = new ArrayList<Player>();
		createLevelList();
	}

	public void createLevelList()
	{
		levelList = new ArrayList<Level>();
		String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath().toString();
		path = path.replaceAll("%20"," ");
		path = path.substring(0, path.lastIndexOf("/"));
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		LevelMap map = new LevelMap();

		for (int i = 0; i < listOfFiles.length; i++)
		{
			String filename = listOfFiles[i].toString();
			System.out.println(filename);

			if (filename.substring( filename.length()- 4, filename.length()).equals(".lvl"))
			{
				try
				{
					ObjectInputStream objectLoader = new ObjectInputStream(new FileInputStream(filename));
					levelList.add(new Level((LevelMap) objectLoader.readObject()));
					objectLoader.close();
				}
				catch(IOException ex)
				{ System.out.println("error");} 
				catch (ClassNotFoundException e) 
				{ System.out.println("error");}
			}
		}
	}

	public boolean checkPlayerExists(Player player)
	{
		for (int i = 0; i < playerList.size(); i++)
		{
			if (playerList.get(i).getName().toLowerCase().equals(player.getName().toLowerCase()))
				return true;
		}
		return false;
	}

	public void createPlayer(Player player)
	{
		if (!checkPlayerExists(player))
		{
			if (!player.getName().equals(""))
			{
				playerList.add(player);
				if (currentPlayer == null)
					currentPlayer = player;
			}

		}
	}

	public ArrayList<Level> getLevelList() {
		return levelList;
	}

	public void setLevelList(ArrayList<Level> levelList) {
		this.levelList = levelList;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Player> getRankingList() {
		return rankingList;
	}

	public void setRankingList(ArrayList<Player> rankingList) {
		this.rankingList = rankingList;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}


}

