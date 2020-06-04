package com.company;

import lib.Functions;

public class Main {
    public static void main(String[] args) {
        System.out.println(Functions.sort("a bbb cccc ddd e"));
	    System.out.println(Functions.sort("я люблю программирование на Java"));
	    System.out.println(Functions.isPhone("+7(123)456-78-90"));
        System.out.println(Functions.isPhone("81234567890"));
    }
}
