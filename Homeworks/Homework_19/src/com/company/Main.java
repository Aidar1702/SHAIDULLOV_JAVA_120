package com.company;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

public class Main {

    public static void main(String[] args) {
	CoffeMachine a1 = new CoffeMachine(70000, "Nivona");
	CoffeMachine b1 = new CoffeMachine(70000, "Nivona");
	CoffeMachine c1 = new CoffeMachine(70000, "Nivona");
	a1.setQuality(Quality.GOOD);
	b1.setQuality(Quality.BAD);
	c1.setQuality(Quality.MEDIUM);
        System.out.println(a1);
        System.out.println(a1.equals(b1));
        System.out.println(a1.equals(c1));
    }
}
