package com.company;

import java.util.Random;

public class Member extends Thread {

    String Color;
    public Member(String name, String color){
        super(name);
        Color=color;
    }

    @Override
    public void run() {
        var random = new Random();
        while(Math.abs(Main.score)<Main.endPoints) {
            if (this.Color == "Синие") {
                Main.changeScore(-random.nextInt(100), this);
            }
            if (this.Color == "Красные") {
                Main.changeScore(random.nextInt(100), this);
            }
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
