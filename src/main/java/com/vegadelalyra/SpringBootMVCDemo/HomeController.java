package com.vegadelalyra.SpringBootMVCDemo;

import com.vegadelalyra.SpringBootMVCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    AlienRepository alienRepository;

    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("name", "Aliens!");
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("home page requested");

        return "index";
    }

    @GetMapping("getAliens")
    public String getAliens(Model m) {

        m.addAttribute("result", alienRepository.findAll());

        return "alienator";
    }

    @GetMapping("getAlien")
    public String getAlien(@RequestParam int aid, Model m) {

        m.addAttribute("result", alienRepository.getReferenceById(aid));

        return "result";
    }

    @GetMapping("getAlienByName")
    public String getAlienByName(@RequestParam String aname, Model m) {

        m.addAttribute("result", alienRepository.find(aname));

        return "result";
    }


    @PostMapping(value="addAlien")
    public String addAlien(@ModelAttribute Alien a) {

        alienRepository.save(a);
        return "alienator";
    }
}
