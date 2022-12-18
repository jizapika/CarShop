package com.jizapika.carShop.controllers;

import com.jizapika.carShop.domain.Car;
import com.jizapika.carShop.domain.Seller;
import com.jizapika.carShop.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private CarRepo carRepo;

    @GetMapping("/")
    public String carShop(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Car> cars = carRepo.findAll();
        model.put("cars", cars);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @RequestParam String color,
            @RequestParam Integer price,
            @AuthenticationPrincipal Seller seller,
            Map<String, Object> model) {
        Car car = new Car(color, price, seller);
        carRepo.save(car);
        Iterable<Car> cars = carRepo.findAll();
        model.put("cars", cars);
        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String color, Map<String, Object> model) {
        Iterable<Car> cars;

        if (color != null && !color.isEmpty()) {
            cars = carRepo.findByColor(color);
        }
        else {
            cars = carRepo.findAll();
        }

        model.put("cars", cars);
        return "filter";
    }
}