package com.projectSpringTeste.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/greeting")
    public String greeting() {
        return "Funcionando";
    }
}
