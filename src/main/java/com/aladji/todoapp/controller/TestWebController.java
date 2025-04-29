package com.aladji.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(path = {"/test"})
public class TestWebController {

    // bienvenu.html (01)
    // Liens pour page 02 et 03
    @GetMapping(path = {"/test"}) // http://localhost:8989/test
    public String pageBienvenu() {
        return "bienvenu";
    }

    // produit.html (02)
    @GetMapping(path = {"/test/produits"}) // http://localhost:8989/test/produits
    public String pageProduit() {
        return "mes_tests/produit";
    }

    // conseil.html (03)
    @GetMapping(path = {"/test/conseil"})
    public String pageConseil() {
        return "mes_tests/conseil";
    }
}
