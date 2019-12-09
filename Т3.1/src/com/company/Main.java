package com.company;
import java.nio.channels.ScatteringByteChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import lib.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input str: ");
        String str3 = in.nextLine();
        String[] wordList2 = str3.split(" ");

        libr.sort(wordList2);

        for (int i = 0; i < wordList2.length; i++) {
            System.out.printf("%s ", wordList2[i]);
        }

        System.out.print("\n");
        Scanner in2 = new Scanner(System.in);
        System.out.print("Input telephone: ");
        String str4 = in2.nextLine();
        String[] wordList4 = str4.split("");
        in2.close();
        in.close();

        String[] wordList5={"+","7","(",")","-"};

        if (libr.isPhone(wordList4,wordList5)==true) System.out.print("True");
        else System.out.print("False");

    }

}
