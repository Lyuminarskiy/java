package com.company;
import lib.*;

public class Main {

    public static void main(String[] args) {
        Team.setMaxRopeValue(20);

        System.out.println("Игра начинается!\nКоманда победит при достижении порога в " + Team.ropeMax + " единиц\n");
    }
}
