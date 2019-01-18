package exercises;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    ShoppingCart cart;
    ProductOrder productOrder;

    @Before
    public void setUp() {
        cart = new ShoppingCart(new DatabaseAccessObject<>());
        productOrder = new ProductOrder("Aparat Canon", 1, 1800.00);
    }

    @Test
    public void testAddProductToEmptyCart() {
        cart.addProduct(productOrder);
        Assertions.assertThat(cart.listProducts()).contains(productOrder);
    }

    @Test()
    public void testAddTheSameProductTwice() {
        cart.addProduct(productOrder);
        try {
            cart.addProduct(productOrder);
            fail();
        } catch (ProductAlreadyInCartException exception) {
            assertEquals(
                    String.format("Product %s is already in the shopping cart", productOrder.getProductName()),
                    exception.getMessage());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(productOrder);
        cart.removeProduct(productOrder.getProductName());
        Assertions.assertThat(cart.listProducts()).doesNotContain(productOrder);
    }

}
