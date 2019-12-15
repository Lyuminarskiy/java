package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File file=new  File(args[0]);
        if(!file.exists()) {
            File newFile = new File(args[0]);
            try {
                newFile.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        try {
            FileReader reader = new FileReader(file);
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
