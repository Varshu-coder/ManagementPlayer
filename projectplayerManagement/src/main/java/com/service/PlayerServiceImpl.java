package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PlayerRepository;
import com.exception.PlayerNotFoundException;
import com.model.Player;
@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	PlayerRepository playerRepo;

	public Player savePlayer(Player player) {
		return playerRepo.save(player);
	}

	@Override
	public Player getOnePlayer(int id) {
		// TODO Auto-generated method stub
		return playerRepo.findById(id).orElse(null);
	}

	@Override
	public List<Player> getAllPlayer() {
		// TODO Auto-generated method stub
		return playerRepo.findAll();
	}

	@Override
	public Map<String, Object> deletePlayer(int id) throws PlayerNotFoundException {
		Map<String,Object> response=new HashMap<String,Object>();
		Player player=playerRepo.findById(id).orElseThrow();
		playerRepo.delete(player);
		return response;
	}

	@Override
	public Player updatePlayer(Player player) {
		Player p=playerRepo.findById(player.getPlayerId()).orElse(null);
		
		p.setPlayerName(player.getPlayerName());
		
		
		return playerRepo.save(p);
	}
		
}
