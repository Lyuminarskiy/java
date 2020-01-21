package lib;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static Integer score,endPoints;
    static boolean isEndGame = false;
    ArrayList<Player> redTeam;
    ArrayList<Player> blueTeam;

    public Game(){
        score=0;
        System.out.print("Введите количество очков необходимых для победы: ");
        Scanner scanner = new Scanner(System.in);
        endPoints = scanner.nextInt();
        redTeam = new ArrayList<Player>();
        blueTeam = new ArrayList<Player>();
    }
    public void CreateTeam(){
        redTeam.add(new Player("Иван","Красные"));
        redTeam.add(new Player("Марина","Красные"));
        redTeam.add(new Player("Анна","Красные"));

        blueTeam.add(new Player("Михаил","Синие"));
        blueTeam.add(new Player("Сергей","Синие"));
        blueTeam.add(new Player("Ольга","Синие"));
    }
    public void PrintMembersTeam(){
        System.out.printf("\nКоманда <Красные>:\n");
        for (Player member:redTeam)
            System.out.printf("%s<%s>\n",member.getName(),member.Color);
        System.out.printf("\nКоманда <Синие>:\n");
        for (Player member:blueTeam)
            System.out.printf("%s<%s>\n",member.getName(),member.Color);
    }
    public void StartGame(){
        System.out.printf("\nИгра начинается!\nКоманда победит при достижении порога в %s единиц\n", endPoints);
        for (Player member:redTeam)
            member.start();
        for (Player member:blueTeam)
            member.start();
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
