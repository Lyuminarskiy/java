package lib;

import java.util.ArrayList;

public class Game{
    private static int currentscore;
    private static int goal;
    public Game(int goal){
        this.goal = goal;
        this.currentscore = 0;
    }

    public static int getCurrentscore() {
        return currentscore;
    }
    public static void setCurrentscore(int currentscore) {
        Game.currentscore = currentscore;
    }
    public static int getGoal() {
        return goal;
    }
    public static void start(ArrayList<Player> players, ThreadGroup red, ThreadGroup blue) {
        StringBuilder redTeam = new StringBuilder("Команда 'Красные':");
        StringBuilder blueTeam = new StringBuilder("Команда 'Синие':");
        for (Player player : players) {
            String temp = String.format("\n%s<%s>", player.getName(), player.getThreadGroup().getName());
            if (player.getThreadGroup().equals(red)) redTeam.append(temp);
            else blueTeam.append(temp);
        }
        System.out.printf("%s\n\n%s", redTeam, blueTeam);

        for (Player player : players) {
            player.start();
        }
    }
}