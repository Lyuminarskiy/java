package com.company;
import lib.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        ArrayList<Challenger> challengers = new ArrayList<>();
        challengers.add(new Challenger("Ольга", "Красные", 20));
        challengers.add(new Challenger("Михаил", "Красные",30));
        challengers.add(new Challenger("Сергей", "Красные",20));
        challengers.add(new Challenger("Иван", "Синие",25));
        challengers.add(new Challenger("Марина", "Синие",20));
        challengers.add(new Challenger("Анна", "Синие",10));

        Game.setWinScore(60);

        game.Start(challengers);
    }
}
