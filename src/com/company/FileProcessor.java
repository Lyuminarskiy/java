package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class FileProcessor {

    static void show(String data, File file) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        StringBuilder text = new StringBuilder();
        text.append("| YEAR |     TOTAL |    BIRTHS |    DEATHS |      RATE |\n| ---- | --------- | --------- | --------- | --------- |\n");
        String line = null;
        List<String> years = Arrays.asList(data.split(","));
        try {
            while((line = fileReader.readLine()) != null){
                if ((years.contains(line.split(",")[0]))||(data.equals("All"))){
                    String[] dataOut = line.split(",");
                    int prirost = Integer.parseInt(dataOut[2]) - Integer.parseInt(dataOut[3]);
                    text.append(String.format("| %s | %9s | %9s | %9s | %9s |\n", dataOut[0], dataOut[1], dataOut[2], dataOut[3], Integer.toString(prirost)));
                }
            }
        }
        finally {
            fileReader.close();
        }
        System.out.println(text.toString());
    }

    static void update(String data, File file) throws IOException{
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            StringBuilder text = new StringBuilder();
            String line = null;
            String year = data.split(",")[0];
            String successMsg = "created";
            while((line = fileReader.readLine()) != null){
                if (line.split(",")[0].equals(year)){
                    text.append(data);
                    text.append("\n");
                    successMsg = "updated";
                }
                else {
                    text.append(line);
                    text.append("\n");
                }
            }
            if (successMsg.equals("created")) {
                text.append(data);
                text.append("\n");
                text = sort(text);
            }
            try (FileWriter fileWriter = new FileWriter(file)){
                fileWriter.write(text.toString());
                System.out.println(String.format("%s %s in %s", year, successMsg, file.getName()));
            }
        }
        catch (IOException e){
            System.out.println(e.toString());
        }
    }

    static void delete(String data, File file) throws IOException{
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            StringBuilder text = new StringBuilder();
            String line = null;
            List<String> years = Arrays.asList(data.split(","));
            StringBuilder deletedLines = new StringBuilder();
            while ((line = fileReader.readLine()) != null) {
                if (years.contains(line.split(",")[0])){
                    deletedLines.append(String.format("%s deleted in %s\n", line.split(",")[0], file.getName()));
                }
                else {
                    text.append(line);
                    text.append("\n");
                }
            }
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(text.toString());
                System.out.println(deletedLines.toString());
            }
        }
        catch (IOException e){
            System.out.println(e.toString());
        }
    }
    private static StringBuilder sort(StringBuilder text){
        List<String> lines = Arrays.asList(text.toString().split("\n"));
        lines.sort((new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.split(",")[0].compareTo(o2.split(",")[0]);
            }
        }));
        text = new StringBuilder();
        for (String line : lines) {
            text.append(line);
            text.append("\n");
        }
        return text;
    }

}
