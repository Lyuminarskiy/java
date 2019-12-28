package com.company;
import java.util.Scanner;

public class Game {

    static Integer score;
    static Integer endPoints;

    public static void start(){
        score=0;
        System.out.print("Введите количество очков необходимых для победы: ");
        var scanner = new Scanner(System.in);
        endPoints = scanner.nextInt();
    }

    public static synchronized void changeScore(int points, Member member)
    {
        if(Math.abs(score)<endPoints)
        {
            score += points;
            System.out.printf("\n%s<%s> добавляет %d к своей команде\nТекущий счет: %d<Красные>,  %d<Синие>\n",
                    member.getName(), member.Color, Math.abs(points), score, -score);
            if (Math.abs(score) >= endPoints) {
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
