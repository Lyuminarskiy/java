import TugOfWar.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        final String leftSideTeamName = "Красные";
        final String rightSideTeamName = "Синие";

        var leftSideTeam = new ArrayList<TeamMember>();
        leftSideTeam.add(new TeamMember("Иван", leftSideTeamName));
        leftSideTeam.add(new TeamMember("Марина", leftSideTeamName));
        leftSideTeam.add(new TeamMember("Анна", leftSideTeamName));

        var rightSideTeam = new ArrayList<TeamMember>();
        rightSideTeam.add(new TeamMember("Михаил", rightSideTeamName));
        rightSideTeam.add(new TeamMember("Сергей", rightSideTeamName));
        rightSideTeam.add(new TeamMember("Ольга", rightSideTeamName));

        Game.start(leftSideTeam, rightSideTeam);

    }
}
