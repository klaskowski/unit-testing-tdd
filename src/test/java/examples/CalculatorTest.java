package examples;

import org.junit.Test;

import static org.junit.Assert.*; // Biblioteka funkcji sprawdzających, tzw. asercji
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class CalculatorTest { // Nazwa klasy testowej, zwykle nazwa testowanej klasy z suffixem 'Test'

    @Test //Adnotacja, informująca że poniższa metoda jest testem
    public void testSimple1Plus1Addtion() { // Nazwa testu

        // GIVEN (Arrange step) [Dane testowe]
        Calculator calculator = new Calculator();

        // WHEN (Action step) [Testowana akcja]
        int result = calculator.add(1,1);

        // THEN (Assertion step) [Oczekiwany rezultat]
        assertEquals(result, 2);
    }

    @Test
    public void testAdditionWithMultipleAssertions() {
        Calculator calculator = new Calculator();

        int result = calculator.add(1,1);
        boolean isResultCorrect = result == 2;

        assertNotEquals(result, 1);

        assertFalse(!isResultCorrect);
        assertTrue(isResultCorrect);

        assertSame(Integer.valueOf(result), Integer.valueOf(2));
        assertNotSame(Integer.valueOf(200), Integer.valueOf(200));

        assertNotNull(Integer.valueOf(result));

        assertThat(result, is(2));
        assertThat(result, is(not(3)));
    }
}