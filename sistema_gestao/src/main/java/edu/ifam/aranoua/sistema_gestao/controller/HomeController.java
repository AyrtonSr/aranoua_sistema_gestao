package edu.ifam.aranoua.sistema_gestao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String init(){
        System.out.println("Testando HomeController");
        return "Testando HomeController";
    }
}
