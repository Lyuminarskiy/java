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
        while(!Game.isEndGame && Math.abs(Game.score)< Game.endPoints) {
            if (this.Color == "Синие")
                Game.changeScore(-random.nextInt(100),this);
            if (this.Color == "Красные")
                Game.changeScore(random.nextInt(100),this);
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
