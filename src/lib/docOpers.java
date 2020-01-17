package lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class docOpers
{
    public static boolean writeData (List<Stats> populations, String path) {
        try
        {
            FileWriter fw = new FileWriter(path);

            fw.write("");

            for (Stats ppl : populations)
            {
                fw.append(ppl.toString()).append("\n");
            }

            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<Stats> getData(String filePath)
    {
        ArrayList<Stats> doc = new ArrayList<Stats>()
        {
        };

        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null)
            {
                String[] arguments = line.split(",");
                Stats ppl = new Stats
                        (
                        Integer.parseInt(arguments[0]),
                        Integer.parseInt(arguments[1]),
                        Integer.parseInt(arguments[2]),
                        Integer.parseInt(arguments[3])
                    );
                doc.add(ppl);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return doc;
    }

}
