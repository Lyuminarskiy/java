package lib;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StringManipulation {

    public static String sort(String str){

        String[] stringArray = str.split(" ");
        Arrays.sort(stringArray, (o1, o2) -> o1.length() - o2.length());

        return String.join(" ", stringArray);
    }

    public static boolean isPhone(String str){

        return Pattern.matches("\\+\\d\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}", str);
    }
}