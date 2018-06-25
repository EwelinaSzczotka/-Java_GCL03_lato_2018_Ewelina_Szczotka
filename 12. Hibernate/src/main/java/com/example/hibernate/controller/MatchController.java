
package com.example.hibernate.controller;

import com.example.hibernate.model.Match;
import com.example.hibernate.repository.MatchRepository;
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
public class MatchController {
    
    @Autowired MatchRepository matchRepository;
    
    @GetMapping("/matches")
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
    
    @PostMapping("/match")
    public Match createMatch(@Valid @RequestBody Match match) {
        return matchRepository.save(match);
    }
    
    @PutMapping("/matches/{id}")
    public Match updateMatch(@PathVariable(value = "id") Long matchId,
                             @Valid @RequestBody Match matchDetails) {

        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new IllegalArgumentException());

        match.setDate(matchDetails.getDate());
        match.setHost(matchDetails.getHost());
        match.setGuest(matchDetails.getGuest());

        Match updatedMatch = matchRepository.save(match);
        return updatedMatch;
    }
    
    @DeleteMapping("/matches/{id}")
    public ResponseEntity<?> deleteMatch(@PathVariable(value = "id") Long matchId) {
        
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new IllegalArgumentException());

        matchRepository.delete(match);

        return ResponseEntity.ok().build();
    }
    
}
