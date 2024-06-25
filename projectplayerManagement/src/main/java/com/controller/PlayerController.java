package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.PlayerNotFoundException;
import com.model.Player;
import com.service.PlayerService;
@CrossOrigin(origins ="http://localhost:4200/")
@RestController
public class PlayerController {
	@Autowired
	PlayerService playerService;

	@PostMapping("/add")
	public ResponseEntity<Player> savePlayer(@RequestBody Player p)
	{
		Player player=playerService.savePlayer(p);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "Player added").body(player);
	}
	@GetMapping("/getOne/{id}")
	public Player getOnePlayer(@PathVariable("id")int id)
	{
		return playerService.getOnePlayer(id);
	}
	@GetMapping("/getAll")
	public List<Player> getAllPlayer()
	{
		return playerService.getAllPlayer();
	}
	@DeleteMapping("/deleteOne/{id}")
	public void deletePlayer(@PathVariable("id")int id) throws PlayerNotFoundException
	{
		playerService.deletePlayer(id);
	}
	
	@PutMapping("/updatePlayer")
	public ResponseEntity<Player> updatePlayer(@RequestBody Player player)
	{
		Player p=playerService.updatePlayer(player);
		return ResponseEntity.status(HttpStatus.CREATED).header("update", "player updated").body(p);
	}
	
}
