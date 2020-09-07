import lib.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        ArrayList<Challenger> challengers = new ArrayList<>();
        challengers.add(new Challenger("Иван", "Красные", 15));
        challengers.add(new Challenger("Анна", "Красные",7));
        challengers.add(new Challenger("Сергей", "Синие",3));
        challengers.add(new Challenger("Иван", "Красные",95));

        Game.setWinScore(60);

        game.Start(challengers);
    }
}