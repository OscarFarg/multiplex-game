package multiplex.settings;

import java.util.ArrayList;

import multiplex.level.Level;

public class Settings {
	
	private ArrayList<Level> levelList;
	private ArrayList<Player> playerList;
	private ArrayList<Level> rankingList;
	private Player currentPlayer;
	
	public void checkPlayerExists()
	{
		
	}
	
	public void createPlayer()
	{
		
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

	public ArrayList<Level> getRankingList() {
		return rankingList;
	}

	public void setRankingList(ArrayList<Level> rankingList) {
		this.rankingList = rankingList;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	

}

