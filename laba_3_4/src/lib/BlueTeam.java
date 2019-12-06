package lib;

import java.util.ArrayList;

public class BlueTeam extends Team {

    private BlueTeam(String color, ArrayList<Challenger> challengersList) {
        super(color, challengersList);
    }

    public BlueTeam(){
        this("Синие", new ArrayList<Challenger>());
        super.challengersList.add(new Challenger("Ольга", 10));
        super.challengersList.add(new Challenger("Михаил", 10));
        super.challengersList.add(new Challenger("Сергей", 10));
    }

    @Override
    protected void hangTheRope(Challenger challenger) {
        Team.ropeCurrent -= challenger.power;
        Team.ropeBlue -= challenger.power;
        System.out.println(String.format("%s<%s> добавляет -%s своей команде\nТекущий счет: %s<Красные>, %s<Синие>\n",
                challenger.name, color, challenger.power, Team.ropeRed, Team.ropeBlue));
    }
}
