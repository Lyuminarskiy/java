package lib;

public class LibraryFunction {
    public static String sort (String str)
    {
        int indexMax = 0;
        String newStr = "", symbol= " ";
        String [] words = str.split(symbol);
        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > words[indexMax].length())
                    indexMax = i;//lib
            }
            newStr = newStr + words[indexMax];
            if (((k+1) % words.length) != 0)
                newStr+=symbol;
            words[indexMax] = "";
            indexMax = 0;
        }
        return newStr;
    }
    public static boolean isPhone (String str) {
        String pattern = "^\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";//регулярное выражение
        return str.matches(pattern);
    }
}
