package com.company.repositories;

import com.company.models.Car;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CarRepository {
    private String filename;
    private IdGenerator idGenerator;

    public CarRepository( String filename, IdGenerator idGenerator){
        this.filename = filename;
        this.idGenerator = idGenerator;
    }

    public void save(Car car){
        try {
            car.setId(idGenerator.generate());
            OutputStream outputStream = new FileOutputStream(filename, true);
            String carLine = car.toString() + "\n";
            outputStream.write(carLine.getBytes());
            outputStream.close();
        }catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
