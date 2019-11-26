package lib;

import java.lang.reflect.Array;
import java.util.*;

public class Task3_3 {

    String path;
    public List<Population> table;

    public Task3_3(String path){
        this.path = path;
        this.table = PopulationData.getData(path);
    }

    public void Update(Population ppl) {
        if (!table.contains(ppl)) {
            table.add(ppl);
            Collections.sort(table);
            if (PopulationData.writeData(table, path)) {
                System.out.format("<%s> <%s> UPDATE %s, %s, %s, %s\n--\n%s added in <%s>\n","hz", path,
                        ppl.getYear(), ppl.getPopulationCount(), ppl.getNewbornCount(), ppl.getDeathCount(),
                        ppl.getYear(), path);
            }
        } else {
            table.set(table.indexOf(ppl), ppl);
            if (PopulationData.writeData(table, path)) {
                System.out.format("<%s> <%s> UPDATE %s, %s, %s, %s\n--\n%s updated in <%s>\n","hz", path,
                        ppl.getYear(), ppl.getPopulationCount(), ppl.getNewbornCount(), ppl.getDeathCount(),
                        ppl.getYear(), path);
            }
        }
    }

    public void Delete(int ...years) {
        String msg = String.format("<%s> <%s> DELETE%s\n--\n","hz",path, Arrays.toString(years));
        msg = msg.replace('[',' ');
        msg = msg.replace(']',' ');
        System.out.print(msg);

        for (int y:
            years){
            Population ppl = new Population(y, 1, 1, 1);
            if (table.contains(ppl)) {
                table.remove(ppl);
                System.out.print( String.format("%s deleted in <%s>\n", y, path));
            }
        }

        PopulationData.writeData(table, path);
    }

    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;
    }

    public void Show(int ...years) {
        String msg = String.format("<%s> <%s> DELETE%s\n--\n","hz",path, Arrays.toString(years));
        msg = msg.replace('[',' ');
        msg = msg.replace(']',' ');
        System.out.print(msg);
        String format = "|%1$5s |%2$10s |%3$10s |%4$10s |%5$7s |\n";
        System.out.format(format, "YEAR", "TOTAL", "BIRTHS", "DEATHS", "RATE");
        System.out.format(format, "----", "---------", "---------", "---------", "------");

        if (years.length != 0) {
            years = bubbleSort(years);
            for (int y : years) {
                Population ppl =
                        table.get(table.indexOf(new Population(y,1,1,1)));
                if (table.contains(ppl)) {
                    System.out.format(format, ppl.getYear(),
                            ppl.getPopulationCount(), ppl.getNewbornCount(), ppl.getDeathCount(),
                            ppl.getNewbornCount() - ppl.getDeathCount());
                }
            }
        } else {
            for (Population ppl : table) {
                System.out.format(format, ppl.getYear(),
                        ppl.getPopulationCount(), ppl.getNewbornCount(), ppl.getDeathCount(),
                        ppl.getNewbornCount() - ppl.getDeathCount());
            }
        }
    }
}
