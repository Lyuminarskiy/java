import TugOfWar.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game.leftSideTeam = "Красные";
        Game.rightSideTeam = "Синие";

        var participants = new ArrayList<TeamMember>();
        participants.add(new TeamMember("Иван", Game.leftSideTeam));
        participants.add(new TeamMember("Марина", Game.leftSideTeam));
        participants.add(new TeamMember("Анна", Game.leftSideTeam));
        participants.add(new TeamMember("Михаил", Game.rightSideTeam));
        participants.add(new TeamMember("Сергей", Game.rightSideTeam));
        participants.add(new TeamMember("Ольга", Game.rightSideTeam));

        System.out.print("Введите порог для победы: ");
        var sc = new Scanner(System.in);
        Game.goal = sc.nextInt();

        var leftTeamPresent = new ArrayList<String>();
        var rightTeamPresent = new ArrayList<String>();
        for (var teamMember : participants) {
            var text = String.format("%s<%s>", teamMember.getName(), teamMember.Team);
            if (teamMember.Team.equals(Game.leftSideTeam))
                leftTeamPresent.add(text);
            if (teamMember.Team.equals(Game.rightSideTeam))
                rightTeamPresent.add(text);
        }


        System.out.printf("\nКоманда <%s>:\n", Game.leftSideTeam);
        System.out.print(String.join("\n", leftTeamPresent));
        System.out.printf("\n\n\nКоманда <%s>:\n", Game.rightSideTeam);
        System.out.print(String.join("\n", rightTeamPresent) + "\n\n");
        System.out.printf("Игра начинается!\nКоманда победит при достижении порога в %s единиц\n\n\n", Game.goal);

        for (var teamMember : participants) {
            teamMember.start();
        }
    }
}
