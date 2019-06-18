package com.company.services;

import com.company.dto.SignUpForm;
import com.company.models.Car;
import com.company.repositories.CarRepository;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository){

        this.carRepository = carRepository;
    }


    public Car signUp(SignUpForm form) {
        Car car = Car.builder()
                .model(form.getModel())
                .driver(form.getDriver())
                .build();
        carRepository.save(car);
        return car;
    }
}
