package lib;

import java.util.ArrayList;
import java.util.Random;

public class BlueTeam extends Team {

    private BlueTeam(String color, ArrayList<Challenger> challengersList) {
        super(color, challengersList);
    }
    private Random random = new Random();

    public BlueTeam(){
        this("Синие", new ArrayList<Challenger>());
        super.challengersList.add(new Challenger("Ольга", 20));
        super.challengersList.add(new Challenger("Михаил", 30));
        super.challengersList.add(new Challenger("Сергей", 20));
    }

    @Override
    protected void hangTheRope(Challenger challenger) {
        int power = random.nextInt(challenger.power + 1);
        Team.ropeCurrent -= power;
        Team.ropeBlue -= power;
        System.out.println(String.format("%s<%s> добавляет -%s своей команде\nТекущий счет: %s<Красные>, %s<Синие>\n",
                challenger.name, color, power, Team.ropeRed, Team.ropeBlue));
    }
}
