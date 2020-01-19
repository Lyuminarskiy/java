package tug;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {


    private static int goal;

    private static int currentScore = 0;

    public static boolean flag = true;

    private static Random r = new Random();

    public static void start(List<TeamMember> leftSideTeam, List<TeamMember> rightSideTeam) {
        System.out.print("Введите порог для победы: ");
        var sc = new Scanner(System.in);
        Game.goal = sc.nextInt();

        System.out.println("\nКоманда <Красные>:");
        for (var teamMember : leftSideTeam){
            System.out.println(String.format("%s<%s>", teamMember.getName(), teamMember.Team));
            teamMember.start();
        }
        System.out.println("\nКоманда <Синие>:");
        for (var teamMember : rightSideTeam) {
            System.out.println(String.format("%s<%s>", teamMember.getName(), teamMember.Team));
            teamMember.start();
        }
        System.out.printf("\nИгра начинается!\nКоманда победит при достижении порога в %s единиц\n", Game.goal);

    }


    static synchronized void pullTheRope(TeamMember teamMember) {
        var currentTurn = r.nextInt(goal / 2);
        if (teamMember.Team.equals("Красные"))
            currentScore += currentTurn;
        if (teamMember.Team.equals("Синие"))
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
