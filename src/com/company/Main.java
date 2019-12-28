package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Game.start();
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
        System.out.printf("\nИгра начинается!\nКоманда победит при достижении порога в %s единиц\n", Game.endPoints);
        for (var member:redTeam) {
            member.start();
        }
        for (var member:blueTeam) {
            member.start();
        }
    }
}
