package com.vegadelalyra.SpringBootMVCDemo;

import com.vegadelalyra.SpringBootMVCDemo.dto.AlienDTO;
import com.vegadelalyra.SpringBootMVCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class AlienController {

    @Autowired()
    AlienDTO alienDTO;

    @Autowired
    AlienRepository alienRepository;

    @GetMapping(path="aliens", produces = {"application/xml"})
    public List<Alien> getAliens() {
        System.out.println("get aliens method called!");
        return alienRepository.findAll();
    }

    @GetMapping("alien/{aid}")
    public AlienDTO getAlien(@PathVariable("aid") int aid) {

        Alien alien = alienRepository.getReferenceById(aid);
        alienDTO.setAid(alien.getAid());
        alienDTO.setAname(alien.getAname());

        return alienDTO;
    }

    @PostMapping(path = "alien", consumes = {"application/json"})
    public Alien addAlien(@RequestBody Alien alien) {
        alienRepository.save(alien);

        return alien;
    }
}
