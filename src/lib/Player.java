package lib;

import com.company.Main;
import java.util.Random;

public class Player extends Thread{
    public Player(ThreadGroup team, String name){
        super(team, name);
    }
    private void printStage(int count){
        System.out.printf("\n\n%s<%s> добавляет %d к своей команде\nТекущий счёт: %d<Красные>, %d<Синие>",
                Player.currentThread().getName(), Player.currentThread().getThreadGroup().getName(),
                count, Main.currentscore, -Main.currentscore);
        if (Math.abs(Main.currentscore) >= Main.goal) {
            System.out.printf("\n\nИгра окончена!\nПобедила команда <%s>", Player.currentThread().getThreadGroup().getName());
        }
    }
    public synchronized void run() {
        while (Math.abs(Main.currentscore) < Main.goal) {
            Random random = new Random();
            try {
                sleep(100 + random.nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ((Object) Main.currentscore) {
                if (Math.abs(Main.currentscore) < Main.goal) {
                    int count = random.nextInt(Main.goal);
                    if (Player.currentThread().getThreadGroup().getName().equals("Красные")) {
                        Main.currentscore += count;
                    }
                    if (Player.currentThread().getThreadGroup().getName().equals("Синие")) {
                        Main.currentscore -= count;
                    }
                    this.printStage(count);
                }
            }
        }
    }
}