import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Invoker {
    public static void start(Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methods = c.getDeclaredMethods();
        boolean beforeSuiteIsDone = false;
        TreeMap<Integer, Method> priorityMethods = new TreeMap();
        Method afterSuiteMethod = null;
        Integer tmpPriority;
        Object myTest = c.newInstance();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class) && !beforeSuiteIsDone) {
                System.out.println("Before sute");
                m.invoke(myTest);
                beforeSuiteIsDone = true;
            }
            if (m.isAnnotationPresent(AfterSuite.class) && afterSuiteMethod == null) {
                afterSuiteMethod = m;
            }
            if (m.isAnnotationPresent(Test.class)) {
                tmpPriority = m.getAnnotation(Test.class).priority();
                if (tmpPriority > 10) {
                    tmpPriority = 10;
                } else if (tmpPriority < 1) {
                    tmpPriority = 1;
                }
                priorityMethods.put(tmpPriority, m);
            }
        }

        for (Map.Entry<Integer,Method> a:priorityMethods.descendingMap().entrySet()) {
            a.getValue().invoke(myTest);
        }

        if (afterSuiteMethod != null) {
            System.out.println("After sute");
            afterSuiteMethod.invoke(myTest);
        }

    }
}
