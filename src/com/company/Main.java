package com.company;
import lib.*;

public class Main {
    public static void main (String[] args)
    {
        if (args.length >= 3)
        {
            Comand.programName = args[0];
            Comand command = new Comand(args[1]);
            switch (args[2].toUpperCase())
            {
                case ("UPDATE"):
                    command.Update(args[3]);
                    break;
                case ("DELETE"):
                    command.Delete(args[3]);
                    break;
                case ("SHOW"):
                    if (args.length == 3)
                    {
                        command.Show();
                    }
                    else
                        {
                        command.Show(args[3]);
                    }
                    break;
            }
        }
    }
}
