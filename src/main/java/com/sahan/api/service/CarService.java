package com.sahan.api.service;

import com.sahan.api.dao.CarRepository;
import com.sahan.api.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.findAll();

    }

    public Car get(int id){
        if (carRepository.findById(id).isPresent()){
            return carRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Car add(Car car){
        carRepository.save(car);
        return car;
    }


}
