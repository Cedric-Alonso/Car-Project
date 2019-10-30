package com.cars.cars.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @Value("welcome yay =)")
    private String message;

    @Value("pas de mot de passe ou identifiant")
    private String errorMessage;

}