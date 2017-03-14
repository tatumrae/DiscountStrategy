package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public interface ReceiptDataAccessStrategy {
    
    public Customer findCustomer(String customerId);
    public Product findProduct(String productId);
    
}
