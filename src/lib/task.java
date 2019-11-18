package lib;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class task {
    public static String sort(String str){
        var arr=str.split(" ");
        Arrays.sort(arr, new SortByLength());
        str="";
        for (var word:arr) {
            str+=word+" ";
        }
        return str;
    }

    static class SortByLength implements Comparator<String>
    {
        public int compare(String a, String b)
        {
            return b.length()-a.length();
        }
    }

    public static boolean isPhone(String str)
    {
        return Pattern.matches("^\\+\\d\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$",str);
    }
}
