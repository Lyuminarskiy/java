package com.company;

import lib.Game;
import lib.Player;

import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Player> RedTeam = new ArrayList<>();
        ArrayList<Player> BlueTeam = new ArrayList<>();

        RedTeam.add(new Player(Game.red, "Иван"));
        RedTeam.add(new Player(Game.red, "Марина"));
        RedTeam.add(new Player(Game.red, "Анна"));
        BlueTeam.add(new Player(Game.blue, "Михаил"));
        BlueTeam.add(new Player(Game.blue, "Сергей"));
        BlueTeam.add(new Player(Game.blue, "Ольга"));

        Game.Play(RedTeam, BlueTeam);
    }
}