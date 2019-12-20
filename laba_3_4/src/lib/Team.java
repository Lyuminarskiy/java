package lib;

import java.util.ArrayList;
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

    protected abstract void hangTheRope(Challenger challenger);
    public static void setMaxRopeValue(int max){
        ropeMax = max;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(String.format("Команда <%s>:\n", color));
        for (Challenger ch:
             challengersList) {
            str.append(String.format("%s<%s>\n", ch.name, color));
        }
        return str.toString();
    }

    @Override
    public void run() {
        while (Math.abs(ropeCurrent) < ropeMax) {
            for (Challenger ch :
                    challengersList) {
                if (Math.abs(ropeCurrent) >= ropeMax) {
                    break;
                } else {
                    try {
                        Thread.sleep(new Random().nextInt(1000 + 100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    hangTheRope(ch);
                }
            }
        }
        if (flag) {
            flag = false;
            if (ropeCurrent > 0) {
                color = "<Красные>";
            } else {
                color = "<Синие>";
            }
            System.out.println("Игра завершена!\nПобедила команда " + color);
            getThreadGroup().stop();
        }
    }

    public void printTeam() {
        System.out.println(this.toString());
    }
}
