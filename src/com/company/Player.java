package com.company;

import java.util.Random;

public class Player extends Thread{
    Player(ThreadGroup group, String name){
        super(group, name);
    }

    public synchronized void run() {
        while (Math.abs(Data.currentscore) < Data.goal) {
            Random random = new Random();
            try {
                Player.currentThread().sleep(100 + random.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ((Object) Data.currentscore) {
                if (Math.abs(Data.currentscore) < Data.goal) {
                    int a = random.nextInt(Data.goal);
                    if (Player.currentThread().getThreadGroup().getName().equals("Красные")) {
                        Data.currentscore += a;
                    }
                    if (Player.currentThread().getThreadGroup().getName().equals("Синие")) {
                        Data.currentscore -= a;
                    }
                    System.out.printf("\n%s<%s> добавляет %d к своей команде\nТекущий счёт: %d<Красные>, %d<Синие>",
                            Player.currentThread().getName(), Player.currentThread().getThreadGroup().getName(),
                            a, Data.currentscore, -Data.currentscore);
                    if (Math.abs(Data.currentscore) >= Data.goal) {
                        System.out.printf("\nИгра окончена!\nПобедила команда <%s>", Player.currentThread().getThreadGroup().getName());
                    }
                }
            }
        }
    }
}
