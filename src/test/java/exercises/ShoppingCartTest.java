package exercises;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ShoppingCartTest {

    ShoppingCart cart;
    ProductOrder productOrder;
    DatabaseAccessObject<ShoppingCart> shoppingCartDaoMock = mock(DatabaseAccessObject.class);
    DatabaseAccessObject<ProductOrder> productDaoMock = mock(DatabaseAccessObject.class);

    @Before
    public void setUp() {
        List<ProductOrder> testList = new ArrayList<ProductOrder>();

        cart = new ShoppingCart(shoppingCartDaoMock, productDaoMock);
        productOrder = new ProductOrder("Aparat Canon", 1, 1800.00);

        testList.add(productOrder);
        when(productDaoMock.loadFromDb()).thenReturn(testList);
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
