package lib;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class liber {

    public static String sort(String text) {
        String[] wordList = text.split(" ");
        boolean isSorted = false;
        String buf = null;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < wordList.length - 1; i++) {
                if (wordList[i].length() < wordList[i + 1].length()) {
                    isSorted = false;
                    buf = wordList[i];
                    wordList[i] = wordList[i + 1];
                    wordList[i + 1] = buf;
                }
            }
        }
        return String.join(" ",wordList);
    }

    public static boolean isPhone(String text){
        Pattern pattern = Pattern.compile("\\+\\d\\(\\d{3}\\)\\d{3}\\-\\d{2}\\-\\d{2}");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
