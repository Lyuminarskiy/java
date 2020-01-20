package lib;

import java.util.Random;

public class Player extends Thread{
    public Player(ThreadGroup team, String name){
        super(team, name);
    }
    private void printStage(int count){
        System.out.printf("\n\n%s<%s> добавляет %d к своей команде\nТекущий счёт: %d<Красные>, %d<Синие>",
                Player.currentThread().getName(), Player.currentThread().getThreadGroup().getName(),
                count, Game.getCurrentscore(), -Game.getCurrentscore());
        if (Math.abs(Game.getCurrentscore()) >= Game.getGoal()) {
            System.out.printf("\n\nИгра окончена!\nПобедила команда <%s>", Player.currentThread().getThreadGroup().getName());
        }
    }
    public synchronized void run() {
        while (Math.abs(Game.getCurrentscore()) < Game.getGoal()) {
            Random random = new Random();
            try {
                sleep(100 + random.nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ((Object) Game.getCurrentscore()) {
                if (Math.abs(Game.getCurrentscore()) < Game.getGoal()) {
                    int count = random.nextInt(Game.getGoal());
                    if (Player.currentThread().getThreadGroup().getName().equals("Красные")) {
                        Game.setCurrentscore(Game.getCurrentscore() + count);
                    }
                    if (Player.currentThread().getThreadGroup().getName().equals("Синие")) {
                        Game.setCurrentscore(Game.getCurrentscore() - count);
                    }
                    this.printStage(count);
                }
            }
        }
    }
}