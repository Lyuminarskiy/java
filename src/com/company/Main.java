package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static lib.Command.*;
import static lib.Reader.readFile;

public class Main {
    public static void main(String[] args) {
        File file;
        String commandArgs;
        try{
            commandArgs = args[2];
        }catch (Throwable e){
            commandArgs = "";
        }
        try{
            file = new File(args[0]);
            file.createNewFile();
            String command = args[1];
            readFile(file);
            switch (command.toLowerCase()){
                case "show":
                    show(commandArgs);
                    break;
                case "update":
                    update(file, commandArgs);
                    break;
                case "delete":
                    delete(file, commandArgs);
                    break;
            }
            readFile(file);
        } catch(Throwable e){
            System.out.print(e);
            System.out.print("\nIncorrect input");
        }
    }
}
