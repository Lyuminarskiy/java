package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Data{
    static int goal;
    static int currentscore=0;
    private static ThreadGroup red=new ThreadGroup("Красные");
    private static ThreadGroup blue=new ThreadGroup("Синие");

    static void Game() {
        ArrayList<Jthread> players = new ArrayList<>();
        players.add(new Jthread(Data.red, "Слава"));
        players.add(new Jthread(Data.blue, "Максим"));
        players.add(new Jthread(Data.red, "Егор"));
        players.add(new Jthread(Data.blue, "Данил"));
        players.add(new Jthread(Data.red, "Даша"));
        players.add(new Jthread(Data.blue, "Маша"));
        String RedTeam = "Команда 'Красные':";
        String BlueTeam = "Команда 'Синие':";
        for (Jthread player : players) {
            String temp = String.format("\n%s<%s>", player.getName(), player.getThreadGroup().getName());
            if (player.getThreadGroup().equals(Data.red)) RedTeam += temp;
            else BlueTeam += temp;
        }
        System.out.printf("%s\n\n%s\n\n", RedTeam, BlueTeam);
        System.out.println("Введите порог победы:");
        Scanner sk = new Scanner(System.in);
        Data.goal = sk.nextInt();
        for (Jthread player : players) {
            player.start();
        }
    }

}
