package lib;
import java.util.ArrayList;

public class Team {
    String color;
    private ArrayList<Player> players;

    public Team(String c,String ... p){
        color = c;
        players = new ArrayList<Player>();
        for(int i = 0;i < p.length;i++)
            players.add(new Player (color, p[i]));
    }
    public void PrintMembers(){
        System.out.printf("\nКоманда <%s>:\n", color);
        for (Player player:players)
            System.out.printf("%s<%s>\n",player.getName(),player.Color);
    }
    public void Start() {
        for (Player player : players)
            player.start();
    }
}
