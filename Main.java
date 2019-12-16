package com.company;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        FileProcessor.file = new File(args[0]);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FileProcessor.file, true));
        FileProcessor.fileReader = new BufferedReader(new FileReader(FileProcessor.file));
        try{
            FileProcessor.data = args[2];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            FileProcessor.data="All";
        }
        switch (args[1].toLowerCase()) {
            case "update": FileProcessor.update();
                break;
            case "delete": FileProcessor.delete();
                break;
            case "show": FileProcessor.show();
                break;
        }
    }
}
