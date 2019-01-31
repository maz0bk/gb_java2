import org.junit.Assert;
import org.junit.Test;

public class ArrayFunctionTest {
    @Test
    public  void testEndAfterFour(){
        Assert.assertArrayEquals(new int []{2,3},ArrayFunctions.endAfterFour(new int[]{4,2,3}));
    }

    @Test
    public  void testChekArray(){
        Assert.assertTrue(ArrayFunctions.chekArray(new int[]{1,4,2,3}));
    }
    @Test
    public  void testChekArray2(){
        Assert.assertFalse(ArrayFunctions.chekArray(new int[]{4,2,3}));
    }

}

