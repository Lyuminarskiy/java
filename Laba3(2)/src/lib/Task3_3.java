package lib;

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

    public void Delete(Population ppl) {
        table.remove(ppl);
    }

    public void Show() {
        String format = "|%1$5s |%2$10s |%3$10s |%4$10s |%5$7s |\n";
        System.out.format(format, "YEAR", "TOTAL", "BIRTHS", "DEATHS", "RATE");
        System.out.format(format, "----", "---------", "---------", "---------", "------");

        for (Population ppl : table) {
            double total = ppl.getNewbornCount();
            double born = (ppl.getPopulationCount());
            double rate = born / total * 1000;

            System.out.format(format, ppl.getYear(),
                    ppl.getPopulationCount(), ppl.getNewbornCount(), ppl.getDeathCount(),
                    (int)rate);
        }
    }
}
