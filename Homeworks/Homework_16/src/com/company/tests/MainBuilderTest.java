package com.company.tests;

import com.company.models.Car;

public class MainBuilderTest {

    public static void main(String[] args) {
        Car car = Car.builder()
                .model("Nissan")
                .carNumber(777)
                .driver("Aidar")
                .engine("Gasoline")
                .build();
    }
}
