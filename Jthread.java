package com.company;

import java.util.Random;

public class Jthread extends Thread{
    Jthread(ThreadGroup group, String name){
        super(group, name);
    }

    public synchronized void run() {
        while (Math.abs(Data.currentscore) < Data.goal) {
            Random random = new Random();
            try {
                Jthread.currentThread().sleep(100 + random.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ((Object) Data.currentscore) {
                if (Math.abs(Data.currentscore) < Data.goal) {
                    int a = random.nextInt(Data.goal);
                    if (Jthread.currentThread().getThreadGroup().getName().equals("Красные")) {
                        Data.currentscore += a;
                    }
                    if (Jthread.currentThread().getThreadGroup().getName().equals("Синие")) {
                        Data.currentscore -= a;
                    }
                    System.out.printf("\n%s<%s> добавляет %d к своей команде\nТекущий счёт: %d<Красные>, %d<Синие>",
                            Jthread.currentThread().getName(), Jthread.currentThread().getThreadGroup().getName(),
                            a, Data.currentscore, -Data.currentscore);
                    if (Math.abs(Data.currentscore) >= Data.goal) {
                        System.out.printf("\nИгра окончена!\nПобедила команда <%s>", Jthread.currentThread().getThreadGroup().getName());
                    }
                }
            }
        }
    }
}
