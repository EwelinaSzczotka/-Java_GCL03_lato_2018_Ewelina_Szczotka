
package com.example.hibernate.repository;

import com.example.hibernate.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long>{
}
