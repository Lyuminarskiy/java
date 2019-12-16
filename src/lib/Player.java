package lib;

import java.util.Random;

public class Player extends Thread{
    public Player(ThreadGroup team, String name){
        super(team, name);
    }
    private void printStage(int count){
        System.out.printf("\n\n%s<%s> добавляет %d к своей команде\nТекущий счёт: %d<Красные>, %d<Синие>",
                Player.currentThread().getName(), Player.currentThread().getThreadGroup().getName(),
                count, Game.currentscore, -Game.currentscore);
        if (Math.abs(Game.currentscore) >= Game.goal) {
            System.out.printf("\n\nИгра окончена!\nПобедила команда <%s>", Player.currentThread().getThreadGroup().getName());
        }
    }
    public synchronized void run() {
        while (Math.abs(Game.currentscore) < Game.goal) {
            Random random = new Random();
            try {
                sleep(100 + random.nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ((Object) Game.currentscore) {
                if (Math.abs(Game.currentscore) < Game.goal) {
                    int count = random.nextInt(Game.goal);
                    if (Player.currentThread().getThreadGroup().getName().equals("Красные")) {
                        Game.currentscore += count;
                    }
                    if (Player.currentThread().getThreadGroup().getName().equals("Синие")) {
                        Game.currentscore -= count;
                    }
                    this.printStage(count);
                }
            }
        }
    }
}