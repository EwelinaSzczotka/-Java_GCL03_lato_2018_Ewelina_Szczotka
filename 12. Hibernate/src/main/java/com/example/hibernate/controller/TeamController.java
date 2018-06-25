
package com.example.hibernate.controller;

import com.example.hibernate.model.Player;
import com.example.hibernate.model.Team;
import com.example.hibernate.repository.TeamRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hibernate")
public class TeamController {
    
    @Autowired TeamRepository teamRepository;
    
    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
    
    @PostMapping("/team")
    public Team createTeam(@Valid @RequestBody Team team) {
        return teamRepository.save(team);
    }
    
    @PutMapping("/teams/{id}")
    public Team updateTeam(@PathVariable(value = "id") Long teamId,
                             @Valid @RequestBody Team teamDetails) {

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException());

        team.setName(teamDetails.getName());
        team.setPoints(teamDetails.getPoints());

        Team updatedTeam = teamRepository.save(team);
        return updatedTeam;
    }
    
    @DeleteMapping("/teams/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable(value = "id") Long teamId) {
        
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException());

        teamRepository.delete(team);

        return ResponseEntity.ok().build();
    }
    
}
