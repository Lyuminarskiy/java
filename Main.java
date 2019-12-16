package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static File file;
    private static BufferedReader fileReader;
    private static String data;

    private static void show() throws IOException{
        StringBuilder text = new StringBuilder();
        text.append("| YEAR |     TOTAL |    BIRTHS |    DEATHS |      RATE |\n| ---- | --------- | --------- | --------- | --------- |\n");
        String line = null;
        List<String> years = Arrays.asList(data.split(","));
        try {
            while((line = fileReader.readLine()) != null){
                if ((years.contains(line.split(",")[0]))||(data.equals("All"))){
                    String[] data = line.split(",");
                    int prirost = Integer.parseInt(data[2]) - Integer.parseInt(data[3]);
                    text.append(String.format("| %s | %9s | %9s | %9s | %9s |\n", data[0], data[1], data[2], data[3], Integer.toString(prirost)));
                }
            }
        }
        finally {
            fileReader.close();
        }
        System.out.println(text.toString());
    }

    private static void update() throws IOException{
        try {
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

    private static void delete() throws IOException{
        try {
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


    public static void main(String[] args) throws IOException {
        file = new File(args[0]);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));
        fileReader = new BufferedReader(new FileReader(file));
        try{
            data = args[2];
        }
        catch (ArrayIndexOutOfBoundsException ex){
            data="All";
        }
        switch (args[1].toLowerCase()) {
            case "update": update();
                break;
            case "delete": delete();
                break;
            case "show": show();
                break;
        }
    }
}
