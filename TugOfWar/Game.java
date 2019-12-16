package TugOfWar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static String leftSideTeam;

    public static String rightSideTeam;

    private static int goal;

    private static int currentScore = 0;

    static boolean flag = true;

    static Random r = new Random();

    public static void start(List<TeamMember> leftSideTeam, List<TeamMember> rightSideTeam) {
        System.out.print("Введите порог для победы: ");
        var sc = new Scanner(System.in);
        Game.goal = sc.nextInt();
        var leftTeamPresent = new ArrayList<String>();
        var rightTeamPresent = new ArrayList<String>();
        for (var teamMember : leftSideTeam) {
            leftTeamPresent.add(String.format("%s<%s>", teamMember.getName(), teamMember.Team));
        }
        for (var teamMember : rightSideTeam) {
            rightTeamPresent.add(String.format("%s<%s>", teamMember.getName(), teamMember.Team));
        }


        System.out.printf("\nКоманда <%s>:\n", Game.leftSideTeam);
        System.out.print(String.join("\n", leftTeamPresent));
        System.out.printf("\n\n\nКоманда <%s>:\n", Game.rightSideTeam);
        System.out.print(String.join("\n", rightTeamPresent) + "\n\n");
        System.out.printf("Игра начинается!\nКоманда победит при достижении порога в %s единиц\n\n\n", Game.goal);

        for (var teamMember : leftSideTeam) {
            teamMember.start();
        }
        for (var teamMember : rightSideTeam) {
            teamMember.start();
        }
    }


    static synchronized void pullTheRope(TeamMember teamMember) {
        var currentTurn = r.nextInt(goal / 2);
        if (teamMember.Team.equals(leftSideTeam))
            currentScore += currentTurn;
        if (teamMember.Team.equals(rightSideTeam))
            currentScore -= currentTurn;
        String leftTeamText = null;
        String rightTeamText = null;
        if (currentScore > 0){
            leftTeamText = "+" + currentScore;
            rightTeamText = Integer.toString(0 - currentScore);
        }
        else if (currentScore < 0){
            rightTeamText = "+" + Math.abs(currentScore);
            leftTeamText = Integer.toString(currentScore);
        }
        else {
            leftTeamText = "0";
            rightTeamText = "0";
        }
        System.out.println(String.format("\n%s<%s> добавляет %d к своей команде\nТекущий счет: %s<Красные>,  %s<Синие>\n",
                teamMember.getName(), teamMember.Team, currentTurn, leftTeamText, rightTeamText));
        if (Math.abs(currentScore) >= goal){
            System.out.printf("\nИгра завершена!\nПобедила команда <%s>!", teamMember.Team);
            Thread.currentThread().getThreadGroup().stop();
        }
    }

}
