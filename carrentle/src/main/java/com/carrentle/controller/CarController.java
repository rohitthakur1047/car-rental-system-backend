package com.carrentle.controller;

import com.carrentle.entity.Car;
import com.carrentle.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        carService.deleteCar(id);
        return "Deleted";
    }
}
