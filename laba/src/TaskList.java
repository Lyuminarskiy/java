import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TaskList  {
    public  static String programName;
    private String path;
    private List<Population> table;
    public ArrayList<Integer> yearsList;

    public TaskList(String path) throws IOException {
        this.path = path;
        table = Population.getData(path);
        for (var i : table) {
           yearsList.add(i.getYear());
        }
        Collections.sort(table);
    }

    public List<Integer> ParseInt(String data){
        String[] years = data.split(",");
        List<Integer> list = null;
        for (var i : years) {
            list.add(Integer.parseInt(i));
        }
        return list;
    }

    public void Update(String data) throws IOException {
        String[] years = data.split(",");
        Population population = new Population(
                Integer.parseInt(years[0]),
                Integer.parseInt(years[1]),
                Integer.parseInt(years[2]),
                Integer.parseInt(years[3]));
        for (var i : table) {
            if(i.getYear() == population.getYear()) {
                table.set(table.indexOf(i), population);
            }
        }
        if(!table.contains(population)){
            table.add(population);
            Collections.sort(table);
        }
        Population.writeData(table, path);
        System.out.format("%s Updated in <%s>\n", population.getYear(), this.path);
    }

    public void Delete(String data) throws IOException {
        List<Integer> years = ParseInt(data);
        if(years.size() > 0) {
            for (var i : years) {
                if (yearsList.contains(i)) {
                    var t = table.size();
                    for (var j = 0; j < t; j++) {
                        if (table.get(j).getYear() == i) {
                            System.out.format("%s Deleted in <%s>\n", table.get(j).getYear(), path);
                            table.remove(j);
                            t--;
                            j--;
                        }
                    }
                }
            }
        }
        Population.writeData(table, path);
    }



    public void Show(String data) {
        List<Integer> years = ParseInt(data);

        String format = "|%1$5s |%2$10s |%3$10s |%4$10s |%5$10s |\n";
        System.out.format(format, "YEAR", "TOTAL", "BIRTHS", "DEATHS", "RATE");
        System.out.format(format, "----", "---------", "---------", "---------", "------");
        if (years.size() == 0) {
                Iterator iter = table.iterator();
                while (iter.hasNext()) {
                    Population population = (Population) iter.next();
                    System.out.format(format, population.getYear(),
                            population.getTotal(), population.getBirths(),
                            population.getDeaths(), population.getRate());
                }
        }
        else {
            for (var i : years) {
                Iterator iter = table.iterator();
                while (iter.hasNext()) {
                    Population population = (Population) iter.next();
                    if (i == population.getYear())
                        System.out.format(format, population.getYear(),
                                population.getTotal(), population.getBirths(),
                                population.getDeaths(), population.getRate());
                }
            }
        }
    }
}
