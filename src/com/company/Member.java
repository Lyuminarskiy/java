package com.company;

import java.util.Random;

public class Member extends Thread {

    protected String Color;
    public Member(String name, String color){
        super(name);
        Color=color;
    }

    @Override
    public void run() {
        var random = new Random();
        while(Math.abs(Game.score)<Game.endPoints) {
            if (this.Color == "Синие") {
                Game.changeScore(-random.nextInt(100), this);
            }
            if (this.Color == "Красные") {
                Game.changeScore(random.nextInt(100), this);
            }
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
