package com.company;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        String data;
        try{
            data = args[2];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            data="All";
        }
        //Передавать что-то одно.
        switch (args[1].toLowerCase()) {
            case "update": FileProcessor.update(data, file);
                break;
            case "delete": FileProcessor.delete(data, file);
                break;
            case "show": FileProcessor.show(data, file);
                break;
        }
    }
}
