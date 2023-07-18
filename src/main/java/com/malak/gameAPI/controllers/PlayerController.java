package com.malak.gameAPI.controllers;

import com.malak.gameAPI.models.Player;
import com.malak.gameAPI.services.PlayerService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping(path = "{id}")
    public Player getSpecificPlayer(@PathVariable(name = "id") int id) {
        Player playerFound = null;
        if (Strings.isNotBlank(String.valueOf(id))){
            playerFound = playerService.getSpecificPlayer(id);
        }
        return playerFound;
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player incomingPlayer) {
        return playerService.createPlayer(incomingPlayer);
    }

//    @PutMapping(path = "{id}")
//    public Player updatePlayer(@PathVariable(name = "id") String id, @RequestBody Player incomingUpdatedPlayer) {
//        return playerService.updatePlayer(id, incomingUpdatedPlayer);
//    }
@PutMapping(path = "{id}")
    public ResponseEntity<Player> updateProduct(@PathVariable int id, @RequestBody Player updatedProduct) {
    Player response = playerService.updatePlayer(id, updatedProduct);
    System.out.println("this is the responed" +response);
        if (response != null) {

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




//    @GetMapping  (path = "{lsitID}")
//    public String deleteLissd(@PathVariable int lsitID) {
//
//        return playerService.deletePlayer(lsitID);
//
//    }


    @GetMapping  ("/hell")
    public String deleteLisd() {

        return playerService.deletePlayer(20);

    }

    @DeleteMapping("/{id}")
    public String deletePersonByName(@PathVariable int id) {
        return playerService.deletePlayer(id);

    }
}
