package examples;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FibonacciParameterizedTest {

    //Testowanie parametryczne
    @Test
    @Parameters({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "7, 13",
            "46, 1836311903"
    })
    public void testFibonacciForCertainValues(int x, int expectedResult) {
        Assert.assertEquals(new Fibonacci().calculateFor(x), expectedResult);
    }
}
