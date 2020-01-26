package com.company;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Player> RedTeam = new ArrayList<>();
        ArrayList<Player> BlueTeam = new ArrayList<>();
        RedTeam.add(new Player(Data.red, "Слава"));
        BlueTeam.add(new Player(Data.blue, "Максим"));
        RedTeam.add(new Player(Data.red, "Егор"));
        BlueTeam.add(new Player(Data.blue, "Данил"));
        RedTeam.add(new Player(Data.red, "Даша"));
        BlueTeam.add(new Player(Data.blue, "Маша"));
        Data.Play(RedTeam, BlueTeam);
    }
}