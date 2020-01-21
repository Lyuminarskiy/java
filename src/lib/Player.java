package lib;
import java.util.Random;

public class Player extends Thread {

    String Color;
    public Player( String color, String name){
        super(name);
        Color = color;
    }
    @Override
    public void run() {
        Random random = new Random();
        while(!Game.isEndGame && Math.abs(Game.score)< Game.endPoints) {
            if (this.Color == "blue")
                Game.changeScore(-random.nextInt(100),this);
            if (this.Color == "red")
                Game.changeScore(random.nextInt(100),this);
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
