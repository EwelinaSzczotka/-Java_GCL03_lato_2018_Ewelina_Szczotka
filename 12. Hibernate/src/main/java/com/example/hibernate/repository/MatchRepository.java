
package com.example.hibernate.repository;

import com.example.hibernate.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchRepository extends JpaRepository<Match,Long> {
    
}
