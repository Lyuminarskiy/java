package lib;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class algorithm {

    public static String sort(String str)
    {
        String[] array = str.split(" ");
        for (int i = 0; i < array.length-1; i++)
        {
            int b = array[i+1].length();
            int c = array[i].length();
            if (b > c)
            {
                String tmp = array[i];
                array[i] = array[i+1];
                array[i+1] = tmp;
                i = -1;
            }
        }
        return String.join(" ", array);
    }
    public static boolean isPhone(String line)
    {
        Pattern pat = Pattern.compile("\\+\\d\\(\\d{3}\\)\\d{3}\\-\\d{2}\\-\\d{2}");
        Matcher match = pat.matcher(line);
        return match.matches();
    }
}
