import java.lang.String;
import static lib.L.sort;
import static lib.L.isPhone;

public class Main {



    public static void main(String [] args) {
        String [] names = {"A", "AAAA", "AAA", "AAAAAA", "AA"};
        String a = "";
        for(String str : names){
            a += str + " ";
        }

        names = sort(a);
        for(String st : names){
            System.out.println(st);
        }

        String number = "+7(123)456-78-90"; // true
        System.out.println(isPhone(number));

    }


}
