package examples;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(JUnit4.class)
public class FibonacciTest {

    Fibonacci fibonacci;

    @Before
    public void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void testFibonacciWithLargeNumber() {
        int result = fibonacci.calculateFor(46);

        assertEquals(result, 1836311903);
    }

    // Testowanie wyjątku za pomocą try/catch
    @Test
    public void testFibonacciWhenNegativeArgument1() {
        try {
            fibonacci.calculateFor(-1);
            fail();
        } catch (StackOverflowError e) {
            assertNull(e.getMessage());
        } catch (Exception e) {
            fail();
        }
    }

    // Testowanie wyjątku za pomocą parametru expected
    @Test(expected = StackOverflowError.class)
    public void testFibonacciWhenNegativeArgument2() {
        fibonacci.calculateFor(-1);
    }

    // ---------------------------------------------------

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    // Testowanie wyjątku za pomocą adnotacji Rule
    @Test
    public void testFibonacciWhenNegativeArgument3() {
        expectedException.expect(StackOverflowError.class);
        fibonacci.calculateFor(-1);
    }

    // Testowanie wyjątku za pomocą assertThrows (JUnit5)
    @Test
    public void testFibonacciWhenNegativeArgument4() {
        Assertions.assertThrows(StackOverflowError.class,
                () -> {
                    fibonacci.calculateFor(-1);
                });
    }

    // ---------------------------------------------------
    // Z użyciem AssertJ
    // ---------------------------------------------------

    @Test
    public void testFibonacciInsideIntMaxRange() {
        int result = fibonacci.calculateFor(46);

        assertThat(result).isEqualTo(1836311903);
    }

    @Test
    @Ignore
    public void testFibonacciAboveIntRange() {
        int result = fibonacci.calculateFor(47);

        assertThat(result).isGreaterThan(1836311903);
    }
}