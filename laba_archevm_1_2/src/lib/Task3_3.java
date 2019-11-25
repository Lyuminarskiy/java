package lib;
/*
* <имя_программы> <имя_файла> SHOW 2007,2011
* --
* | YEAR |     TOTAL |    BIRTHS |    DEATHS |      RATE |
* | ---- | --------- | --------- | --------- | --------- |
* | 2007 | 142862692 |   1610122 |   2080445 |   −470323 |
* | 2011 | 142865433 |   1796629 |   1925720 |   −129091 |
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
class Population{//contain obj
    private int year;
    private int populationCount;
    private int newbornCount;
    private int deathCount;

    Population(int year, int populationCount, int newbornCount, int deathCount){
        this.setYear(year);
        this.setPopulationCount(populationCount);
        this.setNewbornCount(newbornCount);
        this.setDeathCount(deathCount);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(int populationCount) {
        this.populationCount = populationCount;
    }

    public int getNewbornCount() {
        return newbornCount;
    }

    public void setNewbornCount(int newbornCount) {
        this.newbornCount = newbornCount;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }
}

abstract class PopulationData{
    public static List<Population> getData (String filePath) throws FileNotFoundException {//
        FileReader fr = new FileReader(filePath);
        ArrayList<Population> pd = new ArrayList<Population>() {};

        //pd.add(new Population(2007, 1,2,3));

        fr.close();
        return pd;
    }
}

public class Task3_3 {
    List<Population> table; //save table

    {
        table = PopulationData.getData("./russia_population.csv");
    }

    public void Update(Population ppl) {//Создаёт новую или изменяет существующую строку данных.
        if (!table.contains(ppl))
            table.add(ppl);
    }
    public void Delete(Population ppl) {//Удаляет строки данных.
        table.remove(ppl);
    }
    public void Show() {//Отображает строки данных. В качестве параметра команды
                        // пользователь должен указать список годов, разделённых запятой.
                        // Если параметр команды не был указан, то программа должна отобразить данные по всем годам.
        for (Population ppl:
             table) {
            System.out.println(String.format("%i %i %i %i", ppl.getYear(),
                    ppl.getPopulationCount(), ppl.getNewbornCount(), ppl.getDeathCount()));
        }
    }
}
