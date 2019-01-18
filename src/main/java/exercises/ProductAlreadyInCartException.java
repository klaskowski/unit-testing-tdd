package exercises;

public class ProductAlreadyInCartException extends RuntimeException {
    ProductAlreadyInCartException(String message) {
        super(message);
    }
}
