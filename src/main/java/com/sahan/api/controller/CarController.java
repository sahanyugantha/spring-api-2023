package com.sahan.api.controller;

import com.sahan.api.model.Car;
import com.sahan.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars(){
       // System.out.println("reach 1"+carService.get());
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Object getCar(@PathVariable("id") int id){
        if (carService.get(id) != null){
            return carService.get(id);
        } else {
            Map<String,String> msg = new HashMap<>();
            msg.put("ERROR", "Invalid ID");
            return msg;
        }
    }

    @PostMapping
    public Map<String,String> addCar(@RequestBody Car car){
        Map<String,String> msg = new HashMap<>();
        if (carService.add(car) != null){
            msg.put("SUCCESS", "Car item added");
        } else {
            msg.put("ERROR", "Invalid input");
        }
        return msg;
    }

}
