package com.consume.API.consume.controller;

import com.consume.API.consume.model.Car;
import com.consume.API.consume.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    CarService carService;

    // Injectez (inject) via application.properties.
    @Value("welcome yay =)")
    private String message;

    @Value("pas de mot de passe ou identifiant")
    private String errorMessage;

    @GetMapping("/carList" )
    public String carList(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "carList";
    }

    @GetMapping("/carList/{id}")
    public String carDetail(Model model, @PathVariable int id){
        model.addAttribute("car", carService.getById(id));
        return "carDetail";
    }

    @GetMapping("/carList/add")
    public String addCar(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("errorMessage", null);
        model.addAttribute("type","add");
        return "carForm";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car){
        if(car.getBrand() != null && car.getBrand().length() > 0 && car.getCarmodel() != null && car.getCarmodel().length() > 0 && car.getPrice() != 0){
            carService.save(car);
            return "redirect:/carList";
        }
        return "redirect:/carList/add";
    }

    @GetMapping("/carList/{id}/update")
    public String modifCar( @PathVariable int id, Model model ){
        Car car = carService.getById(id);
        model.addAttribute("car", car);
        model.addAttribute("errorMessage", null);
        model.addAttribute("type","modif");
        return "carForm";
    }

    @PostMapping("/saveUpdate")
    public String saveModif(@ModelAttribute("car") Car car){
        if(car.getBrand() != null && car.getBrand().length() > 0 && car.getCarmodel() != null && car.getCarmodel().length() > 0 && car.getPrice() != 0){
            carService.modify(car);
            return "redirect:/carList";
        }
        return "carList/modify";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar( @PathVariable int id, Model model ){
        carService.delete(id);
        return "redirect:/carList";
    }

}