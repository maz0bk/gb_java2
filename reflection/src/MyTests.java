public class MyTests {

    @Test (priority = 10)
    void test1(){
        System.out.println("Test1");
    }

    @Test (priority = 1)
    void test2(){
        System.out.println("Test2");
    }

    @Test (priority = 2)
    void test3(){
        System.out.println("Test3");
    }
    @Test (priority = 8)
    void test4(){
        System.out.println("Test4");
    }
    @Test
    void test5(){
        System.out.println("Test5");
    }
    @BeforeSuite
    void test0(){
        System.out.println("Test0 before suite");
    }

    @AfterSuite
    void test10(){
        System.out.println("Test10 After suite");
    }
}
