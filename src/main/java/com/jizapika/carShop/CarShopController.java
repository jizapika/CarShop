package com.jizapika.carShop;

import com.jizapika.carShop.domain.Car;
import com.jizapika.carShop.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CarShopController {
    @Autowired
    private CarRepo carRepo;

    @GetMapping("/carShop")
    public String carShop(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "carShop";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Car> cars = carRepo.findAll();
        model.put("cars", cars);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String color, @RequestParam Integer price, Map<String, Object> model) {
        Car car = new Car(color, price);
        carRepo.save(car);
        Iterable<Car> cars = carRepo.findAll();
        model.put("cars", cars);
        return "main";
    }

    @PostMapping("filter")
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