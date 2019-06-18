package com.company.tests;

import com.company.dto.SignUpForm;
import com.company.models.Car;
import com.company.repositories.CarRepository;
import com.company.repositories.IdGenerator;
import com.company.services.CarService;

public class MainCarsServiceTest {
    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator("users_id.txt");
        CarRepository carRepository = new CarRepository("Users.txt", idGenerator);
        CarService service = new CarService(CarRepository);
        SignUpForm form = new SignUpForm("Nissan", "Aidar");
        Car car = service.signUp(form);
        System.out.println(car);
    }
}
