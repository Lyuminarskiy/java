package lib;

import com.company.Main;

import java.io.*;
import java.util.Iterator;

import static lib.Reader.*;

public class Command{
    public static void show(String arg) throws FileNotFoundException {
        System.out.printf("|%5s|%5s|%6s|%6s|%6s|\n|-----|-----|------|------|------|\n", "YEAR", "TOTAL", "BIRTHS", "DEATHS", "RATE");
        if(!arg.equals("")){
            Integer start = Integer.parseInt(arg.split(",")[0]);
            Integer end = Integer.parseInt(arg.split(",")[1]);
            for (String[] item: data) {
                if (Integer.parseInt(item[0]) >= start && Integer.parseInt(item[0]) <= end)
                System.out.printf("|%5s|%5s|%6s|%6s|%6d|\n", item[0], item[1], item[2], item[3], Integer.parseInt(item[2]) - Integer.parseInt(item[3]));
            }
        }
        else{
            for (String[] item: data) {
                System.out.printf("|%5s|%5s|%6s|%6s|%6d|\n", item[0], item[1], item[2], item[3], Integer.parseInt(item[2]) - Integer.parseInt(item[3]));
            }
        }
    }
    public static void update(String arg) throws IOException {
        FileWriter myWriter = new FileWriter(Main.file);
        String[] needUpdate = arg.split(",");
        String year = needUpdate[0];
        Boolean containsLine = false;
        for (String[] item: data) {
            if (item[0].equals(year)){
                myWriter.write(needUpdate[0]+';'+needUpdate[1]+';'+needUpdate[2]+';'+needUpdate[3]+System.getProperty("line.separator"));
                containsLine = true;
                System.out.printf("%s updated in %s", year, Main.file.getName());
            }
            else{
                myWriter.write(item[0]+';'+item[1]+';'+item[2]+';'+item[3]+System.getProperty("line.separator"));
            }
        }
        if (!containsLine){
            myWriter.write(needUpdate[0]+';'+needUpdate[1]+';'+needUpdate[2]+';'+needUpdate[3]+System.getProperty("line.separator"));
            System.out.printf("%s created in %s", year, Main.file.getName());
        }
        myWriter.close();
    }
    public static void delete(String arg) throws IOException {
        String[] needDelete = arg.split(",");
        Iterator<String[]> i = data.iterator();
        while (i.hasNext()) {
            String[] item = i.next();
            for (String year: needDelete){
                if (item[0].equals(year)){
                    i.remove();
                    System.out.printf("%s deleted in %s\n", year, Main.file.getName());
                }
            }
        }
        FileWriter myWriter = new FileWriter(Main.file);
        for (String[] item: data) {
            myWriter.write(item[0]+';'+item[1]+';'+item[2]+';'+item[3]+System.getProperty("line.separator"));
        }
        myWriter.close();
    }

}