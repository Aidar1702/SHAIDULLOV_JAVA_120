package com.company.Client;

import com.company.gui.Menu;
import com.company.repositories.CarRepository;
import com.company.repositories.IdGenerator;
import com.company.services.CarService;

public class Application {
    public static void main(String[] args) {
       IdGenerator idGenerator = new IdGenerator("user_id.txt");
       CarRepository carRepository = new CarRepository();
       CarService carServices = new CarService(carRepository);
       Menu menu = new Menu();
       while(true){
           menu.showMainMenu();
       }
    }
}
