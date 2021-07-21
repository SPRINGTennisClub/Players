package com.aubert.players.controller;

import com.aubert.players.entity.Player;
import com.aubert.players.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ViewController {
  @Autowired PlayerService playerService;

  @GetMapping("/homePage")
  public String homePage(Model model) {
    model.addAttribute("players", playerService.getPlayers());
    return "homePage";
  }

  @GetMapping("/showAddPlayer")
  public String initPlayer(Model model) {
    model.addAttribute("player", new Player(0, "", "", 0, ""));
    return "addPlayer";
  }

  @PostMapping("/addPlayer")
  public String addPlayer(Model model, @ModelAttribute("player") Player newPlayer) {
    playerService.addPlayer(
        new Player(
            newPlayer.getId(),
            newPlayer.getNom(),
            newPlayer.getPrenom(),
            newPlayer.getAge(),
            newPlayer.getClassement()));
    return "redirect:/homePage";
  }
}
