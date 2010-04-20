package multiplex.settings;

import java.io.Serializable;
import java.util.ArrayList;
import multiplex.level.Level;

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
		//createPlayerList();
	}

	private void createLevelList()
	{
		String[] levelNames = {"Level Janneke","Level Hanno","Level Oscar","Level Test", "Level 5", "Level 6", 
				"Level 7", "Level 8", "Level 9", "Level 10", "Level 11"};
		for (int i = 0; i <= 10; i ++)
			levelList.add(new Level(levelNames[i]));
	}
	
	private void createPlayerList()
	{
		String[] playerNames = {"Oscar", "Hanno", "Janneke"};
		for (int i = 0; i < 3; i++)
		{
			playerList.add(new Player(playerNames[i], this));
		}
		currentPlayer = playerList.get(0);
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

