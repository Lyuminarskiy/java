package lib;
import java.util.*;

public class Comand
{
    public static String programName = "";
    private String path;
    private List<Stats> data;

    public Comand(String path)
    {
        this.path = path;
        this.data = docOpers.getData(path);
    }

    private int[] convertToIntArray (String years)
    {
        String[] yearString = years.split(",");
        int[] arr = new int[yearString.length];

        for(int i = 0; i < yearString.length; i++)
        {
            arr[i] = Integer.parseInt(yearString[i]);
        }
        return arr;
    }

    public void Update(String data)
    {
        int[] array = convertToIntArray(data);
        if (array.length != 4)
        {
            throw new Error("not enough data");
        }
        else
            {
            Update (new Stats(array[0], array[1], array[2], array[3]));
        }
    }

    public void Update(Stats ppl)
    {
        if (!data.contains(ppl))
        {
            data.add(ppl);
            Collections.sort(data);

        } else
            {
            data.set(data.indexOf(ppl), ppl);
        }
        if (docOpers.writeData(data, path))
        {
            System.out.format("<%s> <%s> UPDATE %s, %s, %s, %s\n--\n%s added in <%s>\n",
                    programName, path, ppl.getYear(), ppl.getPplNum(), ppl.getBorn(), ppl.getDead(), ppl.getYear(), path);
        }
    }

    public void Delete(String years)
    {
        Delete(convertToIntArray(years));
    }

    public void Delete(int ...years)
    {
        String msg = String.format("<%s> <%s> DELETE%s\n--\n", programName,path, Arrays.toString(years));
        msg = msg.replace('[',' ');
        msg = msg.replace(']',' ');
        System.out.print(msg);

        for (int y : years)
        {
            if (data.contains(new Stats(y, 1, 1, 1)))
            {
                data.remove(new Stats(y, 1, 1, 1));
                System.out.print( String.format("%s deleted in <%s>\n", y, path));
            }
        }
        docOpers.writeData(data, path);
    }

    public void Show(String years)
    {
        Show(convertToIntArray(years));
    }

    private void printData(String format, Stats ppl)
    {
        System.out.format(format, ppl.getYear(),
                ppl.getPplNum(), ppl.getBorn(), ppl.getDead(),
                ppl.getBorn() - ppl.getDead());
    }

    public void Show(int ...years)
    {
        String msg = String.format("<%s> <%s> DELETE%s\n--\n", programName,path, Arrays.toString(years));
        msg = msg.replace('[',' ');
        msg = msg.replace(']',' ');
        System.out.print(msg);
        String format = "|%1$5s |%2$10s |%3$10s |%4$10s |%5$7s |\n";
        System.out.format(format, "YEAR", "TOTAL", "BIRTHS", "DEATHS", "RATE");
        System.out.format(format, "----", "---------", "---------", "---------", "------");

        if (years.length != 0)
        {
            Arrays.sort(years);
            for (int y : years)
            {
                Stats ppl = data.get(data.indexOf(new Stats(y,1,1,1)));
                if (data.contains(ppl))
                {
                    printData(format, ppl);
                }
            }
        } else
            {
            for (Stats ppl : data)
            {
                printData(format, ppl);
            }
        }
    }
}
