package exercises;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ProductOrder> orders;
    private DatabaseAccessObject<ShoppingCart> dao;

    public ShoppingCart(DatabaseAccessObject <ShoppingCart>dao) {
        this.orders = new ArrayList<>();
        this.dao = dao;
    }

    public List<ProductOrder> listProducts() {
        return new ArrayList<>(orders);
    }

    public void addProduct(ProductOrder newProductOrder) {
        if(newProductOrder == null){
            throw new IllegalArgumentException("Argument must be provided");
        }

        if(orders.stream().anyMatch(order -> order.getProductName().equals(newProductOrder.getProductName()))){
            throw new ProductAlreadyInCartException(String.format("Product %s is already in the shopping cart", newProductOrder.getProductName()));
            // TODO: Instead of throwing exception, up the quantity of the product
        } else {
            orders.add(newProductOrder);
        }
        // TODO: uncomment after part "7. Mocking"
        // persist();
    }

    public void removeProduct(String productName) {
        orders
            .stream()
            .filter(order -> order.getProductName().equals(productName))
            .findFirst()
            .ifPresent(order -> orders.remove(order));
        // TODO: uncomment after part "7. Mocking"
        // persist();
    }

    public void setProductQuantity(String productName, int productQuantity) {

    }

    public void buy() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void persist() {
        dao.saveToDb(this);
    }
}
