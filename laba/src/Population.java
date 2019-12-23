import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Population implements Comparable<Population>{
    private int year;
    private int total;
    private int births;
    private int deaths;
    private int rate;

    public int getYear(){
        return year;
    }
    public int getTotal(){
        return total;
    }
    public int getBirths(){
        return births;
    }
    public int getDeaths(){
        return deaths;
    }
    public int getRate(){
        return rate;
    }
    public Population(int year, int total, int births, int deaths) {
        this.year = year;
        this.total = total;
        this.births = births;
        this.deaths = deaths;
        this.rate =  births - deaths;
    }

    public String toString(){
        return String.format("%s,%s,%s,%s", this.getYear(), this.getTotal(), this.getBirths(), this.getDeaths());
    }

    public static void writeData(List<Population> populations, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        fw.write("");
        Iterator iter = populations.iterator();

        while(iter.hasNext()) {
            Population population = (Population)iter.next();
            fw.append(population.toString() + "\n");
        }
        fw.close();
    }

    public static List<Population> getData(String path) throws IOException {
            ArrayList pd = new ArrayList<Population>() { };
            BufferedReader reader = new BufferedReader(new FileReader(path));
            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] arg = line.split(",");
                Population population = new Population(
                        Integer.parseInt(arg[0]),
                        Integer.parseInt(arg[1]),
                        Integer.parseInt(arg[2]),
                        Integer.parseInt(arg[3]));
                pd.add(population);
            }
            reader.close();
        return pd;
    }

    @Override
    public int compareTo(Population population) {
        return Integer.compare(this.getYear(), population.getYear());
    }
}
