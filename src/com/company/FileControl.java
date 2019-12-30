package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileControl {

    public static File openFile(String fileName){
        File file=new  File(fileName);
        if(!file.exists()) {
            File newFile = new File(fileName);
            try {
                newFile.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return file;
    }

    public static ArrayList<ArrayList<Integer>> readFile(File file){
        ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
        try {
            FileReader reader = new FileReader(file);
            int c;
            int line=0;
            String stringNumber="";
            c=reader.read();
            while(c!=-1){
                if((char)c=='\n'){
                    data.get(line).add(Integer.parseInt(stringNumber));
                    stringNumber="";
                    line++;
                    data.add(new ArrayList<Integer>());
                }
                else if((char)c==','){
                    if(data.size()==0){
                        data.add(new ArrayList<Integer>());
                    }
                    data.get(line).add(Integer.parseInt(stringNumber));
                    stringNumber="";
                }
                else{
                    stringNumber+=(char)c;
                }
                c=reader.read();
            }
            if(stringNumber!=""){
                data.get(line).add(Integer.parseInt(stringNumber));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public static void writeFile(ArrayList<ArrayList<Integer>> data, String fileName){
        File file=openFile(fileName);
        try {
            FileWriter writer=new FileWriter(file,false);
            for (var i=0;i<data.size();i++) {
                for(var j=0;j<data.get(i).size();j++){
                    writer.write(Integer.toString(data.get(i).get(j)));
                    if(j!=data.get(i).size()-1){
                        writer.append(',');
                    }
                }
                if(i!=data.size()-1){
                    writer.append('\n');
                }
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<ArrayList<Integer>> takeDataFromFile(String fileName){
        File file=FileControl.openFile(fileName);
        ArrayList<ArrayList<Integer>> data = readFile(file);
        return data;
    }
}
