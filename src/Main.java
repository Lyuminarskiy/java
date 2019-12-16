import FileEditor.CSVFileEditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var file = new File(args[0]);
        var command = args[1];
        String data;
        try {
            data = args[2];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            data = "all";
        }
        var fileReader = new BufferedReader(new FileReader(file));
        switch (command.toLowerCase()){
            case "show":{
                CSVFileEditor.show(data, fileReader);
                break;
            }
            case "update":{
                CSVFileEditor.update(data, fileReader, file);
                break;
            }
            case "delete":{
                CSVFileEditor.delete(data, fileReader, file);
                break;
            }
        }
    }
}
