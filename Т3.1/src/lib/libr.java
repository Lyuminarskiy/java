package lib;

public class libr {
    public static void sort(String[] arr) {
        for (int i = arr.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].length() < arr[j + 1].length()) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static boolean isPhone(String[] arr,String[] arr1){
        if(arr[0].equals(arr1[0]) && arr[1].equals(arr1[1]) && arr[2].equals(arr1[2]) && arr[6].equals(arr1[3]) && arr[10].equals(arr1[4]) && arr[13].equals(arr1[4]))
            return true;
        else
            return false;
    }
}
