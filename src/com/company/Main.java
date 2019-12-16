package com.company;

import lib.Game;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите порог победы:");
        Scanner sk = new Scanner(System.in);
        int goal = sk.nextInt();
        Game game = new Game(goal);
        game.start();
    }
}
