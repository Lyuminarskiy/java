package lib;

import java.util.Random;

//Должно быть соответствие один игрок - один поток.
public class Challenger extends Thread {
    public String name;
    public int power;
    public String team;
    Random random = new Random();

    public Challenger(String name, String team, int power){
        this.name = name;
        this.team = team;
        this.power = power;
    }

    @Override
    public void run(){
        while(!Game.checkWin()) {
            hangTheRope();
            try {
                Thread.sleep(random.nextInt(1000)+100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Game.printWinner();
        stop();
    }

    @Override
    public String toString(){
        return String.format("%s<%s> ", name, team);
    }

    public void hangTheRope(){
        int power = random.nextInt(this.power+3);

        if (team.equals("Синие"))  {
            power *= -1;
            Game.blueScore += power;
        } else {
            Game.redScore += power;
        }

        Game.setCurrentScore(this, power);

    }

}
