package com.service;

import java.util.List;
import java.util.Map;

import com.exception.PlayerNotFoundException;
import com.model.Player;

public interface PlayerService {
	
	public Player savePlayer(Player player);
	
	public  Player getOnePlayer(int id);
	
	public List<Player> getAllPlayer();
	
	public Player updatePlayer(Player player);
	
	public Map<String,Object> deletePlayer(int id) throws PlayerNotFoundException;

}
