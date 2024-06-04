package com.vegadelalyra.SpringBootMVCDemo;

import com.vegadelalyra.SpringBootMVCDemo.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlienRepository extends JpaRepository<Alien, Integer> {
    List<Alien> findByAnameOrderByAid(String aname); // Query DSL

    @Query("from Alien where aname=:name")
    List<Alien> find(@Param("name") String aname);
}
