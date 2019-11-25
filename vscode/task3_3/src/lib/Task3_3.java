package lib;

/*
* <имя_программы> <имя_файла> SHOW 2007,2011
* --
* | YEAR |     TOTAL |    BIRTHS |    DEATHS |      RATE |
* | ---- | --------- | --------- | --------- | --------- |
* | 2007 | 142862692 |   1610122 |   2080445 |   −470323 |
* | 2011 | 142865433 |   1796629 |   1925720 |   −129091 |
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

abstract class PopulationData {
    public static List<Population> getData(String filePath) {
        ArrayList<Population> pd = new ArrayList<Population>() {
        };

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                String[] arguments = line.split(",");
                Population ppl = new Population(
                    Integer.parseInt(arguments[0]), 
                    Integer.parseInt(arguments[1]),
                    Integer.parseInt(arguments[2]), 
                    Integer.parseInt(arguments[3]));
                pd.add(ppl);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pd;
    }
}

public class Task3_3 {

    public List<Population> table = PopulationData.getData("russia_population.csv");

    public void Update(Population ppl) {// Создаёт новую или изменяет существующую строку данных.
        if (!table.contains(ppl)) {
            table.add(ppl);
            System.out.println("Evrika");
        }
    }

    public void Delete(Population ppl) {// Удаляет строки данных.
        table.remove(ppl);
    }

    public void Show() {// Отображает строки данных. В качестве параметра команды
                        // пользователь должен указать список годов, разделённых запятой.
                        // Если параметр команды не был указан, то программа должна отобразить данные по
                        // всем годам.
        for (Population ppl : table) {
            System.out.println(String.format("%s %s %s %s", ppl.getYear(), ppl.getPopulationCount(),
                    ppl.getNewbornCount(), ppl.getDeathCount()));
        }
    }
}
