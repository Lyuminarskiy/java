import lib.L;
import static lib.L.isPhone;

public class Main {
    public static void main(String [] args) {
        String str = "a bbb cccc ddd e";
        System.out.println( L.sort(str));
        String number1 = "+7(123)456-78-90"; // true
        String number2 = "+71234567890";     // false
        System.out.println(isPhone(number1));
        System.out.println(isPhone(number2));
    }
}
