package com.company;

import lib.Game;
import lib.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите порог победы:");
        Scanner sk = new Scanner(System.in);
        int goal = sk.nextInt();
        Game game = new Game(goal);

        ThreadGroup red = new ThreadGroup("Красные");
        ThreadGroup blue = new ThreadGroup("Синие");
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(red, "Слава"));
        players.add(new Player(blue, "Максим"));
        players.add(new Player(red, "Егор"));
        players.add(new Player(blue, "Данил"));
        players.add(new Player(red, "Даша"));
        players.add(new Player(blue, "Маша"));

        game.start(players, red, blue);
    }
}
