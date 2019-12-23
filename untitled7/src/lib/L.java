package lib;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L {
    static class StringLengthSort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length()){
                return 1;
            }
            else{
                if(o1.length() < o2.length()){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
    }

    public static String[] sort(String str){
        Comparator<String> stringLengthComparator = new StringLengthSort();
        String[] names;
        names =  str.split(" ");
        Arrays.sort(names, stringLengthComparator);
        return names;
    }

    public static boolean isPhone(String str){
        Pattern pattern = Pattern.compile("\\+\\d\\(\\d{3}\\)\\d{3}\\-\\d{2}\\-\\d{2}");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
}
