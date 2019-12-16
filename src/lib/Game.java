package lib;

import java.util.ArrayList;

public class Game{
    public static int currentscore;
    public static int goal;
    public static ThreadGroup red=new ThreadGroup("Красные");
    public static ThreadGroup blue=new ThreadGroup("Синие");
    public Game(int goal){
        this.goal = goal;
        this.currentscore = 0;
    }
    public static void start() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(red, "Слава"));
        players.add(new Player(blue, "Максим"));
        players.add(new Player(red, "Егор"));
        players.add(new Player(blue, "Данил"));
        players.add(new Player(red, "Даша"));
        players.add(new Player(blue, "Маша"));
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