package com.company;

public class DigitsObserverImpl implements DigitsObserver {

    public void handle(char c) {
        System.out.println("I'm in digit - " + c);
    }
}