package exercises;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class ShoppingCartTest {

    ShoppingCart shoppingCart;
    ProductOrder productOrder;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart(new DatabaseAccessObject<>());
        productOrder = new ProductOrder("Aparat Canon", 1, 1800.00);
    }

    @Test
    public void testIfAddOneProductIsSuccessful() {
        // When
        shoppingCart.addProduct(productOrder);

        // Then
        assertEquals(shoppingCart.listProducts().size(), 1);
        assertThat(shoppingCart.listProducts()).contains(productOrder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentWhenNullArgument() {
        shoppingCart.addProduct(null);
    }

    @Test
    public void testIllegalArgumentWhenNullArgument2() {
        try {
            shoppingCart.addProduct(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Argument must be provided", e.getMessage());
        } catch (Throwable t) {
            fail();
        }
    }

    @Test
    public void testIfAddOneProductTwiceThrowsException() {
        shoppingCart.addProduct(productOrder);
        try {
            shoppingCart.addProduct(productOrder);
            fail();
        } catch (ProductAlreadyInCartException e) {
            assertEquals(
                    String.format(
                            "Product %s is already in the shopping cart",
                            productOrder.getProductName()),
                    e.getMessage()
            );
        } catch (Throwable t) {
            fail();
        }
    }

    @Test
    public void testIfAddedProductIsSuccessfullyRemoved(){
        shoppingCart.addProduct(productOrder);
        shoppingCart.removeProduct(productOrder.getProductName());
        assertThat(shoppingCart.listProducts()).doesNotContain(productOrder);
    }
}





