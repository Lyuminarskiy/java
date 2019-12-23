package lib;
import java.util.*;

public class CommandProcessor {

    public static String PROGRAM_NAME = "";
    private String path;
    private List<Population> table;

    public CommandProcessor(String path){
        this.path = path;
        this.table = PopulationData.getData(path);
    }

    private int[] convertToIntArray (String years) {
        String[] strArray = years.split(",");
        int[] intArray = new int[strArray.length];
        for(int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public void Update(String data) {
        int[] array = convertToIntArray(data);
        if (array.length != 4) {
            throw new Error("недостаточно данных");
        } else {
            Update(new Population(array[0], array[1], array[2], array[3]));
        }
    }

    public void Update(Population ppl) {
        if (!table.contains(ppl)) {
            table.add(ppl);
            Collections.sort(table);

        } else {
            table.set(table.indexOf(ppl), ppl);
        }
        if (PopulationData.writeData(table, path)) {
            System.out.format("<%s> <%s> UPDATE %s, %s, %s, %s\n--\n%s added in <%s>\n",PROGRAM_NAME, path,
                    ppl.getYear(), ppl.getPopulationCount(), ppl.getNewbornCount(), ppl.getDeathCount(),
                    ppl.getYear(), path);
        }
    }

    public void Delete(String years) {
        Delete(convertToIntArray(years));
    }

    public void Delete(int ...years) {
        String msg = String.format("<%s> <%s> DELETE%s\n--\n",PROGRAM_NAME,path, Arrays.toString(years));
        msg = msg.replace('[',' ');
        msg = msg.replace(']',' ');
        System.out.print(msg);

        for (int y : years){
            if (table.contains(new Population(y, 1, 1, 1))) {
                table.remove(new Population(y, 1, 1, 1));
                System.out.print( String.format("%s deleted in <%s>\n", y, path));
            }
        }

        PopulationData.writeData(table, path);
    }

    public void Show(String years) {
        Show(convertToIntArray(years));
    }

    private void printData(String format, Population ppl) {
        System.out.format(format, ppl.getYear(),
                ppl.getPopulationCount(), ppl.getNewbornCount(), ppl.getDeathCount(),
                ppl.getNewbornCount() - ppl.getDeathCount());
    }

    public void Show(int ...years) {
        String msg = String.format("<%s> <%s> DELETE%s\n--\n",PROGRAM_NAME,path, Arrays.toString(years));
        msg = msg.replace('[',' ');
        msg = msg.replace(']',' ');
        System.out.print(msg);
        String format = "|%1$5s |%2$10s |%3$10s |%4$10s |%5$7s |\n";
        System.out.format(format, "YEAR", "TOTAL", "BIRTHS", "DEATHS", "RATE");
        System.out.format(format, "----", "---------", "---------", "---------", "------");

        if (years.length != 0) {
            Arrays.sort(years);
            for (int y : years) {
                Population ppl =
                        table.get(table.indexOf(new Population(y,1,1,1)));
                if (table.contains(ppl)) {
                    printData(format, ppl);
                }
            }
        } else {
            for (Population ppl : table) {
                printData(format, ppl);
            }
        }
    }
}
