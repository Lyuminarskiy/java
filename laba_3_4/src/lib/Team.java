package lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Team extends Thread{
    String color;
    ArrayList<Challenger> challengersList;

    public static int ropeCurrent = 0;
    public static int ropeMax = 100;
    public static int ropeBlue = 0;
    public static int ropeRed = 0;
    private static boolean flag = true;

    Team(String color, ArrayList<Challenger> challengersList){
        this.color = color;
        this.challengersList = challengersList;
    }

    public static void setMaxRopeValue(int max){
        ropeMax = max;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(String.format("Команда <%s>\n", color));
        for (Challenger ch:
             challengersList) {
            str.append(String.format("%s<%s>\n", ch.name, color));
        }
        return str.toString();
    }

    @Override
    public void run() {
        if (Team.flag) {
            Team.flag = false;
            System.out.println("Игра начинается!\nКоманда победит при достижении порога в " + ropeMax + " единиц\n");
        } else {
            while (Math.abs(ropeCurrent) < ropeMax) {
                for (Challenger ch :
                        challengersList) {
                    hangTheRope(ch);
                    if (ropeCurrent >= ropeMax) {
                        break;
                    }
                    try {
                        Thread.sleep(new Random().nextInt(1000 + 100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (ropeCurrent > 0) {
                System.out.println("Победили Красные");
            } else {
                System.out.println("Победили Синие");
            }
        }
    }

    public void printTeam() {
        System.out.println(this.toString());
    }

    protected abstract void hangTheRope(Challenger challenger);
}
