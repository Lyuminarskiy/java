package com.company;
import lib.*;

public class Main {

    public static void main(String[] args) {
	    RedTeam rt = new RedTeam();
	    BlueTeam bt = new BlueTeam();
        rt.printTeam();
        bt.printTeam();

        rt.start();
        bt.start();
    }
}
