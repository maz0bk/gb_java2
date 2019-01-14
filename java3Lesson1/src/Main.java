import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String [] arr = {"a","b","c"};
        arr = changeElementPlace(arr,0,2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        ArrayList <String> list = arrayToArrayList(arr);
        for (String s: list ) {
            System.out.println(s);
        }
    }

    public static <T> T[] changeElementPlace( T[]arr, int firstElIndex, int secondElIndex){
        T tmp;
        tmp = arr[firstElIndex];
        arr[firstElIndex] = arr[secondElIndex];
        arr[secondElIndex] = tmp;
        return arr;
    }

    public static <T> ArrayList arrayToArrayList(T[]arr){
        ArrayList<T> list = new ArrayList<>();
        Arrays.asList(arr);
        Collections.addAll(list,arr);
        return list;
    }
}
