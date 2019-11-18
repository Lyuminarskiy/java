package lib;

import java.util.regex.Pattern;

public class Functions{
    public static String sort(String str){
        var temp = str.split(" ");
        if (temp.length > 0){
            var maxLen = temp[0].length();
            var flag = true;
            while (flag){
                flag = false;
                for (int i = 0; i < temp.length - 1; i++) {
                    if (temp[i + 1].length() > temp[i].length()){
                        var q = temp[i];
                        temp[i] = temp[i+1];
                        temp[i+1] = q;
                        flag = true;
                    }
                }
            }
            return String.join(" ", temp);
        }
        else return str;
    }

    public static boolean isPhone(String str){
        return Pattern.matches("\\+\\d\\(\\d{3}\\)\\d{3}-\\d\\d-\\d\\d", str);
    }
}


