package lib;

import java.util.ArrayList;

public class RedTeam extends Team {

    private RedTeam(String color, ArrayList<Challenger> challengersList) {
        super(color, challengersList);
    }

    public RedTeam() {
        this("Красные", new ArrayList<Challenger>());
        super.challengersList.add(new Challenger("Иван", 10));
        super.challengersList.add(new Challenger("Марина", 10));
        super.challengersList.add(new Challenger("Анна", 10));
    }

    @Override
    protected void hangTheRope(Challenger challenger) {
        Team.ropeCurrent += challenger.power;
        Team.ropeRed += challenger.power;
        System.out.println(String.format("%s<%s> добавляет +%s своей команде\nТекущий счет: %s<Красные>, %s<Синие>\n",
                challenger.name, color, challenger.power, Team.ropeRed, Team.ropeBlue));

        System.out.println("-----ScoreGlobal: " + Team.ropeCurrent + "-----");
    }
}
