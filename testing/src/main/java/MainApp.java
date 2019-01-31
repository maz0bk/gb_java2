public class MainApp {
    public static void main(String[] args) {
        int mas[]={1,2,3,4,5,6,7,8,9,10};
        System.out.println(ArrayFunctions.chekArray(mas));
        System.out.println(ArrayFunctions.endAfterFour(mas));
        for (int i:ArrayFunctions.endAfterFour(mas)) {
            System.out.println(i);

        }
    }
}
