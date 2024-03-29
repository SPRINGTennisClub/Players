package com.aubert.players.controller;

import com.aubert.players.entity.Player;
import com.aubert.players.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ViewController {
  @Autowired PlayerService playerService;

  @Value("${displayed-name}")
  private String displayedName;

  @GetMapping("/homePage")
  public String homePage(Model model) {
    System.out.println("************************************" + displayedName);
    model.addAttribute("players", playerService.getPlayers());
    return "homePage";
  }

  @GetMapping("/showAddPlayer")
  public String initPlayer(Model model) {
    model.addAttribute("player", new Player("", "", 0, ""));
    return "addPlayer";
  }

  @PostMapping("/addPlayer")
  public String addPlayer(Model model, @ModelAttribute("player") Player newPlayer) {
    playerService.addPlayer(
        new Player(
            newPlayer.getNom(),
            newPlayer.getPrenom(),
            newPlayer.getAge(),
            newPlayer.getClassement()));
    return "redirect:/homePage";
  }

  @DeleteMapping("/removePlayer/{id}")
    public String removePlayer (@PathVariable int id){
      playerService.removePlayer(id);
      return "redirect:/homePage";
  }
}
