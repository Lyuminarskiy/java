package lib;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class FileEditor {

    public static void show(String _data, BufferedReader _fileReader) throws IOException{
        StringBuilder text = new StringBuilder();
        boolean isExistData = false;
        text.append("| YEAR |   TOTAL   |   BIRTHS  |   DEATHS  |    RATE   |" +
                "  \n| ---- | --------- | --------- | --------- | --------- |\n");
        String line;
        int changes;
        List<String> years = Arrays.asList(_data.split(","));
        try (_fileReader) {
            while ((line = _fileReader.readLine()) != null) {
                if (years.contains(line.split(",")[0]) || _data.equals("all")) {
                    isExistData = true;
                    String[] data = line.split(",");
                    changes = Integer.parseInt(data[2]) - Integer.parseInt(data[3]);
                    text.append(String.format("| %s | %9s | %9s | %9s | %9s |\n",
                            data[0], data[1], data[2], data[3], Integer.toString(changes)));
                }
            }
        }
        if (isExistData)
            System.out.println(text.toString());
        else
            System.out.println("Данных в заданном диапазоне не существует!");
    }

    public static void update(String _data, BufferedReader _fileReader, File _file) throws IOException{
        try {
            StringBuilder text = new StringBuilder();
            String line;
            String year = _data.split(",")[0];
            String successMsg = "created";
            while((line = _fileReader.readLine()) != null){
                if (line.split(",")[0].equals(year)){
                    text.append(_data);
                    text.append("\n");
                    successMsg = "updated";
                }
                else {
                    text.append(line);
                    text.append("\n");
                }
            }
            if (successMsg.equals("created")) {
                text.append(_data);
                text.append("\n");
                text = sort(text);
            }
            try (FileWriter fileWriter = new FileWriter(_file)){
                fileWriter.write(text.toString());
                System.out.println(String.format("%s %s in %s", year, successMsg, _file.getName()));
            }
        }
        catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public static void delete(String _data, BufferedReader _fileReader, File _file) {
        try {
            StringBuilder text = new StringBuilder();
            String line;
            List<String> years = Arrays.asList(_data.split(","));
            StringBuilder deletedLines = new StringBuilder();
            while ((line = _fileReader.readLine()) != null) {
                if (years.contains(line.split(",")[0])){
                    deletedLines.append(String.format("%s deleted in %s\n", line.split(",")[0], _file.getName()));
                }
                else {
                    text.append(line);
                    text.append("\n");
                }
            }
            try (FileWriter fileWriter = new FileWriter(_file)) {
                fileWriter.write(text.toString());
                System.out.println(deletedLines.toString());
            }
        }
        catch (IOException e){
            System.out.println(e.toString());
        }
    }
    private static StringBuilder sort (StringBuilder text){
        List<String> lines = Arrays.asList(text.toString().split("\n"));
        lines.sort(
                Comparator.comparing(line -> line.split(",")[0])
        );
        text = new StringBuilder();
        for (String line:lines) {
            text.append(line);
            text.append("\n");
        }
        return text;
    }
}
