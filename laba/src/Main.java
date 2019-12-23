import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
            TaskList.programName = args[0];
            TaskList taskList = new TaskList(args[1]);
            List<String> list = new ArrayList<String>(Arrays.asList(args[3].split(" , ")));
            switch (args[2].toUpperCase()){
                case ("UPDATE"):
                    taskList.Update(args[3]);
                    break;
                case ("DELETE"):
                    taskList.Delete(args[3]);
                    break;
                case ("SHOW"):
                    taskList.Show(args[3]);
                    break;
            }
    }
}