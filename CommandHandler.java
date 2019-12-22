package lib;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CommandHandler {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        String command = args[1];
        String data;
        try {
            data = args[2];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            data = "all";
        }
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        switch (command.toLowerCase()){
            case "show":{
                FileEditor.show(data, fileReader);
                break;
            }
            case "update":{
                FileEditor.update(data, fileReader, file);
                break;
            }
            case "delete":{
                FileEditor.delete(data, fileReader, file);
                break;
            }
        }
    }
}