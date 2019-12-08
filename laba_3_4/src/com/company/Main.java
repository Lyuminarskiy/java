package com.company;
import lib.*;

public class Main {

    public static void main(String[] args) {
	    RedTeam rt = new RedTeam();
	    BlueTeam bt = new BlueTeam();
        rt.printTeam();
        bt.printTeam();

        Team.setMaxRopeValue(20);

        System.out.println("Игра начинается!\nКоманда победит при достижении порога в " + Team.ropeMax + " единиц\n");

        rt.start();
        bt.start();
    }
}
