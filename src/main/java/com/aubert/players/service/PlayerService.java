package com.aubert.players.service;

import com.aubert.players.dao.PlayerRepository;
import com.aubert.players.entity.Player;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
  @Autowired private PlayerRepository playerRepository;

  public List<Player> getPlayers() {
    return playerRepository.findAll();
  }

  public void addPlayer(Player newPlayer) {
    playerRepository.save(newPlayer);
  }

  public void removePlayer(int id){
      playerRepository.deleteById(id);
  }
}
