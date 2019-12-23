package lib;

public class liber {

    public static void sort(String kek) {
        String[] wordList = kek.split(" ");
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
        for(int i = 0; i < wordList.length;i++)
        {
            System.out.printf("%s ", wordList[i]);
        }
    }

    public static boolean isPhone(String kek){
        int len = 0;
        boolean result = false;
        if(kek.charAt(0) == '+' && kek.charAt(2) == '(' && kek.charAt(6) == ')' && kek.charAt(10) == '-' && kek.charAt(13) == '-')
        {
            for(int i = 0; i<kek.length(); i++){
                len++;
            }
            if (len == 16) result = true;
        }
        else result = false;
        return result;
    }
}
