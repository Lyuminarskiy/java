package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Integer score,endPoints;

    public static void main(String[] args) {
        score=0;
        System.out.print("Введите количество очков необходимых для победы: ");
        var scanner = new Scanner(System.in);
        endPoints = scanner.nextInt();
        ArrayList<Member> redTeam=new ArrayList<Member>(), blueTeam=new ArrayList<Member>();
        redTeam.add(new Member("Иван","Красные"));
        redTeam.add(new Member("Марина","Красные"));
        redTeam.add(new Member("Анна","Красные"));
        blueTeam.add(new Member("Михаил","Синие"));
        blueTeam.add(new Member("Сергей","Синие"));
        blueTeam.add(new Member("Ольга","Синие"));
        System.out.printf("\nКоманда <Красные>:\n");
        for (var member:redTeam) {
            System.out.printf("%s<%s>\n",member.getName(),member.Color);
        }
        System.out.printf("\nКоманда <Синие>:\n");
        for (var member:blueTeam) {
            System.out.printf("%s<%s>\n",member.getName(),member.Color);
        }
        System.out.printf("\nИгра начинается!\nКоманда победит при достижении порога в %s единиц\n", endPoints);
        for (var member:redTeam) {
            member.start();
        }
        for (var member:blueTeam) {
            member.start();
        }
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
