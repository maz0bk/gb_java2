import java.lang.reflect.InvocationTargetException;

public class MainApp {
    public static void main(String[] args) {
        try {
            Invoker.start(MyTests.class);
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
