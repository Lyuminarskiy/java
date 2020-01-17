package lib;

import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    static int WinScore;
    static int CurrentScore = 0;
    public static ThreadGroup red = new ThreadGroup("Красные");
    public static ThreadGroup blue = new ThreadGroup("Синие");

    public static void Play(ArrayList<Player> RedTeam, ArrayList<Player> BlueTeam)
    {
        System.out.println("Введите порог очков для победы:");
        Scanner sk = new Scanner(System.in);
        Game.WinScore = sk.nextInt();
        String TeamRed = String.format("Команда '%s':", red.getName());
        String TeamBlue = String.format("Команда '%s':", blue.getName());

        for (Player player : RedTeam)
        {
            String temp = String.format("\n%s<%s>", player.getName(), player.getThreadGroup().getName());
            TeamRed += temp;
            player.start();
        }
        for (Player player : BlueTeam)
        {
            String temp = String.format("\n%s<%s>", player.getName(), player.getThreadGroup().getName());
            TeamBlue += temp;
            player.start();
        }

        System.out.printf("%s\n\n%s\n\n", TeamRed, TeamBlue);
    }
}
