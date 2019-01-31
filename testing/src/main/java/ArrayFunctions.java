import java.util.Arrays;

public class ArrayFunctions {

    public static int [] endAfterFour(int mas[]) throws RuntimeException{
        if (mas.length == 0) throw new RuntimeException();

        boolean masCreate = false;
        for (int i = mas.length-1; i >=0 ; i--) {
            if (mas[i]==4){
              return Arrays.copyOfRange(mas,i+1,mas.length);
            }

        }
        if (!masCreate)throw new RuntimeException();

        return null;
    }
    public static  boolean chekArray(int mas []){
        boolean oneOk=false;
        boolean fourOk =false;
        for (int i = 0; i <mas.length ; i++) {
            if (!oneOk) oneOk = mas[i]==1;
            if (!fourOk) fourOk = mas[i]==4;
            if (oneOk && fourOk) return true;
        }
        return false;
    }
}
