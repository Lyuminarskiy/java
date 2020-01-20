package lib;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Reader {
    public static ArrayList<String[]> formattedFileData;
    public static void readFile(File file) throws IOException {
        Scanner myReader = new Scanner(file);
        formattedFileData = new ArrayList<>();
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] splittedLine = line.split(";");
            formattedFileData.add(splittedLine);
        }
        myReader.close();
        sortData();
        FileWriter myWriter = new FileWriter(file);
        for (String[] item: formattedFileData) {
            myWriter.write(item[0]+';'+item[1]+';'+item[2]+';'+item[3]+System.getProperty("line.separator"));
        }
        myWriter.close();
    }
    public static void sortData(){
        formattedFileData.sort((o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));
    }
}