package com.bakigoal.controller;

import com.bakigoal.dao.entity.Player;
import com.bakigoal.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ilmir on 27.06.16.
 */
@RestController
@RequestMapping(value = "/rest")
public class MyRestController {

  @Autowired
  private PlayerService playerService;

  @GetMapping(value = "/players")
  public List<Player> getPlayers() {
    return playerService.getAll();
  }

  @GetMapping(value = "/players/{id}")
  public Player getPlayer(@PathVariable("id") Long id) {
    return playerService.getPlayerById(id);
  }

  @PostMapping(value = "/players")
  public Player addPlayer(@RequestBody Player player) {
    return playerService.addPlayer(player);
  }

  @PutMapping(value = "/players/{id}")
  public Player updatePlayer(@RequestBody Player player, @PathVariable("id") Long id) {
    Player playerById = playerService.getPlayerById(id);
    if (player == null || playerById == null) {
      return null;
    }
    playerById.setFirstName(player.getFirstName());
    playerById.setLastName(player.getLastName());
    playerById.setNumber(player.getNumber());
    playerService.updatePlayer(playerById);
    return playerById;
  }

  @DeleteMapping(value = "/players/{id}")
  public void deletePlayer(@PathVariable("id") Long id) {
    playerService.deletePlayer(id);
  }

  @GetMapping(value = "/customers")
  public String jsonString() {
    return "{\n" +
        "  \"records\": [\n" +
        "    {\n" +
        "      \"Name\": \"Alfreds Futterkiste\",\n" +
        "      \"City\": \"Berlin\",\n" +
        "      \"Country\": \"Germany\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"Name\": \"Ana Trujillo Emparedados y helados\",\n" +
        "      \"City\": \"México D.F.\",\n" +
        "      \"Country\": \"Mexico\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"Name\": \"Antonio Moreno Taquería\",\n" +
        "      \"City\": \"México D.F.\",\n" +
        "      \"Country\": \"Mexico\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"Name\": \"Around the Horn\",\n" +
        "      \"City\": \"London\",\n" +
        "      \"Country\": \"UK\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"Name\": \"Comércio Mineiro\",\n" +
        "      \"City\": \"São Paulo\",\n" +
        "      \"Country\": \"Brazil\"\n" +
        "    }\n" +
        "  ]\n" +
        "}";
  }
}
