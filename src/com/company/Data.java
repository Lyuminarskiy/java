package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Data{
    static int goal;
    static int currentscore=0;
    static ThreadGroup red=new ThreadGroup("Красные");
    static ThreadGroup blue=new ThreadGroup("Синие");

    static void Play(ArrayList<Player> RedTeam, ArrayList<Player> BlueTeam) {
        System.out.println("Введите порог победы:");
        Scanner sk = new Scanner(System.in);
        Data.goal = sk.nextInt();
        String TeamRed = String.format("Команда '%s':",red.getName());
        String TeamBlue = String.format("Команда '%s':",blue.getName());
        for (Player player : RedTeam) {
            String temp = String.format("\n%s<%s>", player.getName(), player.getThreadGroup().getName());
            TeamRed += temp;
            player.start();
        }
        for (Player player : BlueTeam) {
            String temp = String.format("\n%s<%s>", player.getName(), player.getThreadGroup().getName());
            TeamBlue += temp;
            player.start();
        }
        System.out.printf("%s\n\n%s\n\n", TeamRed, TeamBlue);
    }

}
