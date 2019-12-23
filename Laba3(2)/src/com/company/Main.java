package com.company;
import lib.*;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 3){
            CommandProcessor.PROGRAM_NAME = args[0];
            CommandProcessor cp = new CommandProcessor(args[1]);
            switch (args[2].toUpperCase()){
                case ("UPDATE"):
                    cp.Update(args[3]);
                    break;
                case ("DELETE"):
                    cp.Delete(args[3]);
                    break;
                case ("SHOW"):
                    if (args.length == 3) {
                        cp.Show();
                    } else {
                        cp.Show(args[3]);
                    }
                    break;
            }
        }
    }
}