package main;
import lib.LibraryFunction;
public class Main {
    public static void main(String[] args) {
	// write your code here
        System.out.println(LibraryFunction.sort("a bbb cccc ddd e")); // "cccc bbb ddd a e"
        System.out.println(LibraryFunction.isPhone ("+7(123)456-78-90")); // true
        System.out.println(LibraryFunction.isPhone ("81234567890")); // false
    }
}
