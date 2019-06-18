package com.company;

public class CoffeMachine {
    private int cost;
    private String model;
    private Quality quality;


    public  CoffeMachine(int cost, String model){
        this.cost = cost;
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj){
           return true;
       }
       if (obj instanceof CoffeMachine){
           CoffeMachine thisIS = (CoffeMachine)obj;
           return (this.getCost() == thisIS.getCost()) &&
                   (this.getModel() == thisIS.getModel());
       }else {
           return false;
       }
    }

    @Override
    public String toString() {
        return this.getModel() + this.getCost();
    }
}
