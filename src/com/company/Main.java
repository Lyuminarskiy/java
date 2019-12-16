package com.company;

import lib.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int goal;
    public static int currentscore=0;
    public static ThreadGroup red=new ThreadGroup("Красные");
    public static ThreadGroup blue=new ThreadGroup("Синие");
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(red, "Слава"));
        players.add(new Player(blue, "Максим"));
        players.add(new Player(red, "Егор"));
        players.add(new Player(blue, "Данил"));
        players.add(new Player(red, "Даша"));
        players.add(new Player(blue, "Маша"));
        StringBuilder redTeam= new StringBuilder("Команда 'Красные':");
        StringBuilder blueTeam= new StringBuilder("Команда 'Синие':");
        for (Player player:players) {
            String temp=String.format("\n%s<%s>", player.getName(), player.getThreadGroup().getName());
            if (player.getThreadGroup().equals(red)) redTeam.append(temp);
            else blueTeam.append(temp);
        }
        System.out.printf("%s\n\n%s\n\n", redTeam.toString(), blueTeam.toString());
        System.out.println("Введите порог победы:");
        Scanner sk=new Scanner(System.in);
        goal=sk.nextInt();
        for (Player player:players) {
            player.start();
        }
    }
}
