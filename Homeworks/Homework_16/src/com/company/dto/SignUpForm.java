package com.company.dto;

public class SignUpForm {
    private String model;
    private String driver;

    public SignUpForm(String model, String driver){
        this.model = model;
        this.driver = driver;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
