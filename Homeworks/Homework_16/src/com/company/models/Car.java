package com.company.models;

import com.company.exceptions.EmptyCredentialsException;

public class Car {
    private int id;
    private String model;
    private int weight;
    private int carNumber;
    private String engine;
    private String driver;

    private Car(Builder builder){
        this.id = builder.id;
        this.model = builder.model;
        this.carNumber = builder.carNumber;
        this.engine = builder.engine;
        this.driver = builder.driver;
        this.weight = builder.weight;
    }
    public static class Builder {
        private int id;
        private String model;
        private int weight;
        private int carNumber;
        private String engine;
        private String driver;


        public Builder model(String model){
            this.model = model;
            return this;
        }
        public Builder carNumber(int carNumber){
            this.carNumber = carNumber;
            return this;
        }
        public Builder weight(int weight){
            this.weight = weight;
            return this;
        }
        public Builder engine(String engine){
            this.engine = engine;
            return this;
        }
        public Builder driver(String driver){
            this.driver = driver;
            return this;
        }
        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Car build(){
            if (isEmptyCredentials()){
                throw new EmptyCredentialsException("Пустые данные");
            }
            return new Car(this);
        }

        private boolean isEmptyCredentials() {
            return this.model == null ||
                    this.model.equals("") ||
                    this.driver == null ||
                    this.driver.equals("");
        }
    }
    public static Builder builder(){
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String toString(){
        return id + "|"
                + driver + "|"
                + model + "|"
                + engine + "|"
                + carNumber + "|"
                + weight + "|";
    }
}
