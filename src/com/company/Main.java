package com.company;

public class Main {

    public static void main(String[] args){
        String fileName=args[0];
        String commandName=args[1];
        String commandData="";
        Integer argsAmount=args.length;
        if(argsAmount>2)
        {
            commandData=args[2];
        }
        DataControl.processingRequest(fileName,commandName,commandData,argsAmount);
    }
}
