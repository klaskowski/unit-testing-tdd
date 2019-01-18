package exercises;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.DoubleStream;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class AdvancedCalculatorTest {

// TODO Please write unit test for AdvancedCalculator class

    AdvancedCalculator calculator;

    @Before
    public void setUp(){
        //GIVEN (Arrange step)
        calculator = new AdvancedCalculator();
    }

    @Test
    public void testSilniaDla0(){
        // WHEN (Act)
        int result = calculator.silnia(0);

        //THEN (Assert)
        assertEquals(1, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSilniaDlaUjemnegoArgumentu(){
        calculator.silnia(-1);
    }

    @Test
    @Parameters({
            "1, 1",
            "2, 2",
            "5, 120",
            "10, 3628800",
            "12, 479001600"
    })
    public void testSilniaDlaDodatnichArgumentów(int x, int expectedResult){
        int result = calculator.silnia(x);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFunkcjaLiniowa(){
        Function<Double, Double> funkcja1 = calculator.funkcjaLiniowa(Arrays.asList(1.0,3.0,5.0,7.0));
        assertEquals(Double.valueOf(1.0), funkcja1.apply(0.0));
        assertEquals(Double.valueOf(3.0), funkcja1.apply(1.0));
        assertEquals(Double.valueOf(5.0), funkcja1.apply(2.0));
        assertEquals(Double.valueOf(7.0), funkcja1.apply(3.0));
    }

    @Test
    @Parameters({
            "-1.0,5.0",
            "0.0,0.0",
            "100000000000000.0,-100000000000.0",
            "-1.666666666666,3.333333333333",
    })
    public void testFunkcjaLiniowaParametrycznie(double a, double b){
        Function<Double, Double> funkcja1 = calculator.funkcjaLiniowa(Arrays.asList(a,b));
        DoubleStream.of(-2.0,0.0,0.01, 10000000.00000001).forEach(x -> {
            assertEquals(Double.valueOf(a*x+b), funkcja1.apply(x));
        });
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFunkcjaLiniowaZPustaLista(){
        calculator.funkcjaLiniowa(Collections.emptyList());
    }

    @Test(expected = NullPointerException.class)
    public void testFunkcjaLiniowaZPustymArgumentem(){
        Function<Double, Double> funkcja1 = calculator.funkcjaLiniowa(Arrays.asList(1.0,3.0,5.0,7.0));
        funkcja1.apply(null);
    }

    @Test
    @Parameters({"1,1,1.0",
    "2,2,4.0",
    "0,10,0.0",
    "10,0,1.0",
    "-1,2,1"})
    public void testPotega(int podstawa, int wykladnik, double expectedResult){
        double result = calculator.potega(podstawa,wykladnik);
        assertEquals(expectedResult, result, 0.001);
    }

    @Test
    public void testPotegaZeroDoZerowej() {
        double result = calculator.potega(0,0);
        //assertTrue(Double.isNaN(result)); //Possible bug in java.math!
        assertEquals(1.0, result, 0.001);
    }

}