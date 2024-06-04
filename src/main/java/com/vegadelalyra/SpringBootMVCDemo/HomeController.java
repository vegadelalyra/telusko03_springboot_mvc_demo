package com.vegadelalyra.SpringBootMVCDemo;

import com.vegadelalyra.SpringBootMVCDemo.model.Alien;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("name", "Aliens!");
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("home page requested");

        return "index";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) {

        int num3 = i + j;
        m.addAttribute("num3", num3);

        return "result";
    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute Alien a) {
        return "alienator";
    }
}
