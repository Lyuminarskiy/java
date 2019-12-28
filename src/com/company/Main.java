package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

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

    public static ArrayList<ArrayList<Integer>> updateData(String newData, ArrayList<ArrayList<Integer>> data, String fileName) {
        var updateData=newData.split(",");
        int deleteIndex=-1;
        for(int i=0; i<data.size();i++){
            if(data.get(i).size()>0) {
                if (data.get(i).get(0) == Integer.parseInt(updateData[0])) {
                    deleteIndex = i;
                }
            }
        }
        if(deleteIndex!=-1){
            data.remove(deleteIndex);
            System.out.println("--\n"+updateData[0]+" updated in "+fileName);
        }
        else{
            System.out.println("--\n"+updateData[0]+" created in "+fileName);
            deleteIndex=0;
            while(deleteIndex<data.size()){
                if(data.get(deleteIndex).size()>0) {
                    if (data.get(deleteIndex).get(0) > Integer.parseInt(updateData[0])) {
                        break;
                    }
                }
                deleteIndex++;
            }
        }
        data.add(deleteIndex,new ArrayList<Integer>());
        for (var n:updateData) {
            data.get(deleteIndex).add(Integer.parseInt(n));
        }
        return data;
    }

    public static ArrayList<ArrayList<Integer>> deleteData(String oldData, ArrayList<ArrayList<Integer>> data, String fileName){
        System.out.println("--");
        var years=oldData.split(",");
        for (var year:years) {
            var index=-1;
            for (var i=0;i<data.size();i++) {
                if(Integer.parseInt(year)==data.get(i).get(0)){
                    index=i;
                }
            }
            if(index!=-1){
                data.remove(index);
                System.out.println(year+" deleted in "+fileName);
            }
        }
        return data;
    }

    public static void showData(String[] args, ArrayList<ArrayList<Integer>> data){
        System.out.println("| YEAR |     TOTAL |    BIRTHS |    DEATHS |      RATE |\n| ---- | --------- | --------- | --------- | --------- |");
        if(args.length==2)
        {
            for (var line:data) {
                System.out.println(String.format("| %s | %9s | %9s | %9s | %9s |", line.get(0), line.get(1), line.get(2), line.get(3),  line.get(2)- line.get(3)));
            }
        }
        else{
            var years=args[2].split(",");
            for (var year:years) {
                var index=-1;
                for(var i=0;i<data.size();i++){
                    if(data.get(i).get(0)==Integer.parseInt(year)){
                        index=i;
                    }
                }
                if(index!=-1){
                    System.out.println(String.format("| %s | %9s | %9s | %9s | %9s |", data.get(index).get(0), data.get(index).get(1), data.get(index).get(2), data.get(index).get(3),  data.get(index).get(2)- data.get(index).get(3)));
                }
            }
        }
    }

    public static void writeFile(File file, ArrayList<ArrayList<Integer>> data){
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

    public static void main(String[] args){
        File file=openFile(args[0]);
        ArrayList<ArrayList<Integer>> data = readFile(file);
        if(args[1].equals("UPDATE")){
            data=updateData(args[2],data,args[0]);
            writeFile(file,data);
        }
        else if(args[1].equals("DELETE")){
            data=deleteData(args[2],data,args[0]);
            writeFile(file,data);
        }
        else if(args[1].equals("SHOW")){
            showData(args,data);
        }
    }
}
