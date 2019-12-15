package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Jthread extends Thread{
    Jthread(ThreadGroup group, String name){
        super(group, name);
    }

    public synchronized void run() {
        while (Math.abs(Main.currentscore) < Main.goal) {
            Random random = new Random();
            try {
                Jthread.currentThread().sleep(100 + random.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ((Object) Main.currentscore) {
                if (Math.abs(Main.currentscore) < Main.goal) {
                    int a = random.nextInt(Main.goal);
                    if (Jthread.currentThread().getThreadGroup().getName().equals("Красные")) {
                        Main.currentscore += a;
                    }
                    if (Jthread.currentThread().getThreadGroup().getName().equals("Синие")) {
                        Main.currentscore -= a;
                    }
                    System.out.printf("\n%s<%s> добавляет %d к своей команде\nТекущий счёт: %d<Красные>, %d<Синие>",
                            Jthread.currentThread().getName(), Jthread.currentThread().getThreadGroup().getName(),
                            a, Main.currentscore, -Main.currentscore);
                    if (Math.abs(Main.currentscore) >= Main.goal) {
                        System.out.printf("\nИгра окончена!\nПобедила команда <%s>", Jthread.currentThread().getThreadGroup().getName());
                    }
                }
            }
        }
    }
}

public class Main {
    public static int goal;
    public static int currentscore=0;
    public static ThreadGroup red=new ThreadGroup("Красные");
    public static ThreadGroup blue=new ThreadGroup("Синие");
    public static void main(String[] args) throws IOException {
        ArrayList<Jthread> players = new ArrayList<>();
        players.add(new Jthread(red, "Слава"));
        players.add(new Jthread(blue, "Максим"));
        players.add(new Jthread(red, "Егор"));
        players.add(new Jthread(blue, "Данил"));
        players.add(new Jthread(red, "Даша"));
        players.add(new Jthread(blue, "Маша"));
        String AMD= "Команда 'Красные':";
        String Intel= "Команда 'Синие':";
        for (Jthread player:players) {
            String temp=String.format("\n%s<%s>", player.getName(), player.getThreadGroup().getName());
            if (player.getThreadGroup().equals(red)) AMD+=temp;
            else Intel+=temp;
        }
        System.out.printf("%s\n\n%s\n\n",AMD,Intel);
        System.out.println("Введите порог победы:");
        Scanner sk=new Scanner(System.in);
        goal=sk.nextInt();
        for (Jthread player:players) {
            player.start();
        }
    }
}