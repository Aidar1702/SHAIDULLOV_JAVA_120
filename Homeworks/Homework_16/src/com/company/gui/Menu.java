package com.company.gui;

import com.company.dto.SignUpForm;
import com.company.services.CarService;

import java.util.Scanner;

public class Menu {
    private int currentCommand;
    private CarService carService;
    private Scanner scanner = new Scanner(System.in);

    public Menu(CarService carService){
        this.carService = carService;
    }
    public void showMainMenu(){
        System.out.println("Добро пожаловать!");
        System.out.println("1. Регистрация");
        System.out.println("2. Просмотр всех машин");
        System.out.println("3. Выход");
        currentCommand = scanner.nextInt();
        processCommand();
    }

    private void processCommand() {
        if (currentCommand == 1) {
            showRegistrationMenu();
        } else if (currentCommand == 2) {
            showAllCars();
        }else{
            System.exit(0);

        }
    }
    public void showRegistrationMenu(){
        System.out.println("ВВедите модель машины");
        String model = scanner.next();
        System.out.println("ВВедите имя водителя");
        String driver = scanner.next();
        SignUpForm signUpForm = new SignUpForm(model,driver);
        carService.signUp(signUpForm);
        showMainMenu();
    }
    public void showAllCars(){

    }
}
