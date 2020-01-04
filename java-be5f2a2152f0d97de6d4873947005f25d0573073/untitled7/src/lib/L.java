package lib;
import java.util.Arrays;
import java.util.regex.Pattern;

public class L {
    public static String sort(String str){
        String[] arrayStr = str.split(" ");
        Arrays.sort(arrayStr, (o1, o2) -> o1.length() - o2.length());
        return String.join(" ", arrayStr);
    }

    public static boolean isPhone(String str){
        return Pattern.matches("\\+\\d\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}", str);
    }
}
