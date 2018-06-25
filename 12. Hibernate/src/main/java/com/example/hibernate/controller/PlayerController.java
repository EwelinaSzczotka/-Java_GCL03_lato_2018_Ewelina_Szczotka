/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.hibernate.controller;

import com.example.hibernate.model.Player;
import com.example.hibernate.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/hibernate")
public class PlayerController {
    
    @Autowired
    PlayerRepository playerRepository;
    
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    
    @PostMapping("/player")
    public Player createPlayer(@Valid @RequestBody Player player) {
        return playerRepository.save(player);
    }
    
    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable(value = "id") Long playerId,
                             @Valid @RequestBody Player playerDetails) {

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException());

        player.setName(playerDetails.getName());
        player.setNumber(playerDetails.getNumber());

        Player updatedPlayer = playerRepository.save(player);
        return updatedPlayer;
    }
    
    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable(value = "id") Long playerId) {
        
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException());

        playerRepository.delete(player);

        return ResponseEntity.ok().build();
    }
}
