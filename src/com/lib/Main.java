package com.lib;
import lib.liber;
import java.io.FileReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        String kek = in.nextLine();
        liber.isPhone(kek);
        liber.sort(kek);
    }
}
