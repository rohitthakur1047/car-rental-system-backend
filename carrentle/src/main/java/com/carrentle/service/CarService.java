package com.carrentle.service;

import com.carrentle.entity.Car;
import com.carrentle.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findByIsDeletedFalse();
    }

    public void deleteCar(Long id) {
        Car car = carRepository.findById(id).get();
        car.setIsDeleted(true);
        carRepository.save(car);
    }
}