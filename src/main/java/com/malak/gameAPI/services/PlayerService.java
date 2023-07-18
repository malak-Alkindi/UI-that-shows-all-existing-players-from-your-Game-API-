package com.malak.gameAPI.services;

import com.malak.gameAPI.models.Player;
import com.malak.gameAPI.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getSpecificPlayer(String playerId) {
        Player foundPlayer = null;
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);

        if(optionalPlayer.isPresent()) {
            foundPlayer = optionalPlayer.get();
        }
        return foundPlayer;
    }

    public Player createPlayer(@RequestBody Player incomingPlayer) {
        return playerRepository.save(incomingPlayer);
    }

//    public Player updatePlayer(@PathVariable(name = "id") String playerId, @RequestBody Player incomingUpdatedPlayer) {
//        Player existingPlayer = getSpecificPlayer(playerId);
//
//        existingPlayer.name = incomingUpdatedPlayer.name;
//        return playerRepository.save(existingPlayer);
//    }

//    public Player deletePlayer(@PathVariable(name = "id") int id) {
//        Player existingPlayer = getSpecificPlayer(String.valueOf(id));
//        if(existingPlayer != null) {
//            playerRepository.delete(existingPlayer);
//        }
//        return existingPlayer;
//    }


    public Player updatePlayer(int id, Player updatedProduct) {
        Optional<Player> optionalProduct = Optional.ofNullable(playerRepository.getById(id));
        if (optionalProduct.isPresent()) {
            Player product = optionalProduct.get();
            product.id=updatedProduct.id;
            product.name=updatedProduct.name;
            product.gender=updatedProduct.gender;
            product.country=updatedProduct.country;
            playerRepository.save(product);
            return playerRepository.getById(id);
        }
        return null;
    }



    public String deletePlayer(Integer id) {

        playerRepository.delByID(Integer.valueOf(id));
            return "palyer delated";

    }

    public void deletePersonByName(String name) {
        playerRepository.deleteByName(name);
    }

}
