package lib;

import java.util.Arrays;
import java.util.Comparator;

public class L {

    static class StringLengthSort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length()){
                return 1;
            }else{
                if(o1.length() < o2.length()){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }

    public static String[] sort(String str){
        Comparator<String> stringLengthComparator = new StringLengthSort();
        String[] names;
        names =  str.split(" ");
        // применяем сортировку
        Arrays.sort(names, stringLengthComparator);
        return names;

    }

    public static boolean isPhone(String str){

        char[] chars = str.toCharArray();
        if(chars[0] == '+' && chars[2] == '(' &&
                chars[6] == ')' && chars[10] == '-'
                && chars[13] == '-' && chars.length == 16){
            return true;
        }
        else
            return false;
    }
}
