import tug.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        final String leftSideTeamName = "Красные";
        final String rightSideTeamName = "Синие";

        var leftSideTeam = new ArrayList<TeamMember>();
        leftSideTeam.add(new TeamMember("Кирилл", leftSideTeamName));
        leftSideTeam.add(new TeamMember("Константин", leftSideTeamName));
        leftSideTeam.add(new TeamMember("Кира", leftSideTeamName));

        var rightSideTeam = new ArrayList<TeamMember>();
        rightSideTeam.add(new TeamMember("Софья", rightSideTeamName));
        rightSideTeam.add(new TeamMember("Светлана", rightSideTeamName));
        rightSideTeam.add(new TeamMember("Семён", rightSideTeamName));

        Game.start(leftSideTeam, rightSideTeam);

    }
}