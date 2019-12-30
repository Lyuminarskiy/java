package com.company;

import java.util.ArrayList;

public class DataControl {

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

    public static void showData(ArrayList<ArrayList<Integer>> data, Integer argsAmount, String commandData){
        System.out.println("| YEAR |     TOTAL |    BIRTHS |    DEATHS |      RATE |\n| ---- | --------- | --------- | --------- | --------- |");
        if(argsAmount==2)
        {
            for (var line:data) {
                System.out.println(String.format("| %s | %9s | %9s | %9s | %9s |", line.get(0), line.get(1), line.get(2), line.get(3),  line.get(2)- line.get(3)));
            }
        }
        else{
            var years=commandData.split(",");
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

    public static void processingRequest(String fileName, String commandName, String commandData, Integer argsAmount){
        ArrayList<ArrayList<Integer>> data=FileControl.takeDataFromFile(fileName);
        if(commandName.equals("UPDATE")){
            data=updateData(commandData,data,fileName);
            FileControl.writeFile(data,fileName);
        }
        else if(commandName.equals("DELETE")){
            data=deleteData(commandData,data,fileName);
            FileControl.writeFile(data,fileName);
        }
        else if(commandName.equals("SHOW")){
            showData(data,argsAmount,commandData);
        }
    }
}
