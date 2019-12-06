package lib;

import java.util.ArrayList;
import java.util.List;

public abstract class Team extends Thread{
    String color;
    ArrayList<Challenger> challengersList;

    public static int ropeCurrent = 0;
    public static int ropeMax = 100;
    public static int ropeBlue = 0;
    public static int ropeRed = 0;

    Team(String color, ArrayList<Challenger> challengersList){
        this.color = color;
        this.challengersList = challengersList;
    }

//    private void hangTheRope(Challenger challenger) {
//        Team.ropeCurrent += challenger.power;
//        System.out.println(String.format("%s<%s> добавляет %s своей команде\nТекущий счет: %s<Красные>, %s<Синие>\n",
//                challenger.name, color, challenger.power, Team.ropeRed, Team.ropeBlue));
//    }

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
        while (Math.abs(ropeCurrent) < ropeMax) {
            for (Challenger ch:
            challengersList) {
                hangTheRope(ch);
            }
        }
        if (ropeCurrent > 0) {
            System.out.println("Победили Красные");
        } else {
            System.out.println("Победили Синие");
        }
    }

    public void printTeam() {
        System.out.println(this.toString());
    }

    protected abstract void hangTheRope(Challenger challenger);
}
