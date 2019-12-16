package com.company;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String data;
        try{
            data = args[2];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            data="All";
        }
        switch (args[1].toLowerCase()) {
            case "update": FileProcessor.update(fileReader, data, file);
                break;
            case "delete": FileProcessor.delete(fileReader, data, file);
                break;
            case "show": FileProcessor.show(fileReader, data);
                break;
        }
    }
}
