package lib;
import java.util.Scanner;

public class InputProcessor {
    public InputProcessor() {
        System.out.println("Введите команду по шаблону:\n<имя_программы> <имя_файла> имя_функции параметры_через_запятую");

        Scanner scanner = new Scanner(System.in);
        findOutCommand(scanner.nextLine());
    }

    public static String PROGRAM_NAME = "";

    private void findOutCommand(String line){
        String[] arr = line.split(" ");

        if (arr.length >= 3){
            PROGRAM_NAME = arr[0];
            CommandProcessor cp = new CommandProcessor(arr[1]);
            switch (arr[2].toUpperCase()){
                case ("UPDATE"):
                    cp.Update(arr[3]);
                    break;
                case ("DELETE"):
                    cp.Delete(arr[3]);
                    break;
                case ("SHOW"):
                    if (arr.length == 3) {
                        cp.Show();
                    } else {
                        cp.Show(arr[3]);
                    }
                    break;
            }
        } else {
            System.out.println("Ошибка ввода\n");
            new InputProcessor();
        }
    }
}
