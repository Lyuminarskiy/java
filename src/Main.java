import TugOfWar.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Game.leftSideTeam = "Красные";
        Game.rightSideTeam = "Синие";

        var leftSideTeam = new ArrayList<TeamMember>();
        leftSideTeam.add(new TeamMember("Иван", Game.leftSideTeam));
        leftSideTeam.add(new TeamMember("Марина", Game.leftSideTeam));
        leftSideTeam.add(new TeamMember("Анна", Game.leftSideTeam));

        var rightSideTeam = new ArrayList<TeamMember>();
        rightSideTeam.add(new TeamMember("Михаил", Game.rightSideTeam));
        rightSideTeam.add(new TeamMember("Сергей", Game.rightSideTeam));
        rightSideTeam.add(new TeamMember("Ольга", Game.rightSideTeam));

        Game.start(leftSideTeam, rightSideTeam);

    }
}
