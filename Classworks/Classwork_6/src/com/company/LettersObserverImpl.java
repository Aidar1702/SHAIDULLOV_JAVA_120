package com.company;

public class LettersObserverImpl implements LettersObserver {
    public void handle(char c) {
        System.out.println("I'm on letter" + c);
    }
}