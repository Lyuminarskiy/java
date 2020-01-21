package lib;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static Integer score,endPoints;
    static boolean isEndGame = false;
    private ArrayList<Team> teams;

    public Game(){
        score=0;
        System.out.print("Введите количество очков необходимых для победы: ");
        Scanner scanner = new Scanner(System.in);
        endPoints = scanner.nextInt();
        teams = new ArrayList<Team>();
    }
    public void AddTeam(String color, String ... players){
        teams.add(new Team (color,players));
    }
    public void PrintTeams(){
        for (Team team : teams)
            team.PrintMembers();
    }
    public void StartGame(){
        System.out.printf("\nИгра начинается!\nКоманда победит при достижении порога в %s единиц\n", endPoints);
        for (Team team : teams)
            team.Start();
    }
    public static synchronized void changeScore(int points, Player player) {
        if (!isEndGame && Math.abs(score) < endPoints) {
            score += points;
            System.out.printf("\n%s<%s> добавляет %d к своей команде\nТекущий счет: %d<Красные>,  %d<Синие>\n",
                    player.getName(), player.Color, Math.abs(points), score, -score);
            if (Math.abs(score) >= endPoints) {
                isEndGame = true;
                if (score < 0) {
                    System.out.printf("\nИгра завершена!\nПобедила команда <Синие>!");
                }
                if (score > 0) {
                    System.out.printf("\nИгра завершена!\nПобедила команда <Красные>!");
                }
            }
        }
    }
}
