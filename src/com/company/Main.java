package com.company;

import java.io.File;
import java.io.IOException;

import static lib.Command.*;
import static lib.Reader.readFile;

public class Main {
    public static String arg;
    public static File file;
    public static void main(String[] args) throws IOException {
        try{
            arg = args[2];
        }catch (Throwable e){
            arg = "";
        }
        try{
            file = new File(args[0]);
            String command = args[1];
            readFile();
            if (!file.exists()) {
                file.createNewFile();
            }
            switch (command.toLowerCase()){
                case("show"):
                    show(arg);
                    break;
                case ("update"):
                    update(arg);
                    break;
                case ("delete"):
                    delete(arg);
                    break;
            }
            readFile();
        } catch(Throwable e){
            System.out.print(e);
            System.out.print("\nIncorrect input");
        }
    }
}
