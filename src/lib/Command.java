package lib;

import java.io.*;
import java.util.Iterator;

import static lib.Reader.*;

public class Command{
    public static void show(String interval) throws FileNotFoundException {
        System.out.printf("|%5s|%5s|%6s|%6s|%6s|\n|-----|-----|------|------|------|\n", "YEAR", "TOTAL", "BIRTHS", "DEATHS", "RATE");
        if(!interval.equals("")){
            int start = Integer.parseInt(interval.split(",")[0]);
            int end = Integer.parseInt(interval.split(",")[1]);
            for (String[] item: formattedFileData) {
                if (Integer.parseInt(item[0]) >= start && Integer.parseInt(item[0]) <= end)
                System.out.printf("|%5s|%5s|%6s|%6s|%6d|\n", item[0], item[1], item[2], item[3], Integer.parseInt(item[2]) - Integer.parseInt(item[3]));
            }
        }
        else{
            for (String[] item: formattedFileData) {
                System.out.printf("|%5s|%5s|%6s|%6s|%6d|\n", item[0], item[1], item[2], item[3], Integer.parseInt(item[2]) - Integer.parseInt(item[3]));
            }
        }
    }
    public static void update(File file, String newRowData) throws IOException {
        FileWriter myWriter = new FileWriter(file);
        String[] formattedRowData = newRowData.split(",");
        String year = formattedRowData[0];
        boolean containsLine = false;
        for (String[] item: formattedFileData) {
            if (item[0].equals(year)){
                myWriter.write(formattedRowData[0]+';'+formattedRowData[1]+';'+formattedRowData[2]+';'+formattedRowData[3]+System.getProperty("line.separator"));
                containsLine = true;
                System.out.printf("%s updated in %s", year, file.getName());
            }
            else{
                myWriter.write(item[0]+';'+item[1]+';'+item[2]+';'+item[3]+System.getProperty("line.separator"));
            }
        }
        if (!containsLine){
            myWriter.write(formattedRowData[0]+';'+formattedRowData[1]+';'+formattedRowData[2]+';'+formattedRowData[3]+System.getProperty("line.separator"));
            System.out.printf("%s created in %s", year, file.getName());
        }
        myWriter.close();
    }
    public static void delete(File file, String rowsToDelete) throws IOException {
        String[] needDelete = rowsToDelete.split(",");
        Iterator<String[]> i = formattedFileData.iterator();
        while (i.hasNext()) {
            String[] item = i.next();
            for (String year: needDelete){
                if (item[0].equals(year)){
                    i.remove();
                    System.out.printf("%s deleted in %s\n", year, file.getName());
                }
            }
        }
        FileWriter myWriter = new FileWriter(file);
        for (String[] item: formattedFileData) {
            myWriter.write(item[0]+';'+item[1]+';'+item[2]+';'+item[3]+System.getProperty("line.separator"));
        }
        myWriter.close();
    }
}