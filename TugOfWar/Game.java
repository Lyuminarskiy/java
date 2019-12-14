package TugOfWar;

import java.util.Random;

public class Game {

    public static String leftSideTeam;

    public static String rightSideTeam;

    public static int goal;

    public static int currentScore = 0;

    public static boolean flag = true;

    public static Random r = new Random();

    public static synchronized void pullTheRope(TeamMember teamMember) {
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
