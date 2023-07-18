package com.malak.gameAPI.repositories;

import com.malak.gameAPI.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    Player getById(int id);

    void deleteByName(String name);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Player a WHERE a.id = :id")
    void delByID(@Param("id") Integer id);

}
