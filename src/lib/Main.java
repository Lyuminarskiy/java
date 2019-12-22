package lib;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Integer score,endPoints;
    static boolean isEndGame = false;

    public static void main(String[] args) {
        score=0;
        System.out.print("Введите количество очков необходимых для победы: ");
        Scanner scanner = new Scanner(System.in);
        endPoints = scanner.nextInt();
        ArrayList<Player> redTeam=new ArrayList<Player>(), blueTeam=new ArrayList<Player>();
        redTeam.add(new Player("Иван","Красные"));
        redTeam.add(new Player("Марина","Красные"));
        redTeam.add(new Player("Анна","Красные"));
        blueTeam.add(new Player("Михаил","Синие"));
        blueTeam.add(new Player("Сергей","Синие"));
        blueTeam.add(new Player("Ольга","Синие"));

        System.out.printf("\nКоманда <Красные>:\n");
        for (Player member:redTeam)
            System.out.printf("%s<%s>\n",member.getName(),member.Color);
        System.out.printf("\nКоманда <Синие>:\n");
        for (Player member:blueTeam)
            System.out.printf("%s<%s>\n",member.getName(),member.Color);
        System.out.printf("\nИгра начинается!\nКоманда победит при достижении порога в %s единиц\n", endPoints);
        for (Player member:redTeam)
                member.start();
        for (Player member:blueTeam)
                member.start();
    }
}