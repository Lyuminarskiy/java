package lib;

import java.util.regex.Pattern;

public class lib {

    public static String sort(String str){
        String[] newstr=str.split(" ");
        for (int i=0; i<newstr.length; i++)
            for (int j=0; j<newstr.length-1; j++)
                if (newstr[j].length()<newstr[j+1].length()){
                    String a=newstr[j];
                    newstr[j]=newstr[j+1];
                    newstr[j+1]=a;
                }
        return String.join(" ", newstr);
    }

    public static boolean isPhone(String str){
        return Pattern.matches("\\+\\d\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}", str);
    }

}
