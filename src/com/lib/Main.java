package com.lib;
import lib.liber;
import java.io.FileReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        String kek = in.nextLine();
        Scanner on = new Scanner(System.in);
        int button = on.nextInt();
        // Выбираем вид функции посредством ввода числа 1 либо 2
        switch (button) {
            case 1: liber.isPhone(kek);
                break;
            case 2: liber.sort(kek);
                break;
        }
    }
}
