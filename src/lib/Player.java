package lib;
import java.util.Random;

public class Player extends Thread {

    String Color;
    public Player(String name, String color){
        super(name);
        Color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(!Main.isEndGame && Math.abs(Main.score)<Main.endPoints) {
            if (this.Color == "Синие")
                changeScore(-random.nextInt(100));
            if (this.Color == "Красные")
                changeScore(random.nextInt(100));
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private synchronized void changeScore(int points)
    {
        if(!Main.isEndGame && Math.abs(Main.score) < Main.endPoints)
        {
            Main.score += points;
            System.out.printf("\n%s<%s> добавляет %d к своей команде\nТекущий счет: %d<Красные>,  %d<Синие>\n",
                    this.getName(), this.Color, Math.abs(points), Main.score, -Main.score);
            if (Math.abs(Main.score) >= Main.endPoints) {
                Main.isEndGame = true;
                if (Main.score < 0)
                    System.out.printf("\nИгра завершена!\nПобедила команда <Синие>!");
                if (Main.score > 0)
                    System.out.printf("\nИгра завершена!\nПобедила команда <Красные>!");
            }
        }
    }
}
