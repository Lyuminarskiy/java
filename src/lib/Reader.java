package lib;

import com.company.Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Reader {
    public static ArrayList<String[]> data;
    public static void readFile() throws IOException {
        Scanner myReader = new Scanner(Main.file);
        data = new ArrayList<>();
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] splittedLine = line.split(";");
            data.add(splittedLine);
        }
        myReader.close();
        sortData();
        FileWriter myWriter = new FileWriter(Main.file);
        for (String[] item: data) {
            myWriter.write(item[0]+';'+item[1]+';'+item[2]+';'+item[3]+System.getProperty("line.separator"));
        }
        myWriter.close();
    }
    public static void sortData(){
        Collections.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

    }
}