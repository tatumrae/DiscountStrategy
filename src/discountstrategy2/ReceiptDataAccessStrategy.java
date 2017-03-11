package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public interface ReceiptDataAccessStrategy {
    
    public Customer findCustomer(String customerId, ReceiptDataAccessStrategy data);
    public Product findProduct(String productId, ReceiptDataAccessStrategy data);
    
}
