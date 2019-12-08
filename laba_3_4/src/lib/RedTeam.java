package lib;

import java.util.ArrayList;
import java.util.Random;

public class RedTeam extends Team {

    private RedTeam(String color, ArrayList<Challenger> challengersList) {
        super(color, challengersList);
    }
    private Random random = new Random();

    public RedTeam() {
        this("Красные", new ArrayList<Challenger>());
        super.challengersList.add(new Challenger("Иван", 25));
        super.challengersList.add(new Challenger("Марина", 20));
        super.challengersList.add(new Challenger("Анна", 10));
    }

    @Override
    protected void hangTheRope(Challenger challenger) {
        int power = random.nextInt(challenger.power + 1);
        Team.ropeCurrent += power;
        Team.ropeRed += power;
        System.out.println(String.format("%s<%s> добавляет +%s своей команде\nТекущий счет: %s<Красные>, %s<Синие>\n",
                challenger.name, color, power, Team.ropeRed, Team.ropeBlue));

        //System.out.println("-----ScoreGlobal: " + Team.ropeCurrent + "-----");
    }
}
