import FileEditor.CSVFileEditor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var FileEditor = new CSVFileEditor(args);
        switch (FileEditor._command.toLowerCase()){
            case "show":{
                FileEditor.show();
                break;
            }
            case "update":{
                FileEditor.update();
                break;
            }
            case "delete":{
                FileEditor.delete();
                break;
            }
        }
    }
}
